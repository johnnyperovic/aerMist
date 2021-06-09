package llc.aerMist.app.ui.home.schedulere

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.widget.TextViewCompat
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_set_schedule.*
import llc.aerMist.app.R
import llc.aerMist.app.shared.kotlin.hideWithAnimation
import llc.aerMist.app.shared.kotlin.showWithAnimation
import llc.aerMist.app.ui.popup.NumberPickerPopup
import llc.aerMist.app.ui.popup.SetTimePopup
import java.util.*

class SetScheduleFragment : Fragment(), View.OnClickListener {

    var timePickerPopup = SetTimePopup()
    var numberPickerPopup = NumberPickerPopup()
    var numberOfOpenTimers = 1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        monday.setOnClickListener(this)
        tuesday.setOnClickListener(this)
        wednesday.setOnClickListener(this)
        thursday.setOnClickListener(this)
        friday.setOnClickListener(this)
        saturday.setOnClickListener(this)
        sunday.setOnClickListener(this)
        startTimeValue.setOnClickListener(this)
        stopTimeValue.setOnClickListener(this)
        secondStartTimeValue.setOnClickListener(this)
        secondStopTimeValue.setOnClickListener(this)
        thirdStartTimeValue.setOnClickListener(this)
        thirdStopTimerValue.setOnClickListener(this)
        fourthStartTimeValue.setOnClickListener(this)
        fourthStopTimeValue.setOnClickListener(this)
        closeSecondTimer.setOnClickListener(this)
        closeThirdTimer.setOnClickListener(this)
        closeFourthTimer.setOnClickListener(this)
        addTimerBtn.setOnClickListener(this)
        radioBtnNS.setOnClickListener(this)
        radioBtnInterval.setOnClickListener(this)
        wraper.setOnClickListener(this)
        cancelBtn.setOnClickListener(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_schedule, container, false)
    }

    fun setTimePicker() {
        timePickerPopup = SetTimePopup()
        timePickerPopup.isCancelable = false
        timePickerPopup.show(childFragmentManager, "")
    }

    fun setNumberPicker() {
        numberPickerPopup = NumberPickerPopup()
        numberPickerPopup.isCancelable = false
        numberPickerPopup.show(childFragmentManager, "")
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onClick(id: View?) {

        when (id) {
            monday -> {
                if (monday.tag == "false") {
                    TextViewCompat.setTextAppearance(monday, R.style.activeDay);
                    monday.setBackgroundResource(R.drawable.orange_circle)
                    monday.setTag("true")
                } else {
                    TextViewCompat.setTextAppearance(monday, R.style.nonActive);
                    monday.setBackgroundResource(R.drawable.gray_circle)
                    monday.setTag("false")
                }
            }
            tuesday -> {
                if (tuesday.tag == "false") {
                    TextViewCompat.setTextAppearance(tuesday, R.style.activeDay);
                    tuesday.setBackgroundResource(R.drawable.orange_circle)
                    tuesday.setTag("true")
                } else {
                    TextViewCompat.setTextAppearance(tuesday, R.style.nonActive);
                    tuesday.setBackgroundResource(R.drawable.gray_circle)
                    tuesday.setTag("false")
                }
            }
            wednesday -> {
                if (wednesday.tag == "false") {
                    TextViewCompat.setTextAppearance(wednesday, R.style.activeDay);
                    wednesday.setBackgroundResource(R.drawable.orange_circle)
                    wednesday.setTag("true")
                } else {
                    TextViewCompat.setTextAppearance(wednesday, R.style.nonActive);
                    wednesday.setBackgroundResource(R.drawable.gray_circle)
                    wednesday.setTag("false")
                }
            }
            thursday -> {
                if (thursday.tag == "false") {
                    TextViewCompat.setTextAppearance(thursday, R.style.activeDay);
                    thursday.setBackgroundResource(R.drawable.orange_circle)
                    thursday.setTag("true")
                } else {
                    TextViewCompat.setTextAppearance(thursday, R.style.nonActive);
                    thursday.setBackgroundResource(R.drawable.gray_circle)
                    thursday.setTag("false")
                }
            }
            friday -> {
                if (friday.tag == "false") {
                    TextViewCompat.setTextAppearance(friday, R.style.activeDay);
                    friday.setBackgroundResource(R.drawable.orange_circle)
                    friday.setTag("true")
                } else {
                    TextViewCompat.setTextAppearance(friday, R.style.nonActive);
                    friday.setBackgroundResource(R.drawable.gray_circle)
                    friday.setTag("false")
                }
            }
            saturday -> {
                if (saturday.tag == "false") {
                    TextViewCompat.setTextAppearance(saturday, R.style.activeDay);
                    saturday.setBackgroundResource(R.drawable.orange_circle)
                    saturday.setTag("true")
                } else {
                    TextViewCompat.setTextAppearance(saturday, R.style.nonActive);
                    saturday.setBackgroundResource(R.drawable.gray_circle)
                    saturday.setTag("false")
                }
            }
            sunday -> {
                if (sunday.tag == "false") {
                    TextViewCompat.setTextAppearance(sunday, R.style.activeDay);
                    sunday.setBackgroundResource(R.drawable.orange_circle)
                    sunday.setTag("true")
                } else {
                    TextViewCompat.setTextAppearance(sunday, R.style.nonActive);
                    sunday.setBackgroundResource(R.drawable.gray_circle)
                    sunday.setTag("false")
                }
            }
            closeSecondTimer -> {
                secondStartTimeValue.visibility = View.GONE
                secondMiddleLine.visibility = View.GONE
                secondStopTimeValue.visibility = View.GONE
                closeSecondTimer.visibility = View.GONE
                addTimerBtn.visibility = View.VISIBLE
                numberOfOpenTimers = numberOfOpenTimers - 1
            }
            closeThirdTimer -> {
                thirdStartTimeValue.visibility = View.GONE
                thirdMiddleLine.visibility = View.GONE
                thirdStopTimerValue.visibility = View.GONE
                closeThirdTimer.visibility = View.GONE
                addTimerBtn.visibility = View.VISIBLE
                numberOfOpenTimers = numberOfOpenTimers - 1

            }
            closeFourthTimer -> {
                fourthStartTimeValue.visibility = View.GONE
                fourthMiddleLine.visibility = View.GONE
                fourthStopTimeValue.visibility = View.GONE
                closeFourthTimer.visibility = View.GONE
                addTimerBtn.visibility = View.VISIBLE
                numberOfOpenTimers = numberOfOpenTimers - 1
            }

            startTimeValue -> {
                setTimePicker()
            }
            stopTimeValue -> {
                setTimePicker()
            }
            radioBtnNS -> {
            val isCheck=radioBtnNS.isChecked
                if (isCheck)
                {
                    mistTv.hideWithAnimation()
                    suspend.hideWithAnimation()
                    wraper.hideWithAnimation()
                    mistTimeValue.hideWithAnimation()
                    middleLineTwo.hideWithAnimation()
                    suspendValue.hideWithAnimation()
                }
            }
            radioBtnInterval -> {
                val isCheck=radioBtnInterval.isChecked
                if (isCheck)
                {
                    mistTv.showWithAnimation()
                    suspend.showWithAnimation()
                    wraper.showWithAnimation()
                    mistTimeValue.showWithAnimation()
                    middleLineTwo.showWithAnimation()
                    suspendValue.showWithAnimation()
                }
            }

            wraper -> {
                setNumberPicker()
            }
            addTimerBtn -> {
                numberOfOpenTimers = numberOfOpenTimers + 1
                Log.e("D", "BROJ " + numberOfOpenTimers)
                if (numberOfOpenTimers == 4) {
                    addTimerBtn.visibility = View.GONE
                }
                if (closeSecondTimer.visibility == View.GONE) {
                    secondStartTimeValue.visibility = View.VISIBLE
                    secondMiddleLine.visibility = View.VISIBLE
                    secondStopTimeValue.visibility = View.VISIBLE
                    closeSecondTimer.visibility = View.VISIBLE
                    return
                } else if (closeThirdTimer.visibility == View.GONE) {
                    thirdStartTimeValue.visibility = View.VISIBLE
                    thirdMiddleLine.visibility = View.VISIBLE
                    thirdStopTimerValue.visibility = View.VISIBLE
                    closeThirdTimer.visibility = View.VISIBLE
                    return
                } else if (closeFourthTimer.visibility == View.GONE) {
                    fourthStartTimeValue.visibility = View.VISIBLE
                    fourthMiddleLine.visibility = View.VISIBLE
                    fourthStopTimeValue.visibility = View.VISIBLE
                    closeFourthTimer.visibility = View.VISIBLE
                    return
                }
            }
            cancelBtn->{
                navigateToMain()
            }
        }
    }
    private fun navigateToMain() {
        findNavController().navigate(R.id.action_set_schedule_to_home_fragment)
    }
}