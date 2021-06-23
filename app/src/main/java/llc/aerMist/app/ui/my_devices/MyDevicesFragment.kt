package llc.aerMist.app.ui.my_devices

import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothGatt
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.callback.BleNotifyCallback
import com.clj.fastble.callback.BleScanCallback
import com.clj.fastble.callback.BleWriteCallback
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.my_devices_fragment.*
import kotlinx.android.synthetic.main.my_devices_fragment.deviceNumber
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.RenameDevicePopup
import org.koin.android.ext.android.inject
import java.util.*
import kotlin.collections.ArrayList


class MyDevicesFragment : Fragment(), View.OnClickListener {

    private val prefs: PreferenceCache by inject()
    lateinit var bluetoothController: BluetoothController
    val connectionStateCoordinator = NewObservableCoordinator
    lateinit var availableDevicesList: List<BleDevice>
    var list: List<BleDevice> = ArrayList()
    var deviceTotalNumber = 0;
    lateinit var firstDevice: String
     var firstBleDevice: BleDevice?=null
     var firstGate: BluetoothGatt?=null
    var secondDevice: String = ""
    var thirdDevice: String = ""
    var fourthDevice: String = ""
     var secondBleDevice: BleDevice?=null
     var secondGate: BluetoothGatt?=null
     var thirdBleDevice: BleDevice?=null
     var thirdGate: BluetoothGatt?=null
     var fourthBleDevice: BleDevice?=null
     var fourthGate: BluetoothGatt?=null
    private lateinit var renameDeviceDialog: RenameDevicePopup

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_devices_fragment, container, false)
    }


    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
        initBleConroller()
        checkConnection()
        setOnClickListener()
    }

    fun checkConnection() {
        val deviceNumber =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size
        Log.e("D", "device number " + deviceNumber)
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
                }
            }
        }
    }

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
        bluetoothController.bluetoothManager
            .enableLog(true)
            .setReConnectCount(2, 1000)
            .setConnectOverTime(18000).operateTimeout = 1000


        connectionStateCoordinator.bluetoothController = bluetoothController
        bluetoothController.bluetoothAdapter.startDiscovery()
        connectionStateCoordinator.isDeviceConnected = false
        bluetoothController.bluetoothManager.init(requireActivity().application)
