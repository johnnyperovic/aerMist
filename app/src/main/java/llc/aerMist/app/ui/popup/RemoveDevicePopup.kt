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
                        prefs.isDeleted = true
                        prefs.cleanFirstDevice()
                        val bleDevice=connectionStateCoordinator.firstDevice
                       connectionStateCoordinator.bluetoothController?.bluetoothManager?.disconnect(bleDevice)
                   //     BleManager.getInstance().disconnect(bleDevice)
                          connectionStateCoordinator.firstGatt?.close()
                         connectionStateCoordinator.firstDevice=null
                         connectionStateCoordinator.firstGatt=null

//                        connectionStateCoordinator.firstGatt?.services?.clear()
//                        connectionStateCoordinator.firstGatt?.disconnect()
//                        BleManager.getInstance().disconnect(bleDevice)
//                        Log.e("D","NAZIV "+bleDevice?.name)
                    }
                }
                1 -> {
                    if (filter) {
                        prefs.cleanSecondFilter()
                    } else {
                        prefs.cleanSecondDevice()
                        prefs.isDeleted = true
                        val bleDevice=connectionStateCoordinator.secondDevice
                        BleManager.getInstance().disconnect(bleDevice)
                        connectionStateCoordinator.secondGatt?.close()
                        connectionStateCoordinator.secondGatt=null
                        connectionStateCoordinator.secondDevice=null
                    }
                }
                2 -> {
                    if (filter) {
                        prefs.cleanThirdFilter()

                    } else {
                        prefs.cleanThirdDevice()
                        prefs.isDeleted = true
                        val bleDevice=connectionStateCoordinator.thirdDevice
                        BleManager.getInstance().disconnect(bleDevice)
                        connectionStateCoordinator.thirdGatt?.close()
                        connectionStateCoordinator.thirdGatt=null
                        connectionStateCoordinator.thirdDevice=null


                    }
                }
                3 -> {
                    if (filter) {
                        prefs.cleanFourthFilter()

                    } else {
                        prefs.cleanFourthDevice()
                        prefs.isDeleted = true
                        val bleDevice=connectionStateCoordinator.fourthDevice
                        BleManager.getInstance().disconnect(bleDevice)
                        connectionStateCoordinator.fourthGatt?.close()
                        connectionStateCoordinator.fourthGatt=null
                        connectionStateCoordinator.fourthDevice=null
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

