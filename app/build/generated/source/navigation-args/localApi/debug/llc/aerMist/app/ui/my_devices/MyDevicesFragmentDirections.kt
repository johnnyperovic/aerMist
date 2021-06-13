package llc.aerMist.app.ui.my_devices

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.app.R

class MyDevicesFragmentDirections private constructor() {
  companion object {
    fun actionDialogToMyDevices(): NavDirections =
        ActionOnlyNavDirections(R.id.action_dialog_to_my_devices)
  }
}
