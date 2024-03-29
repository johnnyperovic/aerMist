package llc.aerMis.production.ui.popup

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.add_device_popup.view.cancelBtn
import kotlinx.android.synthetic.main.fragment_set_time_popup.view.*
import kotlinx.android.synthetic.main.fragment_set_time_popup.view.saveBtn
import llc.aerMis.production.R

class SetTimePopup(val position : Int) : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val builder = AlertDialog.Builder(requireContext())//,

        if (dialog != null && dialog!!.window != null) {
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
            dialog!!.setCancelable(false)
        }

        val dialogView: View = inflater.inflate(R.layout.fragment_set_time_popup, container, false)
        dialogView.cancelBtn.setOnClickListener {
            dialog?.dismiss()
        }
        dialogView.saveBtn.setOnClickListener {
            Log.e("D","sati "+ dialogView.timePicker.hour)
            val hour=dialogView.timePicker.hour
            val minutes=dialogView.timePicker.minute
            val i: Intent = Intent()
                .putExtra("position", position)
                .putExtra("hour", hour)
                .putExtra("minutes", minutes)
            requireParentFragment().onActivityResult(3, Activity.RESULT_OK, i)
            dialog?.dismiss()
            //   return@setOnClickListener
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