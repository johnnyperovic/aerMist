package llc.aerMist.app.ui.search

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.app.R

public class SearchFragmentDirections private constructor() {
  public companion object {
    public fun actionAvailableDevicesToMyDevices(): NavDirections =
        ActionOnlyNavDirections(R.id.action_available_devices_to_my_devices)
  }
}
