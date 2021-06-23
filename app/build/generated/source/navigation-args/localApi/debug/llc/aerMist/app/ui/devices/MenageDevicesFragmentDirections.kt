package llc.aerMist.app.ui.devices

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress
import llc.aerMist.app.R
import llc.aerMist.app.models.ScheduleModel

class MenageDevicesFragmentDirections private constructor() {
  private data class ActionMenageDevicesToSetDevice(
    val myArg: Int = 1,
    val model: ScheduleModel
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_menage_devices_to_set_device

    @Suppress("CAST_NEVER_SUCCEEDS")
    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("myArg", this.myArg)
      if (Parcelable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
        result.putParcelable("model", this.model as Parcelable)
      } else if (Serializable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
        result.putSerializable("model", this.model as Serializable)
      } else {
        throw UnsupportedOperationException(ScheduleModel::class.java.name +
            " must implement Parcelable or Serializable or must be an Enum.")
      }
      return result
    }
  }

  companion object {
    fun actionMenageDevicesToSetDevice(myArg: Int = 1, model: ScheduleModel): NavDirections =
        ActionMenageDevicesToSetDevice(myArg, model)

    fun actionMenageDevicesToSearchDevice(): NavDirections =
        ActionOnlyNavDirections(R.id.action_menage_devices_to_search_device)
  }
}
