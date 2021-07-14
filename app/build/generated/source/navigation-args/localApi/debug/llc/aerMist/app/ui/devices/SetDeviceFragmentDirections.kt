package llc.aerMist.app.ui.devices

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import java.io.Serializable
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import llc.aerMist.app.R
import llc.aerMist.app.models.ScheduleModel

class SetDeviceFragmentDirections private constructor() {
  private data class ActionSetDeviceToSetScheduleFragment(
    val type: Int = 0,
    val name: String = "",
    val model: ScheduleModel? = null
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_set_device_to_set_schedule_fragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("type", this.type)
      result.putString("name", this.name)
      if (Parcelable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
        result.putParcelable("model", this.model as Parcelable?)
      } else if (Serializable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
        result.putSerializable("model", this.model as Serializable?)
      }
      return result
    }
  }

  companion object {
    fun actionSetDeviceToSetScheduleFragment(
      type: Int = 0,
      name: String = "",
      model: ScheduleModel? = null
    ): NavDirections = ActionSetDeviceToSetScheduleFragment(type, name, model)
  }
}
