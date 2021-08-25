package llc.aerMist.app.ui.home

import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothGatt
import android.content.Intent
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
import kotlinx.android.synthetic.main.fragment_home.sundayTv
import kotlinx.android.synthetic.main.fragment_home.suspendTv
import kotlinx.android.synthetic.main.fragment_home.suspendValue
import kotlinx.android.synthetic.main.fragment_home.tabName
import kotlinx.android.synthetic.main.fragment_home.tab_icon
import kotlinx.android.synthetic.main.fragment_home.thirdTimerTv
import kotlinx.android.synthetic.main.fragment_home.thusdayTv
import kotlinx.android.synthetic.main.fragment_home.wednesdayTv
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.*
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.DevicesDisconnected
import llc.aerMist.app.ui.popup.NumberPickerPopup
import llc.aerMist.app.ui.popup.RenameDevicePopup
import org.koin.android.ext.android.inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class HomeFragment : Fragment(), View.OnClickListener {
    private val prefs: PreferenceCache by inject()
    private var tag = 0
    var numberPickerPopup = NumberPickerPopup()
    var bluetoothController: BluetoothController? = null
    val connectionStateCoordinator = NewObservableCoordinator
    var firstBleDevice: BleDevice? = null
    var secondBleDevice: BleDevice? = null
    var thirdBleDevice: BleDevice? = null
    var fourthBleDevice: BleDevice? = null
    var firstGate: BluetoothGatt? = null
    var secondGate: BluetoothGatt? = null
    var thirdGate: BluetoothGatt? = null
    var fourthGate: BluetoothGatt? = null
    var allDevices = 0
    private var bleList = ArrayList<BleDevice>()
    private var gattList = ArrayList<BluetoothGatt>()
    private var mistValueSeconds = "005"
    private var suspendValueSeconds = "005"
    var counter = 0
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
    lateinit var monday2: ByteArray
    lateinit var tuesday2: ByteArray
    lateinit var wednesday2: ByteArray
    lateinit var thursday2: ByteArray
    lateinit var friday2: ByteArray
    lateinit var saturday2: ByteArray
    lateinit var sunday2: ByteArray
    lateinit var firstTimer2: ByteArray
    lateinit var secondTimer2: ByteArray
    lateinit var thirdTimer2: ByteArray
    lateinit var fourthTimer2: ByteArray
    lateinit var sprayFriquency2: ByteArray
    var sprayFriquency = "EE07000000SSS00PPP"
    var dateAndTimeSynch = "EE00+YYYYMMDDHHNNSST"
    lateinit var daysInWeek: IntArray
    private val scheduleModelArgs: HomeFragmentArgs by navArgs()
    private lateinit var scheduleModel: ScheduleModel
    var deviceObject: ScheduleModel? = null
    var mainDevicePositon = 0
    val scheduleDellay = 1600
    var disconectedDialog: DevicesDisconnected? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setClickListener()
        setMotionLayoutListener()
        setTouchSwipeListener()
        bluetoothController = connectionStateCoordinator.bluetoothController

        allDevices =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        if (allDevices > 0) {
            bleList =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
        }
        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
        checkTotalNumber()
        deviceNumber?.text = allDevices.toString() + " of " + counter + " devices"
        val scheduleModel = prefs.scheduleModel
        val gson = Gson()
        val model = gson.fromJson(scheduleModel, ScheduleModel::class.java)
        deviceObject = model
        if (deviceObject?.timer?.get(0)?.hours != "00" || deviceObject?.timer?.get(2)?.hours != "00" || deviceObject?.timer?.get(
                4
            )?.hours != "00" || deviceObject?.timer?.get(6)?.hours != "00"
        ) {
            isSelected = true
        }
        nonStopImg.performClick()
        if (scheduleModelArgs.model != null) {
            scheduleImg.performClick()
            setScheduleActiveView()
        } else {
            setView()
        }
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
        }

        connectionStateCoordinator.bluetoothByteArray.observe(viewLifecycleOwner, observer)
        val diconectedObserverOne = Observer<BleDevice> {
            connectionStateCoordinator.firstGattController?.let { it1 ->
                setDisonectViewFirst(
                    it,
                    it1
                )
            }
        }

        val conectedObserver = Observer<BleDevice> {
            val size =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            checkTotalNumber()
            deviceNumber?.text = size.toString() + " of " + counter + " devices"
            standbyTv?.text = resources.getString(R.string.standby)
            btnStart.isEnabled = true
            if (size == 0) {
                showDisconnectedDeviceDialog()
                bleBg?.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.red_circle)
                )
            } else if (size != 0 && size < counter) {
                removeDialog()
                bleBg?.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.yelow_img)
                )
            } else if (size == counter) {
                removeDialog()
                bleBg?.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
                )
            }
            allDevices =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            if (allDevices > 0) {
                bleList =
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            }
            if (it.name == deviceOneObj?.name) {
                setFirstDevice()
            }
            if (it.name == deviceTwoObj?.name) {
                setSecondDevice()
            }
            if (it.name == deviceThreeObj?.name) {
                setThirdDevice()
            }
            if (it.name == deviceFourObj?.name) {
                setFourthDevice()
            }
        }
        connectionStateCoordinator.bleDisconnectDevicesFirst.observe(
            viewLifecycleOwner,
            diconectedObserverOne
        )
        connectionStateCoordinator.bluetoothConnectionStateFirst.observe(
            viewLifecycleOwner,
            conectedObserver
        )

        Handler().postDelayed({
            synchTime(4)
        }, 800)
    }

    fun setDisonectViewFirst(bleDevice: BleDevice?, gattCallback: BleGattCallback) {
        bleDevice?.let { connectDevice(it, gattCallback) }
        val size =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        allDevices = size
        checkTotalNumber()
        deviceNumber?.text = allDevices.toString() + " of " + counter + " devices"
        standbyTv?.text = resources.getString(R.string.standby)
        if (size == 0) {
            showDisconnectedDeviceDialog()
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.red_circle)
            )
        } else
            if (size != 0 && size < counter) {
                btnStart.isEnabled = true
                bleBg?.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.yelow_img)
                )
                removeDialog()
            } else if (size == counter) {
                removeDialog()
                btnStart.isEnabled = true
                bleBg?.setImageDrawable(
                    ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
                )
            }
    }

    fun setView() {
        val state = prefs.deviceState
        if (!state.isNullOrEmpty()) {
            val gson = Gson()
            val deviceState = gson.fromJson(state, DeviceState::class.java)
            val deviceTag = deviceState.tag
            val active = deviceState.active

            if (active) {
                when (deviceTag) {
                    0 -> {
                        btnStart?.tag = "stop"
                        motionLayout?.transitionToEnd()
                        isTimeSync = false
                        carViewHome?.isEnabled = false
                        nonStopImg?.performClick()
                        tabName?.text = resources.getString(R.string.non_stop)
                        tab_icon?.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.non_stop_blue_icon
                            )
                        )
                    }
                    1 -> {
                        if (active) {
                            btnStart?.tag = "stop"
                            motionLayout?.transitionToEnd()
                            isTimeSync = false
                            carViewHome?.isEnabled = false
                            intervalImg?.performClick()
                            tabName?.text = resources.getString(R.string.interval)
                            tab_icon?.setImageDrawable(
                                ContextCompat.getDrawable(
                                    requireContext(),
                                    R.drawable.interval_blue_icon
                                )
                            )
                        } else {
                            intervalImg.performClick()
                        }
                    }
                    2 -> {
                        if (active) {
                            btnStart?.tag = "stop"
                            motionLayout?.transitionToEnd()
                            isTimeSync = false
                            carViewHome?.isEnabled = false
                            scheduleImg?.performClick()
                            tabName?.text = resources.getString(R.string.schedule)
                            tab_icon?.setImageDrawable(
                                ContextCompat.getDrawable(
                                    requireContext(),
                                    R.drawable.calendar_blue_icon
                                )
                            )
                            setScheduleActiveView()
                        }
                    }
                }
            } else {
                nonStopImg.performClick()
            }
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    fun connectDevice(bleDevice: BleDevice, gattCallback: BleGattCallback) {
        Log.e("D", "connectDevice " + bleDevice.name)

        if (connectionStateCoordinator.bluetoothController?.bluetoothManager!!.isConnected(bleDevice) == false) {
            Log.e("D", "isConnected  == false")

            if (bleDevice.name == deviceOneObj?.name || bleDevice.name == deviceTwoObj?.name || bleDevice.name == deviceThreeObj?.name || bleDevice.name == deviceFourObj?.name) {
                Log.e("D", "bleDevice.name " + deviceOneObj?.name)

                connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                    bleDevice,
                    gattCallback
                )
            }
        }
    }

    fun setTimeZone(time: String?, zone: String?): String {
        var fullTime = ""
        if (time?.length == 4) {
            var hour = time.substring(0, 2).toIntOrNull()
            var min = time.substring(2, 4).toIntOrNull()

            if (hour != null && min != null) {
                if (hour < 10 && hour != 0) {
                    fullTime = "0" + hour.toString() + ":" + min + zone
                    if (min < 10) {
                        fullTime = "0" + hour.toString() + ":" + "0" + min + zone
                    }
                } else {
                    fullTime = hour.toString() + ":" + min + zone
                    if (min < 10) {
                        fullTime = hour.toString() + ":" + "0" + min + zone
                    }
                }
                if (hour == 0 && min == 0) {
                    fullTime = ""
                }
            }
        }
        return fullTime
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
                isTimeSync = false
                carViewHome.isEnabled = false

                if (bluetoothController?.bluetoothAdapter?.isEnabled == true) {

                    if (tag == 0) {
                        setTabView()
                        motionLayout?.transitionToEnd()
                        motionLayout?.transitionToStart()
                        val deviceState = DeviceState(tag, true)
                        val gson = Gson()
                        val json2 = gson.toJson(deviceState)
                        prefs.deviceState = json2

                        if (btnStart.tag == "start") {
                            btnStart.tag = "stop"
                            Handler().postDelayed({
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
                                Handler().postDelayed({
                                    synchTime(4)
                                }, 800)
                            }, 800)

                        } else {
                            btnStart.tag = "start"
                            val deviceState = DeviceState(tag, false)
                            val gson = Gson()
                            val json2 = gson.toJson(deviceState)
                            prefs.deviceState = json2

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
                            Handler().postDelayed({
                                synchTime(4)
                            }, 800)
                        }
                    } else if (tag == 1) {
                        if (!intervalValue.isEmpty()) {
//                            motionLayout?.transitionToEnd()
//                            motionLayout?.transitionToStart()
                            setTabView()
                            if (btnStart.tag == "start") {
                                btnStart.tag = "stop"
                                motionLayout?.transitionToEnd()
                                motionLayout?.transitionToStart()
                                guideline?.setGuidelinePercent(1f)
                                val intervalModel: IntervalModel =
                                    IntervalModel(mistValueSeconds, suspendValueSeconds)
                                val deviceState = DeviceState(tag, true)
                                val gson = Gson()
                                val json = gson.toJson(intervalModel)
                                val json2 = gson.toJson(deviceState)
                                prefs.intervalModel = json
                                prefs.deviceState = json2

                                var i = 0
                                Handler().postDelayed({

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
                                        synchTime(4)
                                    }, 2000)
                                }, 800)
                            } else {
                                btnStart.tag = "start"
                                motionLayout.transitionToEnd()
                                motionLayout.transitionToStart()
                                guideline?.setGuidelinePercent(0.65f)
                                val deviceState = DeviceState(tag, false)
                                val gson = Gson()
                                val json2 = gson.toJson(deviceState)
                                prefs.deviceState = json2
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
                                Handler().postDelayed({
                                    synchTime(4)
                                }, 800)

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
                            if (firstTimer.contains("null") || !isSelected) {
                                //  if (scheduleModel.timer.get(0)=="0.0")
                                Snackbar.make(
                                    requireView(),
                                    getString(R.string.you_must_choose),
                                    Snackbar.LENGTH_SHORT
                                ).show()
                                return
                            }
                            btnStart.tag = "stop"
                            motionLayout?.transitionToEnd()
                            motionLayout?.transitionToStart()
                            Handler().postDelayed({
                                guideline?.setGuidelinePercent(1f)
                                var i = 0
                                val deviceState = DeviceState(tag, true)
                                val gson = Gson()
                                val json2 = gson.toJson(deviceState)

                                prefs.deviceState = json2
                                firstGate?.let {
                                    firstBleDevice?.let { it1 ->
                                        sendCommand(
                                            intervalOn,
                                            it1, it
                                        )
                                    }
                                }

                                if (secondBleDevice != null) {
                                    secondGate?.let {
                                        secondBleDevice?.let { it1 ->
                                            Handler().postDelayed({
                                                sendCommand(
                                                    intervalOn,
                                                    it1, it
                                                )
                                            }, 1000)
                                        }
                                    }
                                }
                                if (thirdBleDevice != null) {
                                    thirdGate?.let {
                                        thirdBleDevice?.let { it1 ->
                                            Handler().postDelayed({
                                                sendCommand(
                                                    intervalOn,
                                                    it1, it
                                                )
                                            }, 2000)
                                        }
                                    }
                                }
                                if (fourthBleDevice != null) {
                                    fourthGate?.let {
                                        fourthBleDevice?.let { it1 ->
                                            Handler().postDelayed({
                                                sendCommand(
                                                    intervalOn,
                                                    it1, it
                                                )
                                            }, 3000)
                                        }
                                    }
                                }
                                checkTotalNumber()
                                // guideline?.setGuidelinePercent(0.6f)
                                val delay = counter * 1000
                                Handler().postDelayed({
                                    synchTime(4)
                                }, delay.toLong())
                            }, 800)
                        } else {
                            btnStart.tag = "start"
                            var i = 0
                            responseTimerOne = 0
                            responseTimerTwo = 0
                            responseTimerThree = 0
                            responseTimerFour = 0
                            guideline?.setGuidelinePercent(0.65f)
                            motionLayout.transitionToEnd()
                            motionLayout.transitionToStart()
                            val deviceState = DeviceState(tag, false)
                            val gson = Gson()
                            val json2 = gson.toJson(deviceState)
                            prefs.deviceState = json2
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
                            Handler().postDelayed({
                                synchTime(4)
                            }, 1000)
                        }
                    }
                } else {
                    Snackbar.make(
                        requireView(),
                        getString(R.string.turn_bluetooth_on),
                        Snackbar.LENGTH_SHORT
                    ).show()
                    return
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

    fun formatTimer() {

        val hourOne2 = deviceObject?.timerToSend?.get(0)?.hours
        val minOne2 = deviceObject?.timerToSend?.get(0)?.min
        val hourTwo2 = deviceObject?.timerToSend?.get(1)?.hours
        val minTwo2 = deviceObject?.timerToSend?.get(1)?.min

        if (hourOne2 != "00") {
            firstTimer = "EE060000" + hourOne2 + minOne2 + hourTwo2 + minTwo2 + "."
            firstTimer2 = firstTimer.toByteArray(charset)

        } else {
            firstTimer = "EE060001" + hourOne2 + minOne2 + hourTwo2 + minTwo2 + "."
            firstTimer2 = firstTimer.toByteArray(charset)
        }

        val hourThree2 = deviceObject?.timerToSend?.get(2)?.hours
        val minThree2 = deviceObject?.timerToSend?.get(2)?.min
        val hourFour2 = deviceObject?.timerToSend?.get(3)?.hours
        val minFour2 = deviceObject?.timerToSend?.get(3)?.min

        if (hourThree2 != "00") {
            secondTimer = "EE060010" + hourThree2 + minThree2 + hourFour2 + minFour2 + "."
            secondTimer2 = secondTimer.toByteArray(charset)

        } else {
            secondTimer = "EE060011" + hourThree2 + minThree2 + hourFour2 + minFour2 + "."
            secondTimer2 = secondTimer.toByteArray(charset)
        }

        val hourFive2 = deviceObject?.timerToSend?.get(4)?.hours
        val minFive2 = deviceObject?.timerToSend?.get(4)?.min
        val hourSix2 = deviceObject?.timerToSend?.get(5)?.hours
        val minSix2 = deviceObject?.timerToSend?.get(5)?.min
        if (hourFive2 != "00") {
            thirdTimer = "EE060020" + hourFive2 + minFive2 + hourSix2 + minSix2 + "."
            thirdTimer2 = thirdTimer.toByteArray(charset)

        } else {
            thirdTimer = "EE060021" + hourFive2 + minFive2 + hourSix2 + minSix2 + "."
            thirdTimer2 = thirdTimer.toByteArray(charset)
        }

        val hourSeven2 = deviceObject?.timerToSend?.get(6)?.hours
        val minSeven2 = deviceObject?.timerToSend?.get(6)?.min
        val hourEight2 = deviceObject?.timerToSend?.get(7)?.hours
        val minEight2 = deviceObject?.timerToSend?.get(7)?.min

        if (hourSeven2 != "00") {
            fourthTimer = "EE060030" + hourSeven2 + minSeven2 + hourEight2 + minEight2 + "."
            fourthTimer2 = fourthTimer.toByteArray(charset)

        } else {
            fourthTimer = "EE060031" + hourSeven2 + minSeven2 + hourEight2 + minEight2 + "."
            fourthTimer2 = fourthTimer.toByteArray(charset)
        }
    }

    fun checkNonStopResponse(response: String, bleDevice: BleDevice?, gatt: BluetoothGatt?) {
        when (response) {
            "EE120." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
            "EE121." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(nonStopOn, it1, it) } }
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
                        monday2,
                        it1,
                        it
                    )
                }
            }
            "EE1310." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        monday2,
                        it1,
                        it
                    )
                }
            }
            "EE1300." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        tuesday2,
                        it1,
                        it
                    )
                }
            }
            "EE1311." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        tuesday2,
                        it1,
                        it
                    )
                }
            }
            "EE1301." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        wednesday2, it1, it
                    )
                }
            }
            "EE1312." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        wednesday2, it1, it
                    )
                }
            }
            "EE1302." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        thursday2, it1, it
                    )
                }
            }
            "EE1313." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        thursday2, it1, it
                    )
                }
            }
            "EE1303." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        friday2,
                        it1,
                        it
                    )
                }
            }
            "EE1314." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        friday2,
                        it1,
                        it
                    )
                }
            }
            "EE1304." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        saturday2, it1, it
                    )
                }
            }
            "EE1315." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        saturday2, it1, it
                    )
                }
            }
            "EE1305." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        sunday2, it1,
                        it
                    )
                }
            }
            "EE1316." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        sunday2,
                        it1,
                        it
                    )
                }
            }

            "EE1306." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayPDON, it1, it) } }
            "EE141." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayPDON, it1, it) } }
            "EE140." -> gatt?.let {

                if (deviceObject?.nonStop == true) {
                    bleDevice?.let { it1 -> sendCommand(sprayFriq, it1, it) }
                } else {
                    bleDevice?.let { it1 -> sendCommand(intervalFS, it1, it) }
                }
            }
            "EE151." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(sprayFriq, it1, it) } }

            "EE150." -> gatt?.let {
                when (number) {
                    0 -> {
                        responseTimerOne = responseTimerOne + 1
                    }
                    1 -> {
                        responseTimerTwo = responseTimerTwo + 1
                    }
                    2 -> {
                        responseTimerThree = responseTimerThree + 1
                    }
                    3 -> {
                        responseTimerFour = responseTimerFour + 1
                    }
                }
                bleDevice?.let { it1 ->
                    sendCommand(
                        firstTimer2, it1, it
                    )
                }
            }
            "EE16100." -> gatt?.let {

                bleDevice?.let { it1 ->
                    sendCommand(
                        firstTimer2, it1, it
                    )
                }
            }
            "EE16000." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        secondTimer2, it1, it
                    )
                }
            }
            "EE16101." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        secondTimer2, it1, it
                    )
                }
            }
            "EE16001." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        thirdTimer2, it1, it
                    )
                }
            }
            "EE16102." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        thirdTimer2, it1, it
                    )
                }
            }
            "EE16002." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        fourthTimer2, it1, it
                    )
                }
            }
            "EE16103." -> gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        fourthTimer2, it1, it
                    )
                }
            }
            "EE160." -> {
                when (number) {
                    0 -> {
                        when (responseTimerOne) {
                            0 -> gatt?.let {
                                responseTimerOne = responseTimerOne + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        firstTimer2, it1, it
                                    )
                                }
                            }
                            1 -> gatt?.let {
                                responseTimerOne = responseTimerOne + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        secondTimer2, it1, it
                                    )
                                }
                            }
                            2 -> gatt?.let {
                                responseTimerOne = responseTimerOne + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        thirdTimer2, it1, it
                                    )
                                }
                            }
                            3 -> gatt?.let {
                                responseTimerOne = responseTimerOne + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        fourthTimer2, it1, it
                                    )
                                }
                            }
                            4 -> {
                                if (deviceObject?.nonStop == false) {
                                    gatt?.let {
                                        bleDevice?.let { it1 ->
                                            sendCommand(
                                                sprayFriquency2, it1, it
                                            )
                                        }
                                    }
                                } else {
                                    gatt?.let {
                                        bleDevice?.let { it1 ->
                                            sendCommand(
                                                byteArrayON,
                                                it1,
                                                it
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    1 -> {
                        when (responseTimerTwo) {
                            0 -> gatt?.let {
                                responseTimerTwo = responseTimerTwo + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        firstTimer2, it1, it
                                    )
                                }
                            }
                            1 -> gatt?.let {
                                responseTimerTwo = responseTimerTwo + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        secondTimer2, it1, it
                                    )
                                }
                            }
                            2 -> gatt?.let {
                                responseTimerTwo = responseTimerTwo + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        thirdTimer2, it1, it
                                    )
                                }
                            }
                            3 -> gatt?.let {
                                responseTimerTwo = responseTimerTwo + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        fourthTimer2, it1, it
                                    )
                                }
                            }
                            4 -> {
                                if (deviceObject?.nonStop == false) {
                                    gatt?.let {
                                        bleDevice?.let { it1 ->
                                            sendCommand(
                                                sprayFriquency2, it1, it
                                            )
                                        }
                                    }
                                } else {
                                    gatt?.let {
                                        bleDevice?.let { it1 ->
                                            sendCommand(
                                                byteArrayON,
                                                it1,
                                                it
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    2 -> {
                        when (responseTimerThree) {
                            0 -> gatt?.let {
                                responseTimerThree = responseTimerThree + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        firstTimer2, it1, it
                                    )
                                }
                            }
                            1 -> gatt?.let {
                                responseTimerThree = responseTimerThree + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        secondTimer2, it1, it
                                    )
                                }
                            }
                            2 -> gatt?.let {
                                responseTimerThree = responseTimerThree + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        thirdTimer2, it1, it
                                    )
                                }
                            }
                            3 -> gatt?.let {
                                responseTimerThree = responseTimerThree + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        fourthTimer2, it1, it
                                    )
                                }
                            }
                            4 -> {
                                if (deviceObject?.nonStop == false) {
                                    gatt?.let {
                                        bleDevice?.let { it1 ->
                                            sendCommand(
                                                sprayFriquency2, it1, it
                                            )
                                        }
                                    }
                                } else {
                                    gatt?.let {
                                        bleDevice?.let { it1 ->
                                            sendCommand(
                                                byteArrayON,
                                                it1,
                                                it
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    3 -> {
                        when (responseTimerFour) {
                            0 -> gatt?.let {
                                responseTimerFour = responseTimerFour + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        firstTimer2, it1, it
                                    )
                                }
                            }
                            1 -> gatt?.let {
                                responseTimerFour = responseTimerFour + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        secondTimer2, it1, it
                                    )
                                }
                            }
                            2 -> gatt?.let {
                                responseTimerFour = responseTimerFour + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        thirdTimer2, it1, it
                                    )
                                }
                            }
                            3 -> gatt?.let {
                                responseTimerFour = responseTimerFour + 1
                                bleDevice?.let { it1 ->
                                    sendCommand(
                                        fourthTimer2, it1, it
                                    )
                                }
                            }
                            4 -> {
                                if (deviceObject?.nonStop == false) {
                                    gatt?.let {
                                        bleDevice?.let { it1 ->
                                            sendCommand(
                                                sprayFriquency2, it1, it
                                            )
                                        }
                                    }
                                } else {
                                    gatt?.let {
                                        bleDevice?.let { it1 ->
                                            sendCommand(
                                                byteArrayON,
                                                it1,
                                                it
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }


                }
            }
            "EE16003." -> {
                if (deviceObject?.nonStop == false) {

                    gatt?.let {
                        bleDevice?.let { it1 ->
                            sendCommand(
                                sprayFriquency2, it1, it
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
                        sprayFriquency2, it1, it
                    )
                }
            }
            "EE170." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
            //   "EE111." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
            "EE110." -> {
                prefs.isFromHomeScreen = true
//                if (number == 0) {
//                    synchTime(0)
//                }
//                if (number == 1) {
//                    synchTime(1)
//                }
//                if (number == 2) {
//                    synchTime(2)
//                }
//                if (number == 3) {
//                    synchTime(3)
//                }
            }

        }
    }

    fun setFirstDevice() {
        val deviceOne = prefs.firstDevice
        if (!deviceOne.isNullOrEmpty()) {
            val gson = Gson()
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
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

            val gson = Gson()
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
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
            val gson = Gson()
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
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
            val gson = Gson()
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
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
                if (btnStart.tag == "stop") {
                    guideline?.setGuidelinePercent(1f)
                    setTabItemVisibility(true)
                } else {
                    setTabItemVisibility(false)
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
                if (constraintSet == R.id.start) {
                    btnStart?.setBackgroundResource(R.drawable.blue_radius_8)
                    btnStart?.text = getString(R.string.start)
                    btnStart?.isEnabled = true
                    carViewHome?.isEnabled = true
                } else {
                    btnStart?.setBackgroundResource(R.drawable.container_light_blue)
                    btnStart?.text = getString(R.string.stop)
                    //   setTabItemVisibility(true)
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
            showDisconnectedDeviceDialog()
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.red_circle)
            )
        } else if (size != 0 && size < counter) {
            removeDialog()
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.yelow_img)
            )
        } else if (size == counter) {
            removeDialog()
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
            showDisconnectedDeviceDialog()
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.red_circle)
            )
        } else if (size != 0 && size < counter) {
            removeDialog()
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.yelow_img)
            )
        } else if (size == counter) {
            removeDialog()
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
        val intervalModel = prefs.intervalModel
        val gson = Gson()
        val interval = gson.fromJson(intervalModel, ScheduleModel::class.java)
        val ss = interval?.mist
        val pp = interval?.suspend
        Log.e("D", "MIST TIME " + ss)

        if (ss != null) {
            mistValue?.text = getTimeFromSeconds(ss)
            mistValueSeconds = ss
        } else {
            mistValue?.text = "5s"
        }
        if (pp != null) {
            suspendValueSeconds = pp
            suspendValue?.text = getTimeFromSeconds(pp)

        } else {
            suspendValue?.text = "5s"
        }
        if (interval?.mist == "005") {
            mistValue?.text = getTimeFromSeconds(interval?.mist)
        }
        if (interval?.mist == "005") {
            suspendValue?.text = getTimeFromSeconds(interval?.mist)
        }
        var fullCommand = ""
        fullCommand = fullCommand + "EE07000000"
        fullCommand = fullCommand + mistValueSeconds
        fullCommand = fullCommand + "00"
        fullCommand = fullCommand + suspendValueSeconds
        fullCommand = fullCommand + "."
        Log.e("D", "fullCommand " + fullCommand)
        intervalValue = fullCommand.toByteArray(charset)
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
            showDisconnectedDeviceDialog()
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.red_circle)
            )
        } else if (size != 0 && size < counter) {
            removeDialog()
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.yelow_img)
            )
        } else if (size == counter) {
            removeDialog()
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
            )
        }
        guideline?.setGuidelinePercent(0.65f)
        setScheduleActiveView()
    }

    fun setScheduleActiveView() {
        val first =
            setTimeZone(
                deviceObject?.timer?.get(0)?.hours + deviceObject?.timer?.get(0)?.min,
                deviceObject?.timer?.get(0)?.format
            ) + " - " + setTimeZone(
                deviceObject?.timer?.get(1)?.hours + deviceObject?.timer?.get(1)?.min,
                deviceObject?.timer?.get(1)?.format
            )
        val second =
            setTimeZone(
                deviceObject?.timer?.get(2)?.hours + deviceObject?.timer?.get(2)?.min,
                deviceObject?.timer?.get(2)?.format
            ) + " - " + setTimeZone(
                deviceObject?.timer?.get(3)?.hours + deviceObject?.timer?.get(3)?.min,
                deviceObject?.timer?.get(3)?.format
            )
        val third =
            setTimeZone(
                deviceObject?.timer?.get(4)?.hours + deviceObject?.timer?.get(4)?.min,
                deviceObject?.timer?.get(4)?.format
            ) + " - " + setTimeZone(
                deviceObject?.timer?.get(5)?.hours + deviceObject?.timer?.get(5)?.min,
                deviceObject?.timer?.get(5)?.format
            )
        val fourt =
            setTimeZone(
                deviceObject?.timer?.get(6)?.hours + deviceObject?.timer?.get(6)?.min,
                deviceObject?.timer?.get(6)?.format
            ) + " - " + setTimeZone(
                deviceObject?.timer?.get(7)?.hours + deviceObject?.timer?.get(7)?.min,
                deviceObject?.timer?.get(7)?.format
            )

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
        Log.e("D", "deviceObject?.mist " + deviceObject?.mist)

        mistValue?.text = deviceObject?.mist?.let { getTimeFromSeconds(it) }
        suspendValue?.text = deviceObject?.suspend?.let { getTimeFromSeconds(it) }
        if (deviceObject?.mist == "005") {
            mistValue?.text = getTimeFromSeconds(deviceObject?.mist!!)
        }
        if (deviceObject?.mist == "005") {
            suspendValue?.text = getTimeFromSeconds(deviceObject?.mist!!)
        }
        if (tag != 0) {
            mistValue?.visibility = View.VISIBLE
            suspendValue?.visibility = View.VISIBLE
        }
        val ss = deviceObject?.mist
        val pp = deviceObject?.suspend
        if (ss != null) {
            mistValueSeconds = getSeconds(ss)
        }
        if (pp != null) {
            suspendValueSeconds = getSeconds(pp)
        }
        if (deviceObject?.nonStop == true || deviceObject?.mist == null) {
            mistValue?.text = "-"
            suspendValue?.text = "-"
        }

        var friqu = "EE07000000" + ss + "00" + pp + "."
        sprayFriquency = friqu
        sprayFriquency2 = sprayFriquency.toByteArray(charset)
        getActiveDaysFromDb()
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
        if (pos >= 0) {
            connectionStateCoordinator.bluetoothController?.writeCommand(
                bleDevice,
                input,
                gatt.services.get(pos).characteristics.get(0)
            )
        }
    }

    private fun navigateToSetSchedule() {
        view?.post {
            val action = HomeFragmentDirections.actionScheduleToSetScheduleFragment(1)
            findNavController().navigate(action)
        }
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

//
//    fun initBleConroller() {
//        bluetoothController =
//            BluetoothController(
//                null,
//                null,
//                null,
//                null,
//                gattCallback,
//                null,
//                writeCallback,
//                requireContext()
//            )
//
//    }


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
            "40s" -> seconds = "040"
            "45s" -> seconds = "045"
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
            "040" -> time = "40s"
            "045" -> time = "45s"
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


    fun synchTime(pos: Int) {

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
        when (pos) {
            0 -> {
                firstBleDevice?.let {
                    firstGate?.let { it1 ->
                        sendCommand(
                            dateAndTimeSynch.toByteArray(charset),
                            it, it1
                        )
                    }
                }
            }
            1 -> {
                secondBleDevice?.let {
                    secondGate?.let { it1 ->
                        sendCommand(
                            dateAndTimeSynch.toByteArray(charset),
                            it, it1
                        )
                    }
                }
            }
            2 -> {
                thirdBleDevice?.let {
                    thirdGate?.let { it1 ->
                        sendCommand(
                            dateAndTimeSynch.toByteArray(charset),
                            it, it1
                        )
                    }
                }
            }
            3 -> {
                fourthBleDevice?.let {
                    fourthGate?.let { it1 ->
                        sendCommand(
                            dateAndTimeSynch.toByteArray(charset),
                            it, it1
                        )
                    }
                }
            }
            4 -> {
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
        }
    }

    fun removeDialog() {
        //   disconectedDialog?.dismiss()
        btnStart?.isEnabled = true
        if (dialogView.visibility == View.VISIBLE) {
            dialogView?.visibility = View.GONE
        }
    }

    fun showDisconnectedDeviceDialog() {
        dialogView?.visibility = View.VISIBLE


    }

    fun getActiveDaysFromDb() {
        if (deviceObject != null) {
            val one = deviceObject?.days?.get(0)
            val two = deviceObject?.days?.get(1)
            val three = deviceObject?.days?.get(2)
            val four = deviceObject?.days?.get(3)
            val five = deviceObject?.days?.get(4)
            val six = deviceObject?.days?.get(5)
            val seven = deviceObject?.days?.get(6)

            if (one == 0) {
                mondayTv?.alpha = 1f
                monday = scheduleMo + "0."
                monday2 = monday.toByteArray(charset)
            } else {
                mondayTv?.alpha = 0.3f
                monday = scheduleMo + "1."
                monday2 = monday.toByteArray(charset)
            }
            if (two == 0) {
                tuesdayTv?.alpha = 1f
                tuesday = scheduleTu + "0."
                tuesday2 = tuesday.toByteArray(charset)

            } else {
                tuesdayTv?.alpha = 0.3f
                tuesday = scheduleTu + "1."
                tuesday2 = tuesday.toByteArray(charset)

            }
            if (three == 0) {
                wednesdayTv?.alpha = 1f
                wednesday = scheduleWE + "0."
                wednesday2 = wednesday.toByteArray(charset)

            } else {
                wednesdayTv?.alpha = 0.3f
                wednesday = scheduleWE + "1."
                wednesday2 = wednesday.toByteArray(charset)
            }
            if (four == 0) {
                thusdayTv?.alpha = 1f
                thursday = scheduleTH + "0."
                thursday2 = thursday.toByteArray(charset)

            } else {
                thusdayTv?.alpha = 0.3f
                thursday = scheduleTH + "1."
                thursday2 = thursday.toByteArray(charset)
            }

            if (five == 0) {
                fridayTv?.alpha = 1f
                friday = scheduleFR + "0."
                friday2 = friday.toByteArray(charset)

            } else {
                fridayTv?.alpha = 0.3f
                friday = scheduleFR + "1."
                friday2 = friday.toByteArray(charset)
            }
            if (six == 0) {
                saturdayTv?.alpha = 1f
                saturday = scheduleSA + "0."
                saturday2 = saturday.toByteArray(charset)

            } else {
                saturdayTv?.alpha = 0.3f
                saturday = scheduleSA + "1."
                saturday2 = saturday.toByteArray(charset)
            }
            if (seven == 0) {
                sundayTv?.alpha = 1f
                sunday = scheduleSU + "0."
                sunday2 = sunday.toByteArray(charset)

            } else {
                sundayTv?.alpha = 0.3f
                sunday = scheduleSU + "1."
                sunday2 = sunday.toByteArray(charset)
            }
        }
        formatTimer()
    }

    fun checkTotalNumber() {
        counter = 0
        if (deviceOneObj != null) {
            counter = counter + 1
        }
        if (deviceTwoObj != null) {
            counter = counter + 1
        }
        if (deviceThreeObj != null) {
            counter = counter + 1
        }
        if (deviceFourObj != null) {
            counter = counter + 1
        }
        allDevices =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        if (allDevices > 0) {
            bleList =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
        }
        deviceNumber?.text = "$allDevices of $counter devices"
    }
}


