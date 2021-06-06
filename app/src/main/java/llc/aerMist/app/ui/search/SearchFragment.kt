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
import com.clj.fastble.callback.BleScanCallback
import com.clj.fastble.data.BleDevice
import com.google.gson.Gson
import kotlinx.android.synthetic.main.search_fragment.*
import llc.aerMist.app.R
import llc.aerMist.app.adapters.AvailableDevicesAdapter
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.AddDevicePopup
import org.koin.android.ext.android.inject

class SearchFragment : Fragment() {

    private val prefs: PreferenceCache by inject()
    private val BLE_REQUEST_CODE = 1
    private var bluetoothEnabled: Boolean = false
    lateinit var bluetoothController: BluetoothController
    private var adapter: AvailableDevicesAdapter? = null
    private lateinit var addDeviceDialog: AddDevicePopup
    lateinit var firstDevice: String
    lateinit var secondDevice: String
    lateinit var thirdDevice: String
    lateinit var fourthDevice: String
   // var deviceDBList = arrayListOf<String>()
    private var hasDevice=false

    private var deviceName = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.search_fragment, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // hasDevicesFromDB()
        bluetoothController =
            BluetoothController(null, null, scanCallback, null, requireContext())
        bluetoothController.bluetoothManager
            .enableLog(true)
            .setReConnectCount(1, 4000)
            .setConnectOverTime(18000).operateTimeout = 4000
        bluetoothController.bluetoothAdapter.startDiscovery()
        bluetoothController.bluetoothManager.init(requireActivity().application)

        if (!bluetoothController.bluetoothAdapter.isEnabled) {
            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBluetoothIntent, BLE_REQUEST_CODE)
        } else {
            bluetoothController.list.clear()
            bluetoothController.startScan()
        }

        initRecycler()
    }

    fun initRecycler() {
        adapter =
            AvailableDevicesAdapter(
                bluetoothController.list
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
                    bluetoothController.list.clear()
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
            bluetoothController.list.clear()
        }

        override fun onScanning(bleDevice: BleDevice) {
            Log.e("onScanning", "bleDevice.name " + bleDevice.name)
            if (bleDevice.name != null) {
                if (bleDevice.name.contains("FG")) {

                    bluetoothController.list.add(bleDevice)
                    adapter?.notifyDataSetChanged()
                    Log.e("d", "BLE DEVICE NAME " + bleDevice.name)
                }
            }
        }


        override fun onScanFinished(scanResultList: List<BleDevice>) {
            Log.e("d", "Scan done from searcha " + scanResultList.size)
//            bluetoothController.list.clear()
//            for (item in scanResultList) {
//                bluetoothController.list.add(item)
//            }
//            adapter?.notifyDataSetChanged()
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


}