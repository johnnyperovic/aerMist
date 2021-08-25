package llc.aerMist.app.ui.my_devices

import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothGatt
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.clj.fastble.BleManager
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.callback.BleNotifyCallback
import com.clj.fastble.callback.BleScanCallback
import com.clj.fastble.callback.BleWriteCallback
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
import com.clj.fastble.scan.BleScanRuleConfig
import com.google.android.gms.dynamic.IFragmentWrapper
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import kotlinx.android.synthetic.main.my_devices_fragment.*
import kotlinx.android.synthetic.main.my_devices_fragment.btnAddNewDevice
import kotlinx.android.synthetic.main.my_devices_fragment.deviceNumber
import kotlinx.android.synthetic.main.my_devices_fragment.firstCardView
import kotlinx.android.synthetic.main.my_devices_fragment.firstDeviceName
import kotlinx.android.synthetic.main.my_devices_fragment.firstDeviceState
import kotlinx.android.synthetic.main.my_devices_fragment.firstDotColor
import kotlinx.android.synthetic.main.my_devices_fragment.firstInfoDots
import kotlinx.android.synthetic.main.my_devices_fragment.firstPopup
import kotlinx.android.synthetic.main.my_devices_fragment.fourthCardView
import kotlinx.android.synthetic.main.my_devices_fragment.fourthDeviceName
import kotlinx.android.synthetic.main.my_devices_fragment.fourthDeviceState
import kotlinx.android.synthetic.main.my_devices_fragment.fourthDotColor
import kotlinx.android.synthetic.main.my_devices_fragment.fourthInfoDots
import kotlinx.android.synthetic.main.my_devices_fragment.fourthPopup
import kotlinx.android.synthetic.main.my_devices_fragment.mainLayout
import kotlinx.android.synthetic.main.my_devices_fragment.removeFirstDevice
import kotlinx.android.synthetic.main.my_devices_fragment.removeFourthDevice
import kotlinx.android.synthetic.main.my_devices_fragment.removeSecondDevice
import kotlinx.android.synthetic.main.my_devices_fragment.removeThirdDevice
import kotlinx.android.synthetic.main.my_devices_fragment.renameFirstDevice
import kotlinx.android.synthetic.main.my_devices_fragment.renameFourthDevice
import kotlinx.android.synthetic.main.my_devices_fragment.renameSecondDevice
import kotlinx.android.synthetic.main.my_devices_fragment.renameThirdDevice
import kotlinx.android.synthetic.main.my_devices_fragment.resetFirstFilter
import kotlinx.android.synthetic.main.my_devices_fragment.resetFourthFilter
import kotlinx.android.synthetic.main.my_devices_fragment.resetSecondFilter
import kotlinx.android.synthetic.main.my_devices_fragment.resetThirdFilter
import kotlinx.android.synthetic.main.my_devices_fragment.secondCardView
import kotlinx.android.synthetic.main.my_devices_fragment.secondDeviceName
import kotlinx.android.synthetic.main.my_devices_fragment.secondDeviceState
import kotlinx.android.synthetic.main.my_devices_fragment.secondDotColor
import kotlinx.android.synthetic.main.my_devices_fragment.secondInfoDots
import kotlinx.android.synthetic.main.my_devices_fragment.secondPopup
import kotlinx.android.synthetic.main.my_devices_fragment.thirdCardView
import kotlinx.android.synthetic.main.my_devices_fragment.thirdDeviceName
import kotlinx.android.synthetic.main.my_devices_fragment.thirdDeviceState
import kotlinx.android.synthetic.main.my_devices_fragment.thirdDotColor
import kotlinx.android.synthetic.main.my_devices_fragment.thirdInfoDots
import kotlinx.android.synthetic.main.my_devices_fragment.thirdPopup
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.RemoveDevicePopup
import llc.aerMist.app.ui.popup.RenameDevicePopup
import org.koin.android.ext.android.inject
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.collections.ArrayList


class MyDevicesFragment : Fragment(), View.OnClickListener {

