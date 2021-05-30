package llc.aerMist.base.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import llc.aerMist.base.ui.home.interval.IntervalFragment
import llc.aerMist.base.ui.home.nonStop.NonStopFragment
import llc.aerMist.base.ui.home.schedulere.ScheduleFragment

class HomeFragmentAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val nonStopFragment = NonStopFragment()
    private val scheduleFragment = ScheduleFragment()
    private val intervalFragment = IntervalFragment()

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return nonStopFragment
            1 -> return intervalFragment
            else -> return scheduleFragment
        }

    }

}