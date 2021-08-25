package  llc.aerMist.app.observers

import android.bluetooth.BluetoothGatt
import android.bluetooth.BluetoothGattCallback
import androidx.lifecycle.MutableLiveData
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.data.BleDevice
import llc.aerMist.app.helpers.BluetoothController

object NewObservableCoordinator {
    var bluetoothConnectionStateFirst = MutableLiveData<BleDevice>()
    var bluetoothConnectionStateSecond= MutableLiveData<BleDevice>()
    var bluetoothByteArray = MutableLiveData<CharArray>()
    var bleDisconnectDevicesFirst = MutableLiveData<BleDevice>()
    var bleDisconnectDevicesSecond = MutableLiveData<BleDevice>()
    var isFirstTimeSynch = MutableLiveData<Boolean>()
    var isSecondTimeSynch = MutableLiveData<Boolean>()
    var isThirdTimeSynch = MutableLiveData<Boolean>()
    var isFourthTimeSynch = MutableLiveData<Boolean>()
    var listBleDevices: ArrayList<BleDevice> = ArrayList()
    var idString = MutableLiveData("")
    var firstGatt: BluetoothGatt? = null
    var secondGatt: BluetoothGatt? = null
    var thirdGatt: BluetoothGatt? = null
    var fourthGatt: BluetoothGatt? = null
    var firstDevice: BleDevice? = null
    var secondDevice: BleDevice? = null
    var thirdDevice: BleDevice? = null
    var fourthDevice: BleDevice? = null
    var firstGattController: BleGattCallback? = null
    var secondGattController: BleGattCallback? = null
    var bluetoothController: BluetoothController? = null
    var isDeviceConnected = false
    var isDeviceAuthorized = false
    var bleDevicePosition = 0
    var mode = MutableLiveData<String>("")
}