package llc.aerMis.production.ui.popup

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.dialog_reset_app.view.*
import llc.aerMis.production.R
import llc.aerMis.production.shared.util.PreferenceCache
import org.koin.android.ext.android.inject

class StartGlobalModePopup : DialogFragment() {
    private val prefs: PreferenceCache by inject()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val builder = AlertDialog.Builder(requireContext())//,

//
        if (dialog != null && dialog!!.window != null) {
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
            dialog!!.setCancelable(false)
        }

        val dialogView: View = inflater.inflate(R.layout.fragment_start_global_mode_popup, container, false)
        dialogView.cancelDialog.setOnClickListener {
            //   prefs.clear()
            dialog?.dismiss()
        }
        dialogView.resetBtn.setOnClickListener {
            prefs.clear()
            dialog?.dismiss()
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
