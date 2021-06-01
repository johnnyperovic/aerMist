package llc.aerMist.base.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*
import llc.aerMist.base.R
import llc.aerMist.base.adapters.HomeFragmentAdapter


class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewPager.adapter = HomeFragmentAdapter(this)

        TabLayoutMediator(pricingTabs, homeViewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = getString(R.string.non_stop)
                    tab.icon = resources.getDrawable(R.drawable.non_stop)
                }
                1 -> {
                    tab.text = getString(R.string.interval)
                    tab.icon = resources.getDrawable(R.drawable.interval_img)
                }
                else -> {
                    tab.text = getString(R.string.schedule)
                    tab.icon = resources.getDrawable(R.drawable.schedule_icon)

                }
            }
//            if (position == 0)
//            {tab.text = getString(R.string.auto_pricing_tab)}
//            else tab.text = getString(R.string.van_pricing_tab)
        }.attach()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

     fun changeBG() {
         val cardView=view?.findViewById<CardView>(R.id.carViewHome)
         cardView?.setBackgroundColor(resources.getColor(R.color.orange));
    }

}