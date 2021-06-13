package llc.aerMist.app.ui.popup

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.clj.fastble.data.BleDevice
import com.google.gson.Gson
import kotlinx.android.synthetic.main.add_device_popup.view.*
import kotlinx.android.synthetic.main.search_fragment.view.*
import llc.aerMist.app.R
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject


class RenameDevicePopup(val device: BleDevice,val position:Int) : DialogFragment() {
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
        dialogView.addBtn.text = resources.getString(R.string.rename)
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
            val newDevice = MyDevice(device.name, newName,device,false)

            val json = gson.toJson(newDevice)
            when(position)
            {
                0->prefs.firstDevice = json
                1->prefs.secondDevice = json
                2->prefs.thirdDevice = json
                3->prefs.fourthDevice = json
            }
            val i: Intent = Intent()
                .putExtra("name", newName)
                .putExtra("position", position)
            requireParentFragment().onActivityResult(1, Activity.RESULT_OK, i)
            dialog?.dismiss()
        }
        builder.setView(dialogView)
        return dialogView
    }

    private fun navigateToMyDevices() {
        findNavController().navigate(R.id.action_dialog_to_my_devices)
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
