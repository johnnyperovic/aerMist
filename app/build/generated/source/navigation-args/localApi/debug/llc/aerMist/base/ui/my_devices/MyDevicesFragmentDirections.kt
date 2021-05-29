package llc.aerMist.base.ui.my_devices

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.base.R

class MyDevicesFragmentDirections private constructor() {
  companion object {
    fun actionMyDevicesToAvailableDevices(): NavDirections =
        ActionOnlyNavDirections(R.id.action_my_devices_to_available_devices)

    fun actionMyDevicesToMainFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_my_devices_to_main_fragment)
  }
}
