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
import kotlinx.android.synthetic.main.fragment_set_device.sundayTv
import kotlinx.android.synthetic.main.fragment_set_device.suspendTv
import kotlinx.android.synthetic.main.fragment_set_device.suspendValue
import kotlinx.android.synthetic.main.fragment_set_device.tabName
import kotlinx.android.synthetic.main.fragment_set_device.tab_icon
import kotlinx.android.synthetic.main.fragment_set_device.thirdLine
import kotlinx.android.synthetic.main.fragment_set_device.thirdTimerTv
import kotlinx.android.synthetic.main.fragment_set_device.thusdayTv
import kotlinx.android.synthetic.main.fragment_set_device.wednesdayTv
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.BytePayload
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.models.ScheduleModel
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.NumberPickerPopup
import org.koin.android.ext.android.inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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
    var dateAndTimeSynch = "EE00+YYYYMMDDHHNNSST"

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
    var sprayPDON = "EE0401.".toByteArray(charset)
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
    var sprayFriquency = "EE07000000SSS00PPP"
    lateinit var daysInWeek: IntArray
    lateinit var deviceObject: MyDevice
    var mainDevicePositon = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val bundle = arguments
        val mainDevicePositon = bundle?.get("myArg") as Int
        setClickListener()
        setMotionLayoutListener()
        setTouchSwipeListener()
        val observer = Observer<CharArray> {
            var response = ""
            for (item in it) {
                response = response + item
            }
            if (response.contains(",")) {
                Log.e("D", "timer " + response)
                readTimerSync(response)
                return@Observer
            }
            Log.e("D", "Tag " + tag)
            if (tag == 0) {
                checkNonStopResponse(response)
            } else if (tag == 1) {
                checkIntervalResponse(response)
            } else {
                checkScheduleRespone(response)
            }
        }
        connectionStateCoordinator.bluetoothByteArray.observe(viewLifecycleOwner, observer)
        bleDevice =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                mainDevicePositon
            )!!
        gatt = connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
            bleDevice
        )!!

        scheduleModel = scheduleModelArgs.model

        if (scheduleModel.days != null) {
            setScheduleView()
            daysInWeek = scheduleModel.days!!
            formatDaySchedule()
        } else {
            setNonStopView()
        }
        formatDateAndTime()
        when (mainDevicePositon) {
            0 -> {
                val deviceOne = prefs.firstDevice
                val gson = Gson()
                deviceObject = gson.fromJson(deviceOne, MyDevice::class.java)
            }
            1 -> {
                val deviceTwo = prefs.secondDevice
                val gson = Gson()
                deviceObject = gson.fromJson(deviceTwo, MyDevice::class.java)
            }
            2 -> {
                val deviceThree = prefs.thirdDevice
                val gson = Gson()
                deviceObject = gson.fromJson(deviceThree, MyDevice::class.java)
            }
            3 -> {
                val deviceThree = prefs.fourthDevice
                val gson = Gson()
                deviceObject = gson.fromJson(deviceThree, MyDevice::class.java)
            }
        }
        deviceName.text = deviceObject.newName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_set_device, container, false)
    }

    fun formatDateAndTime() {
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
        if (sec < 10) {
            secString = "0" + sec
        } else {
            secString = sec.toString()
        }
        var minString = ""
        if (min < 10) {
            minString = "0" + min
        } else {
            minString = min.toString()
        }
        dateAndTimeSynch =
            "EE000+" + year + month + day + hour + minString + secString + dayNumber + "."

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


    fun readTimerSync(response: String) {
        val register = getRegister(response)
        Log.e("D", "register " + register)
        var workingTime = ""
        var isOn = false
        var isNonStop = false
        var isSprayingMode = false
        var monday = false
        var tuesday = false
        var wednesday = false
        var thursday = false
        var friday = false
        var saturday = false
        var sunday = false
        var isSprayPerDay = false
        var isSprayFriquencu = false
        var firstStartTime: String = ""
        var secondStartTime: String = ""
        var thirdStartTime: String = ""
        var fourtStartTime: String = ""
        var firstStopTime: String = ""
        var secondStopTime: String = ""
        var thirdStopTime: String = ""
        var fourtStopTime: String = ""
        var mistTime: String = ""
        var suspendTime: String = ""
        when (register) {
            "0" -> {
                val subString = response.substring(6, response.length - 1)
                val time = subString.toInt()
                activeValue.text = time.toString() + "h"
                workingTime = time.toString()
            }
            "1" -> {
                val subString = response.substring(6, response.length - 1)
                Log.e("D", "subString " + subString)

                if (subString == "0") {
                    isOn = true
                }
                Log.e("d", "isOn " + isOn)
            }
            "2" -> {
                val subString = response.substring(6, response.length - 1)

                if (subString == "0") {
                    isNonStop = true
                    isSprayingMode = false
                } else {
                    isNonStop = false
                    isSprayingMode = true
                }
                Log.e("d", "isNonStop " + isNonStop)
                Log.e("d", "isSprayingMode " + isSprayingMode)

            }
            "3" -> {
                val subString = response.substring(6, response.length - 1)
                val charArray = subString.toCharArray()
                if (charArray.size == 7) {
                    val isMonday = charArray.get(0)
                    val isTuesday = charArray.get(1)
                    val isWednesday = charArray.get(2)
                    val isThursday = charArray.get(3)
                    val isFriday = charArray.get(4)
                    val isSaturday = charArray.get(5)
                    val isSunday = charArray.get(6)
                    Log.e("D", "isSunday " + isSunday)
                    //0-AKTIVAN
                    if (isMonday == '0') {
                        monday = true
                    }
                    if (isTuesday == '0') {
                        tuesday = true
                    }
                    if (isWednesday == '0') {
                        wednesday = true
                    }
                    if (isThursday == '0') {
                        thursday = true
                    }
                    if (isFriday == '0') {
                        friday = true
                    }
                    if (isSaturday == '0') {
                        saturday = true
                    }
                    if (isSunday == '0') {
                        sunday = true
                    }
                    val gson = Gson()
                    val newDevice = MyDevice(
                        deviceObject.name,
                        deviceObject.newName,
                        false,
                        workingTime,
                        isOn,
                        isNonStop,
                        isSprayingMode,
                        monday,
                        tuesday,
                        wednesday,
                        thursday,
                        friday,
                        saturday,
                        sunday,
                        isSprayPerDay,
                        isSprayFriquencu,
                        firstStartTime,
                        firstStopTime,
                        secondStartTime,
                        secondStopTime,
                        thirdStartTime,
                        thirdStopTime,
                        fourtStartTime,
                        fourtStopTime,
                        mistTime,
                        suspendTime
                    )
                    val json = gson.toJson(newDevice)
                    when (mainDevicePositon) {
                        0 -> prefs.firstDevice = json
                        1 -> prefs.secondDevice = json
                        2 -> prefs.thirdDevice = json
                        3 -> prefs.fourthDevice = json
                    }
                }
            }
            "4" -> {
                val subString = response.substring(6, response.length - 1)
                if (subString == "0") {
                    isSprayPerDay = true
                }
            }
            "5" -> {
                val subString = response.substring(6, response.length - 1)
                if (subString == "0") {
                    isSprayFriquencu = true
                }
            }
            "6" -> {
                val timZoneId = response.get(8)
                when (timZoneId) {
                    '0' -> {
                        firstStartTime = response.substring(9, 13)
                        firstStopTime = response.substring(13, 17)
                    }
                    '1' -> {
                        secondStartTime = response.substring(9, 13)
                        secondStopTime = response.substring(13, 17)
                    }
                    '2' -> {
                        thirdStartTime = response.substring(9, 13)
                        thirdStopTime = response.substring(13, 17)
                    }
                    '3' -> {
                        fourtStartTime = response.substring(9, 13)
                        fourtStopTime = response.substring(13, 17)
                    }
                }

            }
            "7" -> {
                mistTime = response.substring(11, 14)
                suspendTime = response.substring(16, 19)
            }
        }
    }

    private fun getRegister(response: String): String {
        var pos = response.get(5)
        return pos.toString()
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
                "USPJESNO ZAVRSENO"
            }
        }
    }

    fun checkScheduleRespone(response: String) {
        Log.e("d", "RESPONSE " + response)

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
            "EE16003." -> {
                if (scheduleModel.nonStop == true) {
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
        }
    }

    fun formatTimer() {
        val hourOne = scheduleModel.timer?.get(0)!!.hours
        val minOne = scheduleModel.timer?.get(0)!!.min
        val hourTwo = scheduleModel.timer?.get(1)!!.hours
        val minTwo = scheduleModel.timer?.get(1)!!.min
        firstTimer = "EE060000" + hourOne + minOne + hourTwo + minTwo + "."
        firstTimerTv.text = hourOne + ":" + minOne + " - " + hourTwo + ":" + minTwo
        if (hourOne != "0" && hourTwo != "0") {
            firstTimerTv.visibility = View.VISIBLE
        } else {
            firstTimerTv.visibility = View.INVISIBLE
        }
        Log.e("D", "firstTimer " + firstTimer)
        val hourThree = scheduleModel.timer?.get(2)!!.hours
        val minThree = scheduleModel.timer?.get(2)!!.min
        val hourFour = scheduleModel.timer?.get(3)!!.hours
        val minFour = scheduleModel.timer?.get(3)!!.min
        secondTimer = "EE060010" + hourThree + minThree + hourFour + minFour + "."
        secondTimerTv.text = hourThree + ":" + minThree + " - " + hourFour + ":" + hourFour
        if (hourThree != "0" && hourFour != "0") {
            secondTimerTv.visibility = View.VISIBLE
        } else {
            secondTimerTv.visibility = View.INVISIBLE
        }
        Log.e("D", "secondTimer " + secondTimer)
        val hourFive = scheduleModel.timer?.get(4)!!.hours
        val minFive = scheduleModel.timer?.get(4)!!.min
        val hourSix = scheduleModel.timer?.get(5)!!.hours
        val minSix = scheduleModel.timer?.get(5)!!.min
        thirdTimer = "EE060020" + hourFive + minFive + hourSix + minSix + "."
        thirdTimerTv.text = hourFive + ":" + minFive + " - " + hourSix + ":" + minSix
        if (hourFive != "0" && hourSix != "0") {
            thirdTimerTv.visibility = View.VISIBLE
        } else {
            thirdTimerTv.visibility = View.INVISIBLE
        }
        Log.e("D", "thirdTimer " + thirdTimer)
        val hourSeven = scheduleModel.timer?.get(6)!!.hours
        val minSeven = scheduleModel.timer?.get(6)!!.min
        val hourEight = scheduleModel.timer?.get(7)!!.hours
        val minEight = scheduleModel.timer?.get(7)!!.min
        fourthTimer = "EE060030" + hourSeven + minSeven + hourEight + minEight + "."
        fourthTimerTv2.text = hourSeven + ":" + minSeven + " - " + hourEight + ":" + hourEight
        Log.e("D", "hourSeven " + hourSeven)
        Log.e("D", "hourEight " + hourEight)
        Log.e("D", "fourthTimer " + fourthTimer)

        if (hourSeven != "0" && hourEight != "0") {
            Log.e("D", "ULAZI")
            fourthTimerTv2.visibility = View.VISIBLE
        } else {
            Log.e("D", "NE ULAZI")

            fourthTimerTv2.visibility = View.INVISIBLE
        }
        val sss = getSeconds(scheduleModel.mist.toString())
        val ppp = getSeconds(scheduleModel.suspend.toString())
        var friqu = "EE07000000" + sss + ppp + "."
        sprayFriquency = friqu
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
            fourthTimerTv2?.setBackgroundColor(
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
            fourthTimerTv2?.setBackgroundColor(
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
        mistTv?.visibility = View.VISIBLE
        mistValue?.visibility = View.VISIBLE
        suspendTv?.visibility = View.VISIBLE
        suspendValue?.visibility = View.VISIBLE
        btnEdit?.visibility = View.VISIBLE
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
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.orange_circle)
        )
        guideline.setGuidelinePercent(0.65f)
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
    }

    private fun navigateToSetSchedule() {
        findNavController().navigate(R.id.action_set_device_to_set_schedule_fragment)
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
}