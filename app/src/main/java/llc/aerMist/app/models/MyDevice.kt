package llc.aerMist.app.models

import com.clj.fastble.data.BleDevice

data class MyDevice (
    val name: String,
    val newName: String,
    val bleDevice: BleDevice,
    val isConnected:Boolean
)
{

}