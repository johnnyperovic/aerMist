package llc.aerMist.app.ui.home.schedulere

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import java.io.Serializable
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import llc.aerMist.app.R
import llc.aerMist.app.models.ScheduleModel

class SetScheduleFragmentDirections private constructor() {
  private data class ActionSetScheduleToHomeFragment(
    val model: ScheduleModel? = null
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_set_schedule_to_home_fragment

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      if (Parcelable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
        result.putParcelable("model", this.model as Parcelable?)
      } else if (Serializable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
        result.putSerializable("model", this.model as Serializable?)
      }
      return result
    }
  }

  private data class ActionSetScheduleToDeviceFragmnent(
    val myArg: String = "",
    val model: ScheduleModel? = null
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_set_schedule_to_device_fragmnent

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putString("myArg", this.myArg)
      if (Parcelable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
        result.putParcelable("model", this.model as Parcelable?)
      } else if (Serializable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
        result.putSerializable("model", this.model as Serializable?)
      }
      return result
    }
  }

  companion object {
    fun actionSetScheduleToHomeFragment(model: ScheduleModel? = null): NavDirections =
        ActionSetScheduleToHomeFragment(model)

    fun actionSetScheduleToDeviceFragmnent(myArg: String = "", model: ScheduleModel? = null):
        NavDirections = ActionSetScheduleToDeviceFragmnent(myArg, model)
  }
}
