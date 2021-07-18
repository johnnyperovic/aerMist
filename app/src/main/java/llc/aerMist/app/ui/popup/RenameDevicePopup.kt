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


class RenameDevicePopup(val position: Int, val deviceName: String) : DialogFragment() {
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
        val gson = Gson()
        val firstDevice = prefs.firstDevice
        val secondDevice = prefs.secondDevice
        val thirdDevice = prefs.thirdDevice
        val fourthDevice = prefs.fourthDevice
        var firstDeviceObj: MyDevice?=null
        var secondDeviceObj: MyDevice?=null
        var thirdDeviceObj: MyDevice?=null
        var fourthDeviceObj: MyDevice?=null
        if (!firstDevice.isNullOrEmpty())
        {
        }
        if (!secondDevice.isNullOrEmpty())
        {
            secondDeviceObj = gson.fromJson(secondDevice, MyDevice::class.java)
        }
        if (!thirdDevice.isNullOrEmpty())
        {
            thirdDeviceObj = gson.fromJson(thirdDevice, MyDevice::class.java)
        }
        if (!fourthDevice.isNullOrEmpty())
        {
            fourthDeviceObj = gson.fromJson(fourthDevice, MyDevice::class.java)

        }
        when (position) {
            0 -> {
                firstDeviceObj = gson.fromJson(firstDevice, MyDevice::class.java)
                dialogView.deviceId.text = firstDeviceObj.name
            }
            1 -> {
                dialogView.deviceId.text = secondDeviceObj?.name
            }
            2 -> {
                dialogView.deviceId.text = thirdDeviceObj?.name
            }
            3 -> {
                dialogView.deviceId.text = fourthDeviceObj?.name
            }
        }

        dialogView.addBtn.text = resources.getString(R.string.rename)

        dialogView.deviceNameValue.hint = deviceName
        dialogView.cancelBtn.setOnClickListener {
            //   prefs.clear()
            dialog?.dismiss()
        }
        dialogView.addBtn.setOnClickListener {
            val newName = dialogView.deviceNameValue.text.toString()
            if (newName.length == 0) {
                dialog?.dismiss()
                return@setOnClickListener
            }
            val gson = Gson()

            when (position) {
                0 -> {
                    val newDevice = firstDeviceObj?.let { it1 -> MyDevice(it1.name, newName, true) }
                    val json = gson.toJson(newDevice)
                    prefs.firstDevice = json
                }
                1 -> {
                    val newDevice = secondDeviceObj?.let { it1 -> MyDevice(it1.name, newName, true) }
                    val json = gson.toJson(newDevice)
                    prefs.secondDevice = json
                }
                2 -> {
                    val newDevice = thirdDeviceObj?.let { it1 -> MyDevice(it1.name, newName, true) }
                    val json = gson.toJson(newDevice)
                    prefs.thirdDevice = json
                }
                3 -> {
                    val newDevice = fourthDeviceObj?.let { it1 -> MyDevice(it1.name, newName, true) }
                    val json = gson.toJson(newDevice)
                    prefs.fourthDevice = json
                }
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
