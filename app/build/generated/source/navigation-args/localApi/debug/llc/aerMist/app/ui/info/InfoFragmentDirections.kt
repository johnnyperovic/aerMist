package llc.aerMist.app.ui.info

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import llc.aerMist.app.R

class InfoFragmentDirections private constructor() {
  companion object {
    fun actionInfoToWelcome(): NavDirections = ActionOnlyNavDirections(R.id.action_info_to_welcome)
  }
}
