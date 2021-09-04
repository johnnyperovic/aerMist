package llc.aerMis.production.ui.my_devices

import android.annotation.SuppressLint
import android.app.Activity
import android.bluetooth.BluetoothGatt
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.data.BleDevice
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
import llc.aerMis.production.R
import llc.aerMis.production.helpers.BluetoothController
import llc.aerMis.production.models.MyDevice
import llc.aerMis.production.observers.NewObservableCoordinator
import llc.aerMis.production.shared.util.PreferenceCache
import llc.aerMis.production.ui.popup.RemoveDevicePopup
import llc.aerMis.production.ui.popup.RenameDevicePopup
import org.koin.android.ext.android.inject
import kotlin.collections.ArrayList


class MyDevicesFragment : Fragment(), View.OnClickListener {

    private val prefs: PreferenceCache by inject()
    var bluetoothController: BluetoothController? = null
    var connectionStateCoordinator:NewObservableCoordinator? =null
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
    var thirdBleDevice: BleDevice? = null
    var fourthBleDevice: BleDevice? = null
    private lateinit var renameDeviceDialog: RenameDevicePopup
    private lateinit var removeDevicePopup: RemoveDevicePopup
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
        connectionStateCoordinator=NewObservableCoordinator

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
            connectionStateCoordinator?.firstGattController?.let { it1 ->
                setDisonectViewFirst(
                    it,
                    it1
                )
            }
        }
        connectionStateCoordinator?.bluetoothConnectionStateFirst?.observe(
            viewLifecycleOwner,
            conectedObserver
        )
        connectionStateCoordinator?.bleDisconnectDevicesFirst?.observe(
            viewLifecycleOwner,
            diconectedObserverOne
        )
    }

    fun connectDevice(bleDevice: BleDevice, gattCallback: BleGattCallback) {
  //      if (connectionStateCoordinator?.bluetoothController?.bluetoothManager!!.isConnected(bleDevice) == false) {
            if (bleDevice.name == deviceOneObj?.name || bleDevice.name == deviceTwoObj?.name || bleDevice.name == deviceThreeObj?.name || bleDevice.name == deviceFourObj?.name) {

                connectionStateCoordinator?.bluetoothController?.bluetoothManager?.connect(
                    bleDevice,
                    gattCallback
                )
            }
      //  }
    }

    private fun setDisonectViewFirst(bleDevice: BleDevice, gattCallback: BleGattCallback) {
        //if (prefs.isDeleted == false) {
            connectionStateCoordinator?.isDeviceConnected = false
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
            connectionStateCoordinator?.bluetoothController?.bluetoothManager?.allConnectedDevice?.size
        if (deviceNumber != null) {
            if (deviceNumber > 0) {
                var bleList = ArrayList<BleDevice>()
                bleList =
                    connectionStateCoordinator?.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
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
            connectionStateCoordinator?.bluetoothController?.bluetoothManager?.connect(
                firstMac,
                connectionStateCoordinator?.firstGattController
            )
        }
        if (secondMac.length > 0) {
            connectionStateCoordinator?.bluetoothController?.bluetoothManager?.connect(
                secondMac,
                connectionStateCoordinator?.firstGattController
            )
        }
        if (thirdMac.length > 0) {
            connectionStateCoordinator?.bluetoothController?.bluetoothManager?.connect(
                thirdMac,
                connectionStateCoordinator?.firstGattController

            )
        }
        if (fourthMac.length > 0) {
            connectionStateCoordinator?.bluetoothController?.bluetoothManager?.connect(
                fourthMac,
                connectionStateCoordinator?.firstGattController
            )
        }
    }

    private fun navigateToAvailableDevices() {

       // if (bluetoothController?.bluetoothManager?.isBlueEnable == true) {
            try {
                connectionStateCoordinator?.bluetoothController?.bluetoothManager?.cancelScan()
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
                                    connectionStateCoordinator?.listBleDevices?.clear()
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
