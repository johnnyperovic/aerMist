package llc.aerMist.app.ui.my_devices

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String
import llc.aerMist.app.R

class MyDevicesFragmentDirections private constructor() {
  private data class ActionMyDevicesToDevice(
    val myArg: String? = null
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_my_devices_to_device

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("myArg", this.myArg)
      return result
    }
  }

  companion object {
    fun actionMyDevicesToSearchDevices(): NavDirections =
        ActionOnlyNavDirections(R.id.action_my_devices_to_search_devices)

    fun actionMyDevicesToMainFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_my_devices_to_main_fragment)

    fun actionMyDevicesToDevice(myArg: String? = null): NavDirections =
        ActionMyDevicesToDevice(myArg)

    fun actionDialogToMyDevices(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dialog_to_my_devices)
  }
}
