package llc.aerMist.base.ui.splash

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.base.R

class SplashFragmentDirections private constructor() {
  companion object {
    fun actionSplashFragmentToWelcomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_welcomeFragment)
  }
}