//        val scanRuleConfig = BleScanRuleConfig.Builder()
//            .setAutoConnect(true)
//            .setScanTimeOut(10000)
//            .build()
//        BleManager.getInstance().initScanRule(scanRuleConfig)
        //  bluetoothController.bluetoothManager.cancelScan()
        connectionStateCoordinator.listBleDevices.clear()
        bluetoothController.startScan()

    }



    fun readResponse() {
        //  Log.e("D", "onConnectSuccess SERVICE SIZE " + firstGate.services.size)
        for (service in firstGate?.services!!) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)
                for (service in service.characteristics) {
                    if (service.uuid.toString().equals("0000ffe1-0000-1000-8000-00805f9b34fb")) {
                        bluetoothController.blueGattAdapter.addResult(service.service)
                    }
                }

            }
        }
        bluetoothController.bleDeviceMain = firstBleDevice
        connectionStateCoordinator.firstGatt = firstGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)


        if (bluetoothController.blueGattAdapter.getCount() > 0) {
            val service = bluetoothController.blueGattAdapter.getItem(0)
            bluetoothController.readNotification(
                firstBleDevice,
                service?.characteristics!!.get(0)
            )

        } else {
            Toast.makeText(
                requireContext(),
                "Notifications faild",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun readSecondResponse() {
        for (service in secondGate?.services!!) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController.blueGattAdapter.addResult(service)
                }
            }
        }
        bluetoothController.bleDeviceMain = secondBleDevice
        connectionStateCoordinator.secondGatt = secondGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)

        if (bluetoothController.blueGattAdapter.getCount() > 0) {
            val service = bluetoothController.blueGattAdapter.getItem(0)
            bluetoothController.readNotification2(
                secondBleDevice,
                service?.characteristics!!.get(0)
            )

        }
    }

    fun readThirdResponse() {
        for (service in thirdGate?.services!!) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController.blueGattAdapter.addResult(service)
                }
            }
        }
        bluetoothController.bleDeviceMain = thirdBleDevice
        connectionStateCoordinator.thirdGatt = thirdGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)

        if (bluetoothController.blueGattAdapter.getCount() > 0) {
            val service = bluetoothController.blueGattAdapter.getItem(0)
            bluetoothController.readNotification3(
                thirdBleDevice,
                service?.characteristics!!.get(0)
            )

        }
    }

    fun readFourthResponse() {
        for (service in fourthGate?.services!!) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController.blueGattAdapter.addResult(service)
                }
            }
        }
        bluetoothController.bleDeviceMain = fourthBleDevice
        connectionStateCoordinator.fourthGatt = fourthGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)

        if (bluetoothController.blueGattAdapter.getCount() > 0) {
            val service = bluetoothController.blueGattAdapter.getItem(0)
            bluetoothController.readNotification4(
                fourthBleDevice,
                service?.characteristics!!.get(0)
            )

        }
    }

    private fun navigateToAvailableDevices() {
        bluetoothController.bluetoothManager.cancelScan()
        findNavController().navigate(R.id.action_my_devices_to_search_devices)
    }

    private fun navigateToMain() {
//        bluetoothController.bluetoothManager.cancelScan()
        findNavController().navigate(R.id.action_my_devices_to_main_fragment)
    }

    fun setFirstDevice() {
        val deviceOne = prefs.firstDevice
        if (deviceOne.length > 1) {
            firstCardView.visibility = View.VISIBLE
            val gson = Gson()
            val deviceOneObj: MyDevice
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDeviceName.text = deviceOneObj.newName
            firstDevice = deviceOneObj.name
            deviceTotalNumber = deviceTotalNumber + 1
        } else {
            firstCardView.visibility = View.GONE
        }
    }

    fun setSecondDevice() {
        val deviceTwo = prefs.secondDevice
        if (deviceTwo.length > 1) {
            secondCardView.visibility = View.VISIBLE
            val gson = Gson()
            val deviceTwoObj: MyDevice
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            secondDeviceName.text = deviceTwoObj.newName
            secondDevice = deviceTwoObj.name
            deviceTotalNumber = deviceTotalNumber + 1
        } else {
            secondCardView.visibility = View.GONE
        }
    }

    fun setThirdDevice() {
        val deviceThree = prefs.thirdDevice
        if (deviceThree.length > 1) {
            thirdCardView.visibility = View.VISIBLE
            val gson = Gson()
            val deviceThreeObj: MyDevice
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            thirdDeviceName.text = deviceThreeObj.newName
            thirdDevice = deviceThreeObj.name
            deviceTotalNumber = deviceTotalNumber + 1
        } else {
            thirdCardView.visibility = View.GONE
        }
    }

    fun setFourthDevice() {
        val deviceFour = prefs.fourthDevice
        if (deviceFour.length > 1) {
            fourthCardView.visibility = View.VISIBLE
            val gson = Gson()
            val deviceFourObj: MyDevice
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            fourthDeviceName.text = deviceFourObj.newName
            fourthDevice = deviceFourObj.name
            deviceTotalNumber = deviceTotalNumber + 1
        } else {
            fourthCardView.visibility = View.GONE
        }
        deviceNumber.text = "$deviceTotalNumber/4 devices"
    }

    private val scanCallback = object : BleScanCallback() {
        override fun onScanStarted(success: Boolean) {
            Log.e("myDevice", "Scan started on my device")
        }

        override fun onScanning(bleDevice: BleDevice) {
            Log.e("onScanning", "bleDevice.name " + bleDevice.name)
            if (bleDevice.name != null) {
                connectionStateCoordinator.listBleDevices.add(bleDevice)
                if (bleDevice.name == firstDevice) {
                    bluetoothController.connect(bleDevice)
                }
                if (bleDevice.name == secondDevice) {
                    bluetoothController.connect(bleDevice)
                }
                if (bleDevice.name == thirdDevice) {
                    bluetoothController.connect(bleDevice)
                }
                if (bleDevice.name == fourthDevice) {
                    bluetoothController.connect(bleDevice)
                }
            }
        }

        override fun onScanFinished(scanResultList: List<BleDevice>) {
            Log.e("d", "Scan done from MyDevicesFragment" + scanResultList.size)
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
            Log.e("d", "BLE DEVICE onConnect  " + bleDevicee.name)
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
            connectionStateCoordinator.bluetoothConnectionState.value = "distanceDisconnected"
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


    private val writeCallback = object : BleWriteCallback() {
        override fun onWriteSuccess(current: Int, total: Int, justWrite: ByteArray?) {
            Log.e("D", "onWriteSuccess ")
        }

        override fun onWriteFailure(exception: BleException?) {
            // Log.e("D", "Notification faild " + exception?.description)
        }

    }
    private val notifyCallback = object : BleNotifyCallback() {
        override fun onNotifySuccess() {
            Log.e("d", "onNotifySuccess firsDevice ")
        }

        override fun onNotifyFailure(exception: BleException) {
            Log.e("d", " onNotifyFailure $exception")
        }

        override fun onCharacteristicChanged(data: ByteArray) {
            Log.e("d", "Notifaction recived from firstDevice ")
            var newDataChar = CharArray(data.size)
            for ((index, byte) in data.withIndex()) {
                newDataChar[index] = byte.toChar()
//                Log.e("D", "UIntArray " + index + "." + byte.toChar())
            }
            connectionStateCoordinator.bleDevicePosition=1
            connectionStateCoordinator.bluetoothByteArray.value = newDataChar

            var i = 1
//            var dataList = ArrayList<Int>()
            // val idArray: Array<Byte> = arrayOf(data[5], data[6], data[7], data[8])
        }
    }
    private val notifyCallback2 = object : BleNotifyCallback() {
        override fun onNotifySuccess() {
            Log.e("d", "onNotifySuccess secondDevice ")
        }

        override fun onNotifyFailure(exception: BleException) {
            //  Log.e("d", " onNotifyFailure $exception")
        }

        override fun onCharacteristicChanged(data: ByteArray) {
            Log.e("d", "Notifaction recived from secondDevice ")
            var newDataChar = CharArray(data.size)
            for ((index, byte) in data.withIndex()) {
                newDataChar[index] = byte.toChar()
//                Log.e("D", "UIntArray " + index + "." + byte.toChar())
            }
            connectionStateCoordinator.bleDevicePosition=2
            connectionStateCoordinator.bluetoothByteArray.value = newDataChar


        }
    }
    private val notifyCallback3 = object : BleNotifyCallback() {
        override fun onNotifySuccess() {
            Log.e("d", "onNotifySuccess thirdDevice")
        }

        override fun onNotifyFailure(exception: BleException) {
            //  Log.e("d", " onNotifyFailure $exception")
        }

        override fun onCharacteristicChanged(data: ByteArray) {
            Log.e("d", "Notifaction recived from thirdDevice ")
            var newDataChar = CharArray(data.size)
            for ((index, byte) in data.withIndex()) {
                newDataChar[index] = byte.toChar()
//                Log.e("D", "UIntArray " + index + "." + byte.toChar())
            }
            connectionStateCoordinator.bleDevicePosition=3
            connectionStateCoordinator.bluetoothByteArray.value = newDataChar


        }
    }
    private val notifyCallback4 = object : BleNotifyCallback() {
        override fun onNotifySuccess() {
            Log.e("d", "onNotifySuccess fourhDevice")
        }

        override fun onNotifyFailure(exception: BleException) {
            //  Log.e("d", " onNotifyFailure $exception")
        }

        override fun onCharacteristicChanged(data: ByteArray) {
            Log.e("d", "Notifaction recived from fourth ")
            var newDataChar = CharArray(data.size)
            for ((index, byte) in data.withIndex()) {
                newDataChar[index] = byte.toChar()
//                Log.e("D", "UIntArray " + index + "." + byte.toChar())
            }
            connectionStateCoordinator.bleDevicePosition=4
            connectionStateCoordinator.bluetoothByteArray.value = newDataChar

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
            btnDone -> navigateToMain()
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
                firstBleDevice?.let { showRenameDialog(it, 0) }
            }
            renameSecondDevice -> {
                secondBleDevice?.let { showRenameDialog(it, 1) }
            }
            renameThirdDevice -> {
                thirdBleDevice?.let { showRenameDialog(it, 2) }
            }
            renameFourthDevice -> {
                fourthBleDevice?.let { showRenameDialog(it, 3) }
            }
        }
    }

    fun showRenameDialog(bleDevice: BleDevice, positon: Int) {
        renameDeviceDialog = RenameDevicePopup(bleDevice, positon)
        renameDeviceDialog.isCancelable = false
        renameDeviceDialog.show(childFragmentManager, "")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val data = data?.extras

                    val name = data?.getString("name")
                    val position = data?.getInt("position", 0)
                    when (position) {
                        0 -> {
                            firstDeviceName.text = name
                            firstPopup.visibility = View.GONE
                        }
                        1 -> {
                            secondDeviceName.text = name
                            secondPopup.visibility = View.GONE
                        }
                        2 -> {
                            thirdDeviceName.text = name
                            thirdPopup.visibility = View.GONE
                        }
                        3 -> {
                            fourthDeviceName.text = name
                            fourthPopup.visibility = View.GONE
                        }
                    }
                }
            }
        }
    }
}