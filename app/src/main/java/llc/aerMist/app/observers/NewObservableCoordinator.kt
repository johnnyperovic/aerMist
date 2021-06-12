package  llc.aerMist.app.observers

import android.bluetooth.BluetoothGatt
import androidx.lifecycle.MutableLiveData
import com.clj.fastble.data.BleDevice
import llc.aerMist.app.helpers.BluetoothController

object NewObservableCoordinator {
    var bluetoothConnectionState = MutableLiveData<String>("")
    var bluetoothByteArray = MutableLiveData<UIntArray>()
    var listBleDevices: ArrayList<BleDevice> = ArrayList()
    var idString = MutableLiveData("")
    var firstGatt : BluetoothGatt? = null
    var secondGatt : BluetoothGatt? = null
    var thirdGatt : BluetoothGatt? = null
    var fourtGatt : BluetoothGatt? = null
    var gatt : BluetoothGatt? = null
    var bluetoothController : BluetoothController? = null
    var isDeviceConnected = false
    var isDeviceAuthorized = false
}