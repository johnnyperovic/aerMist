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
import androidx.core.widget.TextViewCompat
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_devices.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_set_device.*
import kotlinx.android.synthetic.main.fragment_set_device.bleBg
import kotlinx.android.synthetic.main.fragment_set_device.bleIcon
import kotlinx.android.synthetic.main.fragment_set_device.btnEdit
import kotlinx.android.synthetic.main.fragment_set_device.btnStart
import kotlinx.android.synthetic.main.fragment_set_device.deviceName
import kotlinx.android.synthetic.main.fragment_set_device.firstLine
import kotlinx.android.synthetic.main.fragment_set_device.firstTimerTv
import kotlinx.android.synthetic.main.fragment_set_device.fridayTv
import kotlinx.android.synthetic.main.fragment_set_device.guideline
import kotlinx.android.synthetic.main.fragment_set_device.intervalImg
import kotlinx.android.synthetic.main.fragment_set_device.intervalTv
import kotlinx.android.synthetic.main.fragment_set_device.mistTv
import kotlinx.android.synthetic.main.fragment_set_device.mistValue
import kotlinx.android.synthetic.main.fragment_set_device.mondayTv
import kotlinx.android.synthetic.main.fragment_set_device.nonStopImg
import kotlinx.android.synthetic.main.fragment_set_device.nonStopTv
import kotlinx.android.synthetic.main.fragment_set_device.saturdayTv
import kotlinx.android.synthetic.main.fragment_set_device.scheduleImg
import kotlinx.android.synthetic.main.fragment_set_device.scheduleTv
import kotlinx.android.synthetic.main.fragment_set_device.secondLine
import kotlinx.android.synthetic.main.fragment_set_device.secondTimerTv
import kotlinx.android.synthetic.main.fragment_set_device.standbyTv
import kotlinx.android.synthetic.main.fragment_set_device.startingTv
import kotlinx.android.synthetic.main.fragment_set_device.sundayTv
import kotlinx.android.synthetic.main.fragment_set_device.suspendTv
import kotlinx.android.synthetic.main.fragment_set_device.suspendValue
import kotlinx.android.synthetic.main.fragment_set_device.tabName
import kotlinx.android.synthetic.main.fragment_set_device.tab_icon
import kotlinx.android.synthetic.main.fragment_set_device.thirdLine
import kotlinx.android.synthetic.main.fragment_set_device.thirdTimerTv
import kotlinx.android.synthetic.main.fragment_set_device.thusdayTv
import kotlinx.android.synthetic.main.fragment_set_device.wednesdayTv
import kotlinx.android.synthetic.main.fragment_set_schedule.*
import kotlinx.android.synthetic.main.remove_reset_device_fragment.*
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.BytePayload
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.models.ScheduleModel
import llc.aerMist.app.models.TimerModel
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.DevicesDisconnected
import llc.aerMist.app.ui.popup.NumberPickerPopup
import llc.aerMist.app.ui.popup.RemoveDevicePopup
import org.koin.android.ext.android.inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class SetDeviceFragment : Fragment(), View.OnClickListener {
    private val prefs: PreferenceCache by inject()
    private var tag = 0
    var shortString = ""
    var shortString2 = ""
    var shortString3 = ""
    var shortString4 = ""
    var numberPickerPopup = NumberPickerPopup()
    lateinit var bluetoothController: BluetoothController
    val connectionStateCoordinator = NewObservableCoordinator
    private var bleDevice: BleDevice? = null
    private var gatt: BluetoothGatt? = null
    private lateinit var payload: BytePayload
    private var mistValueSeconds = "005"
    private var suspendValueSeconds = "005"
    private val scheduleModelArgs: SetDeviceFragmentArgs by navArgs()
    private var scheduleModel: ScheduleModel? = null
    private var dialogDisconnectedDevice: DevicesDisconnected? = null
    var dateAndTimeSynch = ""
    var isTimeSync = true
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
    var responseTimmer = 0
    var intervalValue = "".toByteArray(charset)
    var sprayPDON = "EE0400.".toByteArray(charset)
    val sprayFriq = "EE0501.".toByteArray(charset)
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
    var sprayFriquency = ""
    lateinit var daysInWeek: IntArray
    lateinit var deviceObject: MyDevice
    var mainDevicePositon = 0
    var deviceNameValue = ""
    var allDevices = 0
    private var bleList = ArrayList<BleDevice>()
    var singleDeviceName = ""
    var isFromDB = true
    var filterTime = ""

    @SuppressLint("ClickableViewAccessibility", "SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle = arguments
        //mainDevicePositon = bundle?.get("myArg") as String
        deviceNameValue = bundle?.get("myArg") as String
        setClickListener()
        setMotionLayoutListener()
        setTouchSwipeListener()

        allDevices =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        if (allDevices > 0) {
            bleList =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            for (item in bleList) {
                if (deviceNameValue == item.name) {
                    bleDevice = item
                    gatt =
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                            bleDevice
                        )!!
                } else if (allDevices == 1) {
                    bleDevice = item
                    gatt =
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                            bleDevice
                        )!!
                    singleDeviceName = item.name
                }
            }
        }

        val observer = Observer<CharArray> {

            var response = ""
            for (item in it) {
                response = response + item
            }

            if (response.contains(",")) {
                return@Observer
            }
            if (!isTimeSync) {
                if (tag == 0) {
                    checkNonStopResponse(response)
                } else if (tag == 1) {
                    checkIntervalResponse(response)
                } else {
                    checkScheduleRespone(response)
                }
            }
        }
        connectionStateCoordinator.bluetoothByteArray.observe(viewLifecycleOwner, observer)

        val observer2 = Observer<BleDevice> {
            if (deviceObject?.name == it.name) {
                if (connectionStateCoordinator.bluetoothController?.bluetoothManager?.isConnected(it) == false) {
                    showDisconnectedDeviceDialog()
                    connectDevice(it)
                }
            }
        }
        connectionStateCoordinator.bleDisconnectDevices.observe(viewLifecycleOwner, observer2)


        val deviceOne = prefs.firstDevice
        val gson = Gson()
        val deviceObjectOne = gson.fromJson(deviceOne, MyDevice::class.java)
        val deviceTwo = prefs.secondDevice
        val deviceObjectTwo = gson.fromJson(deviceTwo, MyDevice::class.java)
        val deviceThree = prefs.thirdDevice
        val deviceObjectThree = gson.fromJson(deviceThree, MyDevice::class.java)
        val deviceFour = prefs.fourthDevice
        val deviceObjectFour = gson.fromJson(deviceFour, MyDevice::class.java)
        if (bleDevice?.name == deviceObjectOne?.name || bleDevice?.name == singleDeviceName) {
            mainDevicePositon = 0
            if (!deviceOne.isNullOrEmpty()) {
                deviceObject =
                    gson.fromJson(deviceOne, MyDevice::class.java)
                var filTime = prefs.startWorkingTimeFD
                var workTime = deviceObject.workingTime
                if (!workTime.isNullOrEmpty() && !filterTime.isNullOrEmpty()) {
                    filterTime = (workTime.toIntOrNull()!! - filTime.toIntOrNull()!!).toString()
                }
            }
        } else if (bleDevice?.name == deviceObjectTwo?.name || bleDevice?.name == singleDeviceName) {
            mainDevicePositon = 1
            if (!deviceTwo.isNullOrEmpty()) {
                deviceObject =
                    gson.fromJson(deviceTwo, MyDevice::class.java)
                var filTime = prefs.startWorkingTimeSD
                var workTime = deviceObject.workingTime

                if (!workTime.isNullOrEmpty() && !filterTime.isNullOrEmpty()) {
                    filterTime = (workTime.toIntOrNull()!! - filTime.toIntOrNull()!!).toString()
                }

            }
        } else if (bleDevice?.name == deviceObjectThree?.name || bleDevice?.name == singleDeviceName) {
            mainDevicePositon = 2
            if (!deviceThree.isNullOrEmpty()) {
                deviceObject = gson.fromJson(deviceThree, MyDevice::class.java)
                var filTime = prefs.startWorkingTimeTD
                var workTime = deviceObject.workingTime
                if (!workTime.isNullOrEmpty() && !filterTime.isNullOrEmpty()) {
                    filterTime = (workTime.toIntOrNull()!! - filTime.toIntOrNull()!!).toString()
                }
            }
        } else if (bleDevice?.name == deviceObjectFour?.name || bleDevice?.name == singleDeviceName) {
            mainDevicePositon = 3
            if (!deviceFour.isNullOrEmpty()) {
                deviceObject =
                    gson.fromJson(deviceFour, MyDevice::class.java)
                var filTime = prefs.startWorkingTimeFRD
                var workTime = deviceObject.workingTime
                if (!workTime.isNullOrEmpty() && !filterTime.isNullOrEmpty()) {
                    filterTime = (workTime.toIntOrNull()!! - filTime.toIntOrNull()!!).toString()
                }
            }
        }
        if (!filterTime.isNullOrEmpty()) {
            if (filterTime.toIntOrNull()!! > 0) {
                filterValue.text = filterTime + "h"
            }
        }
        deviceName.text = deviceObject.newName
        if (scheduleModelArgs.model != null) scheduleModel = scheduleModelArgs.model!!

        if (scheduleModel?.days != null) {
            daysInWeek = scheduleModel?.days!!
            isFromDB = false
            isSelected = true
            setScheduleView()
            formatDaySchedule()
        } else {
            setNonStopView()
        }
        sendTimeSynchCommand()

        setDisplayMode()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_set_device, container, false)
    }

    fun connectDevice(bleDevice: BleDevice) {
        if (bleDevice.name == deviceObject.name) {
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                bleDevice,
                gattCallback
            )
        }
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
            bleBg?.setImageDrawable(
                ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
            )
            standbyTv.text = resources.getString(R.string.standby)
            btnStart.isEnabled = true
        }

        override fun onDisConnected(
            isActiveDisConnected: Boolean,
            device: BleDevice?,
            gatt: BluetoothGatt?,
            status: Int
        ) {

        }
    }

    fun showDisconnectedDeviceDialog() {
        bleBg?.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.red_circle)
        )
        standbyTv.text = resources.getString(R.string.offline)
        btnStart.isEnabled = false
        dialogDisconnectedDevice = DevicesDisconnected(true)
        dialogDisconnectedDevice?.isCancelable = true
        dialogDisconnectedDevice?.show(childFragmentManager, "")
    }

    fun setDisplayMode() {
        val isOn = deviceObject.isOn
        if (isOn) {
            motionLayoutDevice.transitionToEnd()
            isTimeSync = false
            carViewDevice.isEnabled = false
            if (deviceObject.isSparayMode) {
                if (!deviceObject.isSprayPerDay) {

                    intervalImg.performClick()
                    tabName.text = resources.getString(R.string.interval)
                    guideline?.setGuidelinePercent(1f)
                    tab_icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.interval_blue_icon
                        )
                    )
                    if (btnStart.tag == "start") {
                        startingTv.visibility = View.VISIBLE
                        btnStart.tag = "stop"
                    } else {
                        btnStart.tag = "start"
                    }
                } else {
                    scheduleImg.performClick()
                    guideline?.setGuidelinePercent(1f)
                    tabName.text = resources.getString(R.string.schedule)
                    tab_icon.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.calendar_blue_icon
                        )
                    )
                    setTabItemVisibility(true)
                    if (btnStart.tag == "start") {
                        startingTv.visibility = View.VISIBLE
                        btnStart.tag = "stop"
                    } else {
                        btnStart.tag = "start"
                    }
                }
            } else {
                nonStopImg.performClick()
                tabName.text = resources.getString(R.string.non_stop)
                tab_icon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.non_stop_blue_icon
                    )
                )
                if (btnStart.tag == "start") {
                    startingTv.visibility = View.VISIBLE
                    btnStart.tag = "stop"
                } else {
                    btnStart.tag = "start"
                }
            }
        }
    }

    fun sendTimeSynchCommand() {
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
        gatt?.let {
            bleDevice?.let { it1 ->
                sendCommand(
                    dateAndTimeSynch.toByteArray(
                        charset
                    ), it1, it
                )
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



    private fun getRegister(response: String): String {
        var pos = response.get(5)
        return pos.toString()
    }

    fun formatDaySchedule() {
        monday = scheduleMo + daysInWeek.get(0) + "."
        tuesday = scheduleTu + daysInWeek.get(1) + "."
        wednesday = scheduleWE + daysInWeek.get(2) + "."
        thursday = scheduleTH + daysInWeek.get(3) + "."
        friday = scheduleFR + daysInWeek.get(4) + "."
        saturday = scheduleSA + daysInWeek.get(5) + "."
        sunday = scheduleSU + daysInWeek.get(6) + "."
        if (daysInWeek.get(0) == 0) {
            mondayTv?.alpha = 1f
        } else {
            mondayTv?.alpha = 0.3f
        }
        if (daysInWeek.get(1) == 0) {
            tuesdayTV2?.alpha = 1f
        } else {
            tuesdayTV2?.alpha = 0.3f
        }
        if (daysInWeek.get(2) == 0) {
            wednesdayTv?.alpha = 1f
        } else {
            wednesdayTv?.alpha = 0.3f
        }
        if (daysInWeek.get(3) == 0) {
            thusdayTv?.alpha = 1f
        } else {
            thusdayTv?.alpha = 0.3f
        }
        if (daysInWeek.get(4) == 0) {
            fridayTv?.alpha = 1f
        } else {
            fridayTv?.alpha = 0.3f
        }
        if (daysInWeek.get(5) == 0) {
            saturdayTv?.alpha = 1f
        } else {
            saturdayTv?.alpha = 0.3f
        }
        if (daysInWeek.get(6) == 0) {
            sundayTv?.alpha = 1f
        } else {
            sundayTv?.alpha = 0.3f
        }
        formatTimer()
    }

    fun checkNonStopResponse(response: String) {
        when (response) {
            "EE120." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
            "EE121." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(nonStopOn, it1, it) } }
            "EE111." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayOF, it1, it) } }
            "EE110." -> {
                "USPJESNO ZAVRSENO"
                prefs.isFromHomeScreen = false
                motionLayoutDevice.transitionToEnd()
                motionLayoutDevice.transitionToStart()
                sendTimeSynchCommand()
            }
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
            "EE111." -> gatt?.let { bleDevice?.let { it1 -> sendCommand(byteArrayON, it1, it) } }
            "EE110." -> {
                prefs.isFromHomeScreen = false
                "USPJESNO ZAVRSENO"
                motionLayoutDevice.transitionToEnd()
                motionLayoutDevice.transitionToStart()
                sendTimeSynchCommand()
            }
        }
    }

    fun checkScheduleRespone(response: String) {

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
                bleDevice?.let { it1 ->
                    sendCommand(
                        firstTimer.toByteArray(
                            charset
                        ), it1, it
                    )
                }
                responseTimmer = responseTimmer + 1
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
                responseTimmer = 0
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
                when (responseTimmer) {

                    0 -> gatt?.let {
                        responseTimmer = responseTimmer + 1
                        bleDevice?.let { it1 ->
                            sendCommand(
                                firstTimer.toByteArray(
                                    charset
                                ), it1, it
                            )
                        }
                    }
                    1 -> gatt?.let {
                        responseTimmer = responseTimmer + 1
                        bleDevice?.let { it1 ->
                            sendCommand(
                                secondTimer.toByteArray(
                                    charset
                                ), it1, it
                            )
                        }
                    }
                    2 -> gatt?.let {
                        responseTimmer = responseTimmer + 1
                        bleDevice?.let { it1 ->
                            sendCommand(
                                thirdTimer.toByteArray(
                                    charset
                                ), it1, it
                            )
                        }
                    }
                    3 -> gatt?.let {
                        responseTimmer = 0
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
                if (deviceObject.isNonStop == false) {
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
            "EE110." -> {
                prefs.isFromHomeScreen = false
                motionLayoutDevice.transitionToEnd()
                motionLayoutDevice.transitionToStart()
                sendTimeSynchCommand()
            }
        }
    }

    fun formatTimer() {
        val hourOne = scheduleModel?.timer?.get(0)!!.hours
        val minOne = scheduleModel?.timer?.get(0)!!.min
        val formatOne = scheduleModel?.timer?.get(0)!!.format
        val hourTwo = scheduleModel?.timer?.get(1)!!.hours
        val minTwo = scheduleModel?.timer?.get(1)!!.min
        val formatTwo = scheduleModel?.timer?.get(1)!!.format
        val hourOne2 = scheduleModel?.timerToSend?.get(0)!!.hours
        val minOne2 = scheduleModel?.timerToSend?.get(0)!!.min
        val hourTwo2 = scheduleModel?.timerToSend?.get(1)!!.hours
        val minTwo2 = scheduleModel?.timerToSend?.get(1)!!.min
        firstTimerTv.text =
            setTimeZone(hourOne + minOne) + formatOne + " - " + setTimeZone(hourTwo + minTwo) + formatTwo
        //    hourOne + ":" + minOne + formatOne + " - " + hourTwo + ":" + minTwo + formatTwo
        if (hourOne != "00" && hourTwo != "00") {
            firstTimer = "EE060000" + hourOne2 + minOne2 + hourTwo2 + minTwo2 + "."
            firstTimerTv.visibility = View.VISIBLE
        } else {
            firstTimerTv.visibility = View.INVISIBLE
            firstTimer = "EE060001" + hourOne2 + minOne2 + hourTwo2 + minTwo2 + "."

        }
        val hourThree = scheduleModel?.timer?.get(2)!!.hours
        val minThree = scheduleModel?.timer?.get(2)!!.min
        val formatThree = scheduleModel?.timer?.get(2)!!.format
        val hourFour = scheduleModel?.timer?.get(3)!!.hours
        val minFour = scheduleModel?.timer?.get(3)!!.min
        val formatFour = scheduleModel?.timer?.get(3)!!.format
        val hourThree2 = scheduleModel?.timerToSend?.get(2)!!.hours
        val minThree2 = scheduleModel?.timerToSend?.get(2)!!.min
        val hourFour2 = scheduleModel?.timerToSend?.get(3)!!.hours
        val minFour2 = scheduleModel?.timerToSend?.get(3)!!.min
        secondTimerTv.text =
            setTimeZone(hourThree + minThree) + formatThree + " - " + setTimeZone(hourFour + minFour) + formatFour
        if (hourThree != "00" && hourFour != "00") {
            secondTimerTv.visibility = View.VISIBLE
            secondTimer = "EE060010" + hourThree2 + minThree2 + hourFour2 + minFour2 + "."

        } else {
            secondTimerTv.visibility = View.INVISIBLE
            secondTimer = "EE060011" + hourThree2 + minThree2 + hourFour2 + minFour2 + "."
        }
        val hourFive = scheduleModel?.timer?.get(4)!!.hours
        val minFive = scheduleModel?.timer?.get(4)!!.min
        val formatFive = scheduleModel?.timer?.get(4)!!.format
        val hourSix = scheduleModel?.timer?.get(5)!!.hours
        val minSix = scheduleModel?.timer?.get(5)!!.min
        val formatSix = scheduleModel?.timer?.get(5)!!.format
        val hourFive2 = scheduleModel?.timerToSend?.get(4)!!.hours
        val minFive2 = scheduleModel?.timerToSend?.get(4)!!.min
        val hourSix2 = scheduleModel?.timerToSend?.get(5)!!.hours
        val minSix2 = scheduleModel?.timerToSend?.get(5)!!.min
            thirdTimerTv.text =
            setTimeZone(hourFive + minFive) + formatFive + " - " + setTimeZone(hourSix + minSix) + formatSix

        //  hourFive + ":" + minFive + formatFive + " - " + hourSix + ":" + minSix + "" + formatSix
        if (hourFive != "00" && hourSix != "00") {
            thirdTimerTv.visibility = View.VISIBLE
            thirdTimer = "EE060020" + hourFive2 + minFive2 + hourSix2 + minSix2 + "."

        } else {
            thirdTimerTv.visibility = View.INVISIBLE
            thirdTimer = "EE060021" + hourFive2 + minFive2 + hourSix2 + minSix2 + "."

        }
        val hourSeven = scheduleModel?.timer?.get(6)!!.hours
        val minSeven = scheduleModel?.timer?.get(6)!!.min
        val formatSeven = scheduleModel?.timer?.get(6)!!.format
        val hourEight = scheduleModel?.timer?.get(7)!!.hours
        val minEight = scheduleModel?.timer?.get(7)!!.min
        val formatEight = scheduleModel?.timer?.get(7)!!.format
        val hourSeven2 = scheduleModel?.timerToSend?.get(6)!!.hours
        val minSeven2 = scheduleModel?.timerToSend?.get(6)!!.min
        val hourEight2 = scheduleModel?.timerToSend?.get(7)!!.hours
        val minEight2 = scheduleModel?.timerToSend?.get(7)!!.min
    fourthTimerTv2?.text =
            setTimeZone(hourSeven + minSeven) + formatSeven + " - " + setTimeZone(hourEight + minEight) + formatEight

        if (hourSeven != "00" && hourEight != "00") {
            fourthTimerTv2.visibility = View.VISIBLE
            fourthTimer = "EE060030" + hourSeven2 + minSeven2 + hourEight2 + minEight2 + "."
        } else {
            fourthTimer = "EE060031" + hourSeven2 + minSeven2 + hourEight2 + minEight2 + "."

            fourthTimerTv2.visibility = View.INVISIBLE
        }
        val sss = getSeconds(scheduleModel?.mist.toString())
        val ppp = getSeconds(scheduleModel?.suspend.toString())
        mistValue.text = scheduleModel?.mist.toString()
        suspendValue.text = scheduleModel?.suspend.toString()
        sprayFriquency = "EE07000000" + sss +"00"+ ppp + "."
    }

    fun setTimeZone2(time: String): String {
        var fullTime = ""
        var zone = "am"
        if (time.length == 4) {

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
            }
        }
        return fullTime
    }

    fun setTimeZone(time: String): String {
        var fullTime = ""
        var zone = "am"
        if (time.length == 4) {

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
                fullTime = hour.toString() + ":" + min
            }
        }
        return fullTime
    }

    fun getZone(time: String): String {
        var zone = ""
        val timer = time.toIntOrNull()
        if (timer != null) {
            if (timer < 12) {
                zone = "am"
            } else {

                zone = "pm"
            }
        }
        return zone
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
                isTimeSync = false
                carViewDevice.isEnabled = false
                setViewAndSendCommand()
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
                startingTv.visibility = View.GONE
                if (intervalImg.visibility == View.VISIBLE) {
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

                if (constraintSet == R.id.start) {
                    btnStart.setBackgroundResource(R.drawable.blue_radius_8)
                    btnStart.text = getString(R.string.start)
                    btnStart.isEnabled = true
                    carViewDevice.isEnabled = true
                } else {
                    btnStart.setBackgroundResource(R.drawable.container_light_blue)
                    btnStart.text = getString(R.string.stop)
                    btnStart.isEnabled = true
                    setTabItemVisibility(true)
                    guideline?.setGuidelinePercent(1f)

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
            intervalImg.visibility = View.INVISIBLE
            intervalTv.visibility = View.INVISIBLE
            scheduleImg.visibility = View.INVISIBLE
            scheduleTv.visibility = View.INVISIBLE
            nonStopImg.visibility = View.INVISIBLE
            nonStopTv.visibility = View.INVISIBLE
            firstLine.visibility = View.INVISIBLE
            bleBg.visibility = View.INVISIBLE
            bleIcon.visibility = View.INVISIBLE
            standbyTv.visibility = View.INVISIBLE
            mistTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            mistValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            suspendTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            suspendValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            firstLine.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            mondayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            tuesdayTV2?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            wednesdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            thusdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            fridayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            saturdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            sundayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            firstTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            secondTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            thirdTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            fourthTimerTv2?.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
        } else {
            intervalImg.visibility = View.VISIBLE
            intervalTv.visibility = View.VISIBLE
            scheduleImg.visibility = View.VISIBLE
            scheduleTv.visibility = View.VISIBLE
            nonStopImg.visibility = View.VISIBLE
            nonStopTv.visibility = View.VISIBLE
            firstLine.visibility = View.VISIBLE
            bleBg.visibility = View.VISIBLE
            bleIcon.visibility = View.VISIBLE
            standbyTv.visibility = View.VISIBLE
            mistTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            mistValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            suspendTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            suspendValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            mondayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            tuesdayTV2?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            wednesdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            thusdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            fridayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            saturdayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            sundayTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            firstTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            secondTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            thirdTimerTv?.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            fourthTimerTv2?.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.dark_gray
                )
            )
            firstLine.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.dark_gray
                )
            )
        }
    }

    fun setViewAndSendCommand() {
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
                    startingTv.visibility = View.VISIBLE

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
                    startingTv.visibility = View.VISIBLE
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
                    if (!isSelected) {
                        //  if (scheduleModel.timer.get(0)=="0.0")
                        Snackbar.make(
                            requireView(),
                            "You must choose days and interval",
                            Snackbar.LENGTH_SHORT
                        ).show()
                        return
                    }
//                    else if (scheduleModel?.timer!!.get(0).hours == "0" && scheduleModel?.timer!!.get(
//                            1
//                        ).hours == "0" && scheduleModel?.timer!!.get(2).hours == "0" && scheduleModel?.timer!!.get(
//                            3
//                        ).hours == "0"
//                    ) {
//                        Snackbar.make(
//                            requireView(),
//                            "You must choose days and interval",
//                            Snackbar.LENGTH_SHORT
//                        ).show()
//                        return
//                    }
                    startingTv.visibility = View.VISIBLE

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
        mistTv?.visibility = View.INVISIBLE
        mistValue?.visibility = View.INVISIBLE
        suspendTv?.visibility = View.INVISIBLE
        suspendValue?.visibility = View.INVISIBLE
        btnEdit?.visibility = View.INVISIBLE
        secondLine?.visibility = View.VISIBLE
        thirdLine?.visibility = View.INVISIBLE
        mondayTv?.visibility = View.INVISIBLE
        tuesdayTV2?.visibility = View.INVISIBLE
        wednesdayTv?.visibility = View.INVISIBLE
        thusdayTv?.visibility = View.INVISIBLE
        fridayTv?.visibility = View.INVISIBLE
        saturdayTv?.visibility = View.INVISIBLE
        sundayTv?.visibility = View.INVISIBLE
        firstTimerTv?.visibility = View.INVISIBLE
        secondTimerTv?.visibility = View.INVISIBLE
        thirdTimerTv?.visibility = View.INVISIBLE
        fourthTimerTv2?.visibility = View.INVISIBLE
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        bleBg.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.green_circle))
        activeValue?.text = deviceObject.workingTime + "h"

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
        val ss = deviceObject.mistTime
        val pp = deviceObject.suspendTime
        mistValue?.text = getTimeFromSeconds(ss)
        suspendValue?.text = getTimeFromSeconds(pp)
    }

    fun setIntervalView() {
        tag = 1
        mistTv?.visibility = View.VISIBLE
        mistValue?.visibility = View.VISIBLE
        suspendTv?.visibility = View.VISIBLE
        suspendValue?.visibility = View.VISIBLE
        btnEdit?.visibility = View.VISIBLE
        secondLine?.visibility = View.VISIBLE
        thirdLine?.visibility = View.VISIBLE
        mondayTv?.visibility = View.INVISIBLE
        tuesdayTV2?.visibility = View.INVISIBLE
        wednesdayTv?.visibility = View.INVISIBLE
        thusdayTv?.visibility = View.INVISIBLE
        fridayTv?.visibility = View.INVISIBLE
        saturdayTv?.visibility = View.INVISIBLE
        sundayTv?.visibility = View.INVISIBLE
        firstTimerTv.visibility = View.INVISIBLE
        secondTimerTv.visibility = View.INVISIBLE
        thirdTimerTv.visibility = View.INVISIBLE
        fourthTimerTv2.visibility = View.INVISIBLE
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

        guideline.setGuidelinePercent(0.65f)
        mistValue?.text = getTimeFromSeconds(deviceObject.mistTime)
        suspendValue?.text = getTimeFromSeconds(deviceObject.suspendTime)
        var fullCommand = ""
        fullCommand = fullCommand + "EE07000000"
        fullCommand = fullCommand + deviceObject.mistTime
        fullCommand = fullCommand + "00"
        fullCommand = fullCommand + deviceObject.suspendTime
        fullCommand = fullCommand + "."
        intervalValue = fullCommand.toByteArray(charset)
        activeValue?.text = deviceObject.workingTime + "h"

    }

    fun setScheduleView() {
        tag = 2
        mistTv?.visibility = View.VISIBLE
        mistValue?.visibility = View.VISIBLE
        suspendTv?.visibility = View.VISIBLE
        suspendValue?.visibility = View.VISIBLE
        btnEdit?.visibility = View.VISIBLE
        thirdLine?.visibility = View.VISIBLE
        mondayTv?.visibility = View.VISIBLE
        tuesdayTV2?.visibility = View.VISIBLE
        wednesdayTv?.visibility = View.VISIBLE
        thusdayTv?.visibility = View.VISIBLE
        fridayTv?.visibility = View.VISIBLE
        saturdayTv?.visibility = View.VISIBLE
        sundayTv?.visibility = View.VISIBLE
        firstTimerTv.visibility = View.VISIBLE
        secondTimerTv.visibility = View.VISIBLE
        thirdTimerTv.visibility = View.VISIBLE
        fourthTimerTv2.visibility = View.VISIBLE
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
        val firstStart = deviceObject.firstStartTime
        val firstEnd = deviceObject.firstStopTime
        val secondStart = deviceObject.secondStartTime
        val secondEnd = deviceObject.secondStopTime
        val thirdStart = deviceObject.thirdStartTime
        val thirdEnd = deviceObject.thirdStopTime
        val fourtStart = deviceObject.fourtStartTime
        val fourtEnd = deviceObject.fourtStopTime
        if (firstStart.length == 4 && firstStart != "0000") {
            firstTimerTv.text = setTimeZone2(firstStart) + "-" + setTimeZone2(firstEnd)
            isSelected = true
            firstTimer = "EE060000" + firstStart + firstEnd + "."
        }
        else{
            firstTimer = "EE060001" + "0000" + "0000" + "."

        }
        if (secondStart.length == 4 && secondStart != "0000") {
            secondTimerTv.text =
                setTimeZone2(secondStart) + "-" + setTimeZone2(secondEnd)
            secondTimer = "EE060010" + secondStart + secondEnd + "."
            secondTimerTv?.visibility=View.VISIBLE
        }
        else{
            secondTimer = "EE060011" + "0000" + "0000" + "."
            secondTimerTv?.visibility=View.INVISIBLE
        }
        if (thirdStart.length == 4 && thirdStart != "0000") {
            thirdTimerTv?.text =
                setTimeZone2(thirdStart) + "-" + setTimeZone2(thirdEnd)
            thirdTimer = "EE060020" + thirdStart + thirdEnd + "."
            thirdTimerTv?.visibility=View.VISIBLE
        }else
        {
            thirdTimer = "EE060021" + "0000" + "0000" + "."
            thirdTimerTv?.visibility=View.INVISIBLE
        }
        if (fourtStart.length == 4 && fourtStart != "0000") {
            fourthTimerTv2?.text =
                setTimeZone2(fourtStart) + "-" + setTimeZone2(fourtEnd)
            fourthTimerTv2?.visibility=View.VISIBLE

            fourthTimer = "EE060030" + fourtStart + fourtEnd + "."
        }
        else{
            fourthTimerTv2?.visibility=View.INVISIBLE
            fourthTimer = "EE060031" + "0000" + "0000" + "."
        }
        val ss = deviceObject.mistTime
        val pp = deviceObject.suspendTime
        mistValue?.text = getTimeFromSeconds(ss)
        suspendValue?.text = getTimeFromSeconds(pp)
        var fullCommand ="EE07000000"+deviceObject.mistTime+"00"+deviceObject.suspendTime+"."
        intervalValue = fullCommand.toByteArray(charset)

        sprayFriquency = "EE07000000" + ss+"00" + pp + "."
        activeValue?.text = deviceObject.workingTime + "h"
        getActiveDaysFromDb()
    }


    private fun navigateToSetSchedule() {
        if (isFromDB) {
            val action =
                bleDevice?.name?.let {
                    SetDeviceFragmentDirections.actionSetDeviceToSetScheduleFragment(
                        0,
                        it
                    )
                }
            action?.let { findNavController().navigate(it) }
        } else {

            val action =
                bleDevice?.name?.let {
                    SetDeviceFragmentDirections.actionSetDeviceToSetScheduleFragment(
                        0,
                        it, scheduleModel
                    )
                }
            action?.let { findNavController().navigate(it) }
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

    fun getActiveDaysFromDb() {

        val one = deviceObject.monday
        val two = deviceObject.tuesday
        val three = deviceObject.wednesday
        val four = deviceObject.thursday
        val five = deviceObject.friday
        val six = deviceObject.saturday
        val seven = deviceObject.saturday

        if (one == true) {
            mondayTv?.alpha = 1f
            monday = scheduleMo + "0."
        } else {
            mondayTv?.alpha = 0.3f
            monday = scheduleMo + "1."
        }
        if (two == true) {
            tuesdayTV2?.alpha = 1f
            tuesday = scheduleTu + "0."
        } else {
            tuesdayTV2?.alpha = 0.3f
            tuesday = scheduleTu + "1."
        }
        if (three == true) {
            wednesdayTv?.alpha = 1f
            wednesday = scheduleWE + "0."
        } else {
            wednesdayTv?.alpha = 0.3f
            wednesday = scheduleWE + "1."
        }
        if (four == true) {
            thusdayTv?.alpha = 1f
            thursday = scheduleTH + "0."
        } else {
            thusdayTv?.alpha = 0.3f
            thursday = scheduleTH + "1."
        }

        if (five == true) {
            fridayTv?.alpha = 1f
            friday = scheduleFR + "0."
        } else {
            fridayTv?.alpha = 0.3f
            friday = scheduleFR + "1."
        }
        if (six == true) {
            saturdayTv?.alpha = 1f
            saturday = scheduleSA + "0."
        } else {
            saturdayTv?.alpha = 0.3f
            saturday = scheduleSA + "1."
        }
        if (seven == true) {
            sundayTv?.alpha = 1f
            sunday = scheduleSU + "0."
        } else {
            sundayTv?.alpha = 0.3f
            sunday = scheduleSU + "1."
        }
    }
}