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
import kotlinx.android.synthetic.main.fragment_devices.btnAddNewDevice
import kotlinx.android.synthetic.main.fragment_devices.firstCardView
import kotlinx.android.synthetic.main.fragment_devices.firstDeviceName
import kotlinx.android.synthetic.main.fragment_devices.firstDeviceState
import kotlinx.android.synthetic.main.fragment_devices.firstDotColor
import kotlinx.android.synthetic.main.fragment_devices.firstInfoDots
import kotlinx.android.synthetic.main.fragment_devices.firstPopup
import kotlinx.android.synthetic.main.fragment_devices.fourthCardView
import kotlinx.android.synthetic.main.fragment_devices.fourthDeviceName
import kotlinx.android.synthetic.main.fragment_devices.fourthDeviceState
import kotlinx.android.synthetic.main.fragment_devices.fourthDotColor
import kotlinx.android.synthetic.main.fragment_devices.fourthInfoDots
import kotlinx.android.synthetic.main.fragment_devices.fourthPopup
import kotlinx.android.synthetic.main.fragment_devices.mainLayout
import kotlinx.android.synthetic.main.fragment_devices.removeFirstDevice
import kotlinx.android.synthetic.main.fragment_devices.removeFourthDevice
import kotlinx.android.synthetic.main.fragment_devices.removeSecondDevice
import kotlinx.android.synthetic.main.fragment_devices.removeThirdDevice
import kotlinx.android.synthetic.main.fragment_devices.renameFirstDevice
import kotlinx.android.synthetic.main.fragment_devices.renameFourthDevice
import kotlinx.android.synthetic.main.fragment_devices.renameSecondDevice
import kotlinx.android.synthetic.main.fragment_devices.renameThirdDevice
import kotlinx.android.synthetic.main.fragment_devices.secondCardView
import kotlinx.android.synthetic.main.fragment_devices.secondDeviceName
import kotlinx.android.synthetic.main.fragment_devices.secondDeviceState
import kotlinx.android.synthetic.main.fragment_devices.secondDotColor
import kotlinx.android.synthetic.main.fragment_devices.secondInfoDots
import kotlinx.android.synthetic.main.fragment_devices.secondPopup
import kotlinx.android.synthetic.main.fragment_devices.thirdCardView
import kotlinx.android.synthetic.main.fragment_devices.thirdDeviceName
import kotlinx.android.synthetic.main.fragment_devices.thirdDeviceState
import kotlinx.android.synthetic.main.fragment_devices.thirdDotColor
import kotlinx.android.synthetic.main.fragment_devices.thirdInfoDots
import kotlinx.android.synthetic.main.fragment_devices.thirdPopup
import llc.aerMist.app.R
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.models.ScheduleModel
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.RemoveDevicePopup
import llc.aerMist.app.ui.popup.RenameDevicePopup
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
    private lateinit var renameDeviceDialog: RenameDevicePopup
    private lateinit var removeDevicePopup: RemoveDevicePopup
    var firstDeviceNewName: String = ""
    var secondDeviceNewName: String = ""
    var thirdDeviceNewName: String = ""
    var fourthDeviceNewName: String = ""

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        deviceTotalNumber =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        if (deviceTotalNumber > 0) {
            bleList =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
        }
        if (deviceTotalNumber == 4) {
            btnAddNewDevice.visibility = View.INVISIBLE
        }
        totalDeviceNumber.text = deviceTotalNumber.toString() + "/4 devices"

        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
        setClickListener()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_devices, container, false)
    }

    fun showRenameDialog(positon: Int, name: String) {
        renameDeviceDialog = RenameDevicePopup(positon, name)
        renameDeviceDialog.isCancelable = false
        renameDeviceDialog.show(childFragmentManager, "")
    }

    fun showRemoveDialog(positon: Int, name: String) {
        removeDevicePopup = RemoveDevicePopup(positon, name)
        removeDevicePopup.isCancelable = false
        removeDevicePopup.show(childFragmentManager, "")
    }


    fun setFirstDevice() {
        val deviceOne = prefs.firstDevice
        if (deviceOne.length > 1) {
            firstCardView.visibility = View.VISIBLE
            val gson = Gson()
            val deviceOneObj: MyDevice
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDeviceName.text = deviceOneObj.newName
            firstDeviceNewName = deviceOneObj.newName
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
            secondDeviceNewName = deviceTwoObj.newName
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
            thirdDeviceNewName = deviceThreeObj.newName
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
            fourthDeviceNewName = deviceFourObj.newName
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
    }

    fun setClickListener() {
        firstClickView.setOnClickListener(this)
        firstInfoDots.setOnClickListener(this)
        secondClickView.setOnClickListener(this)
        secondInfoDots.setOnClickListener(this)
        thirdClickView.setOnClickListener(this)
        thirdInfoDots.setOnClickListener(this)
        fourthClickView.setOnClickListener(this)
        fourthInfoDots.setOnClickListener(this)
        renameFirstDevice.setOnClickListener(this)
        renameSecondDevice.setOnClickListener(this)
        renameThirdDevice.setOnClickListener(this)
        renameFourthDevice.setOnClickListener(this)
        removeFirstDevice.setOnClickListener(this)
        removeSecondDevice.setOnClickListener(this)
        removeThirdDevice.setOnClickListener(this)
        removeFourthDevice.setOnClickListener(this)
        mainLayout.setOnClickListener(this)
        btnAddNewDevice.setOnClickListener(this)
    }

    override fun onClick(id: View?) {
        when (id) {
            firstClickView -> {
                navigateToDevice(firstDevicePostion, isFirstConnected)
            }
            firstInfoDots -> {
                // navigateToDevice(firstDevicePostion, isFirstConnected)
                Log.e("D", "KLIKNUTO NA TACKE")
                firstPopup.visibility = View.VISIBLE
            }
            secondClickView -> {
                navigateToDevice(secondDevicePosition, isSecondConnected)
            }
            secondInfoDots -> {
                secondPopup.visibility = View.VISIBLE
            }

            thirdClickView -> {
                navigateToDevice(thirdDevicePosition, isThirdConnected)
            }
            thirdInfoDots -> {
                thirdPopup.visibility = View.VISIBLE
            }
            fourthClickView -> {
                navigateToDevice(fourthDevicePosition, isFourthConnected)
            }
            fourthInfoDots -> {
                fourthPopup.visibility = View.VISIBLE
            }
            renameFirstDevice -> {
                showRenameDialog(0, firstDeviceNewName)
            }
            renameSecondDevice -> {
                showRenameDialog(1, secondDeviceNewName)
            }
            renameThirdDevice -> {
                showRenameDialog(2, thirdDeviceNewName)
            }
            renameFourthDevice -> {
                showRenameDialog(3, fourthDeviceNewName)
            }
            removeFirstDevice -> {
                showRemoveDialog(0, firstDeviceNewName)
            }
            removeSecondDevice -> {
                showRemoveDialog(1, secondDeviceNewName)
            }
            removeThirdDevice -> {
                showRemoveDialog(2, thirdDeviceNewName)
            }
            removeFourthDevice -> {
                showRemoveDialog(3, fourthDeviceNewName)
            }
            mainLayout -> {
                firstPopup.visibility = View.GONE
                secondPopup.visibility = View.GONE
                thirdPopup.visibility = View.GONE
                fourthPopup.visibility = View.GONE
            }
            btnAddNewDevice -> {
                navigateToSearchFragment()
            }
        }
    }

    private fun navigateToDevice(postion: Int, isConnected: Boolean) {
        if (isConnected) {
            val model: ScheduleModel = ScheduleModel(null, null, null, null, null)
            val action =
                MenageDevicesFragmentDirections.actionMenageDevicesToSetDevice(postion, model)
            findNavController().navigate(action)
        }
    }

    private fun navigateToSearchFragment() {

        findNavController().navigate(R.id.action_menage_devices_to_search_device)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val data = data?.extras

                    val name = data?.getString("name")
                    val isDeleted = data?.getBoolean("isDeleted", false)
                    val position = data?.getInt("position", 0)
                    when (position) {
                        0 -> {
                            firstDeviceName.text = name
                            firstDeviceNewName = name.toString()
                            firstPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                firstCardView.visibility = View.GONE
                                deviceTotalNumber=deviceTotalNumber-1
                                totalDeviceNumber.text = deviceTotalNumber.toString() + "/4 devices"

                            }
                        }
                        1 -> {
                            secondDeviceName.text = name
                            secondDeviceNewName = name.toString()
                            secondPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                secondCardView.visibility = View.GONE
                                deviceTotalNumber=deviceTotalNumber-1
                                totalDeviceNumber.text = deviceTotalNumber.toString() + "/4 devices"
                            }
                        }
                        2 -> {
                            thirdDeviceName.text = name
                            thirdDeviceNewName = name.toString()
                            thirdPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                thirdCardView.visibility = View.GONE
                                deviceTotalNumber=deviceTotalNumber-1
                                totalDeviceNumber.text = deviceTotalNumber.toString() + "/4 devices"
                            }
                        }
                        3 -> {
                            fourthDeviceName.text = name
                            fourthDeviceNewName = name.toString()
                            fourthPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                fourthCardView.visibility = View.GONE
                                deviceTotalNumber=deviceTotalNumber-1
                                totalDeviceNumber.text = deviceTotalNumber.toString() + "/4 devices"
                            }
                        }
                    }
                }
            }
        }
    }

}