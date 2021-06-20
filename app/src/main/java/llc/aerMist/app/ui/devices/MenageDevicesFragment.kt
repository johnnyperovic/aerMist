package llc.aerMist.app.ui.devices

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.clj.fastble.data.BleDevice
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_devices.*

import llc.aerMist.app.R
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.models.ScheduleModel
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.home.schedulere.SetScheduleFragmentDirections
import org.koin.android.ext.android.inject


class MenageDevicesFragment : Fragment(), View.OnClickListener {
    private val prefs: PreferenceCache by inject()
    private var deviceTotalNumber = 0
    private lateinit var firstBleDevice: BleDevice
    private lateinit var secondBleDevice: BleDevice
    private lateinit var thirdBleDevice: BleDevice
    private lateinit var fourthBleDevice: BleDevice
    val connectionStateCoordinator = NewObservableCoordinator
    private var bleList = ArrayList<BleDevice>()
    private var firstDevicePostion = 0
    private var isFirstConnected = false
    private var secondDevicePosition = 0
    private var isSecondConnected = false
    private var thirdDevicePosition = 0
    private var isThirdConnected = false
    private var fourthDevicePosition = 0
    private var isFourthConnected = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        deviceTotalNumber =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        if (deviceTotalNumber > 0) {
            bleList =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
        }
        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
        setClickListener()
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
            var i = 0
            for (item in bleList) {

                if (deviceOneObj.name == item.name) {
                    Log.e("D", "PRVI " + i)
                    firstDevicePostion = i
                    isFirstConnected = true
                    firstBleDevice = item
                    firstDeviceState.text = resources.getString(R.string.online)
                    firstDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.green_dot
                        )
                    )
                    return
                } else {
                    i = i + 1
                    isFirstConnected = false
                    firstDeviceState.text = resources.getString(R.string.offline)
                    firstDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
            }
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
            var i = 0
            for (item in bleList) {
                if (deviceTwoObj.name == item.name) {
                    Log.e("D", "DRugi " + i)
                    isSecondConnected = true
                    secondDevicePosition = i
                    secondBleDevice = item
                    secondDeviceState.text = resources.getString(R.string.online)
                    secondDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.green_dot
                        )
                    )
                    return
                } else {
                    i = i + 1
                    isSecondConnected = false
                    secondDeviceState.text = resources.getString(R.string.offline)
                    secondDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
            }
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
            for (item in bleList) {
                if (deviceThreeObj.name == item.name) {
                    thirdBleDevice = item
                    isThirdConnected = true
                    thirdDeviceState.text = resources.getString(R.string.online)
                    thirdDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.green_dot
                        )
                    )
                } else {
                    isThirdConnected = false
                    thirdDeviceState.text = resources.getString(R.string.offline)
                    thirdDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
            }
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
            for (item in bleList) {
                if (deviceFourObj.name == item.name) {
                    fourthBleDevice = item
                    isFourthConnected = true
                    fourthDeviceState.text = resources.getString(R.string.online)
                    fourthDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.green_dot
                        )
                    )
                } else {
                    isFourthConnected = false
                    fourthDeviceState.text = resources.getString(R.string.offline)
                    fourthDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
            }
            deviceTotalNumber = deviceTotalNumber + 1
        } else {
            fourthCardView.visibility = View.GONE
        }
        totalDeviceNumber.text = deviceTotalNumber.toString() + "/4 devices"
    }

    fun setClickListener() {
        firstCardView.setOnClickListener(this)
        secondCardView.setOnClickListener(this)
        thirdCardView.setOnClickListener(this)
        fourthCardView.setOnClickListener(this)
        btnAddNewDevice.setOnClickListener(this)
    }

    override fun onClick(id: View?) {
        when (id) {
            firstCardView -> {
                navigateToDeviceSettings(firstDevicePostion, isFirstConnected)
            }
            secondCardView -> {
                navigateToDeviceSettings(secondDevicePosition, isSecondConnected)
            }
            thirdCardView -> {
                navigateToDeviceSettings(thirdDevicePosition, isThirdConnected)
            }
            fourthCardView -> {
                navigateToDeviceSettings(fourthDevicePosition, isFourthConnected)
            }
        }
    }

    private fun navigateToDeviceSettings(postion: Int, isConnected: Boolean) {
        if (isConnected) {
            val model:ScheduleModel= ScheduleModel(null,null,null,null,null)
            val action = MenageDevicesFragmentDirections.actionMenageDevicesToSetDevice(postion,model)
            findNavController().navigate(action)
        }
    }

    private fun navigateToSearchFragment(postion: Int, isConnected: Boolean) {
        val model:ScheduleModel=ScheduleModel(null,null,null,null,null)

        val action = MenageDevicesFragmentDirections.actionMenageDevicesToSetDevice(postion,model)
        findNavController().navigate(action)
    }
}