package llc.aerMist.app.ui.splash

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGatt
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.clj.fastble.BleManager
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.callback.BleNotifyCallback
import com.clj.fastble.callback.BleWriteCallback
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
import com.clj.fastble.scan.BleScanRuleConfig
import com.google.gson.Gson
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule


class SplashFragment : Fragment() {
    private val prefs: PreferenceCache by inject()
    var bluetoothController: BluetoothController? = null
    val connectionStateCoordinator = NewObservableCoordinator
    private val REQUEST_LOCATION_PERMISSION = 11
    private val locationPermission = Manifest.permission.ACCESS_FINE_LOCATION
    val REQUEST_CODE_PERMISSION_LOCATION = 5
    var locationEnabled = false
    var deviceOne = ""
    var deviceOneObj: MyDevice? = null
    var deviceTwo = ""
    var deviceTwoObj: MyDevice? = null
    var deviceThree = ""
    var deviceThreeObj: MyDevice? = null
    var deviceFour = ""
    var deviceFourObj: MyDevice? = null
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
    var firstTimerActiv = false
    var secondTimerActiv = false
    var thirdTimerActiv = false
    var fourthTimerActiv = false
    var bluetoothEnabled = false
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
    var firstTimerActiv2 = false
    var secondTimerActiv2 = false
    var thirdTimerActiv2 = false
    var fourthTimerActiv2 = false
    var dateAndTimeSynch = ""
    val firstCommand = "EE0c0."
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
    var firstTimerActiv3 = false
    var secondTimerActiv3 = false
    var thirdTimerActiv3 = false
    var fourthTimerActiv3 = false
    var dialogInterface: DialogInterface? = null
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
    var firstTimerActiv4 = false
    var secondTimerActiv4 = false
    var thirdTimerActiv4 = false
    var fourthTimerActiv4 = false
    var bleDeviceToPass: String = ""
    var counter = 0
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 2
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
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
            ?.setReConnectCount(10, 2000)
            ?.setConnectOverTime(2000)
            ?.operateTimeout = 1000
        val scanRuleConfig = BleScanRuleConfig.Builder()
            .setAutoConnect(false)
            .setScanTimeOut(10000)
            .build()
        BleManager.getInstance().initScanRule(scanRuleConfig)
        connectionStateCoordinator.bluetoothController = bluetoothController
        connectionStateCoordinator.bluetoothController?.bluetoothAdapter?.cancelDiscovery()
        bluetoothController?.bluetoothAdapter?.startDiscovery()
        bluetoothController?.bluetoothManager?.init(requireActivity().application)
        if (bluetoothController?.bluetoothManager?.isBlueEnable == false) {
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBluetoothIntent, 1)
        }
        val lm = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var gps_enabled = false
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
        } catch (ex: Exception) {
        }
        if (gps_enabled == false) {
            turnOnLocation()
        } else if (!bluetoothController?.bluetoothManager!!.isBlueEnable) {
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBluetoothIntent, 1)
        } else {
            connectionStateCoordinator.bluetoothController?.gattCallback = gattCallback
            connectDevices()
        }
        deviceOne = prefs.firstDevice
        deviceTwo = prefs.secondDevice
        deviceThree = prefs.thirdDevice
        deviceFour = prefs.fourthDevice

        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
    }

    fun turnOnLocation() {
        val permissions = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        val permissionDeniedList = ArrayList<String>()
        for (permission in permissions) {
            val permissionCheck = context?.let {
                ContextCompat.checkSelfPermission(it, permission)
            }
            if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                onPermissionGranted(permission)
            } else {
                permissionDeniedList.add(permission)
            }
        }
        if (!permissionDeniedList.isEmpty()) {
            val deniedPermissions = permissionDeniedList.toTypedArray()
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    deniedPermissions,
                    REQUEST_CODE_PERMISSION_LOCATION
                )
            }
        }
    }

    private fun onPermissionGranted(permission: String) {
        val lm = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var gps_enabled = false
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
        } catch (ex: Exception) {
        }
        if (gps_enabled == false) {
            when (permission) {
                Manifest.permission.ACCESS_FINE_LOCATION ->
                    if (Build.VERSION.SDK_INT >=
                        Build.VERSION_CODES.M
                    ) {
                        AlertDialog.Builder(requireContext())
                            .setTitle("Info")
                            .setMessage("You need to turn on your location")
                            .setNegativeButton("Cancel", { dialog, which ->
                                dialogInterface = dialog
                                dialog.cancel()
                            })

                            .setPositiveButton("Settings", { dialog, which ->
                                dialogInterface = dialog
                                dialog.cancel()
                                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                                startActivityForResult(intent, 55)
                                dialog?.dismiss()

                            })
                            .setCancelable(false)
                            .show()
                    } else {
                    }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun connectDevices() {
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
            firstBleDevice?.let { firstGate?.let { it1 -> sendTimeSynchCommand(it1, it) } }
            Handler().postDelayed({
                secondBleDevice?.let { secondGate?.let { it1 -> sendTimeSynchCommand(it1, it) } }
            }, 1000)
            Handler().postDelayed({
                thirdBleDevice?.let { thirdGate?.let { it1 -> sendTimeSynchCommand(it1, it) } }
            }, 1000)

            fourthBleDevice?.let { fourthGate?.let { it1 -> sendTimeSynchCommand(it1, it) } }
            Handler().postDelayed({
//                val allDevices =
//                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
                checkTotalNumber()
                if (counter == 0) {
                    navigateToWelcome()
                }
                if (counter == 1) {
                    navigateToDevice()
                } else if (counter > 1) {
                    navigateToHome()
                }
            }, 1000)
        }, 3000)
    }

    fun setFirstDevice() {
        deviceOne = prefs.firstDevice
        if (!deviceOne.isNullOrEmpty()) {
            val gson = Gson()
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDeviceNewName = deviceOneObj?.newName.toString()
            firstDevice = deviceOneObj?.name.toString()
        }
    }

    @SuppressLint("SetTextI18n")

    fun setSecondDevice() {
        val deviceTwo = prefs.secondDevice
        if (!deviceTwo.isNullOrEmpty()) {
            val gson = Gson()
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            secondDeviceNewName = deviceTwoObj?.newName.toString()
            secondDevice = deviceTwoObj?.name.toString()
        }
    }

    @SuppressLint("SetTextI18n")

    fun setThirdDevice() {
        val deviceThree = prefs.thirdDevice
        if (!deviceThree.isNullOrEmpty()) {
            val gson = Gson()
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            thirdDevice = deviceThreeObj?.name.toString()
            thirdDeviceNewName = deviceThreeObj?.name.toString()
        }
    }

    @SuppressLint("SetTextI18n")
    fun setFourthDevice() {
        val deviceFour = prefs.fourthDevice
        if (!deviceFour.isNullOrEmpty()) {
            val gson = Gson()
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            fourthDevice = deviceFourObj?.name.toString()
            fourthDeviceNewName = deviceFourObj?.name.toString()
        }
    }


    private fun navigateToWelcome() {
        view?.post {
            findNavController().navigate(R.id.action_splashFragment_to_welcomeFragment)
            //   findNavController().popBackStack()

        }
    }

    private fun navigateToHome() {
        view?.post {
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
            //   findNavController().popBackStack()

        }
    }

    fun connectDevice(bleDevice: BleDevice) {
        connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
            bleDevice,
            gattCallback
        )
    }

    val gattCallback = object : BleGattCallback() {
        override fun onStartConnect() {
            Log.e("D", "onStartConnect111 ")
        }

        override fun onConnectFail(bleDevice: BleDevice, exception: BleException) {
            Log.e("D", "onConnectFail111 ")
            if (bleDevice.name == deviceOneObj?.name && bleDevice.name == deviceTwoObj?.name && bleDevice.name == deviceThreeObj?.name && bleDevice.name == deviceFourObj?.name) {
                if (connectionStateCoordinator.bluetoothController?.bluetoothManager!!.isConnected(
                        bleDevice
                    ) == false
                ) {
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                        bleDevice,
                        this
                    )
                }
            }
        }

        override fun onConnectSuccess(bleDevicee: BleDevice, gatt: BluetoothGatt, status: Int) {
            connectionStateCoordinator.bluetoothConnectionState.value = bleDevicee
            if (bleDevicee.name == firstDevice) {
                firstBleDevice = bleDevicee
                connectionStateCoordinator.firstDevice=firstBleDevice
                if (bleDevicee != null) {
                    bleDeviceToPass = bleDevicee.name
                }
                firstGate = gatt
                readResponse()
            }
            if (bleDevicee.name == secondDevice) {

                if (bleDevicee != null) {
                    bleDeviceToPass = bleDevicee.name
                }
                secondBleDevice = bleDevicee
                connectionStateCoordinator.secondDevice=secondBleDevice
                secondGate = gatt
                readSecondResponse()
            }
            if (bleDevicee.name == thirdDevice) {
                if (bleDevicee != null) {
                    bleDeviceToPass = bleDevicee.name
                }
                thirdBleDevice = bleDevicee
                connectionStateCoordinator.thirdDevice=thirdBleDevice

                thirdGate = gatt
                readThirdResponse()
            }
            if (bleDevicee.name == fourthDevice) {
                if (bleDevicee != null) {
                    bleDeviceToPass = bleDevicee.name
                }
                fourthBleDevice = bleDevicee
                connectionStateCoordinator.fourthDevice=fourthBleDevice
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
            if (deviceOneObj?.name == bleDevice.name || deviceTwoObj?.name == bleDevice.name || deviceThreeObj?.name == bleDevice.name || deviceFourObj?.name == bleDevice.name) {
                if (prefs.isDeleted == false) {
                    connectionStateCoordinator.bleDisconnectDevices.value = bleDevice
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                        bleDevice,
                        this
                    )
                }
                prefs.clearDelete()
            }
        }
    }

    fun navigateToDevice() {
        prefs.isOneDevice = true
        view?.post {
            findNavController().navigate(
                SplashFragmentDirections.actionSplashFragmentToDeviceFragment(
                    bleDeviceToPass
                )
            )
        }
    }

    fun readResponse() {
        for (service in firstGate?.services!!) {
            if (service.characteristics.size > 0) {
                for (service in service.characteristics) {
                    if (service.uuid.toString().equals("0000ffe1-0000-1000-8000-00805f9b34fb")) {
                        bluetoothController?.blueGattAdapter?.addResult(service.service)
                    }
                }
            }
        }
        bluetoothController?.bleDeviceMain = firstBleDevice
        connectionStateCoordinator.firstGatt = firstGate
        connectionStateCoordinator.firstDevice = firstBleDevice

        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            var size= bluetoothController?.blueGattAdapter!!.getCount()
            for(item in 0..size)
            {
                Log.e("D","SERVICES SPLASH "+bluetoothController?.blueGattAdapter?.getItem(0) )
            }
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            service?.characteristics?.let {
                bluetoothController?.readNotification(
                    firstBleDevice,
                    it.get(0)
                )
            }
        }
    }

    fun readSecondResponse() {
        for (service in secondGate?.services!!) {
            if (service.characteristics.size > 0) {

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController?.blueGattAdapter?.addResult(service)
                }
            }
        }
        bluetoothController?.bleDeviceMain = secondBleDevice
        connectionStateCoordinator.secondGatt = secondGate
        connectionStateCoordinator.secondDevice = secondBleDevice

        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            service?.characteristics?.let {
                bluetoothController?.readNotification2(
                    secondBleDevice,
                    it.get(0)
                )
            }
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

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController?.blueGattAdapter?.addResult(service)
                }
            }
        }
        bluetoothController?.bleDeviceMain = thirdBleDevice
        connectionStateCoordinator.thirdGatt = thirdGate
        connectionStateCoordinator.thirdDevice = thirdBleDevice

        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            service?.characteristics?.let {
                bluetoothController?.readNotification3(
                    thirdBleDevice,
                    it.get(0)
                )
            }
        }
    }

    fun readFourthResponse() {
        for (service in fourthGate?.services!!) {
            if (service.characteristics.size > 0) {

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController?.blueGattAdapter?.addResult(service)
                }
            }
        }
        bluetoothController?.bleDeviceMain = fourthBleDevice
        connectionStateCoordinator.fourthGatt = fourthGate
        connectionStateCoordinator.fourthDevice = fourthBleDevice

        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            service?.characteristics?.let {
                bluetoothController?.readNotification4(
                    fourthBleDevice,
                    it.get(0)
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


        Handler().postDelayed({
            gatt?.let {
                bleDevice?.let { it1 ->
                    sendCommand(
                        dateAndTimeSynch.toByteArray(
                            charset
                        ), it1, it
                    )
                }
            }
        }, 1000)

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
            connectionStateCoordinator.bluetoothByteArray.value = newDataChar
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

        var pos = ""
        if (response.length > 4) {
            pos = response.get(5).toString()
        }
        return pos

    }

    fun readTimerSync(response: String) {
        val register = getRegister(response)

        when (register) {

            "0" -> {
                val subString = response.substring(6, response.length - 1)
                val time = subString.toInt()
                workingTime = time.toString()
                if (prefs.startWorkingTimeFD.isNullOrEmpty()) {
                    prefs.startWorkingTimeFD = workingTime
                }
            }
            "1" -> {
                val subString = response.substring(6, response.length - 1)
                if (subString == "0") {
                    isOn = true
                } else {
                    isOn = false
                }
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

                when (timZoneId) {
                    '0' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                firstTimerActiv = true
                            } else {
                                firstTimerActiv = false
                            }
                        }
                        firstStartTime = response.substring(9, 13)
                        firstStopTime = response.substring(13, response.length - 1)

                    }
                    '1' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                secondTimerActiv = true
                            } else {
                                secondTimerActiv = false
                            }
                        }
                        secondStartTime = response.substring(9, 13)
                        secondStopTime = response.substring(13, response.length - 1)
                    }
                    '2' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                thirdTimerActiv = true
                            } else {
                                thirdTimerActiv = false
                            }
                        }
                        thirdStartTime = response.substring(9, 13)
                        thirdStopTime = response.substring(13, response.length - 1)
                    }
                    '3' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                fourthTimerActiv = true
                            } else {
                                fourthTimerActiv = false
                            }
                        }
                        fourtStartTime = response.substring(9, 13)
                        fourtStopTime = response.substring(13, response.length - 1)
                    }
                }

            }
            "7" -> {
                mistTime = response.substring(11, 14)
                suspendTime = response.substring(16, 19)

                val gson = Gson()

                val deviceOnex = prefs.firstDevice
                if (!deviceOnex.isNullOrEmpty()) {
                    deviceOneObj = gson.fromJson(deviceOnex, MyDevice::class.java)
                    val newDevice = MyDevice(
                        deviceOneObj?.name.toString(),
                        deviceOneObj?.newName.toString(),
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
                        firstTimerActiv,
                        secondStartTime,
                        secondStopTime,
                        secondTimerActiv,
                        thirdStartTime,
                        thirdStopTime,
                        thirdTimerActiv,
                        fourtStartTime,
                        fourtStopTime,
                        fourthTimerActiv,
                        mistTime,
                        suspendTime
                    )
                    val json = gson.toJson(newDevice)
                    prefs.firstDevice = json
                    connectionStateCoordinator.isFirstTimeSynch.value = true
                }
            }
        }
    }

    fun readTimerSync2(response: String) {
        val register = getRegister(response)


        when (register) {
            "0" -> {
                val subString = response.substring(6, response.length - 1)
                val time = subString.toInt()
                workingTime2 = time.toString()
                if (prefs.startWorkingTimeSD.isNullOrEmpty()) {
                    prefs.startWorkingTimeSD = workingTime2
                }
            }
            "1" -> {
                val subString = response.substring(6, response.length - 1)
                if (subString == "0") {
                    isOn2 = true
                } else {
                    isOn2 = false
                }
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
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                firstTimerActiv2 = true
                            } else {
                                firstTimerActiv2 = false
                            }
                        }
                        firstStartTime2 = response.substring(9, 13)
                        firstStopTime2 = response.substring(13, response.length - 1)
                    }
                    '1' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                secondTimerActiv2 = true
                            } else {
                                secondTimerActiv2 = false
                            }
                        }
                        secondStartTime2 = response.substring(9, 13)
                        secondStopTime2 = response.substring(13, response.length - 1)
                    }
                    '2' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                thirdTimerActiv2 = true
                            } else {
                                thirdTimerActiv2 = false
                            }
                        }
                        thirdStartTime2 = response.substring(9, 13)
                        thirdStopTime2 = response.substring(13, response.length - 1)
                    }
                    '3' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                fourthTimerActiv2 = true
                            } else {
                                fourthTimerActiv2 = false
                            }
                        }
                        fourtStartTime2 = response.substring(9, 13)
                        fourtStopTime2 = response.substring(13, response.length - 1)
                    }
                }

            }
            "7" -> {
                mistTime2 = response.substring(11, 14)
                suspendTime2 = response.substring(16, 19)

                val deviceTwox = prefs.secondDevice
                if (!deviceTwox.isNullOrEmpty()) {
                    val gson = Gson()
                    deviceTwoObj = gson.fromJson(deviceTwox, MyDevice::class.java)
                    val newDevice = MyDevice(
                        deviceTwoObj?.name.toString(),
                        deviceTwoObj?.newName.toString(),
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
                        firstTimerActiv2,
                        secondStartTime2,
                        secondStopTime2,
                        secondTimerActiv2,
                        thirdStartTime2,
                        thirdStopTime2,
                        thirdTimerActiv2,
                        fourtStartTime2,
                        fourtStopTime2,
                        fourthTimerActiv2,
                        mistTime2,
                        suspendTime2
                    )
                    val json = gson.toJson(newDevice)
                    prefs.secondDevice = json
                    connectionStateCoordinator.isSecondTimeSynch.value = true

                }
            }
        }
    }


    fun readTimerSync3(response: String) {
        val register = getRegister(response)
        when (register) {
            "0" -> {
                val subString = response.substring(6, response.length - 1)
                val time = subString.toInt()
                workingTime3 = time.toString()
                if (prefs.startWorkingTimeTD.isNullOrEmpty()) {
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
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                firstTimerActiv3 = true
                            } else {
                                firstTimerActiv3 = false
                            }
                        }
                        firstStartTime3 = response.substring(9, 13)
                        firstStopTime3 = response.substring(13, 17)
                    }
                    '1' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                secondTimerActiv3 = true
                            } else {
                                secondTimerActiv3 = false
                            }
                        }
                        secondStartTime3 = response.substring(9, 13)
                        secondStopTime3 = response.substring(13, 17)
                    }
                    '2' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                thirdTimerActiv3 = true
                            } else {
                                thirdTimerActiv3 = false
                            }
                        }
                        thirdStartTime3 = response.substring(9, 13)
                        thirdStopTime3 = response.substring(13, 17)
                    }
                    '3' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                fourthTimerActiv3 = true
                            } else {
                                fourthTimerActiv3 = false
                            }
                        }
                        fourtStartTime3 = response.substring(9, 13)
                        fourtStopTime3 = response.substring(13, 17)
                    }
                }

            }
            "7" -> {
                mistTime3 = response.substring(11, 14)
                suspendTime3 = response.substring(16, 19)

                val gson = Gson()
                val deviceThreex = prefs.thirdDevice
                if (!deviceThreex.isNullOrEmpty()) {
                    deviceThreeObj = gson.fromJson(deviceThreex, MyDevice::class.java)
                    val newDevice = MyDevice(
                        deviceThreeObj?.name.toString(),
                        deviceThreeObj?.newName.toString(),
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
                        firstTimerActiv3,
                        secondStartTime3,
                        secondStopTime3,
                        secondTimerActiv3,
                        thirdStartTime3,
                        thirdStopTime3,
                        thirdTimerActiv3,
                        fourtStartTime3,
                        fourtStopTime3,
                        fourthTimerActiv3,
                        mistTime3,
                        suspendTime3
                    )
                    val json = gson.toJson(newDevice)
                    prefs.thirdDevice = json
                    connectionStateCoordinator.isThirdTimeSynch.value = true
                }
            }
        }
    }

    fun readTimerSync4(response: String) {
        val register = getRegister(response)

        when (register) {
            "0" -> {
                val subString = response.substring(6, response.length - 1)
                val time = subString.toInt()
                workingTime4 = time.toString()
                if (prefs.startWorkingTimeFRD.isNullOrEmpty()) {
                    prefs.startWorkingTimeFRD = workingTime4
                }
            }
            "1" -> {
                val subString = response.substring(6, response.length - 1)
                if (subString == "0") {
                    isOn4 = true
                } else {
                    isOn4 = false
                }
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
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                firstTimerActiv4 = true
                            } else {
                                firstTimerActiv4 = false
                            }
                        }
                        firstStartTime4 = response.substring(9, 13)
                        firstStopTime4 = response.substring(13, response.length - 1)
                    }
                    '1' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                secondTimerActiv4 = true
                            } else {
                                secondTimerActiv4 = false
                            }
                        }
                        secondStartTime4 = response.substring(9, 13)
                        secondStopTime4 = response.substring(13, response.length - 1)
                    }
                    '2' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                thirdTimerActiv4 = true
                            } else {
                                thirdTimerActiv4 = false
                            }
                        }
                        thirdStartTime4 = response.substring(9, 13)
                        thirdStopTime4 = response.substring(13, response.length - 1)
                    }
                    '3' -> {
                        if (response.length > 7) {
                            val value = response.get(8)
                            if (value == '0') {
                                fourthTimerActiv4 = true
                            } else {
                                fourthTimerActiv4 = false
                            }
                        }
                        fourtStartTime4 = response.substring(9, 13)
                        fourtStopTime4 = response.substring(13, response.length - 1)
                    }
                }

            }
            "7" -> {
                mistTime4 = response.substring(11, 14)
                suspendTime4 = response.substring(16, 19)

                val gson = Gson()
                val deviceFourx = prefs.fourthDevice
                if (!deviceFourx.isNullOrEmpty()) {
                    deviceFourObj = gson.fromJson(deviceFourx, MyDevice::class.java)
                    val newDevice = MyDevice(
                        deviceFourObj?.name.toString(),
                        deviceFourObj?.newName.toString(),
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
                        firstTimerActiv4,
                        secondStartTime4,
                        secondStopTime4,
                        secondTimerActiv4,
                        thirdStartTime4,
                        thirdStopTime4,
                        thirdTimerActiv4,
                        fourtStartTime4,
                        fourtStopTime4,
                        fourthTimerActiv4,
                        mistTime4,
                        suspendTime4
                    )
                    val json = gson.toJson(newDevice)
                    prefs.fourthDevice = json
                    connectionStateCoordinator.isFourthTimeSynch.value = true
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val lm = requireContext().getSystemService(Context.LOCATION_SERVICE) as LocationManager
        var gps_enabled = false
        try {
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER)
        } catch (ex: Exception) {
        }
        if (requestCode == 55) {
            if (!gps_enabled) {
                turnOnLocation()
            }
        }
        if (requestCode == 1) {
            if (bluetoothController?.bluetoothAdapter?.isEnabled == true) {
                Log.e("D", "Bluetooth has been enabled")
                bluetoothEnabled = true
                if (bluetoothEnabled && gps_enabled) {
                    connectDevices()
                } else {
//                    if (!gps_enabled) {
//                        turnOnLocation()
//                    }
                }
            } else {
                Log.e("D", "Bluetooth has been disabled")
                bluetoothEnabled = false
                val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(enableBluetoothIntent, 1)
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Log.e("D", "Bluetooth enabling has been canceled")
            bluetoothEnabled = false
            if (bluetoothController?.bluetoothAdapter?.isEnabled == true) {
                Log.e("D", "Bluetooth has been enabled")
                bluetoothEnabled = true
                if (bluetoothEnabled && gps_enabled) {
                    connectDevices()
                } else {
                    if (!gps_enabled) {
                        turnOnLocation()
                    }
                }
            } else {
                bluetoothEnabled = false
                val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
                startActivityForResult(enableBluetoothIntent, 1)
            }
        }
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
    }

    override fun onDestroy() {
        super.onDestroy()
        deviceOneObj=null
        deviceTwoObj=null
        deviceThreeObj=null
        deviceFourObj=null
    }
}


