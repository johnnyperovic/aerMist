package llc.aerMist.app.ui.devices

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_devices.*

import llc.aerMist.app.R
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import org.koin.android.ext.android.inject


class MenageDevicesFragment : Fragment() {
    private val prefs: PreferenceCache by inject()
    private var deviceTotalNumber=0
    val connectionStateCoordinator = NewObservableCoordinator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
     //   Log.e("D", "konektovani uredjaji "+connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size)
    //    Log.e("D", "konektovani uredjaji "+connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(0)?.name)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_devices, container, false)
    }
    fun setFirstDevice() {
        val deviceOne = prefs.firstDevice
        if (deviceOne.length > 1) {
            firstCardView.visibility = View.VISIBLE
            val gson = Gson()
            val deviceOneObj: MyDevice
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDeviceName.text = deviceOneObj.newName
            deviceTotalNumber = deviceTotalNumber + 1
        } else {
            firstCardView.visibility = View.GONE
        }

    }

    fun setSecondDevice() {
        val deviceTwo = prefs.secondDevice
        if (deviceTwo.length > 1) {
            secondCardView.visibility = View.VISIBLE
            val gson = Gson()
            val deviceTwoObj: MyDevice
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            secondDeviceName.text = deviceTwoObj.newName
            deviceTotalNumber = deviceTotalNumber + 1
        } else {
            secondCardView.visibility = View.GONE
        }
    }

    fun setThirdDevice() {
        val deviceThree = prefs.thirdDevice
        if (deviceThree.length > 1) {
            thirdCardView.visibility = View.VISIBLE
            val gson = Gson()
            val deviceThreeObj: MyDevice
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            thirdDeviceName.text = deviceThreeObj.newName
            deviceTotalNumber = deviceTotalNumber + 1
        } else {
            thirdCardView.visibility = View.GONE
        }
    }

    fun setFourthDevice() {
        val deviceFour = prefs.fourthDevice
        if (deviceFour.length > 1) {
            fourthCardView.visibility = View.VISIBLE
            val gson = Gson()
            val deviceFourObj: MyDevice
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            fourthDeviceName.text = deviceFourObj.newName
            deviceTotalNumber = deviceTotalNumber + 1
        } else {
            fourthCardView.visibility = View.GONE
        }
        totalDeviceNumber.text = deviceTotalNumber.toString() + "/4 devices"
    }
}