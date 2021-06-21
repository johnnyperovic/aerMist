package llc.aerMist.app.ui.home

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import llc.aerMist.app.R

class HomeFragmentDirections private constructor() {
  private data class ActionScheduleToSetScheduleFragment(
    val type: Int = 0
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_schedule_to_set_schedule_fragment

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("type", this.type)
      return result
    }
  }

  companion object {
    fun actionScheduleToSetScheduleFragment(type: Int = 0): NavDirections =
        ActionScheduleToSetScheduleFragment(type)
  }
}
