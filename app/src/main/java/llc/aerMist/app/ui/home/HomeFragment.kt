package llc.aerMist.app.ui.home

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothGatt
import android.content.Intent
import android.graphics.Color
import android.graphics.ImageFormat
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.*
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.View.OnTouchListener
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.callback.BleWriteCallback
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.bleBg
import kotlinx.android.synthetic.main.fragment_home.bleIcon
import kotlinx.android.synthetic.main.fragment_home.btnEdit
import kotlinx.android.synthetic.main.fragment_home.btnStart
import kotlinx.android.synthetic.main.fragment_home.firstLine
import kotlinx.android.synthetic.main.fragment_home.firstTimerTv
import kotlinx.android.synthetic.main.fragment_home.fridayTv
import kotlinx.android.synthetic.main.fragment_home.guideline
import kotlinx.android.synthetic.main.fragment_home.intervalImg
import kotlinx.android.synthetic.main.fragment_home.intervalTv
import kotlinx.android.synthetic.main.fragment_home.mistTv
import kotlinx.android.synthetic.main.fragment_home.mistValue
import kotlinx.android.synthetic.main.fragment_home.mondayTv
import kotlinx.android.synthetic.main.fragment_home.nonStopImg
import kotlinx.android.synthetic.main.fragment_home.nonStopTv
import kotlinx.android.synthetic.main.fragment_home.saturdayTv
import kotlinx.android.synthetic.main.fragment_home.scheduleImg
import kotlinx.android.synthetic.main.fragment_home.scheduleTv
import kotlinx.android.synthetic.main.fragment_home.secondLine
import kotlinx.android.synthetic.main.fragment_home.secondTimerTv
import kotlinx.android.synthetic.main.fragment_home.standbyTv
import kotlinx.android.synthetic.main.fragment_home.startingTv
import kotlinx.android.synthetic.main.fragment_home.sundayTv
import kotlinx.android.synthetic.main.fragment_home.suspendTv
import kotlinx.android.synthetic.main.fragment_home.suspendValue
import kotlinx.android.synthetic.main.fragment_home.tabName
import kotlinx.android.synthetic.main.fragment_home.tab_icon
import kotlinx.android.synthetic.main.fragment_home.thirdTimerTv
import kotlinx.android.synthetic.main.fragment_home.thusdayTv
import kotlinx.android.synthetic.main.fragment_home.wednesdayTv
import kotlinx.android.synthetic.main.fragment_set_device.*
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.BytePayload
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.models.ScheduleModel
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.kotlin.hideWithAnimation
import llc.aerMist.app.shared.kotlin.showWithAnimation
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.DevicesDisconnected
import llc.aerMist.app.ui.popup.NumberPickerPopup
import org.koin.android.ext.android.inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class HomeFragment : Fragment(), View.OnClickListener {
    private val prefs: PreferenceCache by inject()
    private var tag = 0
    var numberPickerPopup = NumberPickerPopup()
    lateinit var bluetoothController: BluetoothController
    val connectionStateCoordinator = NewObservableCoordinator
    var firstBleDevice: BleDevice? = null
    var secondBleDevice: BleDevice? = null
    var thirdBleDevice: BleDevice? = null
    var fourthBleDevice: BleDevice? = null
    var firstGate: BluetoothGatt? = null
    var secondGate: BluetoothGatt? = null
    var thirdGate: BluetoothGatt? = null
    var fourthGate: BluetoothGatt? = null
    private var isFirstDevice = true
    var allDevices = 0
    private var bleList = ArrayList<BleDevice>()
    private var gattList = ArrayList<BluetoothGatt>()
    private var mistValueSeconds = "005"
    private var suspendValueSeconds = "005"
    var isSelected = false
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
    val intervalSS = "EE0401.".toByteArray(charset)
    val intervalFS = "EE0500.".toByteArray(charset)
    var intervalValue = "".toByteArray(charset)
    var isTimeSync = true
    var responseTimerOne = 0
    var responseTimerTwo = 0
    var responseTimerThree = 0
    var responseTimerFour = 0
    var mainRegister = "EE000.".toByteArray(charset)
    var deviceOneObj: MyDevice? = null
    var deviceTwoObj: MyDevice? = null
    var deviceThreeObj: MyDevice? = null
    var deviceFourObj: MyDevice? = null
    var sprayPDON =
        "EE0400.".toByteArray(charset)
    val sprayFriq =
        "EE0501.".toByteArray(charset)
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
    var sprayFriquency = "EE07000000SSS00PPP"
    var dateAndTimeSynch = "EE00+YYYYMMDDHHNNSST"
    lateinit var daysInWeek: IntArray
    private val scheduleModelArgs: HomeFragmentArgs by navArgs()
    private lateinit var scheduleModel: ScheduleModel
    var deviceObject: MyDevice? = null
    var mainDevicePositon = 0

    private var dialogDisconnectedDevice: DevicesDisconnected? = null
    var savedDevicesNumber = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickListener()
        setMotionLayoutListener()
        setTouchSwipeListener()
        allDevices =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        if (allDevices > 0) {
            bleList =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
        }
        initBleConroller()
        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
        deviceNumber?.text = allDevices.toString() + " of " + savedDevicesNumber + " devices"
        var fullCommand = ""
        fullCommand = fullCommand + "EE07000000"
        fullCommand = fullCommand + mistValueSeconds
        fullCommand = fullCommand + "00"
        fullCommand = fullCommand + suspendValueSeconds
        fullCommand = fullCommand + "."
        intervalValue = fullCommand.toByteArray(charset)
        val observer = Observer<CharArray> {
            mainDevicePositon = connectionStateCoordinator.bleDevicePosition

            var response = ""
            for (item in it) {
                response = response + item
            }

            if (tag == 0) {

                when (mainDevicePositon) {
                    0 -> {
                        checkNonStopResponse(response, firstBleDevice, firstGate)
                    }
                    1 -> {
                        checkNonStopResponse(response, secondBleDevice, secondGate)
                    }
                    2 -> {
                        checkNonStopResponse(response, thirdBleDevice, thirdGate)
                    }
                    3 -> {
                        checkNonStopResponse(response, fourthBleDevice, fourthGate)
                    }
                }
            } else if (tag == 1) {
                when (mainDevicePositon) {
                    0 -> {
                        checkIntervalResponse(response, firstBleDevice, firstGate)
                    }
                    1 -> {
                        checkIntervalResponse(response, secondBleDevice, secondGate)
                    }
                    2 -> {
                        checkIntervalResponse(response, thirdBleDevice, thirdGate)
                    }
                    3 -> {
                        checkIntervalResponse(response, fourthBleDevice, fourthGate)
                    }
                }
            } else if (tag == 2) {
                when (mainDevicePositon) {
                    0 -> {
                        checkScheduleRespone(
                            response,
                            firstBleDevice,
                            firstGate,
                            mainDevicePositon
                        )
                    }
                    1 -> {
                        checkScheduleRespone(
                            response,
                            secondBleDevice,
                            secondGate,
                            mainDevicePositon
                        )
                    }
                    2 -> {
                        checkScheduleRespone(
                            response,
                            thirdBleDevice,
                            thirdGate,
                            mainDevicePositon
                        )
                    }
                    3 -> {
                        checkScheduleRespone(
                            response,
                            fourthBleDevice,
                            fourthGate,
                            mainDevicePositon
                        )
                    }
                }
            }
            //      }
        }

        connectionStateCoordinator.bluetoothByteArray.observe(viewLifecycleOwner, observer)
        val observer2 = Observer<BleDevice> {
            connectDevice(it)

            val size =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            allDevices = size

            deviceNumber?.text = allDevices.toString() + " of " + savedDevicesNumber + " devices"
            if (size == 0) {
                showDisconnectedDeviceDialog()
                bleBg?.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.red_circle)
                )
            } else
                if (size != 0 && size < savedDevicesNumber) {
                    bleBg?.setImageDrawable(
                        ContextCompat.getDrawable(requireContext(), R.drawable.yelow_img)
                    )
                } else if (size == savedDevicesNumber) {
                    bleBg?.setImageDrawable(
                        ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
                    )
                }

        }
        connectionStateCoordinator.bleDisconnectDevices.observe(viewLifecycleOwner, observer2)
        if (scheduleModelArgs.model != null) {
            scheduleModel = scheduleModelArgs.model!!
            if (scheduleModel.days != null) {
                setScheduleView()
                isSelected = true
                daysInWeek = scheduleModel.days!!
                for (item in daysInWeek) {
                }

                formatDaySchedule()
            }
        } else {
            setNonStopView()
        }
        synchTime()

            setDisplayMode()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    fun connectDevice(bleDevice: BleDevice) {
        if (bleDevice.name == deviceOneObj?.name || bleDevice.name == deviceTwoObj?.name || bleDevice.name == deviceThreeObj?.name || bleDevice.name == deviceFourObj?.name) {
            if (connectionStateCoordinator.bluetoothController?.bluetoothManager?.isConnected(
                    bleDevice
                ) == false
            ) {
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                    bleDevice,
                    gattCallback
                )
            }

        }
    }

    fun setTimeZone(time: String?): String {
        var fullTime = ""
        var zone = "am"
        if (time?.length == 4) {
            var hour = time.substring(0, 2).toIntOrNull()
            var min = time.substring(2, 4).toIntOrNull()
            if (hour != null) {
                if (hour < 12) {
                    zone = "am"
                } else {
                    hour = hour - 12
                    zone = "pm"
                }
            }

            if (hour != null && min != null) {
                fullTime = hour.toString() + ":" + min + zone
                if (hour == 0 && min == 0) {
                    fullTime = ""
                }
            }
        }
        return fullTime
    }

    private val gattCallback = object : BleGattCallback() {
        override fun onStartConnect() {
            Log.e("D", "onStartConnect ")
        }

        override fun onConnectFail(bleDevice: BleDevice, exception: BleException) {
            Log.e("D", "onConnectFail")
            connectDevice(bleDevice)
        }

        override fun onConnectSuccess(bleDevicee: BleDevice, gatt: BluetoothGatt, status: Int) {
            if (dialogDisconnectedDevice != null) dialogDisconnectedDevice?.dialog?.dismiss()
            val size =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            allDevices = size
            deviceNumber?.text = allDevices.toString() + " of " + savedDevicesNumber + " devices"

            if (size == 0) {
                showDisconnectedDeviceDialog()
                bleBg?.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.red_circle)
                )
            } else
                if (size != 0 && size < savedDevicesNumber) {
                    bleBg?.setImageDrawable(
                        ContextCompat.getDrawable(requireContext(), R.drawable.yelow_img)
                    )
                } else if (size == savedDevicesNumber) {
                    bleBg?.setImageDrawable(
                        ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
                    )
                }
        }

        override fun onDisConnected(
            isActiveDisConnected: Boolean,
            device: BleDevice?,
            gatt: BluetoothGatt?,
            status: Int
        ) {
            allDevices =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            deviceNumber?.text = allDevices.toString() + " of " + savedDevicesNumber + " devices"

        }
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
                if (allDevices > 0) {
                    isTimeSync = false
                    carViewHome.isEnabled = false

                    if (tag == 0) {

                        btnStart.isEnabled = false
                        if (btnStart.tag == "start") {
                            setTabView()

                            btnStart.tag = "stop"
                            firstGate?.let {
                                firstBleDevice?.let { it1 ->
                                    sendCommand(
                                        nonStopOn,
                                        it1, it
                                    )
                                }
                            }
                            secondGate?.let {
                                secondBleDevice?.let { it1 ->
                                    sendCommand(
                                        nonStopOn,
                                        it1, it
                                    )
                                }
                            }
                            thirdGate?.let {
                                thirdBleDevice?.let { it1 ->
                                    sendCommand(
                                        nonStopOn,
                                        it1, it
                                    )
                                }
                            }
                            fourthGate?.let {
                                fourthBleDevice?.let { it1 ->
                                    sendCommand(
                                        nonStopOn,
                                        it1, it
                                    )
                                }
                            }
                            startingTv.visibility = View.VISIBLE
                            Handler().postDelayed({
                                Handler().postDelayed({
                                    motionLayout?.transitionToEnd()
                                    motionLayout?.transitionToStart()
                                    startingTv.visibility = View.INVISIBLE
                                    setTabItemVisibility(true)
                                }, 700)
                                synchTime()
                            }, 700)
                        } else {
                            btnStart.tag = "start"

                            motionLayout?.transitionToEnd()
                            motionLayout?.transitionToStart()

                            firstGate?.let {
                                firstBleDevice?.let { it1 ->
                                    sendCommand(
                                        byteArrayOF,
                                        it1, it
                                    )
                                }
                            }
                            secondGate?.let {
                                secondBleDevice?.let { it1 ->
                                    sendCommand(
                                        byteArrayOF,
                                        it1, it
                                    )
                                }
                            }
                            thirdGate?.let {
                                thirdBleDevice?.let { it1 ->
                                    sendCommand(
                                        byteArrayOF,
                                        it1, it
                                    )
                                }
                            }
                            fourthGate?.let {
                                fourthBleDevice?.let { it1 ->
                                    sendCommand(
                                        byteArrayOF,
                                        it1, it
                                    )
                                }
                            }
                            synchTime()
                        }
                    } else if (tag == 1) {
                        if (!intervalValue.isEmpty()) {

                            setTabView()
                            if (btnStart.tag == "start") {
                                startingTv.visibility = View.VISIBLE
                                btnStart.tag = "stop"
                                guideline?.setGuidelinePercent(1f)

                                var i = 0

                                firstGate?.let {
                                    firstBleDevice?.let { it1 ->
                                        sendCommand(
                                            intervalOn,
                                            it1, it
                                        )
                                    }
                                }
                                secondGate?.let {
                                    secondBleDevice?.let { it1 ->
                                        sendCommand(
                                            intervalOn,
                                            it1, it
                                        )
                                    }
                                }
                                thirdGate?.let {
                                    thirdBleDevice?.let { it1 ->
                                        sendCommand(
                                            intervalOn,
                                            it1, it
                                        )
                                    }
                                }
                                fourthGate?.let {
                                    fourthBleDevice?.let { it1 ->
                                        sendCommand(
                                            intervalOn,
                                            it1, it
                                        )
                                    }
                                }
                                startingTv.visibility = View.VISIBLE
                                Handler().postDelayed({
                                    Handler().postDelayed({
                                        motionLayout?.transitionToEnd()
                                        motionLayout?.transitionToStart()
                                    }, 700)
                                    synchTime()

                                }, 2000)
                            } else {
                                motionLayout.transitionToEnd()
                                motionLayout.transitionToStart()
                                guideline?.setGuidelinePercent(0.65f)

                                btnStart.tag = "start"
                                var i = 0
                                firstGate?.let {
                                    firstBleDevice?.let { it1 ->
                                        sendCommand(
                                            byteArrayOF,
                                            it1, it
                                        )
                                    }
                                }
                                secondGate?.let {
                                    secondBleDevice?.let { it1 ->
                                        sendCommand(
                                            byteArrayOF,
                                            it1, it
                                        )
                                    }
                                }
                                thirdGate?.let {
                                    thirdBleDevice?.let { it1 ->
                                        sendCommand(
                                            byteArrayOF,
                                            it1, it
                                        )
                                    }
                                }
                                fourthGate?.let {
                                    fourthBleDevice?.let { it1 ->
                                        sendCommand(
                                            byteArrayOF,
                                            it1, it
                                        )
                                    }
                                }
                                synchTime()
                            }
                        } else {
                            Snackbar.make(
                                requireView(),
                                "You must choose interval",
                                Snackbar.LENGTH_SHORT
                            ).show()
                        }
                    } else if (tag == 2) {
                        setTabView()
                        if (btnStart.tag == "start") {
                            if (!isSelected) {
                                //  if (scheduleModel.timer.get(0)=="0.0")
                                Snackbar.make(
                                    requireView(),
                                    "You must choose  days and interval",
                                    Snackbar.LENGTH_SHORT
                                ).show()
                                return
                            } else if (scheduleModel.timer!!.get(0).hours == "00" && scheduleModel.timer!!.get(
                                    1
                                ).hours == "00" && scheduleModel.timer!!.get(2).hours == "00" && scheduleModel.timer!!.get(
                                    3
                                ).hours == "00"
                            ) {
                                Snackbar.make(
                                    requireView(),
                                    "You must choose  days and interval",
                                    Snackbar.LENGTH_SHORT
                                ).show()
                                return
                            }
                            guideline?.setGuidelinePercent(1f)

                            startingTv.visibility = View.VISIBLE
                            btnStart.tag = "stop"
                            var i = 0

                            firstGate?.let {
                                firstBleDevice?.let { it1 ->
                                    sendCommand(
                                        intervalOn,
                                        it1, it
                                    )
                                }
                            }
                            secondGate?.let {
                                secondBleDevice?.let { it1 ->
                                    sendCommand(
                                        intervalOn,
                                        it1, it
                                    )
                                }
                            }
                            thirdGate?.let {
                                thirdBleDevice?.let { it1 ->
                                    sendCommand(
                                        intervalOn,
                                        it1, it
                                    )
                                }
                            }
                            fourthGate?.let {
                                fourthBleDevice?.let { it1 ->
                                    sendCommand(
                                        intervalOn,
                                        it1, it
                                    )
                                }
                            }
                            Handler().postDelayed({
                                Handler().postDelayed({
                                    motionLayout?.transitionToEnd()
                                    motionLayout?.transitionToStart()
                                }, 700)
                                synchTime()

                            }, 2500)
                        } else {
                            btnStart.tag = "start"
                            var i = 0
                            guideline?.setGuidelinePercent(0.65f)
                            motionLayout.transitionToEnd()
                            motionLayout.transitionToStart()
                            firstGate?.let {
                                firstBleDevice?.let { it1 ->
                                    sendCommand(
                                        byteArrayOF,
                                        it1, it
                                    )
                                }
                            }
                            secondGate?.let {
                                secondBleDevice?.let { it1 ->
                                    sendCommand(
                                        byteArrayOF,
                                        it1, it
                                    )
                                }
                            }
                            thirdGate?.let {
                                thirdBleDevice?.let { it1 ->
                                    sendCommand(
                                        byteArrayOF,
                                        it1, it
                                    )
                                }
                            }
                            fourthGate?.let {
                                fourthBleDevice?.let { it1 ->
                                    sendCommand(
                                        byteArrayOF,
                                        it1, it
                                    )
                                }
                            }
                            firstTimerTv?.visibility=View.INVISIBLE
                            secondTimerTv?.visibility=View.INVISIBLE
                            thirdTimerTv?.visibility=View.INVISIBLE
                            fourthTimerTv?.visibility=View.INVISIBLE
                            synchTime()

                        }
                    }
                }
            }
            btnEdit -> {
                if (tag == 1) {
                    setNumberPicker()
                }
                if (tag == 2) {
                    navigateToSetSchedule()
                }
            }
        }
    }



    fun getDayInWeek(day: String): Int {
        var dayInWeek = 0
        when (day) {
            "monday" -> dayInWeek = 0
            "tuesday" -> dayInWeek = 1
            "wednesday" -> dayInWeek = 2
            "thursday" -> dayInWeek = 3
            "friday" -> dayInWeek = 4
            "saturday" -> dayInWeek = 5
            "sunday" -> dayInWeek = 6
        }
        return dayInWeek
    }

    fun formatDaySchedule() {
        daysInWeek = scheduleModel.days!!
        monday = scheduleMo + daysInWeek.get(0) + "."
        tuesday = scheduleTu + daysInWeek.get(1) + "."
        wednesday = scheduleWE + daysInWeek.get(2) + "."
        thursday = scheduleTH + daysInWeek.get(3) + "."
        friday = scheduleFR + daysInWeek.get(4) + "."
        saturday = scheduleSA + daysInWeek.get(5) + "."
        sunday = scheduleSU + daysInWeek.get(6) + "."

        if (daysInWeek.get(0) == 0) {
            mondayTv.alpha = 1f
        } else {
            mondayTv.alpha = 0.3f
        }
        if (daysInWeek.get(1) == 0) {
            tuesdayTv.alpha = 1f
        } else {
            tuesdayTv.alpha = 0.3f
        }
        if (daysInWeek.get(2) == 0) {
            wednesdayTv.alpha = 1f
        } else {
            wednesdayTv.alpha = 0.3f
        }
        if (daysInWeek.get(3) == 0) {
            thusdayTv.alpha = 1f
        } else {
            thusdayTv.alpha = 0.3f
        }
        if (daysInWeek.get(4) == 0) {
            fridayTv.alpha = 1f
        } else {
            fridayTv.alpha = 0.3f
        }
        if (daysInWeek.get(5) == 0) {
            saturdayTv.alpha = 1f
        } else {
            saturdayTv.alpha = 0.3f
        }
        if (daysInWeek.get(6) == 0) {
            sundayTv.alpha = 1f
        } else {
            sundayTv.alpha = 0.3f
        }
        formatTimer()
    }

    fun formatTimer() {
        val hourOne = scheduleModel.timer?.get(0)!!.hours
        val formatOne = scheduleModel.timer?.get(0)!!.format
        val minOne = scheduleModel.timer?.get(0)!!.min
        val hourTwo = scheduleModel.timer?.get(1)!!.hours
        val minTwo = scheduleModel.timer?.get(1)!!.min
        val formatTwo = scheduleModel.timer?.get(1)!!.format
        val hourOne2 = scheduleModel.timerToSend?.get(0)!!.hours
        val minOne2 = scheduleModel.timerToSend?.get(0)!!.min
        val hourTwo2 = scheduleModel.timerToSend?.get(1)!!.hours
        val minTwo2 = scheduleModel.timerToSend?.get(1)!!.min
        firstTimerTv?.text =
            hourOne + ":" + minOne + formatOne + "-" + hourTwo + ":" + minTwo + formatTwo
        if (hourOne != "00" && minOne != "00") {
            firstTimerTv.visibility = View.VISIBLE
            firstTimer = "EE060000" + hourOne2 + minOne2 + hourTwo2 + minTwo2 + "."

        } else {
            firstTimerTv.visibility = View.INVISIBLE
            firstTimer = "EE060001" + hourOne2 + minOne2 + hourTwo2 + minTwo2 + "."

        }
        val hourThree = scheduleModel.timer?.get(2)!!.hours
        val minThree = scheduleModel.timer?.get(2)!!.min
        val formatThree = scheduleModel.timer?.get(2)!!.format
        val hourFour = scheduleModel.timer?.get(3)!!.hours
        val minFour = scheduleModel.timer?.get(3)!!.min
        val formatFour = scheduleModel.timer?.get(3)!!.format
        val hourThree2 = scheduleModel.timerToSend?.get(2)!!.hours
        val minThree2 = scheduleModel.timerToSend?.get(2)!!.min
        val hourFour2 = scheduleModel.timerToSend?.get(3)!!.hours
        val minFour2 = scheduleModel.timerToSend?.get(3)!!.min
        secondTimerTv?.text =
            hourThree + ":" + minThree + formatThree + "-" + hourFour + ":" + minFour + formatFour
        if (hourThree != "00" && minFour != "00") {
            secondTimer = "EE060010" + hourThree2 + minThree2 + hourFour2 + minFour2 + "."
            secondTimerTv?.visibility = View.VISIBLE
        } else {
            secondTimer = "EE060011" + hourThree2 + minThree2 + hourFour2 + minFour2 + "."
            secondTimerTv?.visibility = View.INVISIBLE
        }
        val hourFive = scheduleModel.timer?.get(4)!!.hours
        val minFive = scheduleModel.timer?.get(4)!!.min
        val formatFive = scheduleModel.timer?.get(4)!!.format
        val hourSix = scheduleModel.timer?.get(5)!!.hours
        val minSix = scheduleModel.timer?.get(5)!!.min
        val formatSix = scheduleModel.timer?.get(5)!!.format
        val hourFive2 = scheduleModel.timerToSend?.get(4)!!.hours
        val minFive2 = scheduleModel.timerToSend?.get(4)!!.min
        val hourSix2 = scheduleModel.timerToSend?.get(5)!!.hours
        val minSix2 = scheduleModel.timerToSend?.get(5)!!.min
        thirdTimerTv?.text =
            hourFive + ":" + minFive + formatFive + "-" + hourSix + ":" + minSix + formatSix
        if (hourFive != "00" && minFive != "00") {
            thirdTimerTv?.visibility = View.VISIBLE
            thirdTimer = "EE060020" + hourFive2 + minFive2 + hourSix2 + minSix2 + "."
        } else {
            thirdTimerTv?.visibility = View.INVISIBLE
            thirdTimer = "EE060021" + hourFive2 + minFive2 + hourSix2 + minSix2 + "."

        }
        val hourSeven = scheduleModel.timer?.get(6)!!.hours
        val formatSeven = scheduleModel.timer?.get(6)!!.format
        val minSeven = scheduleModel.timer?.get(6)!!.min
        val hourEight = scheduleModel.timer?.get(7)!!.hours
        val minEight = scheduleModel.timer?.get(7)!!.min
        val formatEight = scheduleModel.timer?.get(7)!!.format
        val hourSeven2 = scheduleModel.timerToSend?.get(6)!!.hours
        val minSeven2 = scheduleModel.timerToSend?.get(6)!!.min
        val hourEight2 = scheduleModel.timerToSend?.get(7)!!.hours
        val minEight2 = scheduleModel.timerToSend?.get(7)!!.min
        fourthTimerTv?.text =
            hourSeven + ":" + minSeven + formatSeven + "-" + hourEight + ":" + minEight + formatEight
        if (hourSeven != "00" && minSeven != "00") {
            fourthTimerTv?.visibility = View.VISIBLE
            fourthTimer = "EE060030" + hourSeven2 + minSeven2 + hourEight2 + minEight2 + "."
        } else {
            fourthTimerTv?.visibility = View.INVISIBLE
            fourthTimer = "EE060031" + hourSeven2 + minSeven2 + hourEight2 + minEight2 + "."

        }
        val sss = getSeconds(scheduleModel.suspend.toString())
        val ppp = getSeconds(scheduleModel.mist.toString())
        var friqu = "EE07000000" + ppp +"00"+ sss + "."
        sprayFriquency = friqu
        mistValue?.text = scheduleModel.mist.toString()
        suspendValue?.text = scheduleModel.suspend.toString()
    }

    fun checkNonStopResponse(response: String, bleDevice: BleDevice?, gatt: BluetoothGatt?) {
        when (response) {
            "EE120." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
            "EE121." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(nonStopOn, it1, it) } }
            // "EE111." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
            "EE110." -> {
                prefs.isFromHomeScreen = true
            }
        }
    }

    fun checkIntervalResponse(response: String, bleDevice: BleDevice?, gatt: BluetoothGatt?) {
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
            //     "EE111." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
            "EE110." -> {
                prefs.isFromHomeScreen = true
            }
        }
    }

    fun checkScheduleRespone(
        response: String,
        bleDevice: BleDevice?,
        gatt: BluetoothGatt?,
        number: Int
    ) {
        when (response) {
            "EE120." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        monday.toByteArray(charset),
                        it1,
                        it
                    )
                }
            }
            "EE1310." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        monday.toByteArray(charset),
                        it1,
                        it
                    )
                }
            }
            "EE1300." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        tuesday.toByteArray(charset),
                        it1,
                        it
                    )
                }
            }
            "EE1311." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        tuesday.toByteArray(charset),
                        it1,
                        it
                    )
                }
            }
            "EE1301." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        wednesday.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE1312." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        wednesday.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE1302." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        thursday.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE1313." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        thursday.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE1303." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        friday.toByteArray(charset),
                        it1,
                        it
                    )
                }
            }
            "EE1314." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        friday.toByteArray(charset),
                        it1,
                        it
                    )
                }
            }
            "EE1304." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        saturday.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE1315." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        saturday.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE1305." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        sunday.toByteArray(charset),
                        it1,
                        it
                    )
                }
            }
            "EE1316." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        sunday.toByteArray(charset),
                        it1,
                        it
                    )
                }
            }

            "EE1306." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayPDON, it1, it) } }
            "EE141." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayPDON, it1, it) } }
            "EE140." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayFriq, it1, it) } }
            "EE151." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayFriq, it1, it) } }

            "EE150." -> gatt?.let {
                responseTimerOne = responseTimerOne + 1
                bleDevice?.let { it1 ->
                    sendCommand(
                        firstTimer.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE16100." -> gatt?.let {

                bleDevice?.let { it1 ->
                    sendCommand(
                        firstTimer.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE16000." -> gatt?.let {
                responseTimerOne = 0
                bleDevice?.let { it1 ->
                    sendCommand(
                        secondTimer.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE16101." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        secondTimer.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE16001." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        thirdTimer.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE16102." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        thirdTimer.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE16002." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        fourthTimer.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE16103." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        fourthTimer.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE160." -> {
                when (responseTimerOne) {

                    0 -> gatt?.let {
                        responseTimerOne = responseTimerOne + 1
                        bleDevice?.let { it1 ->
                            sendCommand(
                                firstTimer.toByteArray(
                                    charset
                                ), it1, it
                            )
                        }
                    }
                    1 -> gatt?.let {
                        responseTimerOne = responseTimerOne + 1
                        bleDevice?.let { it1 ->
                            sendCommand(
                                secondTimer.toByteArray(
                                    charset
                                ), it1, it
                            )
                        }
                    }
                    2 -> gatt?.let {
                        responseTimerOne = responseTimerOne + 1
                        bleDevice?.let { it1 ->
                            sendCommand(
                                thirdTimer.toByteArray(
                                    charset
                                ), it1, it
                            )
                        }
                    }
                    3 -> gatt?.let {
                        responseTimerOne = 0
                        bleDevice?.let { it1 ->
                            sendCommand(
                                fourthTimer.toByteArray(
                                    charset
                                ), it1, it
                            )
                        }
                    }

                }

            }
            "EE16003." -> {
                if (scheduleModel.nonStop == false) {

                    gatt?.let {
                        bleDevice?.let { it1 ->
                            sendCommand(
                                sprayFriquency.toByteArray(
                                    charset
                                ), it1, it
                            )
                        }
                    }
                } else {
                    gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
                }
            }
            "EE171." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        sprayFriquency.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
            "EE170." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
            //   "EE111." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
            "EE110." -> {
                prefs.isFromHomeScreen = true
            }

        }
    }



    fun setDisplayMode() {

        if (deviceObject != null) {

            val isOn = deviceObject?.isOn
            if (isOn == true && prefs.isFromHomeScreen) {
                btnStart?.isEnabled = false
                Handler().postDelayed({
                    btnStart?.isEnabled = true
                    btnStart?.tag = "stop"
                    motionLayout?.transitionToEnd()
                    isTimeSync = false
                    carViewHome?.isEnabled = false

                    if (deviceObject?.isSparayMode == true) {
                        if (deviceObject?.isSprayPerDay == false) {
                            intervalImg?.performClick()
                            tabName?.text = resources.getString(R.string.interval)
                            tab_icon?.setImageDrawable(
                                ContextCompat.getDrawable(
                                    requireContext(),
                                    R.drawable.interval_blue_icon
                                )
                            )

                        } else {
                            scheduleImg?.performClick()
                            tabName?.text = resources.getString(R.string.schedule)
                            tab_icon?.setImageDrawable(
                                ContextCompat.getDrawable(
                                    requireContext(),
                                    R.drawable.calendar_blue_icon
                                )
                            )
                            //    setTabItemVisibility(true)
                            setScheduleActiveView()
                        }
                    } else {
                        nonStopImg?.performClick()
                        tabName?.text = resources.getString(R.string.non_stop)
                        tab_icon?.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.non_stop_blue_icon
                            )
                        )

                    }
                },1000)
                if (tag!=0)
                {
                    val ss = deviceObject?.mistTime
                    val pp = deviceObject?.suspendTime
                    mistValue?.text = ss?.let { getTimeFromSeconds(it) }
                    suspendValue?.text = pp?.let { getTimeFromSeconds(it) }
                    mistValue?.visibility=View.VISIBLE
                    suspendValue?.visibility=View.VISIBLE
                    if (ss != null) {
                        mistValueSeconds=ss
                    }
                    if (pp != null) {
                        suspendValueSeconds=pp
                    }
                }
            }
        }

    }

    fun setFirstDevice() {
        val deviceOne = prefs.firstDevice
        if (!deviceOne.isNullOrEmpty()) {
            savedDevicesNumber = savedDevicesNumber + 1
            val gson = Gson()
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            deviceObject=deviceOneObj
            var i = 0
            for (item in bleList) {
                if (deviceOneObj?.name == item.name) {
                    firstBleDevice = item
                    firstGate =
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                            firstBleDevice
                        )!!
                    gattList.add(firstGate!!)
                    return
                }
            }
        }
    }


    fun setSecondDevice() {
        val deviceTwo = prefs.secondDevice
        if (!deviceTwo.isNullOrEmpty()) {
            savedDevicesNumber = savedDevicesNumber + 1

            val gson = Gson()
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            deviceObject=deviceTwoObj
            for (item in bleList) {
                if (deviceTwoObj?.name == item.name) {
                    secondBleDevice = item
                    secondGate =
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                            secondBleDevice
                        )!!
                    gattList.add(secondGate!!)
                    return
                }
            }
        }
    }

    fun setThirdDevice() {
        val deviceThree = prefs.thirdDevice
        if (!deviceThree.isNullOrEmpty()) {
            savedDevicesNumber = savedDevicesNumber + 1
            val gson = Gson()
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            deviceObject=deviceThreeObj
            for (item in bleList) {
                if (deviceThreeObj?.name == item.name) {
                    thirdBleDevice = item
                    thirdGate =
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                            thirdBleDevice
                        )!!
                    gattList.add(thirdGate!!)

                    return
                }
            }
        }
    }

    fun setFourthDevice() {
        val deviceFour = prefs.fourthDevice
        if (!deviceFour.isNullOrEmpty()) {
            savedDevicesNumber = savedDevicesNumber + 1
            val gson = Gson()
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            deviceObject=deviceFourObj
            for (item in bleList) {
                if (deviceFourObj?.name == item.name) {
                    fourthBleDevice = item
                    fourthGate =
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                            fourthBleDevice
                        )!!
                    gattList.add(fourthGate!!)
                    return
                }
            }
        }
    }

    fun setTouchSwipeListener() {
        val gesture = GestureDetector(
            activity,
            object : SimpleOnGestureListener() {
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

        carViewHome.setOnTouchListener(OnTouchListener { v, event -> gesture.onTouchEvent(event) })

    }

    fun setMotionLayoutListener() {
        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                constraintSet: Int,
                p2: Int
            ) {
                startingTv.visibility = View.GONE
                if (btnStart.tag == "stop") {
                    setTabItemVisibility(true)

                    guideline?.setGuidelinePercent(1f)

                } else {
                    setTabItemVisibility(false)
                    if (tag == 0) {
                        guideline?.setGuidelinePercent(1f)
                    } else {
                        guideline?.setGuidelinePercent(0.65f)
                    }
                }
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                constraintSet: Int,
                p2: Int,
                p3: Float
            ) {

            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, constraintSet: Int) {
                startingTv?.visibility = View.GONE

                if (constraintSet == R.id.start) {
                    btnStart?.setBackgroundResource(R.drawable.blue_radius_8)
                    btnStart?.text = getString(R.string.start)
                    btnStart.isEnabled = true
                    carViewHome?.isEnabled = true
                    setTabItemVisibility(false)

                } else {
                    btnStart?.setBackgroundResource(R.drawable.container_light_blue)
                    btnStart?.text = getString(R.string.stop)
                    btnStart?.isEnabled = true
                    setTabItemVisibility(true)
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

    fun setTabItemVisibility(state: Boolean) {
        if (state) {
            intervalImg?.visibility = View.INVISIBLE
            intervalTv?.visibility = View.INVISIBLE
            scheduleImg?.visibility = View.INVISIBLE
            scheduleTv?.visibility = View.INVISIBLE
            nonStopImg?.visibility = View.INVISIBLE
            nonStopTv?.visibility = View.INVISIBLE
            firstLine?.visibility = View.INVISIBLE
            bleBg?.visibility = View.INVISIBLE
            bleIcon?.visibility = View.INVISIBLE
            standbyTv?.visibility = View.INVISIBLE
            mistTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            mistValue?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            suspendTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            suspendValue?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            mondayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            tuesdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            wednesdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            thusdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            fridayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            saturdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            sundayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            firstTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            secondTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            thirdTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            fourthTimerTv?.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
        } else {
            intervalImg?.visibility = View.VISIBLE
            intervalTv?.visibility = View.VISIBLE
            scheduleImg?.visibility = View.VISIBLE
            scheduleTv?.visibility = View.VISIBLE
            nonStopImg?.visibility = View.VISIBLE
            nonStopTv?.visibility = View.VISIBLE
            firstLine?.visibility = View.VISIBLE
            bleBg?.visibility = View.VISIBLE
            bleIcon?.visibility = View.VISIBLE
            standbyTv?.visibility = View.VISIBLE
            mistTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            mistValue?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            suspendTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            suspendValue?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            mondayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            tuesdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            wednesdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            thusdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            fridayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            saturdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            sundayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            firstTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            secondTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            thirdTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            fourthTimerTv?.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.dark_gray
                )
            )
            firstLine?.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.dark_gray
                )
            )
        }
    }

    fun setNonStopView() {
        tag = 0
        mistTv?.visibility = View.INVISIBLE
        mistValue?.visibility = View.INVISIBLE
        suspendTv?.visibility = View.INVISIBLE
        suspendValue?.visibility = View.INVISIBLE
        btnEdit?.visibility = View.INVISIBLE
        secondLine?.visibility = View.INVISIBLE
        mondayTv?.visibility = View.INVISIBLE
        tuesdayTv?.visibility = View.INVISIBLE
        wednesdayTv?.visibility = View.INVISIBLE
        thusdayTv?.visibility = View.INVISIBLE
        fridayTv?.visibility = View.INVISIBLE
        saturdayTv?.visibility = View.INVISIBLE
        sundayTv?.visibility = View.INVISIBLE
        firstTimerTv?.visibility = View.INVISIBLE
        secondTimerTv?.visibility = View.INVISIBLE
        thirdTimerTv?.visibility = View.INVISIBLE
        fourthTimerTv?.visibility = View.INVISIBLE

        nonStopTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        intervalTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        scheduleTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        val size =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        if (size == 0) {
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.red_circle)
            )
        } else if (size != 0 && size < savedDevicesNumber) {
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.yelow_img)
            )
        } else if (size == savedDevicesNumber) {
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
            )
        }


        guideline?.setGuidelinePercent(1f)
        nonStopImg?.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop_orange_icon
            )
        )
        intervalImg?.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_icon
            )
        )
        scheduleImg?.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_icon
            )
        )
        val ss = deviceObject?.mistTime
        val pp = deviceObject?.suspendTime
        mistValue?.text = ss?.let { getTimeFromSeconds(it) }
        suspendValue?.text = pp?.let { getTimeFromSeconds(it) }
        if (ss != null) {
            mistValueSeconds=ss
        }
        else{
            mistValue?.text="5s"
        }
        if (pp != null) {
            suspendValueSeconds=pp
        }
        else{
            suspendValue?.text="5s"
        }
    }

    fun setIntervalView() {
        val size =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        tag = 1
        mistTv?.visibility = View.VISIBLE
        mistValue?.visibility = View.VISIBLE
        suspendTv?.visibility = View.VISIBLE
        suspendValue?.visibility = View.VISIBLE
        btnEdit?.visibility = View.VISIBLE
        secondLine?.visibility = View.VISIBLE
        nonStopTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        intervalTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        scheduleTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        nonStopImg?.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop_icon
            )
        )
        intervalImg?.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_orange_icon
            )
        )
        scheduleImg?.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_icon
            )
        )
        if (size == 0) {
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.red_circle)
            )
        } else if (size != 0 && size < savedDevicesNumber) {
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.yelow_img)
            )
        } else if (size == savedDevicesNumber) {
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
            )
        }
        guideline?.setGuidelinePercent(0.65f)
        mondayTv?.visibility = View.INVISIBLE
        tuesdayTv?.visibility = View.INVISIBLE
        wednesdayTv?.visibility = View.INVISIBLE
        thusdayTv?.visibility = View.INVISIBLE
        fridayTv?.visibility = View.INVISIBLE
        saturdayTv?.visibility = View.INVISIBLE
        sundayTv?.visibility = View.INVISIBLE
        firstTimerTv?.visibility = View.INVISIBLE
        secondTimerTv?.visibility = View.INVISIBLE
        thirdTimerTv?.visibility = View.INVISIBLE
        fourthTimerTv?.visibility = View.INVISIBLE
        val ss = deviceObject?.mistTime
        val pp = deviceObject?.suspendTime
        mistValue?.text = ss?.let { getTimeFromSeconds(it) }
        suspendValue?.text = pp?.let { getTimeFromSeconds(it) }

        if (ss != null) {
            mistValueSeconds=ss
        }
        else{
            mistValue?.text="5s"
        }
        if (pp != null) {
            suspendValueSeconds=pp
        }
        else{
            suspendValue?.text="5s"
        }
    }

    fun setScheduleView() {
        val size =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        tag = 2
        mistTv?.visibility = View.VISIBLE
        mistValue?.visibility = View.VISIBLE
        suspendTv?.visibility = View.VISIBLE
        suspendValue?.visibility = View.VISIBLE
        btnEdit?.visibility = View.VISIBLE
        mondayTv?.visibility = View.VISIBLE
        tuesdayTv?.visibility = View.VISIBLE
        wednesdayTv?.visibility = View.VISIBLE
        thusdayTv?.visibility = View.VISIBLE
        fridayTv?.visibility = View.VISIBLE
        saturdayTv?.visibility = View.VISIBLE
        sundayTv?.visibility = View.VISIBLE
        firstTimerTv?.visibility = View.VISIBLE
        secondTimerTv?.visibility = View.VISIBLE
        thirdTimerTv?.visibility = View.VISIBLE
        fourthTimerTv?.visibility = View.VISIBLE
        nonStopTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        intervalTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        scheduleTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        nonStopImg?.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop_icon
            )
        )
        intervalImg?.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_icon
            )
        )
        scheduleImg?.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_orange_icon
            )
        )
        if (size == 0) {
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.red_circle)
            )
        } else if (size != 0 && size < savedDevicesNumber) {
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.yelow_img)
            )
        } else if (size == savedDevicesNumber) {
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
            )
        }
        guideline?.setGuidelinePercent(0.65f)
        val ss = deviceObject?.mistTime
        val pp = deviceObject?.suspendTime
        mistValue?.text = ss?.let { getTimeFromSeconds(it) }
        suspendValue?.text = pp?.let { getTimeFromSeconds(it) }
        if (ss != null) {
            mistValueSeconds=ss
        }
        if (pp != null) {
            suspendValueSeconds=pp
        }
    }

    fun setScheduleActiveView() {
        val first =
            setTimeZone(deviceObject?.firstStartTime) + " - " + setTimeZone(deviceObject?.firstStopTime)
        val second =
            setTimeZone(deviceObject?.secondStartTime) + " - " + setTimeZone(deviceObject?.secondStopTime)
        val third =
            setTimeZone(deviceObject?.thirdStartTime) + " - " + setTimeZone(deviceObject?.thirdStopTime)
        val fourt =
            setTimeZone(deviceObject?.fourtStartTime) + " - " + setTimeZone(deviceObject?.fourtStopTime)

        firstTimerTv?.text = first
        secondTimerTv?.text = second
        thirdTimerTv?.text = third
        fourthTimerTv?.text = fourt
        if (first == " - ") {
            firstTimerTv?.visibility = View.INVISIBLE
        }
        if (second == " - ") {
            secondTimerTv?.visibility = View.INVISIBLE
        }
        if (third == " - ") {
            thirdTimerTv?.visibility = View.INVISIBLE
        }
        if (fourt == " - ") {
            fourthTimerTv?.visibility = View.INVISIBLE
        }
        mistValue?.text=getTimeFromSeconds(deviceObject?.mistTime!!)
        suspendValue?.text=getTimeFromSeconds(deviceObject?.suspendTime!!)
        if(tag!=0)
        {
            mistValue?.visibility=View.VISIBLE
            suspendValue?.visibility=View.VISIBLE
        }
        val ss = deviceObject?.mistTime
        val pp = deviceObject?.suspendTime
        if (ss != null) {
            mistValueSeconds=ss
        }
        if (pp != null) {
            suspendValueSeconds=pp
        }
    }

    fun setTabView() {

        when (tag) {
            0 -> {
                tabName?.text = resources.getString(R.string.non_stop)
                tab_icon?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.non_stop_blue_icon
                    )
                )
            }
            1 -> {
                tabName?.text = resources.getString(R.string.interval)
                tab_icon?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.interval_blue_icon
                    )
                )
            }
            2 -> {
                tabName?.text = resources.getString(R.string.schedule)
                tab_icon?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.calendar_blue_icon
                    )
                )
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


    private fun navigateToSetSchedule() {
        val action = HomeFragmentDirections.actionScheduleToSetScheduleFragment(1)
        findNavController().navigate(action)
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
                    val suspend = data?.getString("suspend")

                    mistValueSeconds = mist?.let { getSeconds(it) }.toString()
                    suspendValueSeconds = suspend?.let { getSeconds(it) }.toString()

                    mistValue?.text = mist
                    suspendValue?.text = suspend
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


    fun initBleConroller() {
        bluetoothController =
            BluetoothController(
                null,
                null,
                null,
                null,
                null,
                null,
                writeCallback,
                requireContext()
            )
        bluetoothController.bluetoothManager
            .enableLog(true)
            .setReConnectCount(1, 4000)
            .setConnectOverTime(18000).operateTimeout = 4000

        connectionStateCoordinator.bluetoothController = bluetoothController
        bluetoothController.bluetoothAdapter.startDiscovery()
        connectionStateCoordinator.isDeviceConnected = false
        bluetoothController.bluetoothManager.init(requireActivity().application)

        connectionStateCoordinator.listBleDevices.clear()
        bluetoothController.startScan()

    }


    private val writeCallback = object : BleWriteCallback() {
        override fun onWriteSuccess(current: Int, total: Int, justWrite: ByteArray?) {
        }

        override fun onWriteFailure(exception: BleException?) {
        }
    }

    fun getSeconds(value: String): String {
        var seconds = "005"
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
            "30s" -> seconds = "030"
            "35s" -> seconds = "035"
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
            "14m 30s" -> seconds = "870"
            "15m" -> seconds = "900"
        }
        return seconds
    }

    fun getTimeFromSeconds(seconds: String): String {
        var time = "5s"
        when (seconds) {
            "005" -> time = "5s"
            "006" -> time = "6s"
            "007" -> time = "7s"
            "008" -> time = "8s"
            "009" -> time = "9s"
            "010" -> time = "10s"
            "011" -> time = "11s"
            "012" -> time = "12s"
            "013" -> time = "13s"
            "014" -> time = "14s"
            "015" -> time = "15s"
            "016" -> time = "16s"
            "017" -> time = "17s"
            "018" -> time = "18s"
            "019" -> time = "19s"
            "020" -> time = "20s"
            "025" -> time = "25s"
            "030" -> time = "30s"
            "035" -> time = "35s"
            "045" -> time = "40s"
            "050" -> time = "50s"
            "055" -> time = "55s"
            "060" -> time = "1m"
            "090" -> time = "1m 30s"
            "120" -> time = "2m"
            "150" -> time = "2m 30s"
            "180" -> time = "3m"
            "210" -> time = "3m 30s"
            "240" -> time = "4m"
            "270" -> time = "4m 30s"
            "300" -> time = "5m"
            "330" -> time = "5m 30s"
            "360" -> time = "6m"
            "390" -> time = "6m 30s"
            "420" -> time = "7m"
            "450" -> time = "7m 30s"
            "480" -> time = "8m"
            "510" -> time = "8m 30s"
            "540" -> time = "9m"
            "570" -> time = "9m 30s"
            "600" -> time = "10m"
            "630" -> time = "10m 30s"
            "660" -> time = "11m"
            "690" -> time = "11m 30s"
            "720" -> time = "12m"
            "750" -> time = "12m 30s"
            "780" -> time = "13m"
            "810" -> time = "13m 30s"
            "840" -> time = "14m"
            "870" -> time = "14m 30s"
            "900" -> time = "15m"
        }
        return time
    }


    fun synchTime() {

        val currentDateTime = LocalDateTime.now()
        val min = currentDateTime.minute
        val hour = currentDateTime.hour
        val sec = currentDateTime.second
        val year = currentDateTime.year
        val dayOfWeek = currentDateTime.dayOfWeek
        val month = currentDateTime.format(DateTimeFormatter.ofPattern("MM"))
        val day = currentDateTime.format(DateTimeFormatter.ofPattern("dd"))
        val dayNumber = getDayInWeek(dayOfWeek.toString().toLowerCase())

        var secString = ""
        var setHour = ""
        if (sec < 10) {
            secString = "0" + sec
        } else {
            secString = sec.toString()
        }
        if (hour < 10) {
            setHour = "0" + hour
        } else {
            setHour = hour.toString()
        }
        var minString = ""
        if (min < 10) {
            minString = "0" + min
        } else {
            minString = min.toString()
        }
        dateAndTimeSynch =
            "EE000+" + year + month + day + setHour + minString + secString + dayNumber + "."

        Log.e("D", "dateAndTimeSynch $dateAndTimeSynch")
        firstBleDevice?.let {
            firstGate?.let { it1 ->
                sendCommand(
                    dateAndTimeSynch.toByteArray(charset),
                    it, it1
                )
            }
        }

        secondBleDevice?.let {
            secondGate?.let { it1 ->
                sendCommand(
                    dateAndTimeSynch.toByteArray(charset),
                    it, it1
                )
            }
        }


        thirdBleDevice?.let {
            thirdGate?.let { it1 ->
                sendCommand(
                    dateAndTimeSynch.toByteArray(charset),
                    it, it1
                )
            }
        }

        fourthBleDevice?.let {
            fourthGate?.let { it1 ->
                sendCommand(
                    dateAndTimeSynch.toByteArray(charset),
                    it, it1
                )
            }
        }
    }

    fun showDisconnectedDeviceDialog() {
        dialogDisconnectedDevice = DevicesDisconnected(false)
        dialogDisconnectedDevice?.isCancelable = true
        dialogDisconnectedDevice?.show(childFragmentManager, "")
    }
}


