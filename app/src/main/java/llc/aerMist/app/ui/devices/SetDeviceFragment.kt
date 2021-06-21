package llc.aerMist.app.ui.devices

import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothGatt
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.clj.fastble.data.BleDevice
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_set_device.*
import kotlinx.android.synthetic.main.fragment_set_device.bleBg
import kotlinx.android.synthetic.main.fragment_set_device.bleIcon
import kotlinx.android.synthetic.main.fragment_set_device.btnEdit
import kotlinx.android.synthetic.main.fragment_set_device.btnStart
import kotlinx.android.synthetic.main.fragment_set_device.firstLine
import kotlinx.android.synthetic.main.fragment_set_device.guideline
import kotlinx.android.synthetic.main.fragment_set_device.intervalImg
import kotlinx.android.synthetic.main.fragment_set_device.intervalTv
import kotlinx.android.synthetic.main.fragment_set_device.mistTv
import kotlinx.android.synthetic.main.fragment_set_device.mistValue
import kotlinx.android.synthetic.main.fragment_set_device.nonStopImg
import kotlinx.android.synthetic.main.fragment_set_device.nonStopTv
import kotlinx.android.synthetic.main.fragment_set_device.scheduleImg
import kotlinx.android.synthetic.main.fragment_set_device.scheduleTv
import kotlinx.android.synthetic.main.fragment_set_device.secondLine
import kotlinx.android.synthetic.main.fragment_set_device.standbyTv
import kotlinx.android.synthetic.main.fragment_set_device.suspendTv
import kotlinx.android.synthetic.main.fragment_set_device.suspendValue
import kotlinx.android.synthetic.main.fragment_set_device.tabName
import kotlinx.android.synthetic.main.fragment_set_device.tab_icon
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.BytePayload
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.models.ScheduleModel
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.kotlin.hideWithAnimation
import llc.aerMist.app.shared.kotlin.showWithAnimation
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.NumberPickerPopup
import org.koin.android.ext.android.inject

class SetDeviceFragment : Fragment(), View.OnClickListener {
    private val prefs: PreferenceCache by inject()
    private var tag = 0
    var numberPickerPopup = NumberPickerPopup()
    lateinit var bluetoothController: BluetoothController
    val connectionStateCoordinator = NewObservableCoordinator
    private var bleDevice: BleDevice? = null
    private var gatt: BluetoothGatt? = null
    private lateinit var payload: BytePayload
    private var mistValueSeconds = "100"
    private var suspendValueSeconds = "100"
    private val scheduleModelArgs: SetDeviceFragmentArgs by navArgs()
    private lateinit var scheduleModel: ScheduleModel

    val charset = Charsets.UTF_8
    val nonStopOn = "EE0200.".toByteArray(charset)
    val byteArrayON = "EE0100.".toByteArray(charset)
    val byteArrayOF = "EE0101.".toByteArray(charset)
    val intervalOn = "EE0201.".toByteArray(charset)
    val intervalMo = "EE03000.".toByteArray(charset)
    val intervalTu = "EE03010.".toByteArray(charset)
    val intervalWE = "EE03020.".toByteArray(charset)
    val intervalTH = "EE03030.".toByteArray(charset)
    val intervalFR = "EE03040.".toByteArray(charset)
    val intervalSA = "EE03050.".toByteArray(charset)
    val intervalSU = "EE03060.".toByteArray(charset)
    val intervalSS = "EE0400.".toByteArray(charset)
    val intervalFS = "EE0500.".toByteArray(charset)

    var intervalValue = "".toByteArray(charset)
    var sprayPDON = "E0400".toByteArray(charset)
    val sprayFriq = "EE0500.".toByteArray(charset)
    val scheduleMo = "EE0300"
    val scheduleTu = "EE0301"
    val scheduleWE = "EE0302"
    val scheduleTH = "EE0303"
    val scheduleFR = "EE0304"
    val scheduleSA = "EE0305"
    val scheduleSU = "EE0306"
    var monday = ""
    var tuesday = ""
    var wednesday = ""
    var thursday = ""
    var friday = ""
    var saturday = ""
    var sunday = ""
    var firstTimer = ""
    var secondTimer = ""
    var thirdTimer = ""
    var fourthTimer = ""
    var sprayFriquency="EE07000000SSS00PPP"
    lateinit var daysInWeek: IntArray

