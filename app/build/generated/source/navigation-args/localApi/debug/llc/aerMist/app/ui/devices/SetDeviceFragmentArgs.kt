package llc.aerMist.app.ui.devices

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmStatic
import llc.aerMist.app.models.ScheduleModel

public data class SetDeviceFragmentArgs(
  public val myArg: String = "",
  public val model: ScheduleModel? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("myArg", this.myArg)
    if (Parcelable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
      result.putParcelable("model", this.model as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
      result.putSerializable("model", this.model as Serializable?)
    }
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SetDeviceFragmentArgs {
      bundle.setClassLoader(SetDeviceFragmentArgs::class.java.classLoader)
      val __myArg : String?
      if (bundle.containsKey("myArg")) {
        __myArg = bundle.getString("myArg")
        if (__myArg == null) {
          throw IllegalArgumentException("Argument \"myArg\" is marked as non-null but was passed a null value.")
        }
      } else {
        __myArg = ""
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
      } else {
        __model = null
      }
      return SetDeviceFragmentArgs(__myArg, __model)
    }
  }
}
