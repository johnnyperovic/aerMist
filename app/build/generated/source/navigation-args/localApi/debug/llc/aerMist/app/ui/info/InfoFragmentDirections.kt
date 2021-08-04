package llc.aerMist.app.ui.info

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.app.R

public class InfoFragmentDirections private constructor() {
  public companion object {
    public fun actionInfoToWelcome(): NavDirections =
        ActionOnlyNavDirections(R.id.action_info_to_welcome)
  }
}
