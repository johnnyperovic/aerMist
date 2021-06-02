package llc.aerMist.app.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clj.fastble.data.BleDevice
import llc.aerMist.app.R

class AvailableDevicesAdapter(
    var availableDevices: ArrayList<BleDevice>,
    val clickListener: (BleDevice) -> Unit
) :
    RecyclerView.Adapter<AvailableDevicesAdapter.DeviceViewHolder>() {

    var isClickable = true
    class DeviceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(device: BleDevice, clickListener: (BleDevice) -> Unit) {
            val deviceName=itemView.findViewById<TextView>(R.id.deviceName)
            deviceName.text= device.name
            itemView.setOnClickListener {
                clickListener(device)
            }
            Log.e("d", "naziv " + device.name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_available_device, parent, false)
        return DeviceViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int = availableDevices.size

    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        holder.bind(availableDevices[position], clickListener)
    }



}