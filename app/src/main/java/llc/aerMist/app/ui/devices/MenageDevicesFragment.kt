package llc.aerMist.app.ui.devices

import android.app.Activity
import android.bluetooth.BluetoothGatt
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableBoolean
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_devices.*
import kotlinx.android.synthetic.main.fragment_home.*
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
    private var totalNumber = 0
    private var firstBleDevice: BleDevice? = null
    private var secondBleDevice: BleDevice? = null
    private var thirdBleDevice: BleDevice? = null
    private var fourthBleDevice: BleDevice? = null
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
    private lateinit var resetFilterDialog: RemoveDevicePopup
    private lateinit var removeDevicePopup: RemoveDevicePopup
    var firstDeviceNewName: String = ""
    var secondDeviceNewName: String = ""
    var thirdDeviceNewName: String = ""
    var fourthDeviceNewName: String = ""
    var deviceOneObj: MyDevice? = null
    var deviceTwoObj: MyDevice? = null
    var deviceThreeObj: MyDevice? = null
    var deviceFourObj: MyDevice? = null
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        deviceTotalNumber =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        totalNumber =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        if (deviceTotalNumber > 0) {
            bleList =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
        }
        if (deviceTotalNumber == 4) {
            btnAddNewDevice.visibility = View.INVISIBLE
        }

        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
        setClickListener()
        totalDeviceNumber?.text = totalNumber.toString() + "/" + deviceTotalNumber + " devices"

        if (totalNumber == 1 && prefs.isOneDevice == true) {
            prefs.isOneDevice = false
            if (firstBleDevice != null) {
                firstClickView.performClick()
            } else if (secondBleDevice != null) {
                secondClickView.performClick()
            } else if (thirdBleDevice != null) {
                thirdClickView.performClick()
            } else if (fourthBleDevice != null) {
                fourthClickView.performClick()
            }
        }
        val observer3 = Observer<Boolean> {
            Log.e("D","I ODJE ULAZI "+it)
            if (it == true) {
                setFirstDevice()
            }
        }
        val observer4 = Observer<Boolean> {
            Log.e("D","I ODJE ULAZI2222222 "+it)
            if (it == true) {
                setSecondDevice()
            }
        }
        val observer5 = Observer<Boolean> {
            if (it == true) {
                setThirdDevice()
            }
        }
        val observer6 = Observer<Boolean> {
            if (it == true) {
                setFourthDevice()
            }

        }

        connectionStateCoordinator.isFirstTimeSynch.observe(viewLifecycleOwner, observer3)
        connectionStateCoordinator.isSecondTimeSynch.observe(viewLifecycleOwner, observer4)
        connectionStateCoordinator.isThirdTimeSynch.observe(viewLifecycleOwner, observer5)
        connectionStateCoordinator.isFourthTimeSynch.observe(viewLifecycleOwner, observer6)
        val observer2 = Observer<BleDevice> {
            val size2 =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!

            totalDeviceNumber?.text = size2.toString() + "/" + deviceTotalNumber + " devices"

          connectDevice(it)
            val size =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            totalDeviceNumber?.text = size.toString() + "/" + deviceTotalNumber + " devices"

        }
        connectionStateCoordinator.bleDisconnectDevices.observe(viewLifecycleOwner, observer2)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_devices, container, false)
    }

    fun connectDevice(bleDevice: BleDevice) {

        if (prefs.isDeleted == false) {
            if (connectionStateCoordinator.bluetoothController?.bluetoothManager?.isConnected(
                    bleDevice
                ) == false
            ) {
                if (bleDevice.name == deviceOneObj?.name) {

                    firstDeviceState.text = resources.getString(R.string.offline)
                    firstDeviceState.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.someGrayColor
                        )
                    )
                    firstDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
                if (bleDevice.name == deviceTwoObj?.name) {
                    secondDeviceState.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.someGrayColor
                        )
                    )
                    secondDeviceState.text = resources.getString(R.string.offline)
                    secondDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
                if (bleDevice.name == deviceThreeObj?.name) {
                    thirdDeviceState.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.someGrayColor
                        )
                    )
                    thirdDeviceState.text = resources.getString(R.string.offline)
                    thirdDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
                if (bleDevice.name == deviceFourObj?.name) {
                    fourthDeviceState.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.someGrayColor
                        )
                    )
                    fourthDeviceState.text = resources.getString(R.string.offline)
                    fourthDotColor.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
                Log.e("D", "NIJE KONEKTOVAN")
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                    bleDevice,
                    gattCallback
                )
            } else {
                Log.e("D", " KONEKTOVAN")

            }
        } else {
            prefs.isDeleted = false
        }
    }

    private val gattCallback = object : BleGattCallback() {
        override fun onStartConnect() {
            Log.e("D", "onStartConnectMenage ")
        }

        override fun onConnectFail(device: BleDevice, exception: BleException) {
            Log.e("D", "onConnectFaildMenageDevices")
            if (device?.name == deviceOneObj?.name) {
                connectDevice(device)
            }
            if (device?.name == deviceTwoObj?.name) {
                connectDevice(device)

            }
            if (device?.name == deviceThreeObj?.name) {
                connectDevice(device)

            }
            if (device?.name == deviceFourObj?.name) {
                connectDevice(device)
            }
        }

        override fun onConnectSuccess(bleDevicee: BleDevice, gatt: BluetoothGatt, status: Int) {
            Log.e("D", "onConnectSuccess  " + bleDevicee.name)

            val size =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            totalDeviceNumber?.text = size.toString() + "/" + deviceTotalNumber + " devices"
            if (bleDevicee.name == deviceOneObj?.name) {
                firstDeviceState.text = resources.getString(R.string.standby)
                firstDeviceState.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.someGrayColor
                    )
                )
                firstDotColor.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.green_dot
                    )
                )
            }
            if (bleDevicee.name == deviceTwoObj?.name) {
                secondDeviceState?.text = resources.getString(R.string.standby)
                secondDeviceState.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.someGrayColor
                    )
                )
                secondDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.green_dot
                    )
                )
            }
            if (bleDevicee.name == deviceThreeObj?.name) {
                thirdDeviceState?.text = resources.getString(R.string.standby)
                thirdDeviceState.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.someGrayColor
                    )
                )
                thirdDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.green_dot
                    )
                )
            }
            if (bleDevicee.name == deviceFourObj?.name) {
                fourthDeviceState?.text = resources.getString(R.string.standby)
                fourthDeviceState.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.someGrayColor
                    )
                )
                fourthDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.green_dot
                    )
                )
            }
        }

        override fun onDisConnected(
            isActiveDisConnected: Boolean,
            device: BleDevice?,
            gatt: BluetoothGatt?,
            status: Int
        ) {
            if (device?.name == deviceOneObj?.name) {
                firstDeviceState?.text = resources.getString(R.string.offline)
                firstDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
            }
            if (device?.name == deviceTwoObj?.name) {
                secondDeviceState?.text = resources.getString(R.string.offline)
                secondDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
            }
            if (device?.name == deviceThreeObj?.name) {
                thirdDeviceState.text = resources.getString(R.string.offline)
                thirdDotColor.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
            }
            if (device?.name == deviceFourObj?.name) {
                fourthDeviceState.text = resources.getString(R.string.offline)
                fourthDotColor.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
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

    fun showResetFilterDialog(positon: Int, name: String) {
        removeDevicePopup = RemoveDevicePopup(positon, name, true)
        removeDevicePopup.isCancelable = false
        removeDevicePopup.show(childFragmentManager, "")
    }

    fun setFirstDevice() {
        val deviceOne = prefs.firstDevice
        if (deviceOne.length > 1) {
            Log.e("D","ODJE ULAZI ")
            firstCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDeviceName.text = deviceOneObj?.newName
            firstDeviceNewName = deviceOneObj?.newName.toString()
            firstId.text = deviceOneObj?.name
            var i = 0
            deviceTotalNumber =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            if (deviceTotalNumber > 0) {
                bleList =
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            }
            for (item in bleList) {
                Log.e("D","ODJE ULAZI OVO JE ITEM  "+item.name)
                Log.e("D","ODJE ULAZI deviceOneObj?.name   "+deviceOneObj?.name)
                Log.e("D","ODJE ULAZI deviceOneObj?.isOn   "+deviceOneObj?.isOn)

                if (deviceOneObj?.name == item.name) {
                    Log.e("D", "prvi " + i)
                    firstDevicePostion = i
                    isFirstConnected = true
                    firstBleDevice = item
                    if (deviceOneObj?.isOn == true) {
                        Log.e("D", "TREBA DA JE ONLINE")
                        firstMode.visibility = View.VISIBLE
                        modeTv.visibility = View.VISIBLE
                        firstDeviceState.text = resources.getString(R.string.misting)
                        firstDeviceState.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.blue
                            )
                        )
                        firstDotColor.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.blue_circle
                            )
                        )
                        if (deviceOneObj?.isSparayMode == true) {
                            if (deviceOneObj?.isSprayPerDay == false) {
                                firstMode.text = resources.getString(R.string.interval)

                            } else {
                                firstMode.text = resources.getString(R.string.schedule)
                            }
                        } else {
                            firstMode.text = resources.getString(R.string.non_stop)
                        }
                        return
                    } else {
                        Log.e("D", "TREBA DA JE STANDBY")

                        firstMode.visibility = View.INVISIBLE
                        modeTv.visibility = View.INVISIBLE
                        firstDeviceState.text = resources.getString(R.string.standby)
                        firstDeviceState.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.someGrayColor
                            )
                        )
                        firstDotColor.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.green_dot
                            )
                        )
                        return
                    }

                } else {
                    i = i + 1
                    isFirstConnected = false
                    Log.e("D", "A ODJE VEC NIJE")

                    firstDeviceState.text = resources.getString(R.string.offline)
                    firstMode.visibility = View.INVISIBLE
                    modeTv.visibility = View.INVISIBLE
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
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            secondDeviceName.text = deviceTwoObj?.newName
            secondDeviceNewName = deviceTwoObj?.newName.toString()
            var i = 0
            secondId.text = deviceTwoObj?.name
            deviceTotalNumber =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            if (deviceTotalNumber > 0) {
                bleList =
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            }
            for (item in bleList) {
                if (deviceTwoObj?.name == item.name) {
                    isSecondConnected = true
                    secondDevicePosition = i
                    secondBleDevice = item
                    // secondDeviceState.text = resources.getString(R.string.online)
                    if (deviceTwoObj?.isOn == true) {
                        secondMode.visibility = View.VISIBLE
                        modeTv2.visibility = View.VISIBLE
                        secondDeviceState.text = resources.getString(R.string.misting)
                        secondDeviceState.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.blue
                            )
                        )
                        secondDotColor.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.blue_circle
                            )
                        )
                        if (deviceTwoObj?.isSparayMode == true) {
                            if (deviceTwoObj?.isSprayPerDay == false) {
                                secondMode.text = resources.getString(R.string.interval)
                            } else {
                                secondMode.text = resources.getString(R.string.schedule)

                            }
                        } else {
                            secondMode.text = resources.getString(R.string.non_stop)
                        }
                        return
                    } else {
                        secondMode.visibility = View.INVISIBLE
                        modeTv2.visibility = View.INVISIBLE
                        secondDeviceState.text = resources.getString(R.string.standby)
                        secondDeviceState.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.someGrayColor
                            )
                        )
                        secondDotColor.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.green_dot
                            )
                        )
                        return

                    }
                } else {
                    i = i + 1
                    isSecondConnected = false
                    secondDeviceState.text = resources.getString(R.string.offline)
                    secondMode.visibility = View.INVISIBLE
                    modeTv2.visibility = View.INVISIBLE
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
            Log.e("D", "odje ulaiz")
            secondCardView.visibility = View.GONE
        }
    }

    fun setThirdDevice() {

        val deviceThree = prefs.thirdDevice
        if (deviceThree.length > 1) {
            thirdCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            thirdDeviceName.text = deviceThreeObj?.newName
            thirdDeviceNewName = deviceThreeObj?.newName.toString()
            thirdId.text = deviceThreeObj?.name
            var i = 0
            deviceTotalNumber =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            if (deviceTotalNumber > 0) {
                bleList =
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            }
            for (item in bleList) {
                if (deviceThreeObj?.name == item.name) {
                    thirdBleDevice = item
                    isThirdConnected = true
                    thirdDevicePosition = i
                    if (deviceThreeObj?.isOn == true) {
                        thirdMode.visibility = View.VISIBLE
                        modeTv3.visibility = View.VISIBLE
                        thirdDeviceState.text = resources.getString(R.string.misting)
                        thirdDeviceState.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.blue
                            )
                        )
                        thirdDotColor.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.blue_circle
                            )
                        )
                        if (deviceThreeObj?.isSparayMode == true) {
                            if (deviceThreeObj?.isSprayPerDay == false) {
                                thirdMode.text = resources.getString(R.string.interval)
                            } else {
                                thirdMode.text = resources.getString(R.string.schedule)
                            }
                        } else {
                            thirdMode.text = resources.getString(R.string.non_stop)
                        }
                        return
                    } else {
                        thirdMode.visibility = View.INVISIBLE
                        modeTv3.visibility = View.INVISIBLE
                        thirdDeviceState.text = resources.getString(R.string.standby)
                        thirdDeviceState.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.someGrayColor
                            )
                        )
                        thirdDotColor.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.green_dot
                            )
                        )
                    }
                    return
                } else {
                    isThirdConnected = false
                    i = i + 1
                    thirdMode.visibility = View.INVISIBLE
                    modeTv3.visibility = View.INVISIBLE
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
        Log.e("D", "SETUJE CETVRTI")

        val deviceFour = prefs.fourthDevice
        if (deviceFour.length > 1) {
            fourthCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            fourthDeviceName.text = deviceFourObj?.newName
            fourthDeviceNewName = deviceFourObj?.newName.toString()
            fourthId.text = deviceFourObj?.name
            var i = 0
            deviceTotalNumber =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            if (deviceTotalNumber > 0) {
                bleList =
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            }
            for (item in bleList) {
                if (deviceFourObj?.name == item.name) {
                    fourthBleDevice = item
                    isFourthConnected = true
                    fourthDevicePosition = i
                    if (deviceFourObj?.isOn == true) {
                        fourthMode.visibility = View.VISIBLE
                        modeTv4.visibility = View.VISIBLE
                        fourthDeviceState.text = resources.getString(R.string.misting)
                        fourthDeviceState.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.blue
                            )
                        )
                        fourthDotColor.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.blue_circle
                            )
                        )
                        if (deviceFourObj?.isSparayMode == true) {
                            if (deviceFourObj?.isSprayPerDay == false) {
                                fourthMode.text = resources.getString(R.string.interval)

                            } else {
                                fourthMode.text = resources.getString(R.string.schedule)

                            }
                        } else {
                            fourthMode.text = resources.getString(R.string.non_stop)
                        }
                        return
                    } else {
                        fourthMode.visibility = View.INVISIBLE
                        modeTv4.visibility = View.INVISIBLE
                        fourthDeviceState.text = resources.getString(R.string.standby)
                        fourthDeviceState.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.someGrayColor
                            )
                        )
                        fourthDotColor.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.green_dot
                            )
                        )
                    }
                    return
                } else {
                    i = i + 1
                    isFourthConnected = false
                    fourthDeviceState.text = resources.getString(R.string.offline)
                    fourthMode.visibility = View.INVISIBLE
                    modeTv4.visibility = View.INVISIBLE
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
        resetFirstFilter.setOnClickListener(this)
        resetSecondFilter.setOnClickListener(this)
        resetThirdFilter.setOnClickListener(this)
        resetFourthFilter.setOnClickListener(this)
        mainLayout.setOnClickListener(this)
        btnAddNewDevice.setOnClickListener(this)
    }

    override fun onClick(id: View?) {
        when (id) {
            firstClickView -> {
                firstBleDevice?.let { navigateToDevice(it.name, isFirstConnected) }
            }
            firstInfoDots -> {

                firstPopup.visibility = View.VISIBLE
            }
            secondClickView -> {
                secondBleDevice?.let { navigateToDevice(it.name, isSecondConnected) }
            }
            secondInfoDots -> {
                secondPopup.visibility = View.VISIBLE
            }

            thirdClickView -> {
                thirdBleDevice?.let { navigateToDevice(it.name, isThirdConnected) }
            }
            thirdInfoDots -> {
                thirdPopup.visibility = View.VISIBLE
            }
            fourthClickView -> {
                fourthBleDevice?.let { navigateToDevice(it.name, isFourthConnected) }
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
            resetFirstFilter -> {
                showResetFilterDialog(0, firstDeviceNewName)
            }
            resetSecondFilter -> {
                showResetFilterDialog(1, secondDeviceNewName)
            }
            resetThirdFilter -> {
                showResetFilterDialog(2, thirdDeviceNewName)
            }
            resetFourthFilter -> {
                showResetFilterDialog(3, fourthDeviceNewName)
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

    private fun navigateToDevice(name: String, isConnected: Boolean) {
        if (isConnected) {
            val model: ScheduleModel = ScheduleModel(null, null, null, null, null)
            val action =
                MenageDevicesFragmentDirections.actionMenageDevicesToSetDevice(name, model)
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
                    val isFilter = data?.getBoolean("isFilter", false)
                    val position = data?.getInt("position", 0)
                    if (isDeleted == true) {
                        deviceTotalNumber = deviceTotalNumber - 1
                    }
                    when (position) {
                        0 -> {
                            firstDeviceName.text = name
                            firstDeviceNewName = name.toString()
                            firstPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                firstCardView.visibility = View.GONE
                            }
                        }
                        1 -> {
                            secondDeviceName.text = name
                            secondDeviceNewName = name.toString()
                            secondPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                secondCardView.visibility = View.GONE
                            }
                        }
                        2 -> {
                            thirdDeviceName.text = name
                            thirdDeviceNewName = name.toString()
                            thirdPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                thirdCardView.visibility = View.GONE
                            }
                        }
                        3 -> {
                            fourthDeviceName.text = name
                            fourthDeviceNewName = name.toString()
                            fourthPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                fourthCardView.visibility = View.GONE
                            }
                        }
                    }
                }
            }
        }
    }

}