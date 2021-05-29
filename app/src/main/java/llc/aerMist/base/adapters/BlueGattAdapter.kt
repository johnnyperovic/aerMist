package llc.aerMist.base.adapters

import android.bluetooth.BluetoothGattService

class BlueGattAdapter  {
    private val bluetoothGattServices: MutableList<BluetoothGattService>

    init {
        bluetoothGattServices = ArrayList()
    }

    internal fun addResult(service: BluetoothGattService) {
        bluetoothGattServices.add(service)
    }

    internal fun clear() {
        bluetoothGattServices.clear()
    }

    fun getCount(): Int {
        return bluetoothGattServices.size
    }

    fun getItem(position: Int): BluetoothGattService? {
        return if (position > bluetoothGattServices.size) null else bluetoothGattServices[position]
    }

    fun getItemId(position: Int): Long {
        return 0
    }
}