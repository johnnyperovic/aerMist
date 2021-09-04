package llc.aerMis.production.ui.popup

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.add_device_popup.view.cancelBtn
import kotlinx.android.synthetic.main.fragment_number_picker_popup.view.*
import kotlinx.android.synthetic.main.fragment_set_time_popup.view.saveBtn
import llc.aerMis.production.R


class NumberPickerPopup : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        // Inflate the layout for this fragment
        val builder = AlertDialog.Builder(requireContext())
        val dialogView: View = inflater.inflate(
            R.layout.fragment_number_picker_popup,
            container,
            false
        )
        if (dialog != null && dialog!!.window != null) {
            dialog!!.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog!!.window!!.requestFeature(Window.FEATURE_NO_TITLE)
            dialog!!.setCancelable(false)
        }
        val sprayTime = arrayOf("5s", "6s", "7s", "8s", "9s", "10s", "11s","12s", "13s" , "14s", "15s", "16s", "17s", "18s", "19s", "20s", "25s", "30s", "35s", "40s", "45s", "50s", "55s", "1m", "1m 30s", "2m", "2m 30s", "3m", "3m 30s", "4m", "4m 30s", "5m", "5m 30s", "6m", "6m 30s", "7m", "7m 30s", "8m", "8m 30s", "9m", "9m 30s", "10m", "10m 30s", "11m", "11m 30s", "12m", "12m 30s", "13m", "13m 30s", "14m", "14m 30s", "15m")
        val suspendTime = arrayOf("5s", "6s", "7s", "8s", "9s", "10s", "11s","12s", "13s" , "14s", "15s", "16s", "17s", "18s", "19s", "20s", "25s", "30s", "35s", "40s", "45s", "50s", "55s", "1m", "1m 30s", "2m", "2m 30s", "3m", "3m 30s", "4m", "4m 30s", "5m", "5m 30s", "6m", "6m 30s", "7m", "7m 30s", "8m", "8m 30s", "9m", "9m 30s", "10m", "10m 30s", "11m", "11m 30s", "12m", "12m 30s", "13m", "13m 30s", "14m", "14m 30s", "15m")
        val sprayTimePicker = dialogView.sprayTimePicker
        val suspendTimePicker = dialogView.suspendTimePicker
        sprayTimePicker.maxValue = 51
        sprayTimePicker.minValue = 0
        suspendTimePicker.maxValue = 51
        suspendTimePicker.minValue = 0
        sprayTimePicker.setDisplayedValues(sprayTime)
        suspendTimePicker.setDisplayedValues(suspendTime)

        dialogView.cancelBtn.setOnClickListener {
            dialog?.dismiss()
        }
        dialogView.saveBtn.setOnClickListener {
            val mist = sprayTime.get(dialogView.sprayTimePicker.value)
            val suspend = suspendTime.get(dialogView.suspendTimePicker.value)
            val i: Intent = Intent()
                .putExtra("mist", mist)
                .putExtra("suspend", suspend)
            requireParentFragment().onActivityResult(1, Activity.RESULT_OK, i)
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