package llc.aerMist.base.ui.home.schedulere

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_set_schedule.*
import llc.aerMist.base.R
import llc.aerMist.base.ui.popup.AddDevicePopup
import llc.aerMist.base.ui.popup.NumberPickerPopup
import llc.aerMist.base.ui.popup.SetTimePopup

class SetScheduleFragment : Fragment() {

    var timePickerPopup = SetTimePopup()
    var numberPickerPopup = NumberPickerPopup()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        startTimeValue.setOnClickListener {
            setTimePicker()
        }
        wraper.setOnClickListener {
            setNumberPicker()
        }

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

}