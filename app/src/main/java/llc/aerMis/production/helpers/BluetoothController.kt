package llc.aerMis.production.helpers

import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGattCharacteristic
import android.content.Context
import androidx.preference.PreferenceManager
import com.clj.fastble.BleManager
import com.clj.fastble.callback.*
import com.clj.fastble.data.BleDevice
import llc.aerMis.production.adapters.BlueGattAdapter
import llc.aerMis.production.observers.NewObservableCoordinator

class BluetoothController(
    var notifyCallback: BleNotifyCallback?,
    val notifyCallback2: BleNotifyCallback?,
    val notifyCallback3: BleNotifyCallback?,
    val notifyCallback4: BleNotifyCallback?,
    var gattCallback: BleGattCallback?,
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
    fun readNotification2(bleDevice: BleDevice?, characteristic: BluetoothGattCharacteristic) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            bluetoothManager.notify(
                bleDevice,
                characteristic.service?.uuid.toString(),
                characteristic.uuid.toString(),
                notifyCallback2
            )
        }
    }

    fun readNotification3(bleDevice: BleDevice?, characteristic: BluetoothGattCharacteristic) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            bluetoothManager.notify(
                bleDevice,
                characteristic.service?.uuid.toString(),
                characteristic.uuid.toString(),
                notifyCallback3
            )
        }
    }
    fun readNotification4(bleDevice: BleDevice?, characteristic: BluetoothGattCharacteristic) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            bluetoothManager.notify(
                bleDevice,
                characteristic.service?.uuid.toString(),
                characteristic.uuid.toString(),
                notifyCallback4
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
        if (scanCallback!=null)
        {
            bluetoothManager.scan(scanCallback)
        }
    }


}