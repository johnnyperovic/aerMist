package llc.aerMist.app.ui.devices

import android.os.Bundle
import androidx.navigation.NavArgs
import kotlin.String
import kotlin.jvm.JvmStatic

public data class MenageDevicesFragmentArgs(
  public val device: String? = null
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("device", this.device)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): MenageDevicesFragmentArgs {
      bundle.setClassLoader(MenageDevicesFragmentArgs::class.java.classLoader)
      val __device : String?
      if (bundle.containsKey("device")) {
        __device = bundle.getString("device")
      } else {
        __device = null
      }
      return MenageDevicesFragmentArgs(__device)
    }
  }
}