    private val prefs: PreferenceCache by inject()
    var bluetoothController: BluetoothController? = null
    val connectionStateCoordinator = NewObservableCoordinator
    lateinit var availableDevicesList: List<BleDevice>
    var list: List<BleDevice> = ArrayList()
    var deviceTotalNumber = 0;
    var firstDevice: String = ""
    var firstDeviceNewName: String = ""
    var firstBleDevice: BleDevice? = null
    var firstGate: BluetoothGatt? = null
    var secondDevice: String = ""
    var secondDeviceNewName: String = ""
    var thirdDevice: String = ""
    var thirdDeviceNewName: String = ""
    var fourthDevice: String = ""
    var fourthDeviceNewName: String = ""
    var secondBleDevice: BleDevice? = null
    var secondGate: BluetoothGatt? = null
    var thirdBleDevice: BleDevice? = null
    var thirdGate: BluetoothGatt? = null
    var fourthBleDevice: BleDevice? = null
    var fourthGate: BluetoothGatt? = null
    val firstCommand = "EE0c0."
    var firstTimerActiv = false
    var secondTimerActiv = false
    var thirdTimerActiv = false
    var fourthTimerActiv = false

    var firstTimerActiv2 = false
    var secondTimerActiv2 = false
    var thirdTimerActiv2 = false
    var fourthTimerActiv2 = false
    var firstTimerActiv3 = false
    var secondTimerActiv3 = false
    var thirdTimerActiv3 = false
    var fourthTimerActiv3 = false
    var firstTimerActiv4 = false
    var secondTimerActiv4 = false
    var thirdTimerActiv4 = false
    var fourthTimerActiv4 = false
    private lateinit var renameDeviceDialog: RenameDevicePopup
    private lateinit var removeDevicePopup: RemoveDevicePopup
    var workingTime = ""
    var isOn = false
    var isNonStop = false
    var isSprayingMode = false
    var mondayActive = false
    var tuesdayActive = false
    var wednesdayActive = false
    var thursdayActive = false
    var fridayActive = false
    var saturdayActive = false
    var sundayActive = false
    var isSprayPerDay = false
    var isSprayFriquencu = false
    var firstStartTime: String = ""
    var secondStartTime: String = ""
    var thirdStartTime: String = ""
    var fourtStartTime: String = ""
    var firstStopTime: String = ""
    var secondStopTime: String = ""
    var thirdStopTime: String = ""
    var fourtStopTime: String = ""
    var mistTime: String = ""
    var suspendTime: String = ""
    var deviceNameValue = ""
    var time = ""
    val charset = Charsets.UTF_8
    var intervalValue = "".toByteArray(charset)
    var shortString = ""
    var shortString2 = ""
    var shortString3 = ""
    var shortString4 = ""
    var workingTime2 = ""
    var isOn2 = false
    var isNonStop2 = false
    var isSprayingMode2 = false
    var mondayActive2 = false
    var tuesdayActive2 = false
    var wednesdayActive2 = false
    var thursdayActive2 = false
    var fridayActive2 = false
    var saturdayActive2 = false
    var sundayActive2 = false
    var isSprayPerDay2 = false
    var isSprayFriquencu2 = false
    var firstStartTime2: String = ""
    var secondStartTime2: String = ""
    var thirdStartTime2: String = ""
    var fourtStartTime2: String = ""
    var firstStopTime2: String = ""
    var secondStopTime2: String = ""
    var thirdStopTime2: String = ""
    var fourtStopTime2: String = ""
    var mistTime2: String = ""
    var suspendTime2: String = ""
    var intervalValue2 = "".toByteArray(charset)
    var dateAndTimeSynch = ""

    var workingTime3 = ""
    var isOn3 = false
    var isNonStop3 = false
    var isSprayingMode3 = false
    var mondayActive3 = false
    var tuesdayActive3 = false
    var wednesdayActive3 = false
    var thursdayActive3 = false
    var fridayActive3 = false
    var saturdayActive3 = false
    var sundayActive3 = false
    var isSprayPerDay3 = false
    var isSprayFriquencu3 = false
    var firstStartTime3: String = ""
    var secondStartTime3: String = ""
    var thirdStartTime3: String = ""
    var fourtStartTime3: String = ""
    var firstStopTime3: String = ""
    var secondStopTime3: String = ""
    var thirdStopTime3: String = ""
    var fourtStopTime3: String = ""
    var mistTime3: String = ""
    var suspendTime3: String = ""
    var intervalValue3 = "".toByteArray(charset)

