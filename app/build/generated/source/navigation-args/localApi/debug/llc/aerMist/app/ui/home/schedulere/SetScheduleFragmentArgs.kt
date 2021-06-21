package llc.aerMist.app.ui.home.schedulere

import android.os.Bundle
import androidx.navigation.NavArgs
import kotlin.Int
import kotlin.jvm.JvmStatic

data class SetScheduleFragmentArgs(
  val type: Int = 0
) : NavArgs {
  fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("type", this.type)
    return result
  }

  companion object {
    @JvmStatic
    fun fromBundle(bundle: Bundle): SetScheduleFragmentArgs {
      bundle.setClassLoader(SetScheduleFragmentArgs::class.java.classLoader)
      val __type : Int
      if (bundle.containsKey("type")) {
        __type = bundle.getInt("type")
      } else {
        __type = 0
      }
      return SetScheduleFragmentArgs(__type)
    }
  }
}
