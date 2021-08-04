package llc.aerMist.app.ui.welcome

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.app.R

public class WelcomeFragmentDirections private constructor() {
  public companion object {
    public fun actionWelcomeToSearchFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_welcome_to_searchFragment)

    public fun actionWelcomeToMyDevices(): NavDirections =
        ActionOnlyNavDirections(R.id.action_welcome_to_my_devices)
  }
}
