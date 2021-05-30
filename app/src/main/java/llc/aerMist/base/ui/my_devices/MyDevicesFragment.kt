package llc.aerMist.base.ui.my_devices

import android.annotation.SuppressLint
import android.bluetooth.BluetoothGatt
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.callback.BleNotifyCallback
import com.clj.fastble.callback.BleScanCallback
import com.clj.fastble.callback.BleWriteCallback
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
import com.google.gson.Gson
import kotlinx.android.synthetic.main.my_devices_fragment.*
import llc.aerMist.base.R
import llc.aerMist.base.helpers.BluetoothController
import llc.aerMist.base.models.MyDevice
import llc.aerMist.base.observers.NewObservableCoordinator
import llc.aerMist.base.shared.util.PreferenceCache
import org.koin.android.ext.android.inject
import java.util.*
import kotlin.collections.ArrayList


class MyDevicesFragment : Fragment() {

    private val prefs: PreferenceCache by inject()
    lateinit var bluetoothController: BluetoothController
    val connectionStateCoordinator = NewObservableCoordinator
    lateinit var availableDevicesList: List<BleDevice>
    var list: List<BleDevice> = ArrayList()
    var deviceTotalNumber = 0;
    lateinit var firstDevice: String
    lateinit var firstBleDevice: BleDevice
    lateinit var firstGate: BluetoothGatt
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_devices_fragment, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val deviceOne = prefs.firstDevice
        val gson = Gson()
        if (deviceOne.length > 0) {
            val deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDevice = deviceOneObj.name
        }
        bluetoothController =
            BluetoothController(
                notifyCallback,
                gattCallback,
                scanCallback,
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
//        val scanRuleConfig = BleScanRuleConfig.Builder()
//            .setAutoConnect(true)
//            .setScanTimeOut(10000)
//            .build()
//        BleManager.getInstance().initScanRule(scanRuleConfig)
      //  bluetoothController.bluetoothManager.cancelScan()
        bluetoothController.list.clear()
        bluetoothController.startScan()
        //  initRecycler()
        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()

        btnAddNewDevice.setOnClickListener {
            bluetoothController.bluetoothManager.cancelScan()
            navigateToAvailableDevices()
        }
        btnDone.setOnClickListener {
            navigateToMain()
        }
        btnOnOf.setOnClickListener {
            val value = btnOnOf.text
            val testData = UUID.fromString("0000180f-0000-1000-8000-00805f9b34fb")
            val charset = Charsets.UTF_8
            val byteArray = "19497846679023918".toByteArray(charset)
            val byteArrayON = "19497846679023662".toByteArray(charset)
            Log.e("D","gate size "+firstGate.services.size)
            if (value == "On") {
                btnOnOf.text = getString(R.string.off)

                bluetoothController.writeCommand(
                    firstBleDevice,
                    byteArray,
                    firstGate.services.get(6).characteristics.get(0)
                )
            } else {
                btnOnOf.text = getString(R.string.on)
                bluetoothController.writeCommand(
                    firstBleDevice,
                    byteArrayON,
                    firstGate.services.get(6).characteristics.get(0)
                )
            }
        }
    }

    private fun navigateToAvailableDevices() {
        bluetoothController.bluetoothManager.cancelScan()
        findNavController().navigate(R.id.action_my_devices_to_available_devices)
    }

