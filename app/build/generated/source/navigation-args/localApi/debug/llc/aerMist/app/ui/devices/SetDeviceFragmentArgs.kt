package llc.aerMist.app.ui.devices

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.Suppress
import kotlin.jvm.JvmStatic
import llc.aerMist.app.models.ScheduleModel

data class SetDeviceFragmentArgs(
  val myArg: Int = 1,
  val model: ScheduleModel
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
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

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): SetDeviceFragmentArgs {
      bundle.setClassLoader(SetDeviceFragmentArgs::class.java.classLoader)
      val __myArg : Int
      if (bundle.containsKey("myArg")) {
        __myArg = bundle.getInt("myArg")
      } else {
        __myArg = 1
      }
      val __model : ScheduleModel?
      if (bundle.containsKey("model")) {
        if (Parcelable::class.java.isAssignableFrom(ScheduleModel::class.java) ||
            Serializable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
          __model = bundle.get("model") as ScheduleModel?
        } else {
          throw UnsupportedOperationException(ScheduleModel::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__model == null) {
          throw IllegalArgumentException("Argument \"model\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"model\" is missing and does not have an android:defaultValue")
      }
      return SetDeviceFragmentArgs(__myArg, __model)
    }
  }
}
