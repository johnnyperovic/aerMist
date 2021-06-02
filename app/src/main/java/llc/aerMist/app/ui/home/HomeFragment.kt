package llc.aerMist.app.ui.home

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*
import llc.aerMist.app.R
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject


class HomeFragment : Fragment(), View.OnClickListener {
    private val prefs: PreferenceCache by inject()
    private var tag = 0

    @SuppressLint("ClickableViewAccessibility")
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
            firstLine.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.dark_gray
                )
            )
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
                if (btnStart.text == resources.getString(R.string.start)) {
                    if (tag == 2) {
                        startAnimation()
                    } else {
                        showDialog()
                    }
                } else {
                    startAnimation()
                }
            }
            btnEdit -> {
                if (tag == 2) {
                    navigateToSetSchedule()
                }
            }
        }
    }

    fun setNonStopView() {
        tag = 0
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
        nonStopImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop_orange_img
            )
        )
        intervalImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_img
            )
        )
        scheduleImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_icon
            )
        )
    }

    fun setIntervalView() {
        tag = 1
        mistTv.visibility = View.VISIBLE
        mistValue.visibility = View.VISIBLE
        suspendTv.visibility = View.VISIBLE
        suspendValue.visibility = View.VISIBLE
        btnEdit.visibility = View.VISIBLE
        secondLine.visibility = View.VISIBLE
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        nonStopImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop
            )
        )
        intervalImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_orange_img
            )
        )
        scheduleImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_icon
            )
        )
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.orange_circle)
        )
        guideline.setGuidelinePercent(0.65f)
    }

    fun setScheduleView() {
        tag = 2
        mistTv.visibility = View.VISIBLE
        mistValue.visibility = View.VISIBLE
        suspendTv.visibility = View.VISIBLE
        suspendValue.visibility = View.VISIBLE
        btnEdit.visibility = View.VISIBLE
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        nonStopImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop
            )
        )
        intervalImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_img
            )
        )
        scheduleImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_orange_img
            )
        )
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
        )
        guideline.setGuidelinePercent(0.65f)
    }

    fun startAnimation() {
        motionLayout.transitionToEnd()
        motionLayout.transitionToStart()
        when (tag) {
            0 -> {
                tabName.text = resources.getString(R.string.non_stop)
                tab_icon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.non_stop_blue
                    )
                )
            }
            1 -> {
                tabName.text = resources.getString(R.string.interval)
                tab_icon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.interval_blue
                    )
                )
            }
            2 -> {
                tabName.text = resources.getString(R.string.schedule)
                tab_icon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.calendar_icon
                    )
                )
            }
        }
        if (intervalImg.visibility == View.VISIBLE) {
            setTabItemVisibility(true)
        } else {
            setTabItemVisibility(false)
        }
    }

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.setContentView(R.layout.fragment_start_global_mode_popup)
        val firstDevice = dialog.findViewById(R.id.firstDevice) as TextView
        val secondDevice = dialog.findViewById(R.id.secondDevice) as TextView
        val thirdDevice = dialog.findViewById(R.id.thirdDevice) as TextView
        val fourthDevice = dialog.findViewById(R.id.fourthDevice) as TextView
        val subTitle = dialog.findViewById(R.id.subTitle) as TextView
        val startBtn = dialog.findViewById(R.id.startBtn) as TextView
        val noBtn = dialog.findViewById(R.id.cancelBtn) as TextView
        if (tag == 0) {
            subTitle.text = resources.getString(R.string.start_global_mode)
        }
        if (tag == 1) {
            subTitle.text = resources.getString(R.string.device_are_offline)
        }
        startBtn.setOnClickListener {
            startAnimation()
            dialog.dismiss()
        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    private fun navigateToSetSchedule() {
        findNavController().navigate(R.id.action_schedule_to_set_schedule_fragment)
    }

}


