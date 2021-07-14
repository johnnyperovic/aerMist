package llc.aerMist.app.ui.splash

import android.annotation.SuppressLint
import android.bluetooth.BluetoothGatt
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.callback.BleNotifyCallback
import com.clj.fastble.callback.BleWriteCallback
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
import com.google.gson.Gson
import kotlinx.android.synthetic.main.my_devices_fragment.*
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class SplashFragment : Fragment() {
    private val prefs: PreferenceCache by inject()
    var bluetoothController: BluetoothController? = null
    val connectionStateCoordinator = NewObservableCoordinator
    var deviceOne = ""
    lateinit var deviceOneObj: MyDevice
    var deviceTwo = ""
    lateinit var deviceTwoObj: MyDevice
    var deviceThree = ""
    lateinit var deviceThreeObj: MyDevice
    var deviceFour = ""
    lateinit var deviceFourObj: MyDevice
    val charset = Charsets.UTF_8
    var firstDevice: String = ""
    var firstDeviceNewName: String = ""
    var firstBleDevice: BleDevice? = null
    var firstGate: BluetoothGatt? = null
    var secondDevice: String = ""
    var secondDeviceNewName: String = ""
    var thirdDevice: String = ""
    var thirdDeviceNewName: String = ""
    var fourthDevice: String = ""
    var fourthDeviceNewName: String = ""
    var secondBleDevice: BleDevice? = null
    var secondGate: BluetoothGatt? = null
    var thirdBleDevice: BleDevice? = null
    var thirdGate: BluetoothGatt? = null
    var fourthBleDevice: BleDevice? = null
    var fourthGate: BluetoothGatt? = null
    var workingTime = ""
    var isOn = false
    var isNonStop = false
    var isSprayingMode = false
    var mondayActive = false
    var tuesdayActive = false
    var wednesdayActive = false
    var thursdayActive = false
    var fridayActive = false
    var saturdayActive = false
    var sundayActive = false
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
    var deviceNameValue = ""
    var time = ""
    var intervalValue = "".toByteArray(charset)
    var shortString = ""
    var shortString2 = ""
    var shortString3 = ""
    var shortString4 = ""
    var workingTime2 = ""
    var isOn2 = false
    var isNonStop2 = false
    var isSprayingMode2 = false
    var mondayActive2 = false
    var tuesdayActive2 = false
    var wednesdayActive2 = false
    var thursdayActive2 = false
    var fridayActive2 = false
    var saturdayActive2 = false
    var sundayActive2 = false
    var isSprayPerDay2 = false
    var isSprayFriquencu2 = false
    var firstStartTime2: String = ""
    var secondStartTime2: String = ""
    var thirdStartTime2: String = ""
    var fourtStartTime2: String = ""
    var firstStopTime2: String = ""
    var secondStopTime2: String = ""
    var thirdStopTime2: String = ""
    var fourtStopTime2: String = ""
    var mistTime2: String = ""
    var suspendTime2: String = ""
    var intervalValue2 = "".toByteArray(charset)
    var dateAndTimeSynch = ""
    val firstCommand="EE0c0."
    var workingTime3 = ""
    var isOn3 = false
    var isNonStop3 = false
    var isSprayingMode3 = false
    var mondayActive3 = false
    var tuesdayActive3 = false
    var wednesdayActive3 = false
    var thursdayActive3 = false
    var fridayActive3 = false
    var saturdayActive3 = false
    var sundayActive3 = false
    var isSprayPerDay3 = false
    var isSprayFriquencu3 = false
    var firstStartTime3: String = ""
    var secondStartTime3: String = ""
    var thirdStartTime3: String = ""
    var fourtStartTime3: String = ""
    var firstStopTime3: String = ""
    var secondStopTime3: String = ""
    var thirdStopTime3: String = ""
    var fourtStopTime3: String = ""
    var mistTime3: String = ""
    var suspendTime3: String = ""
    var intervalValue3 = "".toByteArray(charset)

    var workingTime4 = ""
    var isOn4 = false
    var isNonStop4 = false
    var isSprayingMode4 = false
    var mondayActive4 = false
    var tuesdayActive4 = false
    var wednesdayActive4 = false
    var thursdayActive4 = false
    var fridayActive4 = false
    var saturdayActive4 = false
    var sundayActive4 = false
    var isSprayPerDay4 = false
    var isSprayFriquencu4 = false
    var firstStartTime4: String = ""
    var secondStartTime4: String = ""
    var thirdStartTime4: String = ""
    var fourtStartTime4: String = ""
    var firstStopTime4: String = ""
    var secondStopTime4: String = ""
    var thirdStopTime4: String = ""
    var fourtStopTime4: String = ""
    var mistTime4: String = ""
    var suspendTime4: String = ""
    var intervalValue4 = "".toByteArray(charset)
    var bleDeviceToPass:String=""
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        deviceOne = prefs.firstDevice
        deviceTwo = prefs.secondDevice
        deviceThree = prefs.thirdDevice
        deviceFour = prefs.fourthDevice
        bluetoothController =
            BluetoothController(
                notifyCallback,
                notifyCallback2,
                notifyCallback3,
                notifyCallback4,
                gattCallback,
                null,
                writeCallback,
                requireContext()
            )
        bluetoothController?.bluetoothManager
            ?.enableLog(true)
            ?.setReConnectCount(2, 1000)
            ?.setConnectOverTime(18000)?.operateTimeout = 1000


        connectionStateCoordinator.bluetoothController = bluetoothController
        bluetoothController?.bluetoothAdapter?.startDiscovery()
        connectionStateCoordinator.isDeviceConnected = false
        bluetoothController?.bluetoothManager?.init(requireActivity().application)
        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
        val firstMac = prefs.firstBleDevice
        val secondMac = prefs.secondBleDevice
        val thirdMac = prefs.thirdBleDevice
        val fourthMac = prefs.fourthBleDevice
        if (firstMac.length > 0) {
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                firstMac,
                gattCallback
            )
        }
        if (secondMac.length > 0) {
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                secondMac,
                gattCallback
            )
        }
        if (thirdMac.length > 0) {
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                thirdMac,
                gattCallback
            )
        }
        if (fourthMac.length > 0) {
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                fourthMac,
                gattCallback
            )
        }

        Handler().postDelayed({
            firstBleDevice?.let { sendTimeSynchCommand(firstGate!!, it) }
            secondBleDevice?.let { sendTimeSynchCommand(secondGate!!, it) }
            thirdBleDevice?.let { sendTimeSynchCommand(thirdGate!!, it) }
            fourthBleDevice?.let { sendTimeSynchCommand(fourthGate!!, it) }
            Handler().postDelayed({
            val allDevices =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            if (allDevices == 0) {
                navigateToWelcome()
            }
            if (allDevices == 1) {
                navigateToDevice()
            }
            else if  (allDevices >1) {
                navigateToHome()
            }
            }, 2000)
        }, 3000)
    }    @SuppressLint("SetTextI18n")
    fun setFirstDevice() {
        deviceOne = prefs.firstDevice
        if (!deviceOne.isNullOrEmpty()) {
            val gson = Gson()
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDeviceNewName = deviceOneObj.newName
            firstDevice = deviceOneObj.name
        }
    }

    @SuppressLint("SetTextI18n")

    fun setSecondDevice() {
        val deviceTwo = prefs.secondDevice
        if (!deviceTwo.isNullOrEmpty()) {
            val gson = Gson()
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            secondDeviceNewName = deviceTwoObj.newName
            secondDevice = deviceTwoObj.name
        }
    }

    @SuppressLint("SetTextI18n")

    fun setThirdDevice() {
        val deviceThree = prefs.thirdDevice
        if (!deviceThree.isNullOrEmpty()) {
            val gson = Gson()
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            thirdDevice = deviceThreeObj.name
            thirdDeviceNewName = deviceThreeObj.name

        }
    }

    @SuppressLint("SetTextI18n")
    fun setFourthDevice() {
        val deviceFour = prefs.fourthDevice
        if (!deviceFour.isNullOrEmpty()) {
            val gson = Gson()
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            fourthDevice = deviceFourObj.name
            fourthDeviceNewName = deviceFourObj.name
        }
    }


    private fun navigateToWelcome() {
        findNavController().navigate(R.id.action_splashFragment_to_welcomeFragment)
    }

    private fun navigateToHome() {
        findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
    }

    private val gattCallback = object : BleGattCallback() {
        override fun onStartConnect() {
            Log.e("D", "onStartConnect ")
        }

        override fun onConnectFail(bleDevice: BleDevice, exception: BleException) {
            Log.e("D", "onConnectFail")

        }

        override fun onConnectSuccess(bleDevicee: BleDevice, gatt: BluetoothGatt, status: Int) {
            connectionStateCoordinator.bluetoothConnectionState.value = "connected"
            Log.e("d", " onConnectSuccess  " + bleDevicee.name)
            if (bleDevicee.name == firstDevice) {
                firstBleDevice = bleDevicee
                if (bleDevicee != null) {
                    bleDeviceToPass=bleDevicee.name
                }
                firstGate = gatt
                readResponse()
            }
            if (bleDevicee.name == secondDevice) {
                if (bleDevicee != null) {
                    bleDeviceToPass=bleDevicee.name
                }
                secondBleDevice = bleDevicee
                secondGate = gatt
                readSecondResponse()

            }
            if (bleDevicee.name == thirdDevice) {
                if (bleDevicee != null) {
                    bleDeviceToPass=bleDevicee.name
                }
                thirdBleDevice = bleDevicee
                thirdGate = gatt
                readThirdResponse()

            }
            if (bleDevicee.name == fourthDevice) {
                if (bleDevicee != null) {
                    bleDeviceToPass=bleDevicee.name
                }
                fourthBleDevice = bleDevicee
                fourthGate = gatt
                readFourthResponse()

            }
        }

        override fun onDisConnected(
            isActiveDisConnected: Boolean,
            bleDevice: BleDevice,
            gatt: BluetoothGatt,
            status: Int
        ) {
            connectionStateCoordinator.bleDisconnectDevices.value =  bleDevice
        }
    }
    fun navigateToDevice() {
        prefs.isOneDevice = true
        val action = SplashFragmentDirections.actionSplashFragmentToDeviceFragment(bleDeviceToPass)
        findNavController().navigate(action)
    }
    fun readResponse() {
        //  Log.e("D", "onConnectSuccess SERVICE SIZE " + firstGate.services.size)
        for (service in firstGate?.services!!) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)
                for (service in service.characteristics) {
                    if (service.uuid.toString().equals("0000ffe1-0000-1000-8000-00805f9b34fb")) {
                        bluetoothController?.blueGattAdapter?.addResult(service.service)
                    }
                }

            }
        }
        bluetoothController?.bleDeviceMain = firstBleDevice
        connectionStateCoordinator.firstGatt = firstGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)


        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            bluetoothController?.readNotification(
                firstBleDevice,
                service?.characteristics!!.get(0)
            )
