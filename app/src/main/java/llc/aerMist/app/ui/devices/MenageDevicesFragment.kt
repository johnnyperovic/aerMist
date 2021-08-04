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
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
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
import kotlinx.android.synthetic.main.fragment_devices.resetFirstFilter
import kotlinx.android.synthetic.main.fragment_devices.resetFourthFilter
import kotlinx.android.synthetic.main.fragment_devices.resetSecondFilter
import kotlinx.android.synthetic.main.fragment_devices.resetThirdFilter
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
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.my_devices_fragment.*
import kotlinx.android.synthetic.main.my_devices_fragment.deviceNumber
import llc.aerMist.app.R
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.models.ScheduleModel
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.RemoveDevicePopup
import llc.aerMist.app.ui.popup.RenameDevicePopup
import org.koin.android.ext.android.inject
import java.lang.reflect.Method
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class MenageDevicesFragment : Fragment(), View.OnClickListener {
    private val prefs: PreferenceCache by inject()
    private var deviceTotalNumber = 0
    private var totalNumber = 0
    private var firstBleDevice: BleDevice? = null
    private var secondBleDevice: BleDevice? = null
    private var thirdBleDevice: BleDevice? = null
    private var fourthBleDevice: BleDevice? = null
    var firstGate: BluetoothGatt? = null
    var secondGate: BluetoothGatt? = null
    var thirdGate: BluetoothGatt? = null
    var fourthGate: BluetoothGatt? = null
    var counter = 0
    val charset = Charsets.UTF_8

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

        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
        setClickListener()
        checkTotalNumber()
      //  synchTime()
        if (totalNumber == 1 && prefs.isOneDevice == true && counter == 1) {
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
            if (it == true) {
                setFirstDevice()
            }
        }
        val observer4 = Observer<Boolean> {
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
        totalDeviceNumber?.text = deviceTotalNumber.toString() + "/" + counter + " devices"
        if (counter == 4) {
            btnAddNewDevice.visibility = View.GONE
        }
        connectionStateCoordinator.isFirstTimeSynch.observe(viewLifecycleOwner, observer3)
        connectionStateCoordinator.isSecondTimeSynch.observe(viewLifecycleOwner, observer4)
        connectionStateCoordinator.isThirdTimeSynch.observe(viewLifecycleOwner, observer5)
        connectionStateCoordinator.isFourthTimeSynch.observe(viewLifecycleOwner, observer6)
        val observer2 = Observer<BleDevice> {
            checkTotalNumber()
            connectDevice(it)
            val size =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size
            totalDeviceNumber?.text = size.toString() + "/" + counter + " devices"
            if (counter == 4) {
                btnAddNewDevice.visibility = View.GONE
            }
            if (it.name == deviceOneObj?.name) {
                isFirstConnected = false
                firstDeviceState?.text = resources.getString(R.string.offline)
                firstMode?.visibility = View.INVISIBLE
                modeTv?.visibility = View.INVISIBLE
                firstDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
            } else if (it.name == deviceTwoObj?.name) {
                isSecondConnected = false
                secondDeviceState?.text = resources.getString(R.string.offline)
                secondMode?.visibility = View.INVISIBLE
                modeTv2?.visibility = View.INVISIBLE
                secondDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )

            } else if (it.name == deviceThreeObj?.name) {
                isThirdConnected = false
                thirdDeviceState?.text = resources.getString(R.string.offline)
                thirdMode?.visibility = View.INVISIBLE
                modeTv3?.visibility = View.INVISIBLE
                thirdDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )

            } else if (it.name == deviceFourObj?.name) {
                isFourthConnected = false
                fourthDeviceState?.text = resources.getString(R.string.offline)
                fourthMode?.visibility = View.INVISIBLE
                modeTv4?.visibility = View.INVISIBLE
                fourthDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
            }
        }
        connectionStateCoordinator.bleDisconnectDevices.observe(viewLifecycleOwner, observer2)
        val observerConnected = Observer<BleDevice> {
            val size =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size
            checkTotalNumber()
            totalDeviceNumber?.text = size.toString() + " / " + counter + " devices"
            if (counter == 4) {
                btnAddNewDevice.visibility = View.GONE
            }
            if (it.name == deviceOneObj?.name) {
                setFirstDevice()
            } else if (it.name == deviceTwoObj?.name) {
                setSecondDevice()
            } else if (it.name == deviceThreeObj?.name) {
                setThirdDevice()
            } else if (it.name == deviceFourObj?.name) {
                setFourthDevice()
            }
        }
        connectionStateCoordinator.bluetoothConnectionState.observe(
            viewLifecycleOwner,
            observerConnected
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_devices, container, false)
    }

    fun checkTotalNumber() {
        counter = 0
        if (firstCardView?.visibility == View.VISIBLE) {
            counter = counter + 1
        }
        if (secondCardView?.visibility == View.VISIBLE) {
            counter = counter + 1
        }
        if (thirdCardView?.visibility == View.VISIBLE) {
            counter = counter + 1
        }
        if (fourthCardView?.visibility == View.VISIBLE) {
            counter = counter + 1
        }
        val size =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size

        totalDeviceNumber?.text = size.toString() + "/" + counter + " devices"
        if (counter > 3) {
            btnAddNewDevice.visibility = View.INVISIBLE
        } else {
            btnAddNewDevice.visibility = View.VISIBLE
        }
    }

    fun connectDevice(bleDevice: BleDevice) {
        if (prefs.isDeleted == false) {
            if (connectionStateCoordinator.bluetoothController?.bluetoothManager?.isConnected(
                    bleDevice
                ) == false
            ) {
                if (bleDevice.name == deviceOneObj?.name) {

                    firstDeviceState?.text = resources.getString(R.string.offline)
                    firstDeviceState?.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.someGrayColor
                        )
                    )
                    firstDotColor?.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                        bleDevice,
                        gattCallback
                    )
                }
                if (bleDevice.name == deviceTwoObj?.name) {
                    secondDeviceState?.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.someGrayColor
                        )
                    )
                    secondDeviceState?.text = resources.getString(R.string.offline)
                    secondDotColor?.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                        bleDevice,
                        gattCallback
                    )
                }
                if (bleDevice.name == deviceThreeObj?.name) {
                    thirdDeviceState?.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.someGrayColor
                        )
                    )
                    thirdDeviceState?.text = resources.getString(R.string.offline)
                    thirdDotColor?.setImageDrawable(
                        requireContext().let {
                            ContextCompat.getDrawable(
                                it,
                                R.drawable.red_dot
                            )
                        }
                    )
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                        bleDevice,
                        gattCallback
                    )
                }
                if (bleDevice.name == deviceFourObj?.name) {
                    fourthDeviceState?.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.someGrayColor
                        )
                    )
                    fourthDeviceState?.text = resources.getString(R.string.offline)
                    fourthDotColor?.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.connect(
                        bleDevice,
                        gattCallback
                    )
                }

            }
        } else {
            prefs.isDeleted = false
        }
    }

    private val gattCallback = object : BleGattCallback() {
        override fun onStartConnect() {
        }

        override fun onConnectFail(device: BleDevice, exception: BleException) {
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
            checkTotalNumber()
            val size =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size
            totalDeviceNumber?.text = size.toString() + "/" + counter + " devices"
            if (counter == 4) {
                btnAddNewDevice.visibility = View.GONE
            }
            if (bleDevicee.name == deviceOneObj?.name) {
                isFirstConnected = true
                firstBleDevice = bleDevicee
                firstDeviceState?.text = resources.getString(R.string.standby)
                firstDeviceState?.setTextColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.someGrayColor
                    )
                )
                firstDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.green_dot
                    )
                )
            }
            if (bleDevicee.name == deviceTwoObj?.name) {
                isSecondConnected = true
                secondBleDevice = bleDevicee
                secondDeviceState?.text = resources.getString(R.string.standby)
                secondDeviceState?.setTextColor(
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
                isThirdConnected = true
                thirdBleDevice = bleDevicee
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
                isFourthConnected = true
                fourthBleDevice = bleDevicee
                fourthDeviceState?.text = resources.getString(R.string.standby)
                fourthDeviceState?.setTextColor(
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
            checkTotalNumber()
            val size =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size
            totalDeviceNumber?.text = size.toString() + "/" + counter + " devices"
            if (counter == 4) {
                btnAddNewDevice.visibility = View.GONE
            }
            if (device?.name == deviceOneObj?.name) {
                firstDeviceState?.text = resources.getString(R.string.offline)
                firstDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
                device?.let { connectDevice(it) }

            }
            if (device?.name == deviceTwoObj?.name) {
                secondDeviceState?.text = resources.getString(R.string.offline)
                secondDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
                device?.let { connectDevice(it) }

            }
            if (device?.name == deviceThreeObj?.name) {
                thirdDeviceState?.text = resources.getString(R.string.offline)
                thirdDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
                device?.let { connectDevice(it) }
            }
            if (device?.name == deviceFourObj?.name) {
                fourthDeviceState?.text = resources.getString(R.string.offline)
                fourthDotColor?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.red_dot
                    )
                )
                device?.let { connectDevice(it) }
            }

//            try {
//                // BluetoothGatt gatt
//                val refresh: Method? = gatt?.javaClass?.getMethod("refresh")
//                if (refresh != null) {
//                    refresh.invoke(gatt)
//                }
//            } catch (e: Exception) {
//            }
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
            firstCardView?.visibility = View.VISIBLE
            val gson = Gson()
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDeviceName?.text = deviceOneObj?.newName
            firstDeviceNewName = deviceOneObj?.newName.toString()
            firstId?.text = deviceOneObj?.name
            var i = 0
            deviceTotalNumber =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
            if (deviceTotalNumber > 0) {
                bleList =
                    connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            }
            for (item in bleList) {

                if (deviceOneObj?.name == item.name) {
                    firstDevicePostion = i
                    isFirstConnected = true
                    firstBleDevice = item
                    firstGate =
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                            firstBleDevice
                        )
                    if (deviceOneObj?.isOn == true) {
                        firstMode?.visibility = View.VISIBLE
                        modeTv?.visibility = View.VISIBLE
                        firstDeviceState?.text = resources.getString(R.string.misting)
                        firstDeviceState?.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.blue
                            )
                        )
                        firstDotColor?.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.blue_circle
                            )
                        )
                        if (deviceOneObj?.isSparayMode == true) {
                            if (deviceOneObj?.isSprayPerDay == false) {
                                firstMode?.text = resources.getString(R.string.interval)

                            } else {
                                firstMode?.text = resources.getString(R.string.schedule)
                            }
                        } else {
                            firstMode?.text = resources.getString(R.string.non_stop)
                        }
                        return
                    } else {

                        firstMode?.visibility = View.INVISIBLE
                        modeTv?.visibility = View.INVISIBLE
                        firstDeviceState?.text = resources.getString(R.string.standby)
                        firstDeviceState?.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.someGrayColor
                            )
                        )
                        firstDotColor?.setImageDrawable(
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
                    firstDeviceState?.text = resources.getString(R.string.offline)
                    firstMode?.visibility = View.INVISIBLE
                    modeTv?.visibility = View.INVISIBLE
                    firstDotColor?.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
            }
        } else {
            firstCardView.visibility = View.GONE
        }
    }

    fun setSecondDevice() {

        val deviceTwo = prefs.secondDevice
        if (deviceTwo.length > 1) {
            secondCardView?.visibility = View.VISIBLE
            val gson = Gson()
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            secondDeviceName?.text = deviceTwoObj?.newName
            secondDeviceNewName = deviceTwoObj?.newName.toString()
            var i = 0
            secondId?.text = deviceTwoObj?.name
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
                    secondGate =
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                            secondBleDevice
                        )!!
                    // secondDeviceState.text = resources.getString(R.string.online)
                    if (deviceTwoObj?.isOn == true) {
                        secondMode?.visibility = View.VISIBLE
                        modeTv2?.visibility = View.VISIBLE
                        secondDeviceState?.text = resources.getString(R.string.misting)
                        secondDeviceState?.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.blue
                            )
                        )
                        secondDotColor?.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.blue_circle
                            )
                        )
                        if (deviceTwoObj?.isSparayMode == true) {
                            if (deviceTwoObj?.isSprayPerDay == false) {
                                secondMode?.text = resources.getString(R.string.interval)
                            } else {
                                secondMode?.text = resources.getString(R.string.schedule)

                            }
                        } else {
                            secondMode?.text = resources.getString(R.string.non_stop)
                        }
                        return
                    } else {
                        secondMode?.visibility = View.INVISIBLE
                        modeTv2?.visibility = View.INVISIBLE
                        secondDeviceState?.text = resources.getString(R.string.standby)
                        secondDeviceState?.setTextColor(
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
                        return

                    }
                } else {
                    i = i + 1
                    isSecondConnected = false
                    secondDeviceState?.text = resources.getString(R.string.offline)
                    secondMode?.visibility = View.INVISIBLE
                    modeTv2?.visibility = View.INVISIBLE
                    secondDotColor?.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
            }
        } else {
            secondCardView?.visibility = View.GONE
        }
    }

    fun setThirdDevice() {

        val deviceThree = prefs.thirdDevice
        if (deviceThree.length > 1) {
            thirdCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
            thirdDeviceName?.text = deviceThreeObj?.newName
            thirdDeviceNewName = deviceThreeObj?.newName.toString()
            thirdId?.text = deviceThreeObj?.name
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
                    thirdGate =
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                            thirdBleDevice
                        )!!
                    isThirdConnected = true
                    thirdDevicePosition = i
                    if (deviceThreeObj?.isOn == true) {
                        thirdMode?.visibility = View.VISIBLE
                        modeTv3?.visibility = View.VISIBLE
                        thirdDeviceState?.text = resources.getString(R.string.misting)
                        thirdDeviceState?.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.blue
                            )
                        )
                        thirdDotColor?.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.blue_circle
                            )
                        )
                        if (deviceThreeObj?.isSparayMode == true) {
                            if (deviceThreeObj?.isSprayPerDay == false) {
                                thirdMode?.text = resources.getString(R.string.interval)
                            } else {
                                thirdMode?.text = resources.getString(R.string.schedule)
                            }
                        } else {
                            thirdMode?.text = resources.getString(R.string.non_stop)
                        }
                        return
                    } else {
                        thirdMode?.visibility = View.INVISIBLE
                        modeTv3?.visibility = View.INVISIBLE
                        thirdDeviceState?.text = resources.getString(R.string.standby)
                        thirdDeviceState?.setTextColor(
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
                    return
                } else {
                    isThirdConnected = false
                    i = i + 1
                    thirdMode?.visibility = View.INVISIBLE
                    modeTv3?.visibility = View.INVISIBLE
                    thirdDeviceState?.text = resources.getString(R.string.offline)
                    thirdDotColor?.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
            }
        } else {
            thirdCardView?.visibility = View.GONE
        }
    }

    fun setFourthDevice() {

        val deviceFour = prefs.fourthDevice
        if (deviceFour.length > 1) {
            fourthCardView?.visibility = View.VISIBLE
            val gson = Gson()
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
            fourthDeviceName?.text = deviceFourObj?.newName
            fourthDeviceNewName = deviceFourObj?.newName.toString()
            fourthId?.text = deviceFourObj?.name
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
                    fourthGate =
                        connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                            fourthBleDevice
                        )!!
                    isFourthConnected = true
                    fourthDevicePosition = i
                    if (deviceFourObj?.isOn == true) {
                        fourthMode?.visibility = View.VISIBLE
                        modeTv4?.visibility = View.VISIBLE
                        fourthDeviceState?.text = resources.getString(R.string.misting)
                        fourthDeviceState?.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.blue
                            )
                        )
                        fourthDotColor?.setImageDrawable(
                            ContextCompat.getDrawable(
                                requireContext(),
                                R.drawable.blue_circle
                            )
                        )
                        if (deviceFourObj?.isSparayMode == true) {
                            if (deviceFourObj?.isSprayPerDay == false) {
                                fourthMode?.text = resources.getString(R.string.interval)

                            } else {
                                fourthMode?.text = resources.getString(R.string.schedule)

                            }
                        } else {
                            fourthMode?.text = resources.getString(R.string.non_stop)
                        }
                        return
                    } else {
                        fourthMode?.visibility = View.INVISIBLE
                        modeTv4?.visibility = View.INVISIBLE
                        fourthDeviceState?.text = resources.getString(R.string.standby)
                        fourthDeviceState?.setTextColor(
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
                    return
                } else {
                    i = i + 1
                    isFourthConnected = false
                    fourthDeviceState?.text = resources.getString(R.string.offline)
                    fourthMode?.visibility = View.INVISIBLE
                    modeTv4?.visibility = View.INVISIBLE
                    fourthDotColor?.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.red_dot
                        )
                    )
                }
            }
        } else {
            fourthCardView?.visibility = View.GONE
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
                firstPopup?.visibility = View.VISIBLE
                secondPopup?.visibility = View.INVISIBLE
                thirdPopup?.visibility = View.INVISIBLE
                fourthPopup?.visibility = View.INVISIBLE
            }
            secondClickView -> {
                secondBleDevice?.let { navigateToDevice(it.name, isSecondConnected) }
            }
            secondInfoDots -> {
                firstPopup?.visibility = View.INVISIBLE
                secondPopup?.visibility = View.VISIBLE
                thirdPopup?.visibility = View.INVISIBLE
                fourthPopup?.visibility = View.INVISIBLE
            }

            thirdClickView -> {
                thirdBleDevice?.let { navigateToDevice(it.name, isThirdConnected) }
            }
            thirdInfoDots -> {
                firstPopup?.visibility = View.INVISIBLE
                secondPopup?.visibility = View.INVISIBLE
                thirdPopup?.visibility = View.VISIBLE
                fourthPopup?.visibility = View.INVISIBLE
            }
            fourthClickView -> {
                fourthBleDevice?.let { navigateToDevice(it.name, isFourthConnected) }
            }
            fourthInfoDots -> {
                firstPopup?.visibility = View.INVISIBLE
                secondPopup?.visibility = View.INVISIBLE
                thirdPopup?.visibility = View.INVISIBLE
                fourthPopup?.visibility = View.VISIBLE
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
                            firstDeviceName?.text = name
                            firstDeviceNewName = name.toString()
                            firstPopup?.visibility = View.GONE
                            if (isDeleted == true) {
                                firstCardView?.visibility = View.GONE
                                connectionStateCoordinator.firstGatt?.close()
                            }
                        }
                        1 -> {
                            secondDeviceName?.text = name
                            secondDeviceNewName = name.toString()
                            secondPopup?.visibility = View.GONE
                            if (isDeleted == true) {
                                secondCardView.visibility = View.GONE
                                connectionStateCoordinator.secondGatt?.close()

                            }
                        }
                        2 -> {
                            thirdDeviceName?.text = name
                            thirdDeviceNewName = name.toString()
                            thirdPopup.visibility = View.GONE
                            if (isDeleted == true) {
                                thirdCardView?.visibility = View.GONE
                                connectionStateCoordinator.thirdGatt?.close()
                            }
                        }
                        3 -> {
                            fourthDeviceName?.text = name
                            fourthDeviceNewName = name.toString()
                            fourthPopup?.visibility = View.GONE
                            if (isDeleted == true) {
                                fourthCardView?.visibility = View.GONE
                                connectionStateCoordinator.fourthGatt?.close()
                            }
                        }
                    }
                    checkTotalNumber()
                    if (counter == 0) {
                        navigateToSearchFragment()
                    }
                }
            }
        }
    }

    fun synchTime() {

        val currentDateTime = LocalDateTime.now()
        val min = currentDateTime.minute
        val hour = currentDateTime.hour
        val sec = currentDateTime.second
        val year = currentDateTime.year
        val dayOfWeek = currentDateTime.dayOfWeek
        val month = currentDateTime.format(DateTimeFormatter.ofPattern("MM"))
        val day = currentDateTime.format(DateTimeFormatter.ofPattern("dd"))
        val dayNumber = getDayInWeek(dayOfWeek.toString().toLowerCase())

        var secString = ""
        var setHour = ""
        if (sec < 10) {
            secString = "0" + sec
        } else {
            secString = sec.toString()
        }
        if (hour < 10) {
            setHour = "0" + hour
        } else {
            setHour = hour.toString()
        }
        var minString = ""
        if (min < 10) {
            minString = "0" + min
        } else {
            minString = min.toString()
        }
        val dateAndTimeSynch =
            "EE000+" + year + month + day + setHour + minString + secString + dayNumber + "."

        Log.e("D", "dateAndTimeSynch $dateAndTimeSynch")

        firstBleDevice?.let {
            firstGate?.let { it1 ->
                sendCommand(
                    dateAndTimeSynch.toByteArray(charset),
                    it, it1
                )
            }
        }

        secondBleDevice?.let {
            secondGate?.let { it1 ->
                sendCommand(
                    dateAndTimeSynch.toByteArray(charset),
                    it, it1
                )
            }
        }


        thirdBleDevice?.let {
            thirdGate?.let { it1 ->
                sendCommand(
                    dateAndTimeSynch.toByteArray(charset),
                    it, it1
                )
            }
        }

        fourthBleDevice?.let {
            fourthGate?.let { it1 ->
                sendCommand(
                    dateAndTimeSynch.toByteArray(charset),
                    it, it1
                )
            }
        }
    }

    fun getDayInWeek(day: String): Int {
        var dayInWeek = 0
        when (day) {
            "monday" -> dayInWeek = 0
            "tuesday" -> dayInWeek = 1
            "wednesday" -> dayInWeek = 2
            "thursday" -> dayInWeek = 3
            "friday" -> dayInWeek = 4
            "saturday" -> dayInWeek = 5
            "sunday" -> dayInWeek = 6
        }
        return dayInWeek
    }

    fun sendCommand(input: ByteArray, bleDevice: BleDevice, gatt: BluetoothGatt) {
        val pos = gatt.services.size - 1

        connectionStateCoordinator.bluetoothController?.writeCommand(
            bleDevice,
            input,
            gatt.services.get(pos).characteristics.get(0)
        )
    }

}