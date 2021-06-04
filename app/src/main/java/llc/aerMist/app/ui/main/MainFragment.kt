package llc.aerMist.app.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.fragment_main.*
import llc.aerMist.app.R



class MainFragment : Fragment() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment = childFragmentManager.findFragmentById(R.id.nav_fragment) as NavHostFragment
        navController = NavHostFragment.findNavController(navHostFragment)
        val navGraph = navController.navInflater.inflate(R.navigation.main_nav_graph)
        navGraph.startDestination=R.id.homeFragment
        navController.setGraph(navGraph)
        nav_view.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.setScheduleFragment -> hideBottomNav()
                else -> showBottomNav()
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
}