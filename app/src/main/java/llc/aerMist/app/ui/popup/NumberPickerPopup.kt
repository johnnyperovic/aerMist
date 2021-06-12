package llc.aerMist.app.ui.popup

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.format.DateUtils.getMonthString
import android.util.Log
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.add_device_popup.view.cancelBtn
import kotlinx.android.synthetic.main.fragment_number_picker_popup.view.*
import kotlinx.android.synthetic.main.fragment_set_time_popup.view.saveBtn
import llc.aerMist.app.R
import kotlin.math.absoluteValue


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
        val sprayTime = arrayOf("15sec ", "20 sec", "30sec", "40 sec", "axolotl")
        val suspendTime = arrayOf("15sec ", "20 sec", "30sec", "40 sec", "axolotl")
        val sprayTimePicker = dialogView.sprayTimePicker
        val suspendTimePicker = dialogView.suspendTimePicker
        sprayTimePicker.maxValue = 4
        sprayTimePicker.minValue = 0
        suspendTimePicker.maxValue = 4
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