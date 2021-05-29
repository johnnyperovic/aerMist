package llc.aerMist.base.ui.welcome

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.base.R

class WelcomeFragmentDirections private constructor() {
  companion object {
    fun actionWelcomeToSearchFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_welcome_to_searchFragment)

    fun actionWelcomeToMyDevices(): NavDirections =
        ActionOnlyNavDirections(R.id.action_welcome_to_my_devices)
  }
}
