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
import com.clj.fastble.BleManager
import kotlinx.android.synthetic.main.remove_reset_device_fragment.view.*
import llc.aerMist.app.R
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject

class RemoveDevicePopup(val position: Int, val deviceName: String, val filter: Boolean) :
    DialogFragment() {
    private val prefs: PreferenceCache by inject()
    val connectionStateCoordinator = NewObservableCoordinator
    var isDeleted = false
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

        if (filter) {
            dialogView.title.text = getString(R.string.reset_filter_title)
            dialogView.deviceName.text = deviceName + " filter ?"
            dialogView.btnRemoveDevice.text = getString(R.string.reset)
            isDeleted = false
        } else {
            dialogView.title.text = getString(R.string.are_you_shure_you_want_to_remove)
            dialogView.deviceName.text = deviceName + " device ?"
            dialogView.btnRemoveDevice.text = getString(R.string.remove)
            isDeleted = true
        }

        dialogView.btnCancelDialog.setOnClickListener {
            dialog?.dismiss()
        }

        dialogView.btnRemoveDevice.setOnClickListener {
            when (position) {
                0 -> {
                    if (filter) {
                        prefs.cleanFirstFilter()
                    } else {

                        connectionStateCoordinator.firstGatt?.disconnect()
                        val bleDevice=connectionStateCoordinator.firstDevice
                        BleManager.getInstance().disconnect(bleDevice)
                        Log.e("D","NAZIV "+bleDevice?.name)
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.disconnect(bleDevice)
                        prefs.cleanFirstDevice()
                        prefs.isDeleted = true
                    }
                }
                1 -> {
                    if (filter) {
                        prefs.cleanSecondFilter()
                    } else {
                        connectionStateCoordinator.secondGatt?.disconnect()
                        val bleDevice=connectionStateCoordinator.secondDevice
                        BleManager.getInstance().disconnect(bleDevice)
                        Log.e("D","NAZIV "+bleDevice?.name)
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.disconnect(bleDevice)
                        prefs.cleanSecondDevice()
                        prefs.isDeleted = true
                    }
                }
                2 -> {
                    if (filter) {
                        prefs.cleanThirdFilter()

                    } else {

                        connectionStateCoordinator.thirdGatt?.disconnect()
                        val bleDevice=connectionStateCoordinator.thirdDevice
                        BleManager.getInstance().disconnect(bleDevice)
                        Log.e("D","NAZIV "+bleDevice?.name)
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.disconnect(bleDevice)
                        prefs.cleanThirdDevice()
                        prefs.isDeleted = true
                    }
                }
                3 -> {
                    if (filter) {
                        prefs.cleanFourthFilter()

                    } else {
                        connectionStateCoordinator.fourthGatt?.disconnect()
                        val bleDevice=connectionStateCoordinator.fourthDevice
                        BleManager.getInstance().disconnect(bleDevice)

                        Log.e("D","NAZIV "+bleDevice?.name)
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.disconnect(bleDevice)
                        prefs.cleanFourthDevice()
                        prefs.isDeleted = true
                    }
                }
            }

            val i: Intent = Intent()
                .putExtra("name", deviceName)
                .putExtra("position", position)
                .putExtra("isDeleted", isDeleted)
                .putExtra("isFilter", filter)
            requireParentFragment().onActivityResult(1, Activity.RESULT_OK, i)
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

