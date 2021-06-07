package llc.aerMist.app.ui.my_devices

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.app.R

class MyDevicesFragmentDirections private constructor() {
  companion object {
    fun actionMyDevicesToSearchDevices(): NavDirections =
        ActionOnlyNavDirections(R.id.action_my_devices_to_search_devices)

    fun actionMyDevicesToMainFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_my_devices_to_main_fragment)
  }
}