    var workingTime4 = ""
    var isOn4 = false
    var isNonStop4 = false
    var isSprayingMode4 = false
    var mondayActive4 = false
    var tuesdayActive4 = false
    var wednesdayActive4 = false
    var thursdayActive4 = false
    var fridayActive4 = false
    var saturdayActive4 = false
    var sundayActive4 = false
    var isSprayPerDay4 = false
    var isSprayFriquencu4 = false
    var firstStartTime4: String = ""
    var secondStartTime4: String = ""
    var thirdStartTime4: String = ""
    var fourtStartTime4: String = ""
    var firstStopTime4: String = ""
    var secondStopTime4: String = ""
    var thirdStopTime4: String = ""
    var fourtStopTime4: String = ""
    var mistTime4: String = ""
    var suspendTime4: String = ""
    var intervalValue4 = "".toByteArray(charset)
    var nameToSend = ""
    var deviceOne = ""
    lateinit var deviceOneObj: MyDevice
    var deviceTwo = ""
    lateinit var deviceTwoObj: MyDevice
    var deviceThree = ""
    lateinit var deviceThreeObj: MyDevice
    var deviceFour = ""
    lateinit var deviceFourObj: MyDevice
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.my_devices_fragment, container, false)
    }


    @SuppressLint("SetTextI18n")
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initBleConroller()

        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
        checkConnection()
        setOnClickListener()
        deviceOne = prefs.firstDevice
        deviceTwo = prefs.secondDevice
        deviceThree = prefs.thirdDevice
        deviceFour = prefs.fourthDevice

        if (!deviceOne.isNullOrEmpty()) {
            val gson = Gson()
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            nameToSend = deviceOneObj.name
        }
        if (!deviceTwo.isNullOrEmpty()) {
            val gson = Gson()
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            nameToSend = deviceTwoObj.name
        }
        if (!deviceThree.isNullOrEmpty()) {
            val gson = Gson()
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            nameToSend = deviceThreeObj.name
        }
        if (!deviceFour.isNullOrEmpty()) {
            val gson = Gson()
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            nameToSend = deviceFourObj.name
        }
        if (deviceTotalNumber > 3) {
            if (deviceTotalNumber > 3) {
                btnAddNewDevice?.visibility = View.GONE
            } else {
                if (deviceTotalNumber > 3) {
                    btnAddNewDevice?.visibility = View.VISIBLE
                }
            }
        }
        val conectedObserver = Observer<BleDevice> {
            setConnectionView(it)
        }
        val diconectedObserverOne = Observer<BleDevice> {
            connectionStateCoordinator.firstGattController?.let { it1 ->
                setDisonectViewFirst(
                    it,
                    it1
                )
            }
        }
        connectionStateCoordinator.bluetoothConnectionStateFirst.observe(
            viewLifecycleOwner,
            conectedObserver
        )
        connectionStateCoordinator.bleDisconnectDevicesFirst.observe(
            viewLifecycleOwner,
            diconectedObserverOne
        )
    }

    fun connectDevice(bleDevice: BleDevice, gattCallback: BleGattCallback) {
  //      if (connectionStateCoordinator.bluetoothController?.bluetoothManager!!.isConnected(bleDevice) == false) {
            if (bleDevice.name == deviceOneObj?.name || bleDevice.name == deviceTwoObj?.name || bleDevice.name == deviceThreeObj?.name || bleDevice.name == deviceFourObj?.name) {

                connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                    bleDevice,
                    gattCallback
                )
            }
      //  }
    }

    private fun setDisonectViewFirst(bleDevice: BleDevice, gattCallback: BleGattCallback) {
        //if (prefs.isDeleted == false) {
            connectionStateCoordinator.isDeviceConnected = false
            if (bleDevice.name == firstDevice) {
                bleDevice?.let { connectDevice(it, gattCallback) }
                firstDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
                firstDeviceState?.text = getString(R.string.offline)
                firstProgressBar?.visibility = View.GONE
                firstInfoDots?.visibility = View.VISIBLE
            }
            if (bleDevice.name == secondDevice) {
                bleDevice?.let { connectDevice(it, gattCallback) }

                secondDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
                secondDeviceState?.text = getString(R.string.offline)
                secondProgressBar?.visibility = View.GONE
                secondInfoDots?.visibility = View.VISIBLE
            }
            if (bleDevice.name == thirdDevice) {
                bleDevice?.let { connectDevice(it, gattCallback) }

                thirdDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
                thirdDeviceState?.text = getString(R.string.offline)
                thirdProgressBar?.visibility = View.GONE
                thirdInfoDots?.visibility = View.VISIBLE
            }
            if (bleDevice.name == fourthDevice) {
                bleDevice?.let { connectDevice(it, gattCallback) }

                fourthDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
                fourthDeviceState?.text = getString(R.string.offline)
                fourthProgressBar?.visibility = View.GONE
                fourthInfoDots?.visibility = View.VISIBLE
            }
//        }
//        prefs.isDeleted=false
    }

    fun checkConnection() {
        val deviceNumber =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size
        if (deviceNumber != null) {
            if (deviceNumber > 0) {
                var bleList = ArrayList<BleDevice>()
                bleList =
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
                for (item in bleList) {
                    when (item.name) {
                        firstDevice -> {
                            firstDotColor?.setImageDrawable(
                                ContextCompat.getDrawable(
                                    requireContext(),
                                    R.drawable.green_dot
                                )
                            )
                            firstDeviceState?.text = getString(R.string.online)
                            firstProgressBar?.visibility = View.GONE
                            firstInfoDots?.visibility = View.VISIBLE
                        }
                        secondDevice -> {
                            secondDotColor?.setImageDrawable(
                                ContextCompat.getDrawable(
                                    requireContext(),
                                    R.drawable.green_dot
                                )
                            )
                            secondDeviceState?.text = getString(R.string.online)
                            secondProgressBar?.visibility = View.GONE
                            secondInfoDots?.visibility = View.VISIBLE
                        }
                        thirdDevice -> {
                            thirdDotColor?.setImageDrawable(
                                ContextCompat.getDrawable(
                                    requireContext(),
                                    R.drawable.green_dot
                                )
                            )
                            thirdDeviceState?.text = getString(R.string.online)
                            thirdProgressBar?.visibility = View.GONE
                            thirdInfoDots?.visibility = View.VISIBLE
                        }
                        fourthDevice -> {
                            fourthDotColor?.setImageDrawable(
                                ContextCompat.getDrawable(
                                    requireContext(),
                                    R.drawable.green_dot
                                )
                            )
                            fourthDeviceState?.text = getString(R.string.online)
                            fourthProgressBar?.visibility = View.GONE
                            fourthInfoDots?.visibility = View.VISIBLE
                        }
                    }
                }
            }
        }
    }

    @SuppressLint("MissingPermission")
    fun initBleConroller() {

        val firstMac = prefs.firstBleDevice
        val secondMac = prefs.secondBleDevice
        val thirdMac = prefs.thirdBleDevice
        val fourthMac = prefs.fourthBleDevice
        if (firstMac.length > 0) {
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                firstMac,
                connectionStateCoordinator.firstGattController
            )
        }
        if (secondMac.length > 0) {
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                secondMac,
                connectionStateCoordinator.firstGattController
            )
        }
        if (thirdMac.length > 0) {
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                thirdMac,
                connectionStateCoordinator.firstGattController

            )
        }
        if (fourthMac.length > 0) {
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                fourthMac,
                connectionStateCoordinator.firstGattController
            )
        }
    }

    private fun navigateToAvailableDevices() {

       // if (bluetoothController?.bluetoothManager?.isBlueEnable == true) {
            try {
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.cancelScan()
            } catch (e: Exception) {
            }
            view?.post {
                findNavController().navigate(R.id.action_my_devices_to_search_devices)
            }
//        } else {
//            Log.e("D","ulazi u else")
//            val enableBluetoothIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
//            startActivityForResult(enableBluetoothIntent, 4)
//        }
    }

    private fun navigateToMain() {
        view?.post {
            findNavController().navigate(R.id.action_my_devices_to_main_fragment)
        }
    }

    fun navigateToDevice() {
        prefs.isOneDevice = true
        view?.post {
            val action = MyDevicesFragmentDirections.actionMyDevicesToDevice(nameToSend)
            findNavController().navigate(action)

        }
    }

    fun setConnectionView(bleDevicee: BleDevice) {
        Log.e("D","setConnectionView "+bleDevicee.name)

//        setFirstDevice()
//        setSecondDevice()
//        setThirdDevice()
//        setFourthDevice()
        if (bleDevicee.name == firstDevice) {
            Log.e("D","firstDevice "+firstDevice)
            firstDotColor?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.green_dot
                )
            )
            firstDeviceState?.text = getString(R.string.online)
            firstProgressBar?.visibility = View.GONE
            firstInfoDots?.visibility = View.VISIBLE
            firstBleDevice = bleDevicee

        }
        if (bleDevicee.name == secondDevice) {
            Log.e("D","secondDevice "+secondDevice)

            secondDotColor?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.green_dot
                )
            )
            secondDeviceState?.text = getString(R.string.online)
            secondProgressBar?.visibility = View.GONE
            secondInfoDots?.visibility = View.VISIBLE
            secondBleDevice = bleDevicee

        }
        if (bleDevicee.name == thirdDevice) {
            Log.e("D","thirdDevice "+thirdDevice)

            thirdDotColor?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.green_dot
                )
            )
            thirdDeviceState?.text = getString(R.string.online)
            thirdProgressBar?.visibility = View.GONE
            thirdInfoDots?.visibility = View.VISIBLE
            thirdBleDevice = bleDevicee

        }
        if (bleDevicee.name == fourthDevice) {
            fourthDotColor?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.green_dot
                )
            )
            fourthDeviceState?.text = getString(R.string.online)
            fourthProgressBar?.visibility = View.GONE
            fourthInfoDots?.visibility = View.VISIBLE
            fourthBleDevice = bleDevicee
        }
    }

    fun setFirstDevice() {
        deviceOne = prefs.firstDevice
        if (!deviceOne.isNullOrEmpty()) {
            firstCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDeviceName.text = deviceOneObj.newName
            firstDeviceNewName = deviceOneObj.newName
            firstDevice = deviceOneObj.name
            deviceTotalNumber = deviceTotalNumber + 1
            firstDeviceId.text = resources.getString(R.string.device_id) + deviceOneObj.name
        } else {
            firstCardView.visibility = View.GONE
        }
        deviceNumber.text = "$deviceTotalNumber/4 devices"
    }


    fun setSecondDevice() {
        val deviceTwo = prefs.secondDevice
        if (!deviceTwo.isNullOrEmpty()) {
            secondCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            secondDeviceName.text = deviceTwoObj.newName
            secondDeviceNewName = deviceTwoObj.newName
            secondDevice = deviceTwoObj.name
            deviceTotalNumber = deviceTotalNumber + 1
            secondDeviceId.text = resources.getString(R.string.device_id) + deviceTwoObj.name

        } else {
            secondCardView.visibility = View.GONE
        }
        deviceNumber.text = "$deviceTotalNumber/4 devices"
    }

    @SuppressLint("SetTextI18n")

    fun setThirdDevice() {
        val deviceThree = prefs.thirdDevice
        if (!deviceThree.isNullOrEmpty()) {
            thirdCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            thirdDeviceName.text = deviceThreeObj.newName
            thirdDevice = deviceThreeObj.name
            thirdDeviceNewName = deviceThreeObj.name
            deviceTotalNumber = deviceTotalNumber + 1
            thirdDeviceId?.text = resources.getString(R.string.device_id) + deviceThreeObj.name

        } else {
            thirdCardView?.visibility = View.GONE
        }
        deviceNumber?.text = "$deviceTotalNumber/4 devices"

    }

    @SuppressLint("SetTextI18n")
    fun setFourthDevice() {
        val deviceFour = prefs.fourthDevice
        if (!deviceFour.isNullOrEmpty()) {
            fourthCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            fourthDeviceName?.text = deviceFourObj.newName
            fourthDevice = deviceFourObj.name
            fourthDeviceNewName = deviceFourObj.name
            deviceTotalNumber = deviceTotalNumber + 1
            fourthDeviceId?.text = resources.getString(R.string.device_id) + deviceFourObj.name

        } else {
            fourthCardView.visibility = View.GONE
        }
        deviceNumber?.text = "$deviceTotalNumber/4 devices"
    }

    fun setOnClickListener() {
        mainLayout.setOnClickListener(this)
        firstInfoDots.setOnClickListener(this)
        firstPopup.setOnClickListener(this)
        secondInfoDots.setOnClickListener(this)
        secondPopup.setOnClickListener(this)
        thirdInfoDots.setOnClickListener(this)
        thirdPopup.setOnClickListener(this)
        fourthInfoDots.setOnClickListener(this)
        fourthPopup.setOnClickListener(this)
        btnAddNewDevice.setOnClickListener(this)
        btnDone.setOnClickListener(this)
        resetFirstFilter.setOnClickListener(this)
        renameFirstDevice.setOnClickListener(this)
        removeFirstDevice.setOnClickListener(this)
        renameSecondDevice.setOnClickListener(this)
        removeSecondDevice.setOnClickListener(this)
        resetSecondFilter.setOnClickListener(this)
        renameThirdDevice.setOnClickListener(this)
        removeThirdDevice.setOnClickListener(this)
        resetThirdFilter.setOnClickListener(this)
        renameFourthDevice.setOnClickListener(this)
        removeFourthDevice.setOnClickListener(this)
        resetFourthFilter.setOnClickListener(this)
    }

    override fun onClick(id: View?) {
        when (id) {
            btnAddNewDevice -> navigateToAvailableDevices()
            btnDone -> {
                if (deviceTotalNumber == 0) {
                    Snackbar.make(
                        requireView(),
                        "Please add one or more devices",
                        Snackbar.LENGTH_SHORT
                    ).show()
                } else {
                    if (deviceTotalNumber == 1) {
                        navigateToDevice()
                    } else {
                        navigateToMain()
                    }
                }
            }
            firstInfoDots -> {
                firstPopup.visibility = View.VISIBLE
                secondPopup.visibility = View.INVISIBLE
                thirdPopup.visibility = View.INVISIBLE
                fourthPopup.visibility = View.INVISIBLE
            }

            secondInfoDots -> {
                secondPopup.visibility = View.VISIBLE
                firstPopup.visibility = View.INVISIBLE
                thirdPopup.visibility = View.INVISIBLE
                fourthPopup.visibility = View.INVISIBLE
            }
            thirdInfoDots -> {
                thirdPopup.visibility = View.VISIBLE
                firstPopup.visibility = View.INVISIBLE
                secondPopup.visibility = View.INVISIBLE
                fourthPopup.visibility = View.INVISIBLE
            }
            fourthInfoDots -> {
                firstPopup.visibility = View.INVISIBLE
                secondPopup.visibility = View.INVISIBLE
                thirdPopup.visibility = View.INVISIBLE
                fourthPopup.visibility = View.VISIBLE
            }
            mainLayout -> {
                firstPopup.visibility = View.GONE
                secondPopup.visibility = View.GONE
                thirdPopup.visibility = View.GONE
                fourthPopup.visibility = View.GONE
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
        }
    }

    fun showRenameDialog(positon: Int, name: String) {
        renameDeviceDialog = RenameDevicePopup(positon, name)
        renameDeviceDialog.isCancelable = false
        renameDeviceDialog.show(childFragmentManager, "")
    }

    fun showRemoveDialog(positon: Int, name: String) {
        removeDevicePopup = RemoveDevicePopup(positon, name, false)
        removeDevicePopup.isCancelable = false
        removeDevicePopup.show(childFragmentManager, "")
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
                            firstDeviceName?.text = name
                            firstDeviceNewName = name.toString()
                            firstPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                firstCardView.visibility = View.GONE
                                deviceTotalNumber = deviceTotalNumber - 1
                                deviceNumber.text = "$deviceTotalNumber/4 devices"

                            }
                        }
                        1 -> {
                            secondDeviceName?.text = name
                            secondDeviceNewName = name.toString()
                            secondPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                secondCardView.visibility = View.GONE
                                deviceTotalNumber = deviceTotalNumber - 1
                                deviceNumber?.text = "$deviceTotalNumber/4 devices"
                            }
                        }
                        2 -> {
                            thirdDeviceName?.text = name
                            thirdDeviceNewName = name.toString()
                            thirdPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                thirdCardView.visibility = View.GONE
                                deviceTotalNumber = deviceTotalNumber - 1
                                deviceNumber?.text = "$deviceTotalNumber/4 devices"
                            }
                        }
                        3 -> {
                            fourthDeviceName?.text = name
                            fourthDeviceNewName = name.toString()
                            fourthPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                fourthCardView.visibility = View.GONE
                                deviceTotalNumber = deviceTotalNumber - 1
                                deviceNumber?.text = "$deviceTotalNumber/4 devices"
                            }
                        }

                        4 -> {
                            if (resultCode == Activity.RESULT_OK) {
                                if (bluetoothController?.bluetoothAdapter?.isEnabled == true) {
                                    connectionStateCoordinator.listBleDevices.clear()
                                    bluetoothController?.startScan()
                                } else {
                                }
                            } else if (resultCode == Activity.RESULT_CANCELED) {
                            }
                        }
                    }
                    if (deviceTotalNumber > 3) {
                        btnAddNewDevice?.visibility = View.GONE
                    } else {
                        btnAddNewDevice?.visibility = View.VISIBLE
                    }
                }
            }
        }
    }
}
