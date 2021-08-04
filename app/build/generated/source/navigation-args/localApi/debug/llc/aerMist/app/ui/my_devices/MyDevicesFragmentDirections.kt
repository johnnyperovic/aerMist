package llc.aerMist.app.ui.my_devices

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String
import llc.aerMist.app.R

public class MyDevicesFragmentDirections private constructor() {
  private data class ActionMyDevicesToDevice(
    public val myArg: String? = null
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_my_devices_to_device

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("myArg", this.myArg)
      return result
    }
  }

  public companion object {
    public fun actionMyDevicesToSearchDevices(): NavDirections =
        ActionOnlyNavDirections(R.id.action_my_devices_to_search_devices)

    public fun actionMyDevicesToMainFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_my_devices_to_main_fragment)

    public fun actionMyDevicesToDevice(myArg: String? = null): NavDirections =
        ActionMyDevicesToDevice(myArg)

    public fun actionDialogToMyDevices(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dialog_to_my_devices)
  }
}
