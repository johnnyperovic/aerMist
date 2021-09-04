package llc.aerMis.production.ui.popup

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.dialog_reset_app.view.*
import llc.aerMis.production.R
import llc.aerMis.production.observers.NewObservableCoordinator
import llc.aerMis.production.shared.util.PreferenceCache
import org.koin.android.ext.android.inject
import java.io.File


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
            val firstBle = connectionStateCoordinator.firstDevice
            val secondBle = connectionStateCoordinator.secondDevice
            val thirdBle = connectionStateCoordinator.thirdDevice
            val fourthBle = connectionStateCoordinator.fourthDevice
            connectionStateCoordinator.listBleDevices.clear()
            prefs.clear()
            deleteCache(requireContext())
            connectionStateCoordinator.bluetoothController?.bluetoothAdapter?.cancelDiscovery()
            deleteAppData()
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

    fun deleteCache(context: Context) {
        try {
            val dir: File = context.getCacheDir()
            deleteDir(dir)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun deleteDir(dir: File?): Boolean {
        return if (dir != null && dir.isDirectory()) {
            val children: Array<String> = dir.list()
            for (i in children.indices) {
                val success = deleteDir(File(dir, children[i]))
                if (!success) {
                    return false
                }
            }
            dir.delete()
        } else if (dir != null && dir.isFile()) {
            dir.delete()
        } else {
            false
        }
    }
    private fun deleteAppData() {
        try {
            // clearing app data
            val packageName: String = requireContext().getPackageName()
            val runtime = Runtime.getRuntime()
            runtime.exec("pm clear $packageName")
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }
}