//           firstBleDevice?.let { sendCommand(firstCommand.toByteArray(charset), it, firstGate!!) }
//            firstBleDevice?.let { sendTimeSynchCommand(firstGate!!, it) }

        }
    }

    fun readSecondResponse() {
        for (service in secondGate?.services!!) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController?.blueGattAdapter?.addResult(service)
                }
            }
        }
        bluetoothController?.bleDeviceMain = secondBleDevice
        connectionStateCoordinator.secondGatt = secondGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)

        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            bluetoothController?.readNotification2(
                secondBleDevice,
                service?.characteristics!!.get(0)
            )
//            secondBleDevice?.let { sendCommand(firstCommand.toByteArray(charset), it, secondGate!!) }
//            secondBleDevice?.let { sendTimeSynchCommand(secondGate!!, it) }
        }
    }
    private val writeCallback = object : BleWriteCallback() {
        override fun onWriteSuccess(current: Int, total: Int, justWrite: ByteArray?) {
        }

        override fun onWriteFailure(exception: BleException?) {
        }

    }
    fun readThirdResponse() {
        for (service in thirdGate?.services!!) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController?.blueGattAdapter?.addResult(service)
                }
            }
        }
        bluetoothController?.bleDeviceMain = thirdBleDevice
        connectionStateCoordinator.thirdGatt = thirdGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)

        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            bluetoothController?.readNotification3(
                thirdBleDevice,
                service?.characteristics!!.get(0)
            )
