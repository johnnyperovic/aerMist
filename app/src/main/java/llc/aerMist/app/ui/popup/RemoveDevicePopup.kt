package llc.aerMist.app.ui.popup

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.clj.fastble.data.BleDevice
import com.google.gson.Gson
import kotlinx.android.synthetic.main.add_device_popup.view.*
import kotlinx.android.synthetic.main.add_device_popup.view.cancelBtn
import kotlinx.android.synthetic.main.remove_reset_device_fragment.view.*
import llc.aerMist.app.R
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject

class RemoveDevicePopup (val position:Int,val deviceName:String) : DialogFragment() {
    private val prefs: PreferenceCache by inject()
    val connectionStateCoordinator = NewObservableCoordinator


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

        val dialogView: View =
            inflater.inflate(R.layout.remove_reset_device_fragment, container, false)

        dialogView.deviceName.text=deviceName+" device ?"

        dialogView.btnCancelDialog.setOnClickListener {
            dialog?.dismiss()
        }

        dialogView.btnRemoveDevice.setOnClickListener {
            when (position) {
                0 -> {
                    prefs.cleanFirstDevice()
                    connectionStateCoordinator.firstGatt?.disconnect()
                    connectionStateCoordinator.firstGatt=null

                }
                1 ->{
                    prefs.cleanSecondDevice()
                    connectionStateCoordinator.secondGatt?.disconnect()
                    connectionStateCoordinator.secondGatt=null

                }
                2 ->{
                    prefs.cleanThirdDevice()
                    connectionStateCoordinator.thirdGatt?.disconnect()
                    connectionStateCoordinator.thirdGatt=null
                }
                3 -> {
                    prefs.cleanFourthDevice()
                    connectionStateCoordinator.fourthGatt?.disconnect()
                    connectionStateCoordinator.fourthGatt=null
                }
            }
            val i: Intent = Intent()
                .putExtra("position", position)
                .putExtra("isDeleted", true)
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

