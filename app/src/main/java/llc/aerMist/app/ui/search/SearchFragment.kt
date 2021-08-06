package llc.aerMist.app.ui.search

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.clj.fastble.callback.BleScanCallback
import com.clj.fastble.data.BleDevice
import com.google.gson.Gson
import kotlinx.android.synthetic.main.my_devices_fragment.*
import kotlinx.android.synthetic.main.search_fragment.*
import llc.aerMist.app.R
import llc.aerMist.app.adapters.AvailableDevicesAdapter
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.AddDevicePopup
import org.koin.android.ext.android.inject

class SearchFragment : Fragment() {

    private val prefs: PreferenceCache by inject()
    private val BLE_REQUEST_CODE = 1
    private var bluetoothEnabled: Boolean = false
    lateinit var bluetoothController: BluetoothController
    val connectionStateCoordinator = NewObservableCoordinator

    private var adapter: AvailableDevicesAdapter? = null
    private lateinit var addDeviceDialog: AddDevicePopup
    var firstDevice: String = ""
    var secondDevice: String = ""
    var thirdDevice: String = ""
    var fourthDevice: String = ""


    private var deviceName = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.search_fragment, container, false)
        return root
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setDeviceNamaFromDb()
        bluetoothController =
            BluetoothController(null, null, null, null, null, scanCallback, null, requireContext())
//        bluetoothController.bluetoothManager
//            .enableLog(true)
//            .setReConnectCount(200, 4000)
//            .setConnectOverTime(18000).operateTimeout = 4000
//        bluetoothController.bluetoothAdapter.startDiscovery()
//        bluetoothController.bluetoothManager.init(requireActivity().application)

        if (!bluetoothController.bluetoothAdapter.isEnabled) {
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBluetoothIntent, BLE_REQUEST_CODE)
        } else {
            connectionStateCoordinator.listBleDevices.clear()
            bluetoothController.startScan()
        }

        initRecycler()
        btnCancel.setOnClickListener {
            if (bluetoothEnabled) {
                bluetoothController.bluetoothManager.cancelScan()
            }
            navigateToMyDevices()
        }
    }

    private fun navigateToMyDevices() {
        view?.post {
            findNavController().navigate(R.id.action_available_devices_to_my_devices)
        }
    }

    fun initRecycler() {
        adapter =
            AvailableDevicesAdapter(
                connectionStateCoordinator.listBleDevices
            ) { device: BleDevice -> deviceItemClicked(device) }
        availableDevicesRecycler.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                if (bluetoothController.bluetoothAdapter.isEnabled) {
                    Log.e("D", "Bluetooth has been enabled")
                    bluetoothEnabled = true
                    connectionStateCoordinator.listBleDevices.clear()
                    bluetoothController.startScan()
                } else {
                    Log.e("D", "Bluetooth has been disabled")
                    bluetoothEnabled = false
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                Log.e("D", "Bluetooth enabling has been canceled")
                bluetoothEnabled = false

            }
        }
    }

    val scanCallback = object : BleScanCallback() {
        override fun onScanStarted(success: Boolean) {
            Log.e("onSearch", "Scan started from search")
            connectionStateCoordinator.listBleDevices.clear()
        }

        override fun onScanning(bleDevice: BleDevice) {
            Log.e("onScanning", "bleDevice.name " + bleDevice.name)
            if (bleDevice.name != null) {
                val bleName = bleDevice.name
                if (bleName.contains("FG") && bleName != firstDevice && bleName != secondDevice && bleName != thirdDevice && bleName != fourthDevice) {

                    connectionStateCoordinator.listBleDevices.add(bleDevice)
                    adapter?.notifyDataSetChanged()
                    Log.e("d", "BLE DEVICE NAME " + bleDevice.name)
                }
            }
        }


        override fun onScanFinished(scanResultList: List<BleDevice>) {
            Log.e("d", "Scan done from searcha " + scanResultList.size)
        }
    }

    private fun deviceItemClicked(device: BleDevice) {
        bluetoothController.bluetoothManager.cancelScan()
        deviceName = device.name
        Log.e("D", "Device name " + device.name)
        addDeviceDialog = AddDevicePopup(device)
        addDeviceDialog.isCancelable = false
        addDeviceDialog.show(childFragmentManager, "")
    }

    fun setDeviceNamaFromDb() {
        val deviceOne = prefs.firstDevice
        val deviceTwo = prefs.secondDevice
        val deviceThree = prefs.thirdDevice
        val deviceFour = prefs.fourthDevice

        if (deviceOne.length > 1) {
            val gson = Gson()
            val deviceOneObj: MyDevice
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDevice = deviceOneObj.name
        }
        if (deviceTwo.length > 1) {
            val gson = Gson()
            val deviceTwoObj: MyDevice
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            secondDevice = deviceTwoObj.name
        }
        if (deviceThree.length > 1) {
            val gson = Gson()
            val deviceThreeObj: MyDevice
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            thirdDevice = deviceThreeObj.name
        }
        if (deviceFour.length > 1) {
            val gson = Gson()
            val deviceFourObj: MyDevice
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            fourthDevice = deviceFourObj.name
        }
    }

}