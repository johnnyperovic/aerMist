package llc.aerMist.app.ui.home.schedulere

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.core.widget.TextViewCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_set_schedule.*
import llc.aerMist.app.R
import llc.aerMist.app.models.ScheduleModel
import llc.aerMist.app.models.TimerModel
import llc.aerMist.app.shared.kotlin.hideWithAnimation
import llc.aerMist.app.shared.kotlin.showWithAnimation
import llc.aerMist.app.ui.popup.NumberPickerPopup
import llc.aerMist.app.ui.popup.SetTimePopup

class SetScheduleFragment : Fragment(), View.OnClickListener {

    var numberPickerPopup = NumberPickerPopup()
    var numberOfOpenTimers = 1
    var zeroX = 1
    var oneX = 1
    var twoX = 1
    var threeX = 1
    var fourX = 1
    var fiveX = 1
    var sixX = 1
    var mist = "0"
    var suspend = "0"
    lateinit var numbers: IntArray
    var firstTimer: TimerModel = TimerModel("0", "0")
    var secondTimer: TimerModel = TimerModel("0", "0")
    var thirdTimmer: TimerModel = TimerModel("0", "0")
    var fourtTimmer: TimerModel = TimerModel("0", "0")
    var fifthTimmer: TimerModel = TimerModel("0", "0")
    var sixthTimmer: TimerModel = TimerModel("0", "0")
    var seventhTimmer: TimerModel = TimerModel("0", "0")
    var eightTimmer: TimerModel = TimerModel("0", "0")


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
        saveBtn.setOnClickListener(this)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_set_schedule, container, false)
    }

    fun setTimePicker(position: Int) {
        val timePickerPopup = SetTimePopup(position)
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
                    zeroX = 0
                    TextViewCompat.setTextAppearance(monday, R.style.activeDay);
                    monday.setBackgroundResource(R.drawable.orange_circle)
                    monday.setTag("true")

                } else {
                    zeroX = 1
                    TextViewCompat.setTextAppearance(monday, R.style.nonActive);
                    monday.setBackgroundResource(R.drawable.gray_circle)
                    monday.setTag("false")
                }
            }
            tuesday -> {
                if (tuesday.tag == "false") {
                    oneX = 0
                    TextViewCompat.setTextAppearance(tuesday, R.style.activeDay);
                    tuesday.setBackgroundResource(R.drawable.orange_circle)
                    tuesday.setTag("true")
                } else {
                    oneX = 1
                    TextViewCompat.setTextAppearance(tuesday, R.style.nonActive);
                    tuesday.setBackgroundResource(R.drawable.gray_circle)
                    tuesday.setTag("false")
                }
            }
            wednesday -> {
                if (wednesday.tag == "false") {
                    twoX = 0
                    TextViewCompat.setTextAppearance(wednesday, R.style.activeDay);
                    wednesday.setBackgroundResource(R.drawable.orange_circle)
                    wednesday.setTag("true")
                } else {
                    twoX = 1
                    TextViewCompat.setTextAppearance(wednesday, R.style.nonActive);
                    wednesday.setBackgroundResource(R.drawable.gray_circle)
                    wednesday.setTag("false")
                }
            }
            thursday -> {
                if (thursday.tag == "false") {
                    threeX = 0
                    TextViewCompat.setTextAppearance(thursday, R.style.activeDay);
                    thursday.setBackgroundResource(R.drawable.orange_circle)
                    thursday.setTag("true")
                } else {
                    threeX = 1
                    TextViewCompat.setTextAppearance(thursday, R.style.nonActive);
                    thursday.setBackgroundResource(R.drawable.gray_circle)
                    thursday.setTag("false")
                }
            }
            friday -> {
                if (friday.tag == "false") {
                    fourX = 0
                    TextViewCompat.setTextAppearance(friday, R.style.activeDay);
                    friday.setBackgroundResource(R.drawable.orange_circle)
                    friday.setTag("true")
                } else {
                    fourX = 1
                    TextViewCompat.setTextAppearance(friday, R.style.nonActive);
                    friday.setBackgroundResource(R.drawable.gray_circle)
                    friday.setTag("false")
                }
            }
            saturday -> {
                if (saturday.tag == "false") {
                    fiveX = 0
                    TextViewCompat.setTextAppearance(saturday, R.style.activeDay);
                    saturday.setBackgroundResource(R.drawable.orange_circle)
                    saturday.setTag("true")
                } else {
                    fiveX = 1
                    TextViewCompat.setTextAppearance(saturday, R.style.nonActive);
                    saturday.setBackgroundResource(R.drawable.gray_circle)
                    saturday.setTag("false")
                }
            }
            sunday -> {
                if (sunday.tag == "false") {
                    sixX = 0
                    TextViewCompat.setTextAppearance(sunday, R.style.activeDay);
                    sunday.setBackgroundResource(R.drawable.orange_circle)
                    sunday.setTag("true")
                } else {
                    sixX = 1
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
                setTimePicker(1)
            }
            stopTimeValue -> {
                setTimePicker(2)
            }
            secondStartTimeValue -> {
                setTimePicker(3)
            }
            secondStopTimeValue -> {
                setTimePicker(4)
            }
            thirdStartTimeValue -> {
                setTimePicker(5)
            }
            thirdStopTimerValue -> {
                setTimePicker(6)
            }
            fourthStartTimeValue -> {
                setTimePicker(7)
            }
            fourthStopTimeValue -> {
                setTimePicker(8)
            }
            radioBtnNS -> {
                val isCheck = radioBtnNS.isChecked
                if (isCheck) {
                    mistTv.hideWithAnimation()
                    suspendTv.hideWithAnimation()
                    wraper.hideWithAnimation()
                    mistTimeValue.hideWithAnimation()
                    middleLineTwo.hideWithAnimation()
                    suspendValue.hideWithAnimation()
                }
            }
            radioBtnInterval -> {
                val isCheck = radioBtnInterval.isChecked
                if (isCheck) {
                    mistTv.showWithAnimation()
                    suspendTv.showWithAnimation()
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
            cancelBtn -> {
                navigateToMain()
            }
            saveBtn -> {
                numbers = intArrayOf(zeroX, oneX, twoX, threeX, fourX, fiveX, sixX)
                val timerList =
                    listOf<TimerModel>(firstTimer, secondTimer, thirdTimmer, fourtTimmer,fifthTimmer,sixthTimmer,seventhTimmer,eightTimmer)
                val isNonSton = radioBtnNS.isChecked
                val model = ScheduleModel(numbers, timerList, isNonSton, mist, suspend)
                val action=SetScheduleFragmentDirections.actionSetScheduleToDeviceFragmnent(0,model)
                findNavController().navigate(action)
            }
        }
    }

    private fun navigateToMain() {
        findNavController().navigate(R.id.action_set_schedule_to_home_fragment)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val data = data?.extras
                    Log.e("D", "data " + data)

                    mist = data?.getString("mist").toString()
                    suspend = data?.getString("suspend").toString()
                    mistTimeValue.text = mist
                    suspendValue.text = suspend
                }
            }
            3 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val data = data?.extras
                    Log.e("D", "data " + data)

                    val position = data?.getInt("position")
                    val hour = data?.getInt("hour")
                    val minutes = data?.getInt("minutes")
                    if (hour != null && minutes != null && position != null) {
                        formatTime(hour, minutes, position)
                    }
                }
            }
        }
    }

    fun formatTime(hour: Int, min: Int, position: Int) {
        var hour = hour
        var setMin = min.toString()
        if (hour == 0) {
            hour += 12
        } else if (hour > 12) {
            hour -= 12
        }
        var setHour = hour.toString()
        if (hour < 10) {
            setHour = "0" + hour
        }
        if (min < 10) {
            setMin = "0" + min
        }
        when (position) {
            1 -> {
                startTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                )
                firstTimer= TimerModel(setHour,setMin)
            }
            2 -> {
                stopTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                )
                secondTimer=TimerModel(setHour,setMin)
            }
            3 -> {
                secondStartTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                )
                thirdTimmer=TimerModel(setHour,setMin)
            }
            4 -> {
                secondStopTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                )
                fourtTimmer=TimerModel(setHour,setMin)
            }
            5 -> {
                thirdStartTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                )
                fifthTimmer=TimerModel(setHour,setMin)

            }
            6 -> {
                thirdStopTimerValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                )
                sixthTimmer=TimerModel(setHour,setMin)
            }
            7 -> {
                fourthStartTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                )
                seventhTimmer=TimerModel(setHour,setMin)

            }
            8 -> {
                fourthStopTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                )
                eightTimmer=TimerModel(setHour,setMin)
            }
        }

    }

}