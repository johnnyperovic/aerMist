package llc.aerMist.app.ui.home.schedulere

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_schedule.*
import llc.aerMist.app.R
import llc.aerMist.app.ui.home.HomeFragment


class ScheduleFragment : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnEdit.setOnClickListener {
            navigateToSetSchedule()
        }
        val homeFragment= HomeFragment()
        val fragment = childFragmentManager.findFragmentById(R.id.homeFragment)

        btnStart.setOnClickListener {
            fragment?.view?.setBackgroundColor(resources.getColor(R.color.orange))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    private fun navigateToSetSchedule() {
        findNavController().navigate(R.id.action_schedule_to_set_schedule_fragment)
    }
}