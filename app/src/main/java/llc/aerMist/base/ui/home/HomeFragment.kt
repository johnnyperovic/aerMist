package llc.aerMist.base.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_home.*
import llc.aerMist.base.R
import llc.aerMist.base.adapters.HomeFragmentAdapter
import org.koin.androidx.viewmodel.dsl.ATTRIBUTE_VIEW_MODEL


class HomeFragment : Fragment(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        setNonStopView()
        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                constraintSet: Int,
                p2: Int
            ) {

            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                constraintSet: Int,
                p2: Int,
                p3: Float
            ) {

            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, constraintSet: Int) {
                if (constraintSet == R.id.start) {
                    btnStart.setBackgroundResource(R.drawable.blue_radius_8)
                    btnStart.text = getString(R.string.start)
                } else {
                    btnStart.setBackgroundResource(R.drawable.container_light_blue)
                    btnStart.text = getString(R.string.stop)
                }
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                constraintSet: Int,
                p2: Boolean,
                p3: Float
            ) {

            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    fun setClickListener() {
        nonStopImg.setOnClickListener(this)
        nonStopTv.setOnClickListener(this)
        intervalImg.setOnClickListener(this)
        intervalTv.setOnClickListener(this)
        scheduleImg.setOnClickListener(this)
        scheduleTv.setOnClickListener(this)
        btnStart.setOnClickListener(this)
        btnEdit.setOnClickListener(this)
    }

    fun setTabItemVisibility(state: Boolean) {
        if (state) {
            btnStart.text = getString(R.string.stop)
            intervalImg.visibility = View.INVISIBLE
            intervalTv.visibility = View.INVISIBLE
            scheduleImg.visibility = View.INVISIBLE
            scheduleTv.visibility = View.INVISIBLE
            nonStopImg.visibility = View.INVISIBLE
            nonStopTv.visibility = View.INVISIBLE
            firstLine.visibility = View.INVISIBLE
            bleBg.visibility = View.INVISIBLE
            bleIcon.visibility = View.INVISIBLE
            standbyTv.visibility = View.INVISIBLE
            mistTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            mistValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            suspendTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            suspendValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            firstLine.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
        } else {
            btnStart.text = getString(R.string.stop)
            intervalImg.visibility = View.VISIBLE
            intervalTv.visibility = View.VISIBLE
            scheduleImg.visibility = View.VISIBLE
            scheduleTv.visibility = View.VISIBLE
            nonStopImg.visibility = View.VISIBLE
            nonStopTv.visibility = View.VISIBLE
            firstLine.visibility = View.VISIBLE
            bleBg.visibility = View.VISIBLE
            bleIcon.visibility = View.VISIBLE
            standbyTv.visibility = View.VISIBLE
            mistTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            mistValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            suspendTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            suspendValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            firstLine.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
        }
    }

    override fun onClick(id: View?) {
        when (id) {
            nonStopImg -> {
                setNonStopView()
            }
            nonStopTv -> {
                setNonStopView()
            }
            intervalImg -> {
                setIntervalView()
            }
            intervalTv -> {
                setIntervalView()
            }
            scheduleImg -> {
                setScheduleView()
            }
            scheduleTv -> {
                setScheduleView()
            }
            btnStart -> {
                startAnimation()
            }
            btnEdit -> {
            }
        }
    }

    fun setNonStopView() {
        mistTv.visibility = View.GONE
        mistValue.visibility = View.GONE
        suspendTv.visibility = View.GONE
        suspendValue.visibility = View.GONE
        btnEdit.visibility = View.GONE
        secondLine.visibility = View.GONE
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
        )
        guideline.setGuidelinePercent(1f)
    }

    fun setIntervalView() {
        mistTv.visibility = View.VISIBLE
        mistValue.visibility = View.VISIBLE
        suspendTv.visibility = View.VISIBLE
        suspendValue.visibility = View.VISIBLE
        btnEdit.visibility = View.VISIBLE
        secondLine.visibility = View.VISIBLE
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.orange_circle)
        )
        guideline.setGuidelinePercent(0.65f)
    }

    fun setScheduleView() {
        mistTv.visibility = View.VISIBLE
        mistValue.visibility = View.VISIBLE
        suspendTv.visibility = View.VISIBLE
        suspendValue.visibility = View.VISIBLE
        btnEdit.visibility = View.VISIBLE
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
        )
        guideline.setGuidelinePercent(0.65f)
    }

    fun startAnimation() {
        motionLayout.transitionToEnd()
        motionLayout.transitionToStart()
        if (intervalImg.visibility == View.VISIBLE) {
            setTabItemVisibility(true)
        } else {
            setTabItemVisibility(false)
        }
    }
}