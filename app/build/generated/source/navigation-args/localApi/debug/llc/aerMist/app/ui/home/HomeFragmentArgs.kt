package llc.aerMist.app.ui.home

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavArgs
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic
import llc.aerMist.app.models.ScheduleModel

data class HomeFragmentArgs(
  val model: ScheduleModel? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
      result.putParcelable("model", this.model as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(ScheduleModel::class.java)) {
      result.putSerializable("model", this.model as Serializable?)
    }
    return result
  }

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): HomeFragmentArgs {
      bundle.setClassLoader(HomeFragmentArgs::class.java.classLoader)
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
      return HomeFragmentArgs(__model)
    }
  }
}
