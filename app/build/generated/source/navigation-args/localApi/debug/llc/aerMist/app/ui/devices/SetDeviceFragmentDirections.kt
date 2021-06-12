package llc.aerMist.app.ui.devices

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.app.R

class SetDeviceFragmentDirections private constructor() {
  companion object {
    fun actionSetDeviceToSetScheduleFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_set_device_to_set_schedule_fragment)
  }
}
