package llc.aerMist.app.ui.home.schedulere

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.app.R

class SetScheduleFragmentDirections private constructor() {
  companion object {
    fun actionSetScheduleToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_set_schedule_to_home_fragment)
  }
}
