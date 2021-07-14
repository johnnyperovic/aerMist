package llc.aerMist.app.ui.popup

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_devices_disconnected.view.*
import kotlinx.android.synthetic.main.remove_reset_device_fragment.view.*
import llc.aerMist.app.R
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject


class DevicesDisconnected(val isOneDevice:Boolean): DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val builder = AlertDialog.Builder(requireContext())//,

        if (dialog != null && dialog!!.window != null) {
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
            dialog!!.setCancelable(true)
        }


        val dialogView: View =
            inflater.inflate(R.layout.fragment_devices_disconnected, container, false)
        if (isOneDevice)
        {
            dialogView.deviceDisconnectedTv.text=resources.getString(R.string.your_device_is_disconnected)
        }
        else{
            dialogView.deviceDisconnectedTv.text=resources.getString(R.string.all_devices_are_disconnected)
        }
        builder.setView(dialogView)
        return dialogView
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

