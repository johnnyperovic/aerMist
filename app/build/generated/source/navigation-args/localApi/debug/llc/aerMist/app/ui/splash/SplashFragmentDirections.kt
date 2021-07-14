package llc.aerMist.app.ui.splash

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String
import llc.aerMist.app.R

class SplashFragmentDirections private constructor() {
  private data class ActionSplashFragmentToDeviceFragment(
    val myArg: String? = null
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_splashFragment_to_deviceFragment

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("myArg", this.myArg)
      return result
    }
  }

  companion object {
    fun actionSplashFragmentToWelcomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_welcomeFragment)

    fun actionSplashFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_homeFragment)

    fun actionSplashFragmentToDeviceFragment(myArg: String? = null): NavDirections =
        ActionSplashFragmentToDeviceFragment(myArg)
  }
}