//            thirdBleDevice?.let { sendCommand(firstCommand.toByteArray(charset), it, thirdGate!!) }
//            thirdBleDevice?.let { sendTimeSynchCommand(thirdGate!!, it) }
        }
    }

    fun readFourthResponse() {
        for (service in fourthGate?.services!!) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController?.blueGattAdapter?.addResult(service)
                }
            }
        }
        bluetoothController?.bleDeviceMain = fourthBleDevice
        connectionStateCoordinator.fourthGatt = fourthGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)

        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            bluetoothController?.readNotification4(
                fourthBleDevice,
                service?.characteristics!!.get(0)
            )
//            fourthBleDevice?.let { sendCommand(firstCommand.toByteArray(charset), it, fourthGate!!) }
//            fourthBleDevice?.let { sendTimeSynchCommand(fourthGate!!, it) }

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

    fun sendTimeSynchCommand(gatt: BluetoothGatt, bleDevice: BleDevice) {
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
                    firstCommand.toByteArray(
                        charset
                    ), it1, it
                )
            }
        }
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
    private val notifyCallback = object : BleNotifyCallback() {
        override fun onNotifySuccess() {
        }

        override fun onNotifyFailure(exception: BleException) {
        }

        override fun onCharacteristicChanged(data: ByteArray) {
            var newDataChar = CharArray(data.size)
            for ((index, byte) in data.withIndex()) {
                newDataChar[index] = byte.toChar()
            }
            connectionStateCoordinator.bleDevicePosition = 0
            connectionStateCoordinator.bluetoothByteArray.value = newDataChar
            var response = ""
            var firstPart = ""

            for (item in newDataChar) {

                response = response + item
                if (item.equals(',')) {
                    if (shortString.length > 0) {
                        response = shortString + response
                        shortString = ""
                    }
                    firstPart = response
                    Log.e("D", "RESPONSE " + response)
                    if (getRegister(firstPart) == "7") {
                        firstPart = firstPart + "."
                    }
                    readTimerSync(firstPart)
                    response = ""
                }
            }
            if (!response.contains(".") && !response.contains(",")) {
                shortString = response
                return
            }

        }
    }
    private val notifyCallback2 = object : BleNotifyCallback() {
        override fun onNotifySuccess() {
        }

        override fun onNotifyFailure(exception: BleException) {
        }

        override fun onCharacteristicChanged(data: ByteArray) {
            var newDataChar = CharArray(data.size)
            for ((index, byte) in data.withIndex()) {
                newDataChar[index] = byte.toChar()
            }
            connectionStateCoordinator.bleDevicePosition = 1
            connectionStateCoordinator.bluetoothByteArray.value = newDataChar

            var response = ""
            var firstPart = ""
            for (item in newDataChar) {
                response = response + item
                if (item.equals(',')) {
                    if (shortString2.length > 0) {
                        response = shortString2 + response
                        shortString2 = ""
                    }
                    firstPart = response
                    Log.e("D", "RESPONSE " + response)
                    if (getRegister(firstPart) == "7") {
                        firstPart = firstPart + "."
                    }
                    readTimerSync2(firstPart)
                    response = ""
                }
            }
            if (!response.contains(".") && !response.contains(",")) {
                shortString2 = response
                return
            }
        }
    }
    private val notifyCallback3 = object : BleNotifyCallback() {
        override fun onNotifySuccess() {
        }

        override fun onNotifyFailure(exception: BleException) {
        }

        override fun onCharacteristicChanged(data: ByteArray) {
            var newDataChar = CharArray(data.size)
            for ((index, byte) in data.withIndex()) {
                newDataChar[index] = byte.toChar()
            }
            connectionStateCoordinator.bleDevicePosition = 2
            var response = ""
            var firstPart = ""
            for (item in newDataChar) {
                response = response + item
                if (item.equals(',')) {
                    if (shortString3.length > 0) {
                        response = shortString3 + response
                        shortString3 = ""
                    }
                    firstPart = response
                    Log.e("D", "RESPONSE " + response)
                    if (getRegister(firstPart) == "7") {
                        firstPart = firstPart + "."
                    }
                    readTimerSync3(firstPart)
                    response = ""
                }
            }
            if (!response.contains(".") && !response.contains(",")) {
                shortString3 = response
                return
            }

        }
    }
    private val notifyCallback4 = object : BleNotifyCallback() {
        override fun onNotifySuccess() {
        }

        override fun onNotifyFailure(exception: BleException) {
        }

        override fun onCharacteristicChanged(data: ByteArray) {
            var newDataChar = CharArray(data.size)
            for ((index, byte) in data.withIndex()) {
                newDataChar[index] = byte.toChar()
            }
            connectionStateCoordinator.bleDevicePosition = 3
            connectionStateCoordinator.bluetoothByteArray.value = newDataChar
            var response = ""
            var firstPart = ""
            for (item in newDataChar) {
                response = response + item
                if (item.equals(',')) {
                    if (shortString4.length > 0) {
                        response = shortString4 + response
                        shortString4 = ""
                    }
                    firstPart = response
                    Log.e("D", "RESPONSE " + response)
                    if (getRegister(firstPart) == "7") {
                        firstPart = firstPart + "."
                    }
                    readTimerSync4(firstPart)
                    response = ""
                }
            }
            if (!response.contains(".") && !response.contains(",")) {
                shortString4 = response
                return
            }
        }
    }
    private fun getRegister(response: String): String {
        var pos = response.get(5)
        return pos.toString()
    }
    fun readTimerSync(response: String) {
        val register = getRegister(response)
        Log.e("D", "register " + register)

        when (register) {

            "0" -> {
                val subString = response.substring(6, response.length - 1)
                val time = subString.toInt()
                Log.e("D", "OVO JE VRIJEME " + time)
                workingTime = time.toString()
                if (prefs.startWorkingTimeFD == "") {
                    prefs.startWorkingTimeFD = workingTime
                }
            }
            "1" -> {
                val subString = response.substring(6, response.length - 1)
                Log.e("D", "subString " + subString)
                if (subString == "0") {
                    isOn = true
                } else {
                    isOn = false
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
                        mondayActive = true
                    } else {
                        mondayActive = false
                    }
                    if (isTuesday == '0') {
                        tuesdayActive = true
                    } else {
                        tuesdayActive = false
                    }
                    if (isWednesday == '0') {
                        wednesdayActive = true
                    } else {
                        wednesdayActive = false
                    }
                    if (isThursday == '0') {
                        thursdayActive = true
                    } else {
                        thursdayActive = false
                    }
                    if (isFriday == '0') {
                        fridayActive = true
                    } else {
                        fridayActive = false
                    }
                    if (isSaturday == '0') {
                        saturdayActive = true
                    } else {
                        saturdayActive = false
                    }
                    if (isSunday == '0') {
                        sundayActive = true
                    } else {
                        sundayActive = false
                    }
                }
            }
            "4" -> {
                val subString = response.substring(6, response.length - 1)
                Log.e("d", "SPRAY PER DAY " + subString)
                if (subString == "0") {
                    isSprayPerDay = true
                } else {
                    isSprayPerDay = false
                }
            }
            "5" -> {
                val subString = response.substring(6, response.length - 1)
                if (subString == "0") {
                    isSprayFriquencu = true
                } else {
                    isSprayFriquencu = false
                }
            }
            "6" -> {
                val timZoneId = response.get(7)
                Log.e("D", "ZONA " + timZoneId)

                when (timZoneId) {
                    '0' -> {
                        firstStartTime = response.substring(9, 13)
                        firstStopTime = response.substring(13, response.length - 1)

                    }
                    '1' -> {
                        secondStartTime = response.substring(9, 13)
                        secondStopTime = response.substring(13, response.length - 1)
                    }
                    '2' -> {
                        thirdStartTime = response.substring(9, 13)
                        thirdStopTime = response.substring(13, response.length - 1)
                    }
                    '3' -> {
                        fourtStartTime = response.substring(9, 13)
                        fourtStopTime = response.substring(13, response.length - 1)
                    }
                }
                Log.e("D", "firstStartTime " + firstStartTime)
                Log.e("D", "firstStopTime " + firstStopTime)
                Log.e("D", "secondStartTime " + secondStartTime)
                Log.e("D", "secondStopTime " + secondStopTime)
            }
            "7" -> {
                mistTime = response.substring(11, 14)
                suspendTime = response.substring(16, 19)
                var fullCommand = ""
                fullCommand = fullCommand + "EE07000000"
                fullCommand = fullCommand + mistTime
                fullCommand = fullCommand + "00"
                fullCommand = fullCommand + suspendTime
                fullCommand = fullCommand + "."
                intervalValue = fullCommand.toByteArray(charset)
                val gson = Gson()
                val newDevice = MyDevice(
                    deviceOneObj.name,
                    deviceOneObj.newName,
                    true,
                    workingTime,
                    isOn,
                    isNonStop,
                    isSprayingMode,
                    mondayActive,
                    tuesdayActive,
                    wednesdayActive,
                    thursdayActive,
                    fridayActive,
                    saturdayActive,
                    sundayActive,
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
                Log.e("D", "MIST TIME " + mistTime)
                Log.e("D", "suspendTime TIME " + suspendTime)
                val json = gson.toJson(newDevice)
                prefs.firstDevice = json
                connectionStateCoordinator.isFirstTimeSynch.value=true
            }
        }
    }

    fun readTimerSync2(response: String) {
        val register = getRegister(response)
        Log.e("D", "register " + register)

        when (register) {
            "0" -> {
                val subString = response.substring(6, response.length - 1)
                val time = subString.toInt()
                workingTime2 = time.toString()
                if (prefs.startWorkingTimeSD == "") {
                    prefs.startWorkingTimeSD = workingTime2
                }
            }
            "1" -> {
                val subString = response.substring(6, response.length - 1)
                Log.e("D", "subString " + subString)
                if (subString == "0") {
                    isOn2 = true
                } else {
                    isOn2 = false
                }
                Log.e("d", "isOn " + isOn)
            }
            "2" -> {
                val subString = response.substring(6, response.length - 1)

                if (subString == "0") {
                    isNonStop2 = true
                    isSprayingMode2 = false
                } else {
                    isNonStop2 = false
                    isSprayingMode2 = true
                }


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
                        mondayActive2 = true
                    } else {
                        mondayActive2 = false
                    }
                    if (isTuesday == '0') {
                        tuesdayActive2 = true
                    } else {
                        tuesdayActive2 = false
                    }
                    if (isWednesday == '0') {
                        wednesdayActive2 = true
                    } else {
                        wednesdayActive2 = false
                    }
                    if (isThursday == '0') {
                        thursdayActive2 = true
                    } else {
                        thursdayActive2 = false
                    }
                    if (isFriday == '0') {
                        fridayActive2 = true
                    } else {
                        fridayActive2 = false
                    }
                    if (isSaturday == '0') {
                        saturdayActive2 = true
                    } else {
                        saturdayActive2 = false
                    }
                    if (isSunday == '0') {
                        sundayActive2 = true
                    } else {
                        sundayActive2 = false
                    }
                }
            }
            "4" -> {
                val subString = response.substring(6, response.length - 1)
                Log.e("d", "SPRAY PER DAY " + subString)
                if (subString == "0") {
                    isSprayPerDay2 = true
                } else {
                    isSprayPerDay2 = false
                }
            }
            "5" -> {
                val subString = response.substring(6, response.length - 1)
                if (subString == "0") {
                    isSprayFriquencu2 = true
                } else {
                    isSprayFriquencu2 = false
                }
            }
            "6" -> {
                val timZoneId = response.get(7)

                when (timZoneId) {

                    '0' -> {
                        firstStartTime2 = response.substring(9, 13)
                        firstStopTime2 = response.substring(13, response.length - 1)
                    }
                    '1' -> {
                        secondStartTime2 = response.substring(9, 13)
                        secondStopTime2 = response.substring(13, response.length - 1)
                    }
                    '2' -> {
                        thirdStartTime2 = response.substring(9, 13)
                        thirdStopTime2 = response.substring(13, response.length - 1)
                    }
                    '3' -> {
                        fourtStartTime2 = response.substring(9, 13)
                        fourtStopTime2 = response.substring(13, response.length - 1)
                    }
                }

            }
            "7" -> {
                mistTime2 = response.substring(11, 14)
                suspendTime2 = response.substring(16, 19)
                var fullCommand = ""
                fullCommand = fullCommand + "EE07000000"
                fullCommand = fullCommand + mistTime
                fullCommand = fullCommand + "00"
                fullCommand = fullCommand + suspendTime
                fullCommand = fullCommand + "."
                intervalValue2 = fullCommand.toByteArray(charset)
                val gson = Gson()
                val newDevice = MyDevice(
                    deviceTwoObj.name,
                    deviceTwoObj.newName,
                    true,
                    workingTime2,
                    isOn2,
                    isNonStop2,
                    isSprayingMode2,
                    mondayActive2,
                    tuesdayActive2,
                    wednesdayActive2,
                    thursdayActive2,
                    fridayActive2,
                    saturdayActive2,
                    sundayActive2,
                    isSprayPerDay2,
                    isSprayFriquencu2,
                    firstStartTime2,
                    firstStopTime2,
                    secondStartTime2,
                    secondStopTime2,
                    thirdStartTime2,
                    thirdStopTime2,
                    fourtStartTime2,
                    fourtStopTime2,
                    mistTime2,
                    suspendTime2
                )
                val json = gson.toJson(newDevice)
                prefs.secondDevice = json
                connectionStateCoordinator.isSecondTimeSynch.value=true

            }
        }
    }


    fun readTimerSync3(response: String) {
        val register = getRegister(response)
        Log.e("D", "register " + register)

        when (register) {
            "0" -> {
                val subString = response.substring(6, response.length - 1)
                val time = subString.toInt()
                workingTime3 = time.toString()
                if (prefs.startWorkingTimeTD == "") {
                    prefs.startWorkingTimeTD = workingTime3
                }
            }
            "1" -> {
                val subString = response.substring(6, response.length - 1)
                if (subString == "0") {
                    isOn3 = true
                } else {
                    isOn3 = false
                }
                Log.e("d", "isOn " + isOn)
            }
            "2" -> {
                val subString = response.substring(6, response.length - 1)

                if (subString == "0") {
                    isNonStop3 = true
                    isSprayingMode3 = false
                } else {
                    isNonStop3 = false
                    isSprayingMode3 = true
                }


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
                        mondayActive3 = true
                    } else {
                        mondayActive3 = false
                    }
                    if (isTuesday == '0') {
                        tuesdayActive3 = true
                    } else {
                        tuesdayActive3 = false
                    }
                    if (isWednesday == '0') {
                        wednesdayActive3 = true
                    } else {
                        wednesdayActive3 = false
                    }
                    if (isThursday == '0') {
                        thursdayActive3 = true
                    } else {
                        thursdayActive3 = false
                    }
                    if (isFriday == '0') {
                        fridayActive3 = true
                    } else {
                        fridayActive3 = false
                    }
                    if (isSaturday == '0') {
                        saturdayActive3 = true
                    } else {
                        saturdayActive3 = false
                    }
                    if (isSunday == '0') {
                        sundayActive3 = true
                    } else {
                        sundayActive3 = false
                    }
                }
            }
            "4" -> {
                val subString = response.substring(6, response.length - 1)
                Log.e("d", "SPRAY PER DAY " + subString)
                if (subString == "0") {
                    isSprayPerDay3 = true
                } else {
                    isSprayPerDay3 = false
                }
            }
            "5" -> {
                val subString = response.substring(6, response.length - 1)
                if (subString == "0") {
                    isSprayFriquencu3 = true
                } else {
                    isSprayFriquencu3 = false
                }
            }
            "6" -> {
                val timZoneId = response.get(7)
                when (timZoneId) {
                    '0' -> {
                        firstStartTime3 = response.substring(9, 13)
                        firstStopTime3 = response.substring(13, 17)
                    }
                    '1' -> {
                        secondStartTime3 = response.substring(9, 13)
                        secondStopTime3 = response.substring(13, 17)
                    }
                    '2' -> {
                        thirdStartTime3 = response.substring(9, 13)
                        thirdStopTime3 = response.substring(13, 17)
                    }
                    '3' -> {
                        fourtStartTime3 = response.substring(9, 13)
                        fourtStopTime3 = response.substring(13, 17)
                    }
                }

            }
            "7" -> {
                mistTime3 = response.substring(11, 14)
                suspendTime3 = response.substring(16, 19)
                var fullCommand = ""
                fullCommand = fullCommand + "EE07000000"
                fullCommand = fullCommand + mistTime
                fullCommand = fullCommand + "00"
                fullCommand = fullCommand + suspendTime
                fullCommand = fullCommand + "."
                intervalValue3 = fullCommand.toByteArray(charset)
                val gson = Gson()
                val newDevice = MyDevice(
                    deviceThreeObj.name,
                    deviceThreeObj.newName,
                    true,
                    workingTime3,
                    isOn3,
                    isNonStop3,
                    isSprayingMode3,
                    mondayActive3,
                    tuesdayActive3,
                    wednesdayActive3,
                    thursdayActive3,
                    fridayActive3,
                    saturdayActive3,
                    sundayActive3,
                    isSprayPerDay3,
                    isSprayFriquencu3,
                    firstStartTime3,
                    firstStopTime3,
                    secondStartTime3,
                    secondStopTime3,
                    thirdStartTime3,
                    thirdStopTime3,
                    fourtStartTime3,
                    fourtStopTime3,
                    mistTime3,
                    suspendTime3
                )
                val json = gson.toJson(newDevice)
                prefs.thirdDevice = json
                connectionStateCoordinator.isThirdTimeSynch.value=true

            }
        }
    }

    fun readTimerSync4(response: String) {
        val register = getRegister(response)
        Log.e("D", "register " + register)

        when (register) {
            "0" -> {
                val subString = response.substring(6, response.length - 1)
                val time = subString.toInt()
                workingTime4 = time.toString()
                if (prefs.startWorkingTimeFRD == "") {
                    prefs.startWorkingTimeFRD = workingTime4
                }
            }
            "1" -> {
                val subString = response.substring(6, response.length - 1)
                Log.e("D", "subString " + subString)
                if (subString == "0") {
                    isOn4 = true
                } else {
                    isOn4 = false
                }
                Log.e("d", "isOn " + isOn)
            }
            "2" -> {
                val subString = response.substring(6, response.length - 1)

                if (subString == "0") {
                    isNonStop4 = true
                    isSprayingMode4 = false
                } else {
                    isNonStop4 = false
                    isSprayingMode4 = true
                }


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
                        mondayActive4 = true
                    } else {
                        mondayActive4 = false
                    }
                    if (isTuesday == '0') {
                        tuesdayActive4 = true
                    } else {
                        tuesdayActive4 = false
                    }
                    if (isWednesday == '0') {
                        wednesdayActive4 = true
                    } else {
                        wednesdayActive4 = false
                    }
                    if (isThursday == '0') {
                        thursdayActive4 = true
                    } else {
                        thursdayActive4 = false
                    }
                    if (isFriday == '0') {
                        fridayActive4 = true
                    } else {
                        fridayActive4 = false
                    }
                    if (isSaturday == '0') {
                        saturdayActive4 = true
                    } else {
                        saturdayActive4 = false
                    }
                    if (isSunday == '0') {
                        sundayActive4 = true
                    } else {
                        sundayActive4 = false
                    }
                }
            }
            "4" -> {
                val subString = response.substring(6, response.length - 1)
                Log.e("d", "SPRAY PER DAY " + subString)
                if (subString == "0") {
                    isSprayPerDay4 = true
                } else {
                    isSprayPerDay4 = false
                }
            }
            "5" -> {
                val subString = response.substring(6, response.length - 1)
                if (subString == "0") {
                    isSprayFriquencu4 = true
                } else {
                    isSprayFriquencu4 = false
                }
            }
            "6" -> {
                val timZoneId = response.get(7)
                when (timZoneId) {
                    '0' -> {
                        firstStartTime4 = response.substring(9, 13)
                        firstStopTime4 = response.substring(13, response.length - 1)
                    }
                    '1' -> {
                        secondStartTime4 = response.substring(9, 13)
                        secondStopTime4 = response.substring(13, response.length - 1)
                    }
                    '2' -> {
                        thirdStartTime4 = response.substring(9, 13)
                        thirdStopTime4 = response.substring(13, response.length - 1)
                    }
                    '3' -> {
                        fourtStartTime4 = response.substring(9, 13)
                        fourtStopTime4 = response.substring(13, response.length - 1)
                    }
                }

            }
            "7" -> {
                mistTime4 = response.substring(11, 14)
                suspendTime4 = response.substring(16, 19)
                var fullCommand = ""
                fullCommand = fullCommand + "EE07000000"
                fullCommand = fullCommand + mistTime
                fullCommand = fullCommand + "00"
                fullCommand = fullCommand + suspendTime
                fullCommand = fullCommand + "."
                intervalValue4 = fullCommand.toByteArray(charset)
                val gson = Gson()
                val newDevice = MyDevice(
                    deviceFourObj.name,
                    deviceFourObj.newName,
                    true,
                    workingTime4,
                    isOn4,
                    isNonStop4,
                    isSprayingMode4,
                    mondayActive4,
                    tuesdayActive4,
                    wednesdayActive4,
                    thursdayActive4,
                    fridayActive4,
                    saturdayActive4,
                    sundayActive4,
                    isSprayPerDay4,
                    isSprayFriquencu4,
                    firstStartTime4,
                    firstStopTime4,
                    secondStartTime4,
                    secondStopTime4,
                    thirdStartTime4,
                    thirdStopTime4,
                    fourtStartTime4,
                    fourtStopTime4,
                    mistTime4,
                    suspendTime4
                )
                val json = gson.toJson(newDevice)
                prefs.thirdDevice = json
                connectionStateCoordinator.isFourthTimeSynch.value=true

            }
        }
    }

}

