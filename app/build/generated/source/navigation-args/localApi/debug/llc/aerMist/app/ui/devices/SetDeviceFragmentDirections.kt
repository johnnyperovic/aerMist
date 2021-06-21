package llc.aerMist.app.ui.devices

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import llc.aerMist.app.R

class SetDeviceFragmentDirections private constructor() {
  private data class ActionSetDeviceToSetScheduleFragment(
    val type: Int = 0
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_set_device_to_set_schedule_fragment

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("type", this.type)
      return result
    }
  }

  companion object {
    fun actionSetDeviceToSetScheduleFragment(type: Int = 0): NavDirections =
        ActionSetDeviceToSetScheduleFragment(type)
  }
}
