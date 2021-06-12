package llc.aerMist.app.ui.devices

import android.os.Bundle
import androidx.navigation.NavArgs
import kotlin.Int
import kotlin.jvm.JvmStatic

data class SetDeviceFragmentArgs(
  val myArg: Int = 1
) : NavArgs {
  fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("myArg", this.myArg)
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
      return SetDeviceFragmentArgs(__myArg)
    }
  }
}
