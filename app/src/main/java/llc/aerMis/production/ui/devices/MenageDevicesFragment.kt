package llc.aerMis.production.ui.devices

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.clj.fastble.callback.BleGattCallback
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
import llc.aerMis.production.R
import llc.aerMis.production.models.MyDevice
import llc.aerMis.production.models.ScheduleModel
import llc.aerMis.production.observers.NewObservableCoordinator
import llc.aerMis.production.shared.util.PreferenceCache
import llc.aerMis.production.ui.popup.RemoveDevicePopup
import llc.aerMis.production.ui.popup.RenameDevicePopup
import org.koin.android.ext.android.inject
import java.lang.Exception

class MenageDevicesFragment : Fragment(), View.OnClickListener {
    private val prefs: PreferenceCache by inject()
    private var deviceTotalNumber = 0
    private var firstBleDevice: BleDevice? = null
    private var secondBleDevice: BleDevice? = null
    private var thirdBleDevice: BleDevice? = null
    private var fourthBleDevice: BleDevice? = null
    var counter = 0
     var connectionStateCoordinator: NewObservableCoordinator? = null
    private var bleList = ArrayList<BleDevice>()
    private var isFirstConnected = false
    private var isSecondConnected = false
    private var isThirdConnected = false
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
        connectionStateCoordinator=NewObservableCoordinator
        try {
            deviceTotalNumber =
                getAllConnectedDevices()
        }
        catch (e:Exception)
        {

        }
        if (deviceTotalNumber > 0) {
            bleList =
                connectionStateCoordinator?.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
        }

        setFirstDevice()
        setSecondDevice()
        setThirdDevice()
        setFourthDevice()
        setClickListener()
        checkTotalNumber()

