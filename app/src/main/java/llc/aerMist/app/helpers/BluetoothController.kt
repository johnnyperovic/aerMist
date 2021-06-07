package llc.aerMist.app.helpers

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGattCharacteristic
import android.content.Context
import android.util.Log
import androidx.preference.PreferenceManager
import com.clj.fastble.BleManager
import com.clj.fastble.callback.*
import com.clj.fastble.data.BleDevice
import com.clj.fastble.scan.BleScanRuleConfig
import com.google.gson.Gson
import llc.aerMist.app.adapters.BlueGattAdapter
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject

import java.util.*
import kotlin.collections.ArrayList

class BluetoothController(
    val notifyCallback: BleNotifyCallback?,
    val gattCallback: BleGattCallback?,
    val scanCallback: BleScanCallback?,
    val writeCallback: BleWriteCallback?,
     applicationContext: Context
) {
    var bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
    var bleDeviceMain: BleDevice? = null
    var blueGattAdapter: BlueGattAdapter = BlueGattAdapter()
    val bluetoothManager: BleManager = BleManager.getInstance()
    val connectionStateCoordinator = NewObservableCoordinator
    private val prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)

    var isMyDevice = false

    fun readNotification(bleDevice: BleDevice?, characteristic: BluetoothGattCharacteristic) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            bluetoothManager.notify(
                bleDevice,
                characteristic.service?.uuid.toString(),
                characteristic.uuid.toString(),
                notifyCallback
            )
        }
    }

    fun writeCommand(bleDevice: BleDevice,input: ByteArray, characteristic: BluetoothGattCharacteristic) {

        bluetoothManager.write(
            bleDevice,
            characteristic.service.uuid.toString(),
            characteristic.uuid.toString(),
            input,
            writeCallback
        )
    }

    fun connect(bleDevice: BleDevice?) {
        bluetoothManager.connect(bleDevice, gattCallback)
    }

    fun startScan() {
//        initScanRule()
        if (scanCallback!=null)
        {
            bluetoothManager.scan(scanCallback)
        }
    }

    fun initScanRule() {
        Log.i("BluetoothController","initScanRule()")
        // real service UUID: d973f2e0-b19e-11e2-9e96-0800200c9a66
        // 00000000-0000-1000-8000-00805f9b34fb
        val uuidString = "d973f2e0-b19e-11e2-9e96-0800200c9a66"
        val uuid = UUID.fromString(uuidString)
        val uuids = arrayOf<UUID>(uuid)
        val scanRuleConfig = BleScanRuleConfig.Builder()
            .setServiceUuids(uuids)
            .build()
        Log.i("BluetoothController","scanRuleConfig: ${scanRuleConfig.serviceUuids[0]}")
        bluetoothManager.initScanRule(scanRuleConfig)
    }

    fun disconnect() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            connectionStateCoordinator.gatt?.disconnect()
        }
        connectionStateCoordinator.bluetoothConnectionState.value = ""
        connectionStateCoordinator.isDeviceConnected = false
        connectionStateCoordinator.idString.value = ""
        connectionStateCoordinator.gatt = null
        connectionStateCoordinator.bluetoothController = null
        connectionStateCoordinator.isDeviceAuthorized = false
        connectionStateCoordinator.bluetoothByteArray.value = UIntArray(14)
        Log.i("BluetoothController", "Device disconnected")
    }
    fun startConnectingMyDevices()
    {
        val deviceOne = prefs.getString("first_device","")
        val gson = Gson()
        if (deviceOne!!.length > 0) {
            val deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
          val  firstDevice = deviceOneObj.name
            Log.e("D","naziv "+firstDevice)
                    if (connectionStateCoordinator.listBleDevices.size > 0) {
            for (item in connectionStateCoordinator.listBleDevices) {
                if (item.name == firstDevice) {
                    connect(item)
                }
            }
        }
        }
    }
}