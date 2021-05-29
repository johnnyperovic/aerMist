package llc.aerMist.base.ui.search

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.base.R

class SearchFragmentDirections private constructor() {
  companion object {
    fun actionAvailableDevicesToMyDevices(): NavDirections =
        ActionOnlyNavDirections(R.id.action_available_devices_to_my_devices)
  }
}
