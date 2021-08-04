package llc.aerMist.app.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_main.*
import llc.aerMist.app.R
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject


class MainFragment : Fragment() {
    private lateinit var navController: NavController
    val connectionStateCoordinator = NewObservableCoordinator
    private val prefs: PreferenceCache by inject()
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        navController = NavHostFragment.findNavController(navHostFragment)
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        val deviceNumber =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        checkTotalNumber()
        Log.e("D","main counter "+counter)
        if (deviceNumber == 1 || deviceNumber == 0 && counter==1) {
            navGraph.startDestination = R.id.deviceFragment
            showBottomNav()
        } else  {
            navGraph.startDestination = R.id.homeFragment
            showBottomNav()
        }
        navController.setGraph(navGraph)
        nav_view.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> showBottomNav()
                R.id.deviceFragment -> showBottomNav()
                R.id.infoFragment -> showBottomNav()
                R.id.setDeviceFragment -> showBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    private fun showBottomNav() {
        nav_view.visibility = View.VISIBLE

    }

    private fun hideBottomNav() {
        nav_view.visibility = View.GONE

    }

    fun checkTotalNumber() :Int{
        counter = 0
        val deviceOne = prefs.firstDevice
        val deviceTwo = prefs.secondDevice
        val deviceThree = prefs.thirdDevice
        val deviceFour = prefs.fourthDevice
        if (!deviceOne.isNullOrEmpty()) {
            counter = counter + 1
        }
        if (!deviceTwo.isNullOrEmpty()) {
            counter = counter + 1
        }
        if (!deviceThree.isNullOrEmpty()) {
            counter = counter + 1
        }
        if (!deviceFour.isNullOrEmpty()) {
            counter = counter + 1
        }
        return counter
    }
}