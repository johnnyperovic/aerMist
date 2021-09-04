package llc.aerMis.production.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import llc.aerMis.production.R
import llc.aerMis.production.models.MyDevice

class MyDevicesAdapter(
    var availableDevices: List<MyDevice>,

    val clickListener: (MyDevice) -> Unit
) :
    RecyclerView.Adapter<MyDevicesAdapter.DeviceViewHolder>() {

    var isClickable = true

    class DeviceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(device: MyDevice, clickListener: (MyDevice) -> Unit) {
            val deviceName = itemView.findViewById<TextView>(R.id.deviceName)
            deviceName.text = device.newName
            itemView.setOnClickListener {
                clickListener(device)
            }
            Log.e("d", "device name  " + device)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DeviceViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_my_device, parent, false)
        return DeviceViewHolder(
            itemView
        )
    }

    override fun getItemCount(): Int = availableDevices.size


    override fun onBindViewHolder(holder: DeviceViewHolder, position: Int) {
        if (availableDevices[position].newName.length > 0) {
            holder.bind(availableDevices[position], clickListener)
        }
    }


}