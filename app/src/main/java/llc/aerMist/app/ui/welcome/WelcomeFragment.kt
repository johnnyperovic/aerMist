package llc.aerMist.app.ui.welcome
import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_welcome.*
import llc.aerMist.app.R
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject


class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    private val prefs: PreferenceCache by inject()
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 2;

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (!checkPermissions()) {
            requestPermissions2()
        }
        if (hasDevicesFromDB()) {
            navigateToMyDevices()
        }
        btnSearch.setOnClickListener {
            navigateToSearch()
        }
    }

    private fun navigateToSearch() {
        findNavController().navigate(R.id.action_welcome_to_searchFragment)
    }

    private fun navigateToMyDevices(){
        findNavController().navigate(R.id.action_welcome_to_my_devices)
    }


    private fun checkPermissions(): Boolean {
        val permissionState = ActivityCompat.checkSelfPermission(
            requireContext(),
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        return permissionState == PackageManager.PERMISSION_GRANTED
    }

    /**
     * this method request to permission asked.
     */
    private fun requestPermissions2() {
        val shouldProvideRationale = ActivityCompat.shouldShowRequestPermissionRationale(
            requireActivity(),
            Manifest.permission.ACCESS_FINE_LOCATION
        )
        if (shouldProvideRationale) {
            Log.i("TAG", "Displaying permission rationale to provide additional context.")
        } else {
            Log.i("TAG", "Requesting permission")
            // previously and checked "Never ask again".
            ActivityCompat.requestPermissions(
                requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_PERMISSIONS_REQUEST_CODE
            )
        }
    }

    /**
     * Callback received when a permissions request has been completed.
     */
    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String?>,
        grantResults: IntArray
    ) {
        Log.i("TAG", "onRequestPermissionResult")
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            if (grantResults.size <= 0) {
                // If user interaction was interrupted, the permission request is cancelled and you
                // receive empty arrays.
                Log.i("TAG", "User interaction was cancelled.")
            } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission was granted. Kick off the process of building and connecting
                // GoogleApiClient.
                //  buildGoogleApiClient()
            } else {
                // Permission denied.
            }
        }
    }

    fun hasDevicesFromDB(): Boolean {
        val deviceOne = prefs.firstDevice
        val deviceTwo = prefs.secondDevice
        val deviceThree = prefs.thirdDevice
        val deviceFour = prefs.fourthDevice
        var hasDevice = false
        if (deviceOne.length > 0 || deviceTwo.length > 0 || deviceThree.length > 0 || deviceFour.length > 0) {
            hasDevice = true
        }

        return hasDevice
    }
}