    private fun navigateToMain() {
        bluetoothController.bluetoothManager.cancelScan()
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
            deviceTotalNumber = deviceTotalNumber + 1
        } else {
            fourthCardView.visibility = View.GONE
        }
        deviceNumber.text = deviceTotalNumber.toString() + "/4 devices"
    }

    private val writeCallback = object : BleWriteCallback() {
        override fun onWriteSuccess(current: Int, total: Int, justWrite: ByteArray?) {
            Log.e("D", "SUCCESS")
        }

        override fun onWriteFailure(exception: BleException?) {
            Log.e("D", "Notification faild " + exception?.description)
            Log.e("D", "Notification faild " + exception?.code)
        }

    }
    private val scanCallback = object : BleScanCallback() {
        override fun onScanStarted(success: Boolean) {
            Log.e("myDevice", "Scan started on my device")
        }

        override fun onScanning(bleDevice: BleDevice) {
            Log.e("onScanning", "bleDevice.name " + bleDevice.name)
            if (bleDevice.name != null) {
                bluetoothController.list.add(bleDevice)

            }
        }

        override fun onScanFinished(scanResultList: List<BleDevice>) {
            Log.e("d", "Scan done from MyDevicesFragment" + scanResultList.size)
            availableDevicesList = scanResultList
            list = scanResultList
            for (item in scanResultList) {
                if (item.name == firstDevice) {
                    bluetoothController.connect(item)
                }
            }
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
                firstDotColor?.setImageDrawable(resources.getDrawable(R.drawable.green_dot))
                firstDeviceState?.text = "Online"
                firstProgressBar?.visibility = View.GONE
                firstInfoDots?.visibility = View.VISIBLE
                btnOnOf?.visibility = View.VISIBLE
                firstBleDevice = bleDevicee
                firstGate = gatt
            }
//            if (firstDevice == bleDevicee) {
//                Log.e("D", "BRAVO PRVI JE KONEKTOVAN JOS SAMO 3")
//            }
//            Log.e("D", "onConnectSuccess SERVICE SIZE " + gatt.services.size)
//            for (service in gatt.services) {
//                if (service.characteristics.size > 0) {
//                    Log.e("d", "UUID " + service.characteristics.get(0).uuid)
//
//                    if (service.characteristics.get(0).uuid.toString()
//                            .equals("d973f2e1-b19e-11e2-9e96-0800200c9a66")
//                    ) {
//                        bluetoothController.blueGattAdapter.addResult(service)
////                        Log.e(
////                            "d",
////                            "SERVICE characteristics descriptors" + service.characteristics.get(
////                                0
////                            ).descriptors
////                        )
//                    }
//                }
//            }
//            bluetoothController.bleDeviceMain = bleDevicee
//            connectionStateCoordinator.gatt = gatt
//            Log.e("D", "bleDevicee.mac " + bleDevicee.mac)
//
//
//            if (bluetoothController.blueGattAdapter.getCount() > 0) {
//                val service = bluetoothController.blueGattAdapter.getItem(0)
//                bluetoothController.readNotification(
//                    bluetoothController.bleDeviceMain,
//                    service?.characteristics!!.get(0)
//                )
//
//            } else {
//                Toast.makeText(
//                    requireContext(),
//                    "Notifications faild",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
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
                firstDotColor?.setImageDrawable(resources.getDrawable(R.drawable.red_dot))
                firstDeviceState?.text = "Ofline"
                firstProgressBar?.visibility = View.GONE
                firstInfoDots?.visibility = View.VISIBLE
                btnOnOf?.visibility = View.INVISIBLE
            }
        }
    }


    private val notifyCallback = object : BleNotifyCallback() {
        override fun onNotifySuccess() {
            Log.e("d", "USPJESNO ")
        }

        override fun onNotifyFailure(exception: BleException) {
            Log.e("d", " onNotifyFailure $exception")
        }

        override fun onCharacteristicChanged(data: ByteArray) {

            var newData: UIntArray = UIntArray(data.size)
            for ((index, byte) in data.withIndex()) {
                Log.e("D", "ByteArray " + index + "." + byte)
            }
            for ((index, byte) in data.withIndex()) {
                newData[index] = byte.toUInt()
                Log.e("D", "UIntArray " + index + "." + byte.toUInt())
            }
            //     connectionStateCoordinator.bluetoothByteArray.value = newData
            var i = 0
//            var dataList = ArrayList<Int>()
            // val idArray: Array<Byte> = arrayOf(data[5], data[6], data[7], data[8])
        }
    }


}