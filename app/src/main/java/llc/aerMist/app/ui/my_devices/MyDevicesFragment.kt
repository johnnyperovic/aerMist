package llc.aerMist.app.ui.my_devices

import android.annotation.SuppressLint
import android.bluetooth.BluetoothGatt
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
import kotlinx.android.synthetic.main.my_devices_fragment.*
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
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
    var secondDevice: String = ""
    lateinit var secondBleDevice: BleDevice
    lateinit var secondGate: BluetoothGatt
    private var isFirstDevice = true
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
        btnAddNewDevice.setOnClickListener {
            bluetoothController.bluetoothManager.cancelScan()
            navigateToAvailableDevices()
        }
        btnDone.setOnClickListener {
            navigateToMain()
        }
        btnOnOf.setOnClickListener {
            isFirstDevice = true
            val value = btnOnOf.text.toString().toLowerCase()
            val charset = Charsets.UTF_8
            val byteArrayON = "EE0100.".toByteArray(charset)
            val byteArrayOF = "EE0101.".toByteArray(charset)
            Log.e("D", "gate size " + firstGate.services.size)
            Log.e("D", "BTN VALUE  " + value)
            if (value == getString(R.string.on).toLowerCase()) {
                Log.e("D", "ULAZI U ON")
                btnOnOf.text = getString(R.string.off)
                turnOn(byteArrayON)
            } else {
                turnOf(byteArrayOF)
                btnOnOf.text = getString(R.string.on)
                Log.e("D", "ULAZI U OF")

            }

        }
        secondOnOfBtn.setOnClickListener {
            isFirstDevice = false
            val value = secondOnOfBtn.text.toString().toLowerCase()
            val charset = Charsets.UTF_8
            val byteArrayON = "EE0100.".toByteArray(charset)
            val byteArrayOF = "EE0101.".toByteArray(charset)
            //     Log.e("D", "gate size " + firstGate.services.size)
            Log.e("D", "BTN VALUE  " + value)
            if (value == getString(R.string.on).toLowerCase()) {
                secondOnOfBtn.text = getString(R.string.off)

                turnOnSecond(byteArrayON)
                readSecondResponse()
            } else {
                secondOnOfBtn.text = getString(R.string.on)
                turnOfSecond(byteArrayOF)
                readSecondResponse()
            }
        }
    }

    fun checkConnection() {
        val deviceNumber =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size
        if (deviceNumber == 1) {
            val deviceName =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                    0
                )?.name
            if (firstDevice == deviceName) {
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
        } else
            if (deviceNumber == 2) {
                val deviceName =
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                        0
                    )?.name
                val secondDeviceName =
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                        1
                    )?.name
                if (firstDevice == deviceName) {
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
                if (secondDevice == secondDeviceName) {
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

    fun initBleConroller() {
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
        connectionStateCoordinator.listBleDevices.clear()
        bluetoothController.startScan()

    }

    fun turnOn(input: ByteArray) {
        bluetoothController.writeCommand(
            firstBleDevice,
            input,
            firstGate.services.get(2).characteristics.get(0)
        )
    }

    fun turnOf(input: ByteArray) {
        bluetoothController.writeCommand(
            firstBleDevice,
            input,
            firstGate.services.get(2).characteristics.get(0)
        )
    }

    fun turnOnSecond(input: ByteArray) {
        bluetoothController.writeCommand(
            secondBleDevice,
            input,
            secondGate.services.get(2).characteristics.get(0)
        )
    }

    fun turnOfSecond(input: ByteArray) {
        bluetoothController.writeCommand(
            secondBleDevice,
            input,
            secondGate.services.get(2).characteristics.get(0)
        )
    }


    fun readResponse() {
        Log.e("D", "onConnectSuccess SERVICE SIZE " + firstGate.services.size)
        for (service in firstGate.services) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController.blueGattAdapter.addResult(service)
                    Log.e(
                        "d",
                        "SERVICE characteristics descriptors " + service.characteristics.get(
                            0
                        ).descriptors
                    )
                }
            }
        }
        bluetoothController.bleDeviceMain = firstBleDevice
        connectionStateCoordinator.gatt = firstGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)


        if (bluetoothController.blueGattAdapter.getCount() > 0) {
            val service = bluetoothController.blueGattAdapter.getItem(0)
            bluetoothController.readNotification(
                bluetoothController.bleDeviceMain,
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
        Log.e("D", "onConnectSuccess SERVICE SIZE " + secondGate.services.size)
        for (service in secondGate.services) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController.blueGattAdapter.addResult(service)
                    Log.e(
                        "d",
                        "SERVICE characteristics descriptors " + service.characteristics.get(
                            0
                        ).descriptors
                    )
                }
            }
        }
        bluetoothController.bleDeviceMain = secondBleDevice
        connectionStateCoordinator.gatt = secondGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)

        if (bluetoothController.blueGattAdapter.getCount() > 0) {
            val service = bluetoothController.blueGattAdapter.getItem(0)
            bluetoothController.readNotification(
                bluetoothController.bleDeviceMain,
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

    private fun navigateToAvailableDevices() {
        bluetoothController.bluetoothManager.cancelScan()
        findNavController().navigate(R.id.action_my_devices_to_search_devices)
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
        deviceNumber.text = "$deviceTotalNumber/4 devices"
    }

    private val writeCallback = object : BleWriteCallback() {
        override fun onWriteSuccess(current: Int, total: Int, justWrite: ByteArray?) {
            Log.e("D", "onWriteSuccess ")
//            if (isFirstDevice) {
//                readResponse()
//            } else {
//                readSecondResponse()
//            }
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
                connectionStateCoordinator.listBleDevices.add(bleDevice)
                if (bleDevice.name == firstDevice) {
                    bluetoothController.connect(bleDevice)
                }
                if (bleDevice.name == secondDevice) {
                    bluetoothController.connect(bleDevice)
                }

            }
        }

        override fun onScanFinished(scanResultList: List<BleDevice>) {
            Log.e("d", "Scan done from MyDevicesFragment" + scanResultList.size)
            availableDevicesList = scanResultList
            list = scanResultList
//            for (item in scanResultList) {
//                if (item.name == firstDevice) {
//                    bluetoothController.connect(item)
//                }
            //         }
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
                btnOnOf?.visibility = View.VISIBLE
                firstBleDevice = bleDevicee
                firstGate = gatt
                Log.e("D", "GATE firstGate " + firstGate.device.name)
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
                secondOnOfBtn?.visibility = View.VISIBLE
                secondBleDevice = bleDevicee
                secondGate = gatt
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
                Log.e("D", "UIntArray " + index + "." + byte.toChar())
            }
            //     connectionStateCoordinator.bluetoothByteArray.value = newData
            var i = 0
//            var dataList = ArrayList<Int>()
            // val idArray: Array<Byte> = arrayOf(data[5], data[6], data[7], data[8])
        }
    }

}