    @SuppressLint("ClickableViewAccessibility")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle = arguments
        val postion = bundle?.get("myArg") as Int
        setClickListener()
        setNonStopView()
        setMotionLayoutListener()
        setTouchSwipeListener()
        val observer = Observer<CharArray> {
            var response = ""
            for (item in it) {
                response = response + item
            }

            Log.e("D", "Tag " + tag)
            if (tag == 0) {
                checkNonStopResponse(response)
            }
            else if(tag==1) {
                checkIntervalResponse(response)
            }
            else{
                checkScheduleRespone(response)
            }
        }
        connectionStateCoordinator.bluetoothByteArray.observe(viewLifecycleOwner, observer)
        bleDevice =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                postion
            )!!

        gatt = connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
            bleDevice
        )!!

        deviceName.text = bleDevice?.name.toString()
        scheduleModel = scheduleModelArgs.model
        if (scheduleModel.days!=null) {
            setScheduleView()
            daysInWeek = scheduleModel.days!!
            formatDaySchedule()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_set_device, container, false)
    }

    fun formatDaySchedule() {
        monday = scheduleMo + daysInWeek.get(0) + "."
        Log.e("D", "MONDAY " + monday)
        tuesday = scheduleTu + daysInWeek.get(1) + "."
        wednesday = scheduleWE + daysInWeek.get(2) + "."
        thursday = scheduleTH + daysInWeek.get(3) + "."
        friday = scheduleFR + daysInWeek.get(4) + "."
        saturday = scheduleSA + daysInWeek.get(5) + "."
        sunday = scheduleSU + daysInWeek.get(6) + "."
        formatTimer()
    }

    fun checkNonStopResponse(response: String) {
        when (response) {
            "EE120." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
            "EE121." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(nonStopOn, it1, it) } }
            "EE111." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayOF, it1, it) } }
        }
    }

    fun checkIntervalResponse(response: String) {
        when (response) {
            "EE121." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalOn, it1, it) } }
            "EE120." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalMo, it1, it) } }
            "EE1310." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalMo, it1, it) } }
            "EE1300." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalTu, it1, it) } }
            "EE1311." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalTu, it1, it) } }
            "EE1301." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalWE, it1, it) } }
            "EE1312." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalWE, it1, it) } }
            "EE1302." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalTH, it1, it) } }
            "EE1313." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalTH, it1, it) } }
            "EE1303." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalFR, it1, it) } }
            "EE1314." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalFR, it1, it) } }
            "EE1304." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalSA, it1, it) } }
            "EE1315." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalSA, it1, it) } }
            "EE1305." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalSU, it1, it) } }
            "EE1316." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalSU, it1, it) } }
            "EE1306." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalSS, it1, it) } }
            "EE141." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalSS, it1, it) } }
            "EE140." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalFS, it1, it) } }
            "EE151." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalFS, it1, it) } }
            "EE150." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalValue, it1, it) } }
            "EE171." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalValue, it1, it) } }
            "EE170." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
        }
    }
    fun checkScheduleRespone(response: String) {
        when (response) {
            "EE120." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(monday.toByteArray(charset), it1, it) } }
            "EE1310." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(monday.toByteArray(charset), it1, it) } }
            "EE1300." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(tuesday.toByteArray(charset), it1, it) } }
            "EE1311." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(tuesday.toByteArray(charset), it1, it) } }
            "EE1301." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(wednesday.toByteArray(charset), it1, it) } }
            "EE1312." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(wednesday.toByteArray(charset), it1, it) } }
            "EE1302." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(thursday.toByteArray(charset), it1, it) } }
            "EE1313." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(thursday.toByteArray(charset), it1, it) } }
            "EE1303." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(friday.toByteArray(charset), it1, it) } }
            "EE1314." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(friday.toByteArray(charset), it1, it) } }
            "EE1304." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(saturday.toByteArray(charset), it1, it) } }
            "EE1315." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(saturday.toByteArray(charset), it1, it) } }
            "EE1305." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sunday.toByteArray(charset), it1, it) } }
            "EE1316." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sunday.toByteArray(charset), it1, it) } }

            "EE1306." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayPDON, it1, it) } }
            "EE141." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayPDON, it1, it) } }
            "EE140." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayFriq, it1, it) } }
            "EE151." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayFriq, it1, it) } }

            "EE150." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(firstTimer.toByteArray(charset), it1, it) } }
            "EE16100." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(firstTimer.toByteArray(charset), it1, it) } }
            "EE16000." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(secondTimer.toByteArray(charset), it1, it) } }
            "EE16101." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(secondTimer.toByteArray(charset), it1, it) } }
            "EE16001." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(thirdTimer.toByteArray(charset), it1, it) } }
            "EE16102." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(thirdTimer.toByteArray(charset), it1, it) } }
            "EE16002." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(fourthTimer.toByteArray(charset), it1, it) } }
            "EE16103." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(fourthTimer.toByteArray(charset), it1, it) } }
            "EE16003." -> {
                if (scheduleModel.nonStop==true)
                {gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayFriquency.toByteArray(charset), it1, it) } }
                    }
                else{
                  gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
                }
            }
            "EE171." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayFriquency.toByteArray(charset), it1, it) } }
            "EE170." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
        }
    }

    fun formatTimer() {
        val hourOne = scheduleModel.timer?.get(0)!!.hours
        val minOne = scheduleModel.timer?.get(0)!!.min
        val hourTwo = scheduleModel.timer?.get(1)!!.hours
        val minTwo = scheduleModel.timer?.get(1)!!.min
        firstTimer = "EE060000" + hourOne + minOne + hourTwo + minTwo+"."
        Log.e("D", "firstTimer " + firstTimer)
        val hourThree = scheduleModel.timer?.get(2)!!.hours
        val minThree = scheduleModel.timer?.get(2)!!.min
        val hourFour = scheduleModel.timer?.get(3)!!.hours
        val minFour = scheduleModel.timer?.get(3)!!.min
        secondTimer = "EE060010" + hourThree + minThree + hourFour + minFour+"."
        Log.e("D", "secondTimer " + secondTimer)
        val hourFive = scheduleModel.timer?.get(4)!!.hours
        val minFive = scheduleModel.timer?.get(4)!!.min
        val hourSix = scheduleModel.timer?.get(5)!!.hours
        val minSix = scheduleModel.timer?.get(5)!!.min
        thirdTimer = "EE060020" + hourFive + minFive + hourSix + minSix+"."
        Log.e("D", "thirdTimer " + thirdTimer)
        val hourSeven = scheduleModel.timer?.get(6)!!.hours
        val minSeven = scheduleModel.timer?.get(6)!!.min
        val hourEight = scheduleModel.timer?.get(7)!!.hours
        val minEight = scheduleModel.timer?.get(7)!!.min
        fourthTimer = "EE060030" + hourSeven + minSeven + hourEight + minEight+"."
        Log.e("D", "fourthTimer " + fourthTimer)
        val sss=getSeconds(scheduleModel.mist.toString())
        val ppp=getSeconds(scheduleModel.suspend.toString())
        var friqu="EE07000000"+sss+ppp+"."
        sprayFriquency=friqu
    }

    fun setClickListener() {
        nonStopImg.setOnClickListener(this)
        nonStopTv.setOnClickListener(this)
        intervalImg.setOnClickListener(this)
        intervalTv.setOnClickListener(this)
        scheduleImg.setOnClickListener(this)
        scheduleTv.setOnClickListener(this)
        btnStart.setOnClickListener(this)
        btnEdit.setOnClickListener(this)
    }

    override fun onClick(id: View?) {
        when (id) {

            nonStopImg -> {
                setNonStopView()
            }
            nonStopTv -> {
                setNonStopView()
            }
            intervalImg -> {
                setIntervalView()
            }
            intervalTv -> {
                setIntervalView()
            }
            scheduleImg -> {
                setScheduleView()
            }
            scheduleTv -> {
                setScheduleView()
            }
            btnStart -> {
                Log.e("D", "TAG " + tag)
                btnStart.isEnabled = false
                if (intervalImg.visibility == View.VISIBLE) {
                    setTabItemVisibility(true)
                } else {
                    setTabItemVisibility(false)
                }
                startAnimationSendCommand()
            }
            btnEdit -> {
                if (tag == 1) {
                    setNumberPicker()
                } else if (tag == 2) {
                    navigateToSetSchedule()
                }
            }
        }
    }

    fun setMotionLayoutListener() {
        motionLayoutDevice.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                constraintSet: Int,
                p2: Int
            ) {
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                constraintSet: Int,
                p2: Int,
                p3: Float
            ) {
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, constraintSet: Int) {
                if (constraintSet == R.id.start) {
                    btnStart.setBackgroundResource(R.drawable.blue_radius_8)
                    btnStart.text = getString(R.string.start)
                    btnStart.isEnabled = true
                } else {
                    btnStart.setBackgroundResource(R.drawable.container_light_blue)
                    btnStart.text = getString(R.string.stop)
                    btnStart.isEnabled = true
                }
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                constraintSet: Int,
                p2: Boolean,
                p3: Float
            ) {

            }

        })
    }

    fun setTouchSwipeListener() {
        val gesture = GestureDetector(
            activity,
            object : GestureDetector.SimpleOnGestureListener() {
                override fun onDown(e: MotionEvent): Boolean {
                    return true
                }

                override fun onFling(
                    e1: MotionEvent, e2: MotionEvent, velocityX: Float,
                    velocityY: Float
                ): Boolean {
                    val SWIPE_MIN_DISTANCE = 120
                    val SWIPE_MAX_OFF_PATH = 250
                    val SWIPE_THRESHOLD_VELOCITY = 200
                    try {
                        if (Math.abs(e1.y - e2.y) > SWIPE_MAX_OFF_PATH) return false
                        if (e1.x - e2.x > SWIPE_MIN_DISTANCE
                            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY
                        ) {
                            if (tag == 0) {
                                intervalImg.performClick()
                            } else if (tag == 1) {
                                scheduleImg.performClick()
                            }

                        } else if (e2.x - e1.x > SWIPE_MIN_DISTANCE
                            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY
                        ) {
                            if (tag == 2) {
                                intervalImg.performClick()
                            } else if (tag == 1) {
                                nonStopImg.performClick()
                            }

                        }
                    } catch (e: Exception) {
                        // nothing
                    }
                    return super.onFling(e1, e2, velocityX, velocityY)
                }
            })

        carViewDevice.setOnTouchListener(View.OnTouchListener { v, event ->
            gesture.onTouchEvent(
                event
            )
        })

    }

    fun setTabItemVisibility(state: Boolean) {
        if (state) {
            intervalImg.hideWithAnimation()
            intervalTv.hideWithAnimation()
            scheduleImg.hideWithAnimation()
            scheduleTv.hideWithAnimation()
            nonStopImg.hideWithAnimation()
            nonStopTv.hideWithAnimation()
            firstLine.hideWithAnimation()
            bleBg.hideWithAnimation()
            bleIcon.hideWithAnimation()
            standbyTv.hideWithAnimation()
            mistTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            mistValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            suspendTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            suspendValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            firstLine.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
        } else {
            intervalImg.showWithAnimation()
            intervalTv.showWithAnimation()
            scheduleImg.showWithAnimation()
            scheduleTv.showWithAnimation()
            nonStopImg.showWithAnimation()
            nonStopTv.showWithAnimation()
            firstLine.showWithAnimation()
            bleBg.showWithAnimation()
            bleIcon.showWithAnimation()
            standbyTv.showWithAnimation()
            mistTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            mistValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            suspendTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            suspendValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            firstLine.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.dark_gray
                )
            )
        }
    }

    fun startAnimationSendCommand() {
        motionLayoutDevice.transitionToEnd()
        motionLayoutDevice.transitionToStart()
        when (tag) {
            0 -> {
                tabName.text = resources.getString(R.string.non_stop)
                tab_icon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.non_stop_blue_icon
                    )
                )
                if (btnStart.tag == "start") {

                    bleDevice?.let {
                        gatt?.let { it1 ->
                            sendCommand(
                                nonStopOn, it,
                                it1
                            )
                        }
                    }
                    btnStart.tag = "stop"
                } else {
                    bleDevice?.let {
                        gatt?.let { it1 ->
                            sendCommand(
                                byteArrayOF, it,
                                it1
                            )
                        }
                    }
                    btnStart.tag = "start"
                }
            }
            1 -> {
                tabName.text = resources.getString(R.string.interval)
                tab_icon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.interval_blue_icon
                    )
                )
                if (btnStart.tag == "start") {
                    gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalOn, it1, it) } }

                    btnStart.tag = "stop"
                } else {
                    gatt?.let {
                        bleDevice?.let { it1 ->
                            sendCommand(
                                byteArrayOF,
                                it1,
                                it
                            )
                        }
                    }
                    btnStart.tag = "start"
                }
            }
            2 -> {
                tabName.text = resources.getString(R.string.schedule)
                tab_icon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.calendar_blue_icon
                    )
                )
                if (btnStart.tag == "start") {
                    gatt?.let { bleDevice?.let { it1 -> sendCommand(intervalOn, it1, it) } }

                    btnStart.tag = "stop"
                } else {
                    gatt?.let {
                        bleDevice?.let { it1 ->
                            sendCommand(
                                byteArrayOF,
                                it1,
                                it
                            )
                        }
                    }
                    btnStart.tag = "start"
                }
            }
        }

    }

    fun sendCommand(input: ByteArray, bleDevice: BleDevice, gatt: BluetoothGatt) {
        val pos = gatt.services.size - 1
        connectionStateCoordinator.bluetoothController?.writeCommand(
            bleDevice,
            input,
            gatt.services.get(pos).characteristics.get(0)
        )
    }

    fun setNumberPicker() {
        numberPickerPopup = NumberPickerPopup()
        numberPickerPopup.isCancelable = false
        numberPickerPopup.show(childFragmentManager, "")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val data = data?.extras

                    val mist = data?.getString("mist")
                    mistValueSeconds = mist?.let { getSeconds(it) }.toString()
                    val suspend = data?.getString("suspend")
                    suspendValueSeconds = suspend?.let { getSeconds(it) }.toString()

                    mistValue.text = mist
                    suspendValue.text = suspend
                    var fullCommand = ""
                    fullCommand = fullCommand + "EE07000000"
                    fullCommand = fullCommand + mistValueSeconds
                    fullCommand = fullCommand + "00"
                    fullCommand = fullCommand + suspendValueSeconds
                    fullCommand = fullCommand + "."
                    intervalValue = fullCommand.toByteArray(charset)
                }
            }
        }
    }

    fun setNonStopView() {
        tag = 0
        mistTv.visibility = View.INVISIBLE
        mistValue.visibility = View.INVISIBLE
        suspendTv.visibility = View.INVISIBLE
        suspendValue.visibility = View.INVISIBLE
        btnEdit.visibility = View.INVISIBLE
        secondLine.visibility = View.INVISIBLE
        thirdLine.visibility = View.INVISIBLE
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
        )
        guideline.setGuidelinePercent(1f)
        nonStopImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop_orange_icon
            )
        )
        intervalImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_icon
            )
        )
        scheduleImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_icon
            )
        )
    }

    fun setIntervalView() {
        tag = 1
        mistTv.showWithAnimation()
        mistValue.showWithAnimation()
        suspendTv.showWithAnimation()
        suspendValue.showWithAnimation()
        btnEdit.showWithAnimation()
        secondLine.showWithAnimation()
        thirdLine.hideWithAnimation()
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        nonStopImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop_icon
            )
        )
        intervalImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_orange_icon
            )
        )
        scheduleImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_icon
            )
        )
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.orange_circle)
        )
        guideline.setGuidelinePercent(0.65f)
    }

    fun setScheduleView() {
        tag = 2
        mistTv.showWithAnimation()
        mistValue.showWithAnimation()
        suspendTv.showWithAnimation()
        suspendValue.showWithAnimation()
        btnEdit.showWithAnimation()
        thirdLine.showWithAnimation()
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        nonStopImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop_icon
            )
        )
        intervalImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_icon
            )
        )
        scheduleImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_orange_icon
            )
        )
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
        )
        guideline.setGuidelinePercent(0.65f)
    }

    private fun navigateToSetSchedule() {
        findNavController().navigate(R.id.action_set_device_to_set_schedule_fragment)
    }

    fun getSeconds(value: String): String {
        var seconds = "100"
        when (value) {
            "5s" -> seconds = "005"
            "6s" -> seconds = "006"
            "7s" -> seconds = "007"
            "8s" -> seconds = "008"
            "9s" -> seconds = "009"
            "10s" -> seconds = "010"
            "11s" -> seconds = "011"
            "12s" -> seconds = "012"
            "13s" -> seconds = "013"
            "14s" -> seconds = "014"
            "15s" -> seconds = "015"
            "16s" -> seconds = "016"
            "17s" -> seconds = "017"
            "18s" -> seconds = "018"
            "19s" -> seconds = "019"
            "20s" -> seconds = "020"
            "25s" -> seconds = "025"
            "40s" -> seconds = "045"
            "50s" -> seconds = "050"
            "55s" -> seconds = "055"
            "1m" -> seconds = "060"
            "1m 30s" -> seconds = "090"
            "2m" -> seconds = "120"
            "2m 30s" -> seconds = "150"
            "3m" -> seconds = "180"
            "3m 30s" -> seconds = "210"
            "4m" -> seconds = "240"
            "4m 30s" -> seconds = "270"
            "5m" -> seconds = "300"
            "5m 30s" -> seconds = "330"
            "6m" -> seconds = "360"
            "6m 30s" -> seconds = "390"
            "7m" -> seconds = "420"
            "7m 30s" -> seconds = "450"
            "8m" -> seconds = "480"
            "8m 30s" -> seconds = "510"
            "9m" -> seconds = "540"
            "9m 30s" -> seconds = "570"
            "10m" -> seconds = "600"
            "10m 30s" -> seconds = "630"
            "11m" -> seconds = "660"
            "11m 30s" -> seconds = "690"
            "12m" -> seconds = "720"
            "12m 30s" -> seconds = "750"
            "13m" -> seconds = "780"
            "13m 30s" -> seconds = "810"
            "14m" -> seconds = "840"
            "14m 30a" -> seconds = "870"
            "15m" -> seconds = "900"
        }
        return seconds
    }
}