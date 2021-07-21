package llc.aerMist.app.ui.my_devices

import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGatt
import android.content.Intent
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
import com.clj.fastble.callback.BleScanCallback
import com.clj.fastble.callback.BleWriteCallback
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_devices.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_set_device.*
import kotlinx.android.synthetic.main.my_devices_fragment.*
import kotlinx.android.synthetic.main.my_devices_fragment.btnAddNewDevice
import kotlinx.android.synthetic.main.my_devices_fragment.deviceNumber
import kotlinx.android.synthetic.main.my_devices_fragment.firstCardView
import kotlinx.android.synthetic.main.my_devices_fragment.firstDeviceName
import kotlinx.android.synthetic.main.my_devices_fragment.firstDeviceState
import kotlinx.android.synthetic.main.my_devices_fragment.firstDotColor
import kotlinx.android.synthetic.main.my_devices_fragment.firstInfoDots
import kotlinx.android.synthetic.main.my_devices_fragment.firstPopup
import kotlinx.android.synthetic.main.my_devices_fragment.fourthCardView
import kotlinx.android.synthetic.main.my_devices_fragment.fourthDeviceName
import kotlinx.android.synthetic.main.my_devices_fragment.fourthDeviceState
import kotlinx.android.synthetic.main.my_devices_fragment.fourthDotColor
import kotlinx.android.synthetic.main.my_devices_fragment.fourthInfoDots
import kotlinx.android.synthetic.main.my_devices_fragment.fourthPopup
import kotlinx.android.synthetic.main.my_devices_fragment.mainLayout
import kotlinx.android.synthetic.main.my_devices_fragment.removeFirstDevice
import kotlinx.android.synthetic.main.my_devices_fragment.removeFourthDevice
import kotlinx.android.synthetic.main.my_devices_fragment.removeSecondDevice
import kotlinx.android.synthetic.main.my_devices_fragment.removeThirdDevice
import kotlinx.android.synthetic.main.my_devices_fragment.renameFirstDevice
import kotlinx.android.synthetic.main.my_devices_fragment.renameFourthDevice
import kotlinx.android.synthetic.main.my_devices_fragment.renameSecondDevice
import kotlinx.android.synthetic.main.my_devices_fragment.renameThirdDevice
import kotlinx.android.synthetic.main.my_devices_fragment.resetFirstFilter
import kotlinx.android.synthetic.main.my_devices_fragment.resetFourthFilter
import kotlinx.android.synthetic.main.my_devices_fragment.resetSecondFilter
import kotlinx.android.synthetic.main.my_devices_fragment.resetThirdFilter
import kotlinx.android.synthetic.main.my_devices_fragment.secondCardView
import kotlinx.android.synthetic.main.my_devices_fragment.secondDeviceName
import kotlinx.android.synthetic.main.my_devices_fragment.secondDeviceState
import kotlinx.android.synthetic.main.my_devices_fragment.secondDotColor
import kotlinx.android.synthetic.main.my_devices_fragment.secondInfoDots
import kotlinx.android.synthetic.main.my_devices_fragment.secondPopup
import kotlinx.android.synthetic.main.my_devices_fragment.thirdCardView
import kotlinx.android.synthetic.main.my_devices_fragment.thirdDeviceName
import kotlinx.android.synthetic.main.my_devices_fragment.thirdDeviceState
import kotlinx.android.synthetic.main.my_devices_fragment.thirdDotColor
import kotlinx.android.synthetic.main.my_devices_fragment.thirdInfoDots
import kotlinx.android.synthetic.main.my_devices_fragment.thirdPopup
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.RemoveDevicePopup
import llc.aerMist.app.ui.popup.RenameDevicePopup
import org.koin.android.ext.android.inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList


class MyDevicesFragment : Fragment(), View.OnClickListener {

    private val prefs: PreferenceCache by inject()
    var bluetoothController: BluetoothController? = null
    val connectionStateCoordinator = NewObservableCoordinator
    lateinit var availableDevicesList: List<BleDevice>
    var list: List<BleDevice> = ArrayList()
    var deviceTotalNumber = 0;
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
    val firstCommand = "EE0c0."

