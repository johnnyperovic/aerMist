package llc.aerMist.app.ui.devices

import android.os.Bundle
import androidx.navigation.NavDirections
import kotlin.Int
import llc.aerMist.app.R

class MenageDevicesFragmentDirections private constructor() {
  private data class ActionMenageDevicesToSetDevice(
    val myArg: Int = 1
  ) : NavDirections {
    override fun getActionId(): Int = R.id.action_menage_devices_to_set_device

    override fun getArguments(): Bundle {
      val result = Bundle()
      result.putInt("myArg", this.myArg)
      return result
    }
  }

  companion object {
    fun actionMenageDevicesToSetDevice(myArg: Int = 1): NavDirections =
        ActionMenageDevicesToSetDevice(myArg)
  }
}
