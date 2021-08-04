package llc.aerMist.app.ui.home.schedulere

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmStatic
import llc.aerMist.app.models.ScheduleModel

public data class SetScheduleFragmentArgs(
  public val type: Int = 0,
  public val name: String = "",
  public val model: ScheduleModel? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
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

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SetScheduleFragmentArgs {
      bundle.setClassLoader(SetScheduleFragmentArgs::class.java.classLoader)
      val __type : Int
      if (bundle.containsKey("type")) {
        __type = bundle.getInt("type")
      } else {
        __type = 0
      }
      val __name : String?
      if (bundle.containsKey("name")) {
        __name = bundle.getString("name")
        if (__name == null) {
          throw IllegalArgumentException("Argument \"name\" is marked as non-null but was passed a null value.")
        }
      } else {
        __name = ""
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
      return SetScheduleFragmentArgs(__type, __name, __model)
    }
  }
}
