package llc.aerMist.app.ui.popup

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.clj.fastble.BleManager
import kotlinx.android.synthetic.main.dialog_reset_app.view.*
import llc.aerMist.app.R
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject

class ResetAppPopup() : DialogFragment() {
    private val prefs: PreferenceCache by inject()
    val connectionStateCoordinator = NewObservableCoordinator


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

        val dialogView: View = inflater.inflate(R.layout.dialog_reset_app, container, false)
        dialogView.cancelDialog.setOnClickListener {
            //   prefs.clear()
            dialog?.dismiss()
        }
        dialogView.resetBtn.setOnClickListener {
         //   connectionStateCoordinator.bluetoothController?.bluetoothManager?.disconnectAllDevice()
            val firstBle=connectionStateCoordinator.firstDevice
            val secondBle=connectionStateCoordinator.secondDevice
            val thirdBle=connectionStateCoordinator.thirdDevice
            val fourthBle=connectionStateCoordinator.fourthDevice
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.disconnect(firstBle)
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.disconnect(secondBle)
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.disconnect(thirdBle)
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.disconnect(fourthBle)
            connectionStateCoordinator.firstGatt?.disconnect()
            connectionStateCoordinator.secondGatt?.disconnect()
            connectionStateCoordinator.thirdGatt?.disconnect()
            connectionStateCoordinator.fourthGatt?.disconnect()
            connectionStateCoordinator.firstGatt?.close()
            connectionStateCoordinator.firstGatt?.close()
            connectionStateCoordinator.secondGatt?.close()
            connectionStateCoordinator.secondGatt?.close()
            connectionStateCoordinator.thirdGatt?.close()
            connectionStateCoordinator.thirdGatt?.close()
            connectionStateCoordinator.fourthGatt?.close()
            BleManager.getInstance().disconnectAllDevice()
            BleManager.getInstance().destroy()
            connectionStateCoordinator.secondGatt=null
            connectionStateCoordinator.thirdGatt=null
            connectionStateCoordinator.fourthGatt=null
            connectionStateCoordinator.firstDevice=null
            connectionStateCoordinator.secondDevice=null
            connectionStateCoordinator.thirdDevice=null
            connectionStateCoordinator.fourthDevice=null
            connectionStateCoordinator.listBleDevices.clear()
            prefs.clear()
            dialog?.dismiss()
            navigateToWelcomeScreen()
        }
        builder.setView(dialogView)
        return dialogView
    }
    private fun navigateToWelcomeScreen() {
//        bluetoothController.bluetoothManager.cancelScan()
        findNavController().navigate(R.id.action_info_to_welcome)
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