    private lateinit var renameDeviceDialog: RenameDevicePopup
    private lateinit var removeDevicePopup: RemoveDevicePopup
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
    val charset = Charsets.UTF_8
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
    var nameToSend = ""
    var deviceOne = ""
    lateinit var deviceOneObj: MyDevice
    var deviceTwo = ""
    lateinit var deviceTwoObj: MyDevice
    var deviceThree = ""
    lateinit var deviceThreeObj: MyDevice
    var deviceFour = ""
    lateinit var deviceFourObj: MyDevice
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_devices_fragment, container, false)
    }


    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initBleConroller()

        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
        checkConnection()
        setOnClickListener()
        deviceOne = prefs.firstDevice
        deviceTwo = prefs.secondDevice
        deviceThree = prefs.thirdDevice
        deviceFour = prefs.fourthDevice

        if (!deviceOne.isNullOrEmpty()) {
            val gson = Gson()
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            nameToSend = deviceOneObj.name
        }
        if (!deviceTwo.isNullOrEmpty()) {
            val gson = Gson()
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            nameToSend = deviceTwoObj.name
        }
        if (!deviceThree.isNullOrEmpty()) {
            val gson = Gson()
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            nameToSend = deviceThreeObj.name
        }
        if (!deviceFour.isNullOrEmpty()) {
            val gson = Gson()
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            nameToSend = deviceFourObj.name
        }
    }

    fun checkConnection() {
        val deviceNumber =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size
        if (deviceNumber!! > 0) {
            var bleList = ArrayList<BleDevice>()
            bleList =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            for (item in bleList) {
                when (item.name) {
                    firstDevice -> {
                        firstDotColor?.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.green_dot
                            )
                        )
                        firstDeviceState?.text = getString(R.string.online)
                        firstProgressBar?.visibility = View.GONE
                        firstInfoDots?.visibility = View.VISIBLE
                    }
                    secondDevice -> {
                        secondDotColor?.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.green_dot
                            )
                        )
                        secondDeviceState?.text = getString(R.string.online)
                        secondProgressBar?.visibility = View.GONE
                        secondInfoDots?.visibility = View.VISIBLE
                    }
                    thirdDevice -> {
                        thirdDotColor?.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.green_dot
                            )
                        )
                        thirdDeviceState?.text = getString(R.string.online)
                        thirdProgressBar?.visibility = View.GONE
                        thirdInfoDots?.visibility = View.VISIBLE
                    }
                    fourthDevice -> {
                        fourthDotColor?.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.green_dot
                            )
                        )
                        fourthDeviceState?.text = getString(R.string.online)
                        fourthProgressBar?.visibility = View.GONE
                        fourthInfoDots?.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun initBleConroller() {
        bluetoothController =
            BluetoothController(
                notifyCallback,
                notifyCallback2,
                notifyCallback3,
                notifyCallback4,
                gattCallback,
                scanCallback,
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
        connectionStateCoordinator.listBleDevices.clear()
        //    bluetoothController?.startScan()
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

        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            bluetoothController?.readNotification(
                firstBleDevice,
                service?.characteristics!!.get(0)
            )
            Handler().postDelayed({
                firstBleDevice?.let { sendTimeSynchCommand(firstGate!!, it) }
            }, 1000)
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

        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            bluetoothController?.readNotification2(
                secondBleDevice,
                service?.characteristics!!.get(0)
            )
            Handler().postDelayed({
                secondBleDevice?.let { sendTimeSynchCommand(secondGate!!, it) }
            }, 1000)
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

        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            bluetoothController?.readNotification3(
                thirdBleDevice,
                service?.characteristics!!.get(0)
            )
            Handler().postDelayed({
                thirdBleDevice?.let { sendTimeSynchCommand(thirdGate!!, it) }
            }, 1000)
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

        if (bluetoothController?.blueGattAdapter?.getCount()!! > 0) {
            val service = bluetoothController?.blueGattAdapter?.getItem(0)
            bluetoothController?.readNotification4(
                fourthBleDevice,
                service?.characteristics!!.get(0)
            )
            Handler().postDelayed({
                fourthBleDevice?.let { sendTimeSynchCommand(fourthGate!!, it) }
            }, 1000)

        }
    }

    private fun navigateToAvailableDevices() {

        if (bluetoothController?.bluetoothManager!!.isBlueEnable) {
            try {
                connectionStateCoordinator?.bluetoothController?.bluetoothManager?.cancelScan()
            } catch (e: Exception) {
            }
            findNavController().navigate(R.id.action_my_devices_to_search_devices)
        } else {
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBluetoothIntent, 4)
        }
    }

    private fun navigateToMain() {

        findNavController().navigate(R.id.action_my_devices_to_main_fragment)
    }

    fun navigateToDevice() {
        prefs.isOneDevice = true
        val action = MyDevicesFragmentDirections.actionMyDevicesToDevice(nameToSend)
        findNavController().navigate(action)
    }

    fun setFirstDevice() {
        deviceOne = prefs.firstDevice
        if (!deviceOne.isNullOrEmpty()) {
            firstCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDeviceName.text = deviceOneObj.newName
            firstDeviceNewName = deviceOneObj.newName
            firstDevice = deviceOneObj.name
            deviceTotalNumber = deviceTotalNumber + 1
            firstDeviceId.text = resources.getString(R.string.device_id) + deviceOneObj.name
        } else {
            firstCardView.visibility = View.GONE
        }
        deviceNumber.text = "$deviceTotalNumber/4 devices"
    }


    fun setSecondDevice() {
        val deviceTwo = prefs.secondDevice
        if (!deviceTwo.isNullOrEmpty()) {
            secondCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            secondDeviceName.text = deviceTwoObj.newName
            secondDeviceNewName = deviceTwoObj.newName
            secondDevice = deviceTwoObj.name
            deviceTotalNumber = deviceTotalNumber + 1
            secondDeviceId.text = resources.getString(R.string.device_id) + deviceTwoObj.name

        } else {
            secondCardView.visibility = View.GONE
        }
        deviceNumber.text = "$deviceTotalNumber/4 devices"
    }

    @SuppressLint("SetTextI18n")

    fun setThirdDevice() {
        val deviceThree = prefs.thirdDevice
        if (!deviceThree.isNullOrEmpty()) {
            thirdCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            thirdDeviceName.text = deviceThreeObj.newName
            thirdDevice = deviceThreeObj.name
            thirdDeviceNewName = deviceThreeObj.name
            deviceTotalNumber = deviceTotalNumber + 1
            thirdDeviceId.text = resources.getString(R.string.device_id) + deviceThreeObj.name

        } else {
            thirdCardView.visibility = View.GONE
        }
        deviceNumber.text = "$deviceTotalNumber/4 devices"

    }

    @SuppressLint("SetTextI18n")
    fun setFourthDevice() {
        val deviceFour = prefs.fourthDevice
        if (!deviceFour.isNullOrEmpty()) {
            fourthCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            fourthDeviceName.text = deviceFourObj.newName
            fourthDevice = deviceFourObj.name
            fourthDeviceNewName = deviceFourObj.name
            deviceTotalNumber = deviceTotalNumber + 1
            fourthDeviceId.text = resources.getString(R.string.device_id) + deviceFourObj.name

        } else {
            fourthCardView.visibility = View.GONE
        }
        deviceNumber.text = "$deviceTotalNumber/4 devices"
    }

    private val scanCallback = object : BleScanCallback() {
        override fun onScanStarted(success: Boolean) {
        }

        override fun onScanning(bleDevice: BleDevice) {

        }

        override fun onScanFinished(scanResultList: List<BleDevice>) {
            availableDevicesList = scanResultList
            list = scanResultList
        }
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
            if (bleDevicee.name == firstDevice) {
                firstDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.green_dot
                    )
                )
                firstDeviceState?.text = getString(R.string.online)
                firstProgressBar?.visibility = View.GONE
                firstInfoDots?.visibility = View.VISIBLE
                firstBleDevice = bleDevicee
                firstGate = gatt
                readResponse()

            }
            if (bleDevicee.name == secondDevice) {
                secondDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.green_dot
                    )
                )
                secondDeviceState?.text = getString(R.string.online)
                secondProgressBar?.visibility = View.GONE
                secondInfoDots?.visibility = View.VISIBLE
                secondBleDevice = bleDevicee
                secondGate = gatt
                readSecondResponse()

            }
            if (bleDevicee.name == thirdDevice) {
                thirdDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.green_dot
                    )
                )
                thirdDeviceState?.text = getString(R.string.online)
                thirdProgressBar?.visibility = View.GONE
                thirdInfoDots?.visibility = View.VISIBLE
                thirdBleDevice = bleDevicee
                thirdGate = gatt
                readThirdResponse()

            }
            if (bleDevicee.name == fourthDevice) {
                fourthDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.green_dot
                    )
                )
                fourthDeviceState?.text = getString(R.string.online)
                fourthProgressBar?.visibility = View.GONE
                fourthInfoDots?.visibility = View.VISIBLE
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
            Log.e("D", "device disocnnected " + bleDevice.device.name)
            connectionStateCoordinator.bleDisconnectDevices.value = bleDevice
            connectionStateCoordinator.isDeviceConnected = false
            if (bleDevice.name == firstDevice) {
                firstDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
                firstDeviceState?.text = "Ofline"
                firstProgressBar?.visibility = View.GONE
                firstInfoDots?.visibility = View.VISIBLE
            }
            if (bleDevice.name == secondDevice) {
                secondDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
                secondDeviceState?.text = "Ofline"
                secondProgressBar?.visibility = View.GONE
                secondInfoDots?.visibility = View.VISIBLE
            }
        }
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

    fun sendCommand(input: ByteArray, bleDevice: BleDevice, gatt: BluetoothGatt) {
        val pos = gatt.services.size - 1
        connectionStateCoordinator.bluetoothController?.writeCommand(
            bleDevice,
            input,
            gatt.services.get(pos).characteristics.get(0)
        )
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

    private val writeCallback = object : BleWriteCallback() {
        override fun onWriteSuccess(current: Int, total: Int, justWrite: ByteArray?) {
        }

        override fun onWriteFailure(exception: BleException?) {
        }

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
        var pos = response.get(5)
        return pos.toString()
    }

    fun readTimerSync(response: String) {
        val register = getRegister(response)
        when (register) {

            "0" -> {
                val subString = response.substring(6, response.length - 1)
                val time = subString.toInt()
                workingTime = time.toString()
                if (prefs.startWorkingTimeFD == "") {
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
                val json = gson.toJson(newDevice)
                prefs.firstDevice = json
                connectionStateCoordinator.isFirstTimeSynch.value = true
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
                if (prefs.startWorkingTimeSD == "") {
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
                connectionStateCoordinator.isSecondTimeSynch.value = true

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
                connectionStateCoordinator.isThirdTimeSynch.value = true

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
                if (prefs.startWorkingTimeFRD == "") {
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
                connectionStateCoordinator.isFourthTimeSynch.value = true

            }
        }
    }

    fun setOnClickListener() {
        mainLayout.setOnClickListener(this)
        firstInfoDots.setOnClickListener(this)
        firstPopup.setOnClickListener(this)
        secondInfoDots.setOnClickListener(this)
        secondPopup.setOnClickListener(this)
        thirdInfoDots.setOnClickListener(this)
        thirdPopup.setOnClickListener(this)
        fourthInfoDots.setOnClickListener(this)
        fourthPopup.setOnClickListener(this)
        btnAddNewDevice.setOnClickListener(this)
        btnDone.setOnClickListener(this)
        resetFirstFilter.setOnClickListener(this)
        renameFirstDevice.setOnClickListener(this)
        removeFirstDevice.setOnClickListener(this)
        renameSecondDevice.setOnClickListener(this)
        removeSecondDevice.setOnClickListener(this)
        resetSecondFilter.setOnClickListener(this)
        renameThirdDevice.setOnClickListener(this)
        removeThirdDevice.setOnClickListener(this)
        resetThirdFilter.setOnClickListener(this)
        renameFourthDevice.setOnClickListener(this)
        removeFourthDevice.setOnClickListener(this)
        resetFourthFilter.setOnClickListener(this)
    }

    override fun onClick(id: View?) {
        when (id) {
            btnAddNewDevice -> navigateToAvailableDevices()
            btnDone -> {
                if(deviceTotalNumber==0)
                {
                    Snackbar.make(
                        requireView(),
                        "Please add one or more devices",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
                else{
                if (deviceTotalNumber == 1) {
                    navigateToDevice()
                } else {
                    navigateToMain()
                }
                }
            }
            firstInfoDots -> firstPopup.visibility = View.VISIBLE
            secondInfoDots -> secondPopup.visibility = View.VISIBLE
            thirdInfoDots -> thirdPopup.visibility = View.VISIBLE
            fourthInfoDots -> fourthPopup.visibility = View.VISIBLE
            mainLayout -> {
                firstPopup.visibility = View.GONE
                secondPopup.visibility = View.GONE
                thirdPopup.visibility = View.GONE
                fourthPopup.visibility = View.GONE
            }
            renameFirstDevice -> {
                showRenameDialog(0, firstDeviceNewName)
            }
            renameSecondDevice -> {
                showRenameDialog(1, secondDeviceNewName)
            }
            renameThirdDevice -> {
                showRenameDialog(2, thirdDeviceNewName)
            }
            renameFourthDevice -> {
                showRenameDialog(3, fourthDeviceNewName)
            }
            removeFirstDevice -> {
                showRemoveDialog(0, firstDeviceNewName)
            }
            removeSecondDevice -> {
                showRemoveDialog(1, secondDeviceNewName)
            }
            removeThirdDevice -> {
                showRemoveDialog(2, thirdDeviceNewName)
            }
            removeFourthDevice -> {
                showRemoveDialog(3, fourthDeviceNewName)
            }
        }
    }

    fun showRenameDialog(positon: Int, name: String) {
        renameDeviceDialog = RenameDevicePopup(positon, name)
        renameDeviceDialog.isCancelable = false
        renameDeviceDialog.show(childFragmentManager, "")
    }

    fun showRemoveDialog(positon: Int, name: String) {
        removeDevicePopup = RemoveDevicePopup(positon, name, false)
        removeDevicePopup.isCancelable = false
        removeDevicePopup.show(childFragmentManager, "")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val data = data?.extras

                    val name = data?.getString("name")
                    val isDeleted = data?.getBoolean("isDeleted", false)
                    val position = data?.getInt("position", 0)
                    when (position) {
                        0 -> {
                            firstDeviceName.text = name
                            firstDeviceNewName = name.toString()
                            firstPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                firstCardView.visibility = View.GONE
                                deviceTotalNumber = deviceTotalNumber - 1
                                deviceNumber.text = "$deviceTotalNumber/4 devices"

                            }
                        }
                        1 -> {
                            secondDeviceName.text = name
                            secondDeviceNewName = name.toString()
                            secondPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                secondCardView.visibility = View.GONE
                                deviceTotalNumber = deviceTotalNumber - 1
                                deviceNumber.text = "$deviceTotalNumber/4 devices"
                            }
                        }
                        2 -> {
                            thirdDeviceName.text = name
                            thirdDeviceNewName = name.toString()
                            thirdPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                thirdCardView.visibility = View.GONE
                                deviceTotalNumber = deviceTotalNumber - 1
                                deviceNumber.text = "$deviceTotalNumber/4 devices"
                            }
                        }
                        3 -> {
                            fourthDeviceName.text = name
                            fourthDeviceNewName = name.toString()
                            fourthPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                fourthCardView.visibility = View.GONE
                                deviceTotalNumber = deviceTotalNumber - 1
                                deviceNumber.text = "$deviceTotalNumber/4 devices"
                            }
                        }

                        4 -> {
                            if (resultCode == Activity.RESULT_OK) {
                                if (bluetoothController?.bluetoothAdapter!!.isEnabled) {
                                    connectionStateCoordinator.listBleDevices.clear()
                                    bluetoothController?.startScan()
                                } else {
                                }
                            } else if (resultCode == Activity.RESULT_CANCELED) {
                            }
                        }
                    }
                }
            }
        }
    }
}