        if (deviceTotalNumber == 1 && prefs.isOneDevice == true && counter == 1) {
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
            //    setFirstDevice()
                val deviceOne = prefs.firstDevice
                if (deviceOne.length > 1) {
                    firstCardView?.visibility = View.VISIBLE
                    val gson = Gson()
                    deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
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
                    }
                }
            }
        }
        val observer4 = Observer<Boolean> {
            if (it == true) {
            //    setSecondDevice()
                   val deviceTwo = prefs.secondDevice
        if (deviceTwo.length > 1) {
            secondCardView?.visibility = View.VISIBLE
            val gson = Gson()
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)

                    isSecondConnected = true
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
                    }
                }
            }
        }
        val observer5 = Observer<Boolean> {
            if (it == true) {
            //    setThirdDevice()
                 val deviceThree = prefs.thirdDevice
        if (deviceThree.length > 1) {
            thirdCardView.visibility = View.VISIBLE
            val gson = Gson()
            deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
                    isThirdConnected = true
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
                }
            }
        }
        val observer6 = Observer<Boolean> {
            if (it == true) {
            //    setFourthDevice()
                 val deviceFour = prefs.fourthDevice
        if (deviceFour.length > 1) {
            fourthCardView?.visibility = View.VISIBLE
            val gson = Gson()
            deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
                    isFourthConnected = true
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
                }
            }
        }
        if (counter == 4) {
            btnAddNewDevice?.visibility = View.GONE
        }
        connectionStateCoordinator?.isFirstTimeSynch?.observe(viewLifecycleOwner, observer3)
        connectionStateCoordinator?.isSecondTimeSynch?.observe(viewLifecycleOwner, observer4)
        connectionStateCoordinator?.isThirdTimeSynch?.observe(viewLifecycleOwner, observer5)
        connectionStateCoordinator?.isFourthTimeSynch?.observe(viewLifecycleOwner, observer6)
        val observerDisconectedFirst = Observer<BleDevice> {
            connectionStateCoordinator?.firstGattController?.let { it1 ->
                checkDisconectView(it,
                    it1
                )
            }
        }
        connectionStateCoordinator?.bleDisconnectDevicesFirst?.observe(
            viewLifecycleOwner,
            observerDisconectedFirst
        )
        val observerConnected = Observer<BleDevice> {
            checkTotalNumber()
            if (counter == 4) {
                btnAddNewDevice.visibility = View.GONE
            }
            val gson = Gson()
            val deviceOne = prefs.firstDevice
            val deviceTwo = prefs.secondDevice
            val deviceThree = prefs.thirdDevice
            val deviceFour = prefs.fourthDevice
            if (deviceOne.length > 1) {
                deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
                if (it?.name == deviceOneObj?.name) {
                    setFirstDevice()
                }
            }

            if (deviceTwo.length > 1) {
                deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
                if (it?.name == deviceTwoObj?.name) {
                    setSecondDevice()
                }
            }
            if (deviceThree.length > 1) {
                deviceThreeObj = gson.fromJson(deviceThree, MyDevice::class.java)
                if (it?.name == deviceThreeObj?.name) {
                    setThirdDevice()
                }
            }
            if (deviceFour.length > 1) {
                deviceFourObj = gson.fromJson(deviceFour, MyDevice::class.java)
                if (it?.name == deviceFourObj?.name) {
                    setFourthDevice()
                }
            }
        }
        connectionStateCoordinator?.bluetoothConnectionStateFirst?.observe(
            viewLifecycleOwner,
            observerConnected
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_devices, container, false)
    }
    fun checkDisconectView(bleDevice: BleDevice,gattCallback: BleGattCallback) {

        if (connectionStateCoordinator?.bluetoothController?.bluetoothManager!!.isConnected(bleDevice) == false) {
            checkTotalNumber()
            if (counter == 4) {
                btnAddNewDevice?.visibility = View.GONE
            }
            if (bleDevice.name == deviceOneObj?.name) {
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
                connectDevice(bleDevice, gattCallback)

            } else if (bleDevice.name == deviceTwoObj?.name) {
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
                connectDevice(bleDevice, gattCallback)

            } else if (bleDevice.name == deviceThreeObj?.name) {
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
                connectDevice(bleDevice, gattCallback)

            } else if (bleDevice.name == deviceFourObj?.name) {
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
                connectDevice(bleDevice, gattCallback)
            }
        }
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
            connectionStateCoordinator?.bluetoothController?.bluetoothManager?.allConnectedDevice?.size

        totalDeviceNumber?.text = size.toString() + "/" + counter + " devices"
        if (counter > 3) {
            btnAddNewDevice?.visibility = View.INVISIBLE
        } else {
            btnAddNewDevice?.visibility = View.VISIBLE
        }
    }

    fun connectDevice(bleDevice: BleDevice,gattCallback: BleGattCallback) {
        if (connectionStateCoordinator?.bluetoothController?.bluetoothManager!!.isConnected(bleDevice) == false) {
            connectionStateCoordinator?.bluetoothController?.bluetoothManager?.connect(
                bleDevice,
                gattCallback
            )
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
            deviceTotalNumber =
                getAllConnectedDevices()
            if (deviceTotalNumber > 0) {
                bleList =
                    connectionStateCoordinator?.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            }
            for (item in bleList) {

                if (deviceOneObj?.name == item.name) {
                    isFirstConnected = true
                    firstBleDevice = item
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
            firstCardView?.visibility = View.GONE
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
                getAllConnectedDevices()
            if (deviceTotalNumber > 0) {
                bleList =
                    connectionStateCoordinator?.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            }
            for (item in bleList) {
                if (deviceTwoObj?.name == item.name) {
                    isSecondConnected = true
                    secondBleDevice = item

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
                getAllConnectedDevices()
            if (deviceTotalNumber > 0) {
                bleList =
                    connectionStateCoordinator?.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            }
            for (item in bleList) {
                if (deviceThreeObj?.name == item.name) {
                    thirdBleDevice = item
                    isThirdConnected = true
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
    fun getAllConnectedDevices():Int{
        var size=0
        try {
            size =connectionStateCoordinator
                ?.bluetoothController?.
            bluetoothManager?.
            allConnectedDevice?.size!!
        }
        catch (e:Exception)
        {
        }
        return size
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
                getAllConnectedDevices()
            if (deviceTotalNumber > 0) {
                bleList =
                    connectionStateCoordinator?.bluetoothController?.bluetoothManager?.allConnectedDevice as ArrayList<BleDevice>
            }
            for (item in bleList) {
                if (deviceFourObj?.name == item.name) {
                    fourthBleDevice = item
                    isFourthConnected = true
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
                            }
                        }
                        1 -> {
                            secondDeviceName?.text = name
                            secondDeviceNewName = name.toString()
                            secondPopup?.visibility = View.GONE
                            if (isDeleted == true) {
                                secondCardView?.visibility = View.GONE

                            }
                        }
                        2 -> {
                            thirdDeviceName?.text = name
                            thirdDeviceNewName = name.toString()
                            thirdPopup?.visibility = View.GONE
                            if (isDeleted == true) {
                                thirdCardView?.visibility = View.GONE
                            }
                        }
                        3 -> {
                            fourthDeviceName?.text = name
                            fourthDeviceNewName = name.toString()
                            fourthPopup?.visibility = View.GONE
                            if (isDeleted == true) {
                                fourthCardView?.visibility = View.GONE
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
}