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
import androidx.navigation.fragment.navArgs
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_set_device.*
import kotlinx.android.synthetic.main.fragment_set_schedule.*
import kotlinx.android.synthetic.main.fragment_set_schedule.mistTv
import kotlinx.android.synthetic.main.fragment_set_schedule.suspendTv
import kotlinx.android.synthetic.main.fragment_set_schedule.suspendValue
import llc.aerMist.app.R
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.models.ScheduleModel
import llc.aerMist.app.models.TimerModel
import llc.aerMist.app.shared.kotlin.hideWithAnimation
import llc.aerMist.app.shared.kotlin.showWithAnimation
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.devices.SetDeviceFragmentArgs
import llc.aerMist.app.ui.popup.NumberPickerPopup
import llc.aerMist.app.ui.popup.SetTimePopup
import org.koin.android.ext.android.inject

class SetScheduleFragment : Fragment(), View.OnClickListener {
    private val args: SetScheduleFragmentArgs by navArgs()

    var numberPickerPopup = NumberPickerPopup()
    private var scheduleModel: ScheduleModel? = null
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
    var firstTimer: TimerModel = TimerModel("00", "00", "")
    var secondTimer: TimerModel = TimerModel("00", "00", "")
    var thirdTimmer: TimerModel = TimerModel("00", "00", "")
    var fourtTimmer: TimerModel = TimerModel("00", "00", "")
    var fifthTimmer: TimerModel = TimerModel("00", "00", "")
    var sixthTimmer: TimerModel = TimerModel("00", "00", "")
    var seventhTimmer: TimerModel = TimerModel("00", "00", "")
    var eightTimmer: TimerModel = TimerModel("00", "00", "")
    var firstTimer2: TimerModel = TimerModel("00", "00", "")
    var secondTimer2: TimerModel = TimerModel("00", "00", "")
    var thirdTimmer2: TimerModel = TimerModel("00", "00", "")
    var fourtTimmer2: TimerModel = TimerModel("00", "00", "")
    var fifthTimmer2: TimerModel = TimerModel("00", "00", "")
    var sixthTimmer2: TimerModel = TimerModel("00", "00", "")
    var seventhTimmer2: TimerModel = TimerModel("00", "00", "")
    var eightTimmer2: TimerModel = TimerModel("00", "00", "")
    var type = 0
    var deviceName = ""
    var nonStop=false
    private val prefs: PreferenceCache by inject()
    private lateinit var deviceObject: MyDevice
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
        type = args.type
        deviceName = args.name
        scheduleModel = args.model
        Log.e("D", "scheduleModel " + scheduleModel)

        if (scheduleModel == null && type == 0) {
            setScheduleView2()
        } else {
            scheduleModel?.let { setScheduleView(it) }

        }
        //scheduleModel?.let { setScheduleView(it) }
    }

    private fun setScheduleView2() {

        val deviceOne = prefs.firstDevice
        val gson = Gson()
        val deviceObjectOne = gson.fromJson(deviceOne, MyDevice::class.java)
        val deviceTwo = prefs.secondDevice
        val deviceObjectTwo = gson.fromJson(deviceTwo, MyDevice::class.java)
        val deviceThree = prefs.thirdDevice
        val deviceObjectThree = gson.fromJson(deviceThree, MyDevice::class.java)
        val deviceFour = prefs.fourthDevice
        val deviceObjectFour = gson.fromJson(deviceFour, MyDevice::class.java)
        if (deviceName == deviceObjectOne?.name) {
            if (!deviceOne.isNullOrEmpty()) {
                deviceObject =
                    gson.fromJson(deviceOne, MyDevice::class.java)
            }
        } else if (deviceName == deviceObjectTwo?.name) {
            if (!deviceTwo.isNullOrEmpty()) {
                deviceObject =
                    gson.fromJson(deviceTwo, MyDevice::class.java)
            }
        } else if (deviceName == deviceObjectThree?.name) {
            if (!deviceThree.isNullOrEmpty()) {
                deviceObject = gson.fromJson(deviceThree, MyDevice::class.java)
            }
        } else if (deviceName == deviceObjectFour?.name) {
            if (!deviceFour.isNullOrEmpty()) {
                deviceObject =
                    gson.fromJson(deviceFour, MyDevice::class.java)
            }
        }
        val firstStart = deviceObject.firstStartTime
        val firstEnd = deviceObject.firstStopTime
        val secondStart = deviceObject.secondStartTime
        val secondEnd = deviceObject.secondStopTime
        val thirdStart = deviceObject.thirdStartTime
        val thirdEnd = deviceObject.thirdStopTime
        val fourtStart = deviceObject.fourtStartTime
        val fourtEnd = deviceObject.fourtStopTime
        Log.e("D", "firstStart " + firstStart)
        Log.e("d", "secondStart " + secondStart)
        Log.e("d", "secondEnd " + secondEnd)
        Log.e("f", "fourtStart " + fourtStart)

        if (firstStart.length == 4 && firstStart != "0000") {
            startTimeValue.text =
                setTimeZone2(firstStart, 1)
        }
        if (firstEnd.length == 4 && firstEnd != "0000") {
            stopTimeValue.text =
                setTimeZone2(firstEnd, 2)
        }
        if (secondStart.length == 4 && secondStart != "0000" && secondEnd.length == 4 && secondEnd != "0000") {
            secondStartTimeValue.text =
                setTimeZone2(secondStart, 3)
            secondStopTimeValue.text =
                setTimeZone2(secondEnd, 4)
            secondStartTimeValue?.visibility = View.VISIBLE
            secondStopTimeValue?.visibility = View.VISIBLE
            closeSecondTimer.visibility = View.VISIBLE
        }
        if (thirdStart.length == 4 && thirdStart != "0000" && thirdEnd.length == 4 && thirdEnd != "0000") {
            thirdStartTimeValue.text =
                setTimeZone2(thirdStart, 5)
            thirdStopTimerValue.text =
                setTimeZone2(thirdEnd, 6)
            thirdStartTimeValue?.visibility = View.VISIBLE
            thirdStopTimerValue?.visibility = View.VISIBLE
            closeThirdTimer.visibility = View.VISIBLE
        }
        if (fourtStart.length == 4 && fourtStart != "0000" && fourtEnd.length == 4 && fourtEnd != "0000") {
            fourthStartTimeValue.text =
                setTimeZone2(fourtStart, 7)
            fourthStopTimeValue.text =
                setTimeZone2(fourtEnd, 8)
            fourthStartTimeValue?.visibility = View.VISIBLE
            fourthStopTimeValue?.visibility = View.VISIBLE
            closeFourthTimer.visibility = View.VISIBLE
        }
//        if (thirdStart.length == 4 && thirdStart != "0000")
//        {
//            thirdTimerTv.text =
//                setTimeZone2(thirdStart) + "-" + setTimeZone2(thirdEnd)
//        }
//        if (fourtStart.length == 4 && fourtStart != "0000")
//        {
//            fourthTimerTv2.text =
//                setTimeZone2(fourtStart) + "-" + setTimeZone2(fourtEnd)
//        }
        mistTimeValue.text = getTimeFromSeconds(deviceObject.mistTime)
        suspendValue.text = getTimeFromSeconds(deviceObject.suspendTime)
        getActiveDays()
    }

    fun getTimeFromSeconds(seconds: String): String {
        var time = "5s"
        when (seconds) {
            "005" -> time = "5s"
            "006" -> time = "6s"
            "007" -> time = "7s"
            "008" -> time = "8s"
            "009" -> time = "9s"
            "010" -> time = "10s"
            "011" -> time = "11s"
            "012" -> time = "12s"
            "013" -> time = "13s"
            "014" -> time = "14s"
            "015" -> time = "15s"
            "016" -> time = "16s"
            "017" -> time = "17s"
            "018" -> time = "18s"
            "019" -> time = "19s"
            "020" -> time = "20s"
            "025" -> time = "25s"
            "030" -> time = "30s"
            "035" -> time = "35s"
            "045" -> time = "40s"
            "050" -> time = "50s"
            "055" -> time = "55s"
            "060" -> time = "1m"
            "090" -> time = "1m 30s"
            "120" -> time = "2m"
            "150" -> time = "2m 30s"
            "180" -> time = "3m"
            "210" -> time = "3m 30s"
            "240" -> time = "4m"
            "270" -> time = "4m 30s"
            "300" -> time = "5m"
            "330" -> time = "5m 30s"
            "360" -> time = "6m"
            "390" -> time = "6m 30s"
            "420" -> time = "7m"
            "450" -> time = "7m 30s"
            "480" -> time = "8m"
            "510" -> time = "8m 30s"
            "540" -> time = "9m"
            "570" -> time = "9m 30s"
            "600" -> time = "10m"
            "630" -> time = "10m 30s"
            "660" -> time = "11m"
            "690" -> time = "11m 30s"
            "720" -> time = "12m"
            "750" -> time = "12m 30s"
            "780" -> time = "13m"
            "810" -> time = "13m 30s"
            "840" -> time = "14m"
            "870" -> time = "14m 30s"
            "900" -> time = "15m"
        }
        return time
    }

    fun setTimeZone2(time: String, position: Int): String {
        var fullTime = ""
        var zone = "am"
        Log.e("D", "TIME ZOVNE " + time)
        if (time.length == 4) {
            Log.e("D", "TIME ZOVNE ULAZI " + time)

            var hour = time.substring(0, 2).toIntOrNull()
            var min = time.substring(2, 4).toIntOrNull()
            hour?.let { min?.let { it1 -> formatTime(it, it1, position) } }
            if (hour != null) {
                if (hour < 12) {
                    zone = "am"
                } else {
                    hour = hour - 12
                    zone = "pm"
                }
            }
            if (hour != null && min != null) {
                fullTime = hour.toString() + ":" + min + zone
            }
        }
        return fullTime
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
                thirdTimmer = TimerModel("00", "00", "")
                fourtTimmer = TimerModel("00", "00", "")

            }
            closeThirdTimer -> {
                thirdStartTimeValue.visibility = View.GONE
                thirdMiddleLine.visibility = View.GONE
                thirdStopTimerValue.visibility = View.GONE
                closeThirdTimer.visibility = View.GONE
                addTimerBtn.visibility = View.VISIBLE
                numberOfOpenTimers = numberOfOpenTimers - 1
                fifthTimmer = TimerModel("00", "00", "")
                sixthTimmer = TimerModel("00", "00", "")

            }
            closeFourthTimer -> {
                fourthStartTimeValue.visibility = View.GONE
                fourthMiddleLine.visibility = View.GONE
                fourthStopTimeValue.visibility = View.GONE
                closeFourthTimer.visibility = View.GONE
                addTimerBtn.visibility = View.VISIBLE
                numberOfOpenTimers = numberOfOpenTimers - 1
                seventhTimmer = TimerModel("00", "00", "")
                eightTimmer = TimerModel("00", "00", "")
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
                    listOf<TimerModel>(
                        firstTimer,
                        secondTimer,
                        thirdTimmer,
                        fourtTimmer,
                        fifthTimmer,
                        sixthTimmer,
                        seventhTimmer,
                        eightTimmer
                    )
                val timerList2 =
                    listOf<TimerModel>(
                        firstTimer2,
                        secondTimer2,
                        thirdTimmer2,
                        fourtTimmer2,
                        fifthTimmer2,
                        sixthTimmer2,
                        seventhTimmer2,
                        eightTimmer
                    )
                val isNonSton = radioBtnNS.isChecked
                Log.e("d","isNonSton "+isNonSton)
                val model = ScheduleModel(numbers, timerList, timerList2, isNonSton, mist, suspend)
                if (type == 0) {

                    var action =
                        SetScheduleFragmentDirections.actionSetScheduleToDeviceFragmnent(
                            deviceName,
                            model
                        )
                    findNavController().navigate(action)
                } else if (type == 1) {
                    val action =
                        SetScheduleFragmentDirections.actionSetScheduleToHomeFragment(model)
                    findNavController().navigate(action)
                }
                //
            }
        }
    }

    private fun navigateToMain() {
        if (type == 1) {
            findNavController().navigate(R.id.action_set_schedule_to_home_fragment)
        } else {
            val model = ScheduleModel()
            var action =
                SetScheduleFragmentDirections.actionSetScheduleToDeviceFragmnent(
                    deviceName,
                    model
                )
            findNavController().navigate(action)

        }
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
                    Log.e("d", "sat " + hour)
                    if (hour != null && minutes != null && position != null) {
                        formatTime(hour, minutes, position)
                    }
                }
            }
        }
    }

    fun formatTime(hour: Int, min: Int, position: Int) {
        var hour = hour
        var hour2 = hour
        var hour2ToSend = ""
        var format = "am"
        var setMin = min.toString()
        if (hour == 0) {
            hour += 12
        } else if (hour > 12) {
            hour -= 12
            format = "pm"
        }
        var setHour = hour.toString()
        if (hour < 10) {
            setHour = "0" + hour
        }
        if (hour2 == 0) {
            hour2 += 12
        }
        hour2ToSend = hour2.toString()
        if (hour2 < 10) {
            hour2ToSend = "0" + hour2
        }
        if (min < 10) {
            setMin = "0" + min
        }

        when (position) {
            1 -> {
                startTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(format)
                )
                firstTimer = TimerModel(setHour, setMin, format)
                firstTimer2 = TimerModel(hour2ToSend, setMin, format)
            }
            2 -> {
                stopTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(format)
                )
                secondTimer = TimerModel(setHour, setMin, format)
                secondTimer2 = TimerModel(hour2ToSend, setMin, format)
            }
            3 -> {
                secondStartTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(format)
                )
                thirdTimmer = TimerModel(setHour, setMin, format)
                thirdTimmer2 = TimerModel(hour2ToSend, setMin, format)
            }
            4 -> {
                secondStopTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(format)
                )
                fourtTimmer = TimerModel(setHour, setMin, format)
                fourtTimmer2 = TimerModel(hour2ToSend, setMin, format)
            }
            5 -> {
                thirdStartTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                        .append(format)
                )
                fifthTimmer = TimerModel(setHour, setMin, format)
                fifthTimmer2 = TimerModel(hour2ToSend, setMin, format)

            }
            6 -> {
                thirdStopTimerValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                        .append(format)
                )
                sixthTimmer = TimerModel(setHour, setMin, format)
                sixthTimmer2 = TimerModel(hour2ToSend, setMin, format)
            }
            7 -> {
                fourthStartTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                        .append(format)
                )
                seventhTimmer = TimerModel(setHour, setMin, format)
                seventhTimmer2 = TimerModel(hour2ToSend, setMin, format)

            }
            8 -> {
                fourthStopTimeValue.setText(
                    StringBuilder().append(setHour).append(" : ").append(setMin).append(" ")
                        .append(format)
                )
                eightTimmer = TimerModel(setHour, setMin, format)
                eightTimmer2 = TimerModel(hour2ToSend, setMin, format)
            }
        }
    }

    fun setScheduleView(model: ScheduleModel) {

        val firstStart =
            model.timer?.get(0)?.hours + ":" + model.timer?.get(0)?.min + model.timer?.get(0)?.format
        val firstStop =
            model.timer?.get(1)?.hours + ":" + model.timer?.get(1)?.min + model.timer?.get(1)?.format
        val secondStart =
            model.timer?.get(2)?.hours + ":" + model.timer?.get(2)?.min + model.timer?.get(2)?.format
        val secondStop =
            model.timer?.get(3)?.hours + ":" + model.timer?.get(3)?.min + model.timer?.get(3)?.format
        val thirdStart =
            model.timer?.get(4)?.hours + ":" + model.timer?.get(4)?.min + model.timer?.get(4)?.format
        val thirdStop =
            model.timer?.get(5)?.hours + ":" + model.timer?.get(5)?.min + model.timer?.get(5)?.format
        val fourthStart =
            model.timer?.get(6)?.hours + ":" + model.timer?.get(6)?.min + model.timer?.get(6)?.format
        val fourthStop =
            model.timer?.get(7)?.hours + ":" + model.timer?.get(7)?.min + model.timer?.get(7)?.format
        firstTimer = model.timer?.get(0)?.format?.let {
            TimerModel(
                model.timer?.get(0)?.hours, model.timer?.get(0)?.min,
                it
            )
        }!!
        secondTimer = model.timer?.get(1)?.format?.let {
            TimerModel(
                model.timer?.get(1)?.hours, model.timer?.get(1)?.min,
                it
            )
        }
        thirdTimmer = model.timer?.get(2)?.format?.let {
            TimerModel(
                model.timer?.get(2)?.hours, model.timer?.get(2)?.min,
                it
            )
        }
        fourtTimmer = model.timer?.get(3)?.format?.let {
            TimerModel(
                model.timer?.get(3)?.hours, model.timer?.get(3)?.min,
                it
            )
        }
        fifthTimmer = model.timer?.get(4)?.format?.let {
            TimerModel(
                model.timer?.get(4)?.hours, model.timer?.get(4)?.min,
                it
            )
        }
        sixthTimmer = model.timer?.get(5)?.format?.let {
            TimerModel(
                model.timer?.get(5)?.hours, model.timer?.get(5)?.min,
                it
            )
        }
        seventhTimmer = model.timer?.get(6)?.format?.let {
            TimerModel(
                model.timer?.get(6)?.hours, model.timer?.get(6)?.min,
                it
            )
        }
        eightTimmer = model.timer?.get(7)?.format?.let {
            TimerModel(
                model.timer?.get(7)?.hours, model.timer?.get(7)?.min,
                it
            )
        }

        if (!firstStart.contains("null") && !firstStop.contains("null") && !firstStart.contains("00") && firstStart.length > 0) {
            Log.e("D", "OVO JE RPVI START " + firstStart)
            Log.e("D", "OVO JE RPVI firstStop " + firstStop)
            startTimeValue?.text = firstStart
            stopTimeValue?.text = firstStop

        }
        if (!secondStart.contains("null") && !secondStop.contains("null") && !secondStart.contains("00") && secondStart.length > 0) {
            Log.e("D", "OVO JE RPVI secondStart " + secondStart)
            Log.e("D", "OVO JE RPVI secondStop " + secondStop)
            secondStartTimeValue?.text = secondStart
            secondStopTimeValue?.text = secondStop
            secondStartTimeValue?.visibility = View.VISIBLE
            secondStopTimeValue?.visibility = View.VISIBLE
            closeSecondTimer?.visibility = View.VISIBLE

        }
        if (!thirdStart.contains("null") && !thirdStop.contains("null") && !thirdStart.contains("00") && thirdStart.length > 0) {
            thirdStartTimeValue?.text = thirdStart
            thirdStopTimerValue?.text = thirdStop
            thirdStartTimeValue?.visibility = View.VISIBLE
            thirdStopTimerValue?.visibility = View.VISIBLE
            closeThirdTimer?.visibility = View.VISIBLE

        }
        if (!fourthStart.contains("null") && !fourthStop.contains("null") && !fourthStart.contains("00") && fourthStart.length > 0) {
            fourthStartTimeValue?.text = fourthStart
            fourthStopTimeValue?.text = fourthStop
            fourthStartTimeValue?.visibility = View.VISIBLE
            fourthStopTimeValue?.visibility = View.VISIBLE
            closeFourthTimer?.visibility = View.VISIBLE

        }
    }



    fun getActiveDays() {

        val one = deviceObject.monday
        val two = deviceObject.tuesday
        val three = deviceObject.wednesday
        val four = deviceObject.thursday
        val five = deviceObject.friday
        val six = deviceObject.saturday
        val seven = deviceObject.saturday
        if (one == true) {
            zeroX = 0
            TextViewCompat.setTextAppearance(monday, R.style.activeDay);
            monday.setBackgroundResource(R.drawable.orange_circle)

        } else {
            zeroX = 1
            TextViewCompat.setTextAppearance(monday, R.style.nonActive);
            monday.setBackgroundResource(R.drawable.gray_circle)
        }
        if (two == true) {
            oneX = 0
            TextViewCompat.setTextAppearance(tuesday, R.style.activeDay);
            tuesday.setBackgroundResource(R.drawable.orange_circle)
        } else {
            oneX = 1
            TextViewCompat.setTextAppearance(tuesday, R.style.nonActive);
            tuesday.setBackgroundResource(R.drawable.gray_circle)
        }
        if (three == true) {
            twoX = 0
            TextViewCompat.setTextAppearance(tuesday, R.style.activeDay);
            tuesday.setBackgroundResource(R.drawable.orange_circle)
        } else {
            twoX = 1
            TextViewCompat.setTextAppearance(tuesday, R.style.nonActive);
            tuesday.setBackgroundResource(R.drawable.gray_circle)
        }
        if (four == true) {
            TextViewCompat.setTextAppearance(wednesday, R.style.activeDay);
            wednesday.setBackgroundResource(R.drawable.orange_circle)
            threeX = 0
        } else {
            TextViewCompat.setTextAppearance(wednesday, R.style.nonActive);
            wednesday.setBackgroundResource(R.drawable.gray_circle)
        }

        if (five == true) {
            fourX = 0
            TextViewCompat.setTextAppearance(friday, R.style.activeDay);
            friday.setBackgroundResource(R.drawable.orange_circle)

        } else {
            fourX = 1
            TextViewCompat.setTextAppearance(friday, R.style.nonActive);
            friday.setBackgroundResource(R.drawable.gray_circle)
        }
        if (six == true) {
            fiveX = 0
            TextViewCompat.setTextAppearance(saturday, R.style.activeDay);
            saturday.setBackgroundResource(R.drawable.orange_circle)

        } else {
            fiveX = 1
            TextViewCompat.setTextAppearance(saturday, R.style.nonActive);
            saturday.setBackgroundResource(R.drawable.gray_circle)
        }
        if (seven == true) {
            sixX = 0
            TextViewCompat.setTextAppearance(sunday, R.style.activeDay);
            sunday.setBackgroundResource(R.drawable.orange_circle)
        } else {
            sixX = 1
            TextViewCompat.setTextAppearance(sunday, R.style.nonActive);
            sunday.setBackgroundResource(R.drawable.gray_circle)
        }
        //  daysInWeek = intArrayOf(zeroX, oneX, twoX, threeX, fourX, fiveX, sixX)
    }
}