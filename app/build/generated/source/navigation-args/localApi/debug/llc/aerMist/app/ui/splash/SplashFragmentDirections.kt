package llc.aerMist.app.ui.splash

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import kotlin.Int
import kotlin.String
import llc.aerMist.app.R

public class SplashFragmentDirections private constructor() {
  private data class ActionSplashFragmentToDeviceFragment(
    public val myArg: String? = null
  ) : NavDirections {
    public override fun getActionId(): Int = R.id.action_splashFragment_to_deviceFragment

    public override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("myArg", this.myArg)
      return result
    }
  }

  public companion object {
    public fun actionSplashFragmentToWelcomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_welcomeFragment)

    public fun actionSplashFragmentToHomeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_splashFragment_to_homeFragment)

    public fun actionSplashFragmentToDeviceFragment(myArg: String? = null): NavDirections =
        ActionSplashFragmentToDeviceFragment(myArg)
  }
}
