package llc.aerMist.app.ui.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.app.R

class HomeFragmentDirections private constructor() {
  companion object {
    fun actionScheduleToSetScheduleFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_schedule_to_set_schedule_fragment)
  }
}
