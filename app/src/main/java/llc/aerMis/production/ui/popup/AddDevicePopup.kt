package llc.aerMis.production.ui.popup

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.clj.fastble.data.BleDevice
import com.google.gson.Gson
import kotlinx.android.synthetic.main.add_device_popup.view.*
import kotlinx.android.synthetic.main.search_fragment.view.*
import llc.aerMis.production.R
import llc.aerMis.production.models.MyDevice
import llc.aerMis.production.shared.util.PreferenceCache
import org.koin.android.ext.android.inject


class AddDevicePopup(val device: BleDevice) : DialogFragment() {
    private val prefs: PreferenceCache by inject()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val builder = AlertDialog.Builder(requireContext())//,

        if (dialog != null && dialog!!.window != null) {
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
            dialog!!.setCancelable(false)
        }

        val dialogView: View = inflater.inflate(R.layout.add_device_popup, container, false)
        dialogView.deviceId.text = device.name
        dialogView.cancelBtn.setOnClickListener { 
         //   prefs.clear()
            dialog?.dismiss()
        }
        dialogView.addBtn.setOnClickListener {
            val newName = dialogView.deviceNameValue.text.toString()
            if (newName.length==0)
            {
                dialog?.dismiss()
                return@setOnClickListener
            }
            val gson = Gson()
            val newDevice = MyDevice(device.name, newName,false)

            val json = gson.toJson(newDevice)
            if (prefs.firstDevice.length > 0 && prefs.secondDevice.length > 0 && prefs.thirdDevice.length > 0 && prefs.fourthDevice.length == 0) {
                prefs.fourthDevice = json
                prefs.fourthBleDevice = device.mac
            } else if (prefs.firstDevice.length > 0 && prefs.secondDevice.length > 0 && prefs.thirdDevice.length == 0) {
                prefs.thirdDevice = json
                prefs.thirdBleDevice = device.mac
            } else if (prefs.firstDevice.length > 0 && prefs.secondDevice.length == 0) {
                prefs.secondDevice = json
                prefs.secondBleDevice = device.mac
            }
            if (prefs.firstDevice.length == 0) {
                prefs.firstDevice = json
                prefs.firstBleDevice = device.mac
            }
                navigateToMyDevices()
                dialog?.dismiss()
        }
        builder.setView(dialogView)
        return dialogView
    }

    private fun navigateToMyDevices() {
        findNavController().navigate(R.id.action_available_devices_to_my_devices)
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(
            WindowManager.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.WRAP_CONTENT
        )
    }

    override fun dismiss() {
        if (isVisible)
            super.dismiss()
    }


}
