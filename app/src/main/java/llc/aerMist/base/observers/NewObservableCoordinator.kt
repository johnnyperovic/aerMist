package  llc.aerMist.base.observers

import android.bluetooth.BluetoothGatt
import androidx.lifecycle.MutableLiveData
import llc.aerMist.base.helpers.BluetoothController

object NewObservableCoordinator {
    var bluetoothConnectionState = MutableLiveData<String>("")
    var bluetoothByteArray = MutableLiveData<UIntArray>()
    var idString = MutableLiveData("")
    var gatt : BluetoothGatt? = null
    var bluetoothController : BluetoothController? = null
    var isDeviceConnected = false
    var isDeviceAuthorized = false
}