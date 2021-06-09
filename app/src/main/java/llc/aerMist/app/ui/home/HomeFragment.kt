package llc.aerMist.app.ui.home

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.bluetooth.BluetoothGatt
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.provider.SyncStateContract
import android.util.Log
import android.view.*
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.View.OnTouchListener
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.clj.fastble.callback.BleGattCallback
import com.clj.fastble.callback.BleNotifyCallback
import com.clj.fastble.callback.BleScanCallback
import com.clj.fastble.callback.BleWriteCallback
import com.clj.fastble.data.BleDevice
import com.clj.fastble.exception.BleException
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.bleBg
import kotlinx.android.synthetic.main.fragment_home.btnEdit
import kotlinx.android.synthetic.main.fragment_home.btnStart
import kotlinx.android.synthetic.main.fragment_home.guideline
import kotlinx.android.synthetic.main.fragment_home.mistTv
import kotlinx.android.synthetic.main.fragment_home.mistValue
import kotlinx.android.synthetic.main.fragment_home.standbyTv
import kotlinx.android.synthetic.main.fragment_home.suspendTv
import kotlinx.android.synthetic.main.fragment_home.suspendValue
import kotlinx.android.synthetic.main.fragment_interval.*
import kotlinx.android.synthetic.main.my_devices_fragment.*
import llc.aerMist.app.R
import llc.aerMist.app.helpers.BluetoothController
import llc.aerMist.app.models.MyDevice
import llc.aerMist.app.observers.NewObservableCoordinator
import llc.aerMist.app.shared.kotlin.hideWithAnimation
import llc.aerMist.app.shared.kotlin.showWithAnimation
import llc.aerMist.app.shared.util.PreferenceCache
import llc.aerMist.app.ui.popup.NumberPickerPopup
import org.koin.android.ext.android.inject


class HomeFragment : Fragment(), View.OnClickListener {
    private val prefs: PreferenceCache by inject()
    private var tag = 0
    var numberPickerPopup = NumberPickerPopup()
    lateinit var bluetoothController: BluetoothController
    val connectionStateCoordinator = NewObservableCoordinator
    private var firstDevice = ""
    var secondDevice: String = ""
    var thirdDevice: String = ""
    var fourthDevice: String = ""
    lateinit var firstBleDevice: BleDevice
    lateinit var secondBleDevice: BleDevice
    lateinit var thirdBleDevice: BleDevice
    lateinit var fourthBleDevice: BleDevice
    lateinit var firstGate: BluetoothGatt
    lateinit var secondGate: BluetoothGatt
    lateinit var thirdGate: BluetoothGatt
    lateinit var fourthGate: BluetoothGatt
    private var isFirstDevice = true
    val charset = Charsets.UTF_8
    val byteArrayON = "EE0100.".toByteArray(charset)
    val byteArrayOF = "EE0101.".toByteArray(charset)
    var allDevices = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        setNonStopView()
        setMotionLayoutListener()
        setTouchSwipeListener()
        setFirstDevice()
        setSecondDevice()
        initBleConroller()
        Log.e(
            "D",
            "broj konektovanih  uredjaja " + connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size
        )
        allDevices =
            connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.size!!
        if (allDevices == 1) {
            firstBleDevice =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                    0
                )!!
            firstGate =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                    firstBleDevice
                )!!
        } else if (allDevices == 2) {
            firstBleDevice =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                    0
                )!!
            firstGate =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                    firstBleDevice
                )!!
            secondBleDevice =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                    1
                )!!
            secondGate =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                    secondBleDevice
                )!!
        } else if (allDevices == 3) {
            firstBleDevice =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                    0
                )!!
            firstGate =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                    firstBleDevice
                )!!
            secondBleDevice =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                    1
                )!!
            secondGate =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                    secondBleDevice
                )!!
            thirdBleDevice =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                    2
                )!!
            thirdGate =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                    thirdBleDevice
                )!!
        } else if (allDevices == 4) {
            firstBleDevice =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                    0
                )!!
            firstGate =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                    firstBleDevice
                )!!
            secondBleDevice =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                    1
                )!!
            secondGate =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                    secondBleDevice
                )!!
            thirdBleDevice =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                    2
                )!!
            thirdGate =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                    thirdBleDevice
                )!!
            fourthBleDevice =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.allConnectedDevice?.get(
                    3
                )!!
            fourthGate =
                connectionStateCoordinator.bluetoothController?.bluetoothManager?.getBluetoothGatt(
                    fourthBleDevice
                )!!
        }
    }

    fun setTouchSwipeListener() {
        val gesture = GestureDetector(
            activity,
            object : SimpleOnGestureListener() {
                override fun onDown(e: MotionEvent): Boolean {
                    return true
                }

                override fun onFling(
                    e1: MotionEvent, e2: MotionEvent, velocityX: Float,
                    velocityY: Float
                ): Boolean {
                    val SWIPE_MIN_DISTANCE = 120
                    val SWIPE_MAX_OFF_PATH = 250
                    val SWIPE_THRESHOLD_VELOCITY = 200
                    try {
                        if (Math.abs(e1.y - e2.y) > SWIPE_MAX_OFF_PATH) return false
                        if (e1.x - e2.x > SWIPE_MIN_DISTANCE
                            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY
                        ) {
                            if (tag == 0) {
                                intervalImg.performClick()
                            } else if (tag == 1) {
                                scheduleImg.performClick()
                            }

                        } else if (e2.x - e1.x > SWIPE_MIN_DISTANCE
                            && Math.abs(velocityX) > SWIPE_THRESHOLD_VELOCITY
                        ) {
                            if (tag == 2) {
                                intervalImg.performClick()
                            } else if (tag == 1) {
                                nonStopImg.performClick()
                            }

                        }
                    } catch (e: Exception) {
                        // nothing
                    }
                    return super.onFling(e1, e2, velocityX, velocityY)
                }
            })

        carViewHome.setOnTouchListener(OnTouchListener { v, event -> gesture.onTouchEvent(event) })

    }

    fun setMotionLayoutListener() {
        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                constraintSet: Int,
                p2: Int
            ) {

            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                constraintSet: Int,
                p2: Int,
                p3: Float
            ) {

            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, constraintSet: Int) {
                if (constraintSet == R.id.start) {
                    btnStart.setBackgroundResource(R.drawable.blue_radius_8)
                    btnStart.text = getString(R.string.start)
                } else {
                    btnStart.setBackgroundResource(R.drawable.container_light_blue)
                    btnStart.text = getString(R.string.stop)
                }
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                constraintSet: Int,
                p2: Boolean,
                p3: Float
            ) {

            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    fun setClickListener() {
        nonStopImg.setOnClickListener(this)
        nonStopTv.setOnClickListener(this)
        intervalImg.setOnClickListener(this)
        intervalTv.setOnClickListener(this)
        scheduleImg.setOnClickListener(this)
        scheduleTv.setOnClickListener(this)
        btnStart.setOnClickListener(this)
        btnEdit.setOnClickListener(this)
    }

    fun setTabItemVisibility(state: Boolean) {
        if (state) {
            btnStart.text = getString(R.string.stop)
            intervalImg.hideWithAnimation()
            intervalTv.hideWithAnimation()
            scheduleImg.hideWithAnimation()
            scheduleTv.hideWithAnimation()
            nonStopImg.hideWithAnimation()
            nonStopTv.hideWithAnimation()
            firstLine.hideWithAnimation()
            bleBg.hideWithAnimation()
            bleIcon.hideWithAnimation()
            standbyTv.hideWithAnimation()
            mistTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            mistValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            suspendTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            suspendValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.white))
            firstLine.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
        } else {
            btnStart.text = getString(R.string.stop)
            intervalImg.showWithAnimation()
            intervalTv.showWithAnimation()
            scheduleImg.showWithAnimation()
            scheduleTv.showWithAnimation()
            nonStopImg.showWithAnimation()
            nonStopTv.showWithAnimation()
            firstLine.showWithAnimation()
            bleBg.showWithAnimation()
            bleIcon.showWithAnimation()
            standbyTv.showWithAnimation()
            mistTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            mistValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            suspendTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            suspendValue.setTextColor(ContextCompat.getColor(requireContext(), R.color.dark_gray))
            firstLine.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.dark_gray
                )
            )
        }
    }

    override fun onClick(id: View?) {
        when (id) {
            nonStopImg -> {
                setNonStopView()
            }
            nonStopTv -> {
                setNonStopView()
            }
            intervalImg -> {
                setIntervalView()
            }
            intervalTv -> {
                setIntervalView()
            }
            scheduleImg -> {
                setScheduleView()
            }
            scheduleTv -> {
                setScheduleView()
            }
            btnStart -> {
                Log.e("D", "TAG " + tag)
                if (btnStart.tag == "start") {
                    if (tag == 0) {
                        if (allDevices == 1) {
                            if (btnStart.tag == "start") {
                                turnOnOFDevice(byteArrayON, firstBleDevice, firstGate)
                                btnStart.tag = "stop"
                            } else {
                                turnOnOFDevice(byteArrayOF, firstBleDevice, firstGate)
                                btnStart.tag = "start"
                            }
                        } else if (allDevices == 2) {
                            if (btnStart.tag == "start") {
                                turnOnOFDevice(byteArrayON, firstBleDevice, firstGate)
                                turnOnOFDevice(byteArrayON, secondBleDevice, secondGate)
                                btnStart.tag = "stop"
                            } else {
                                turnOnOFDevice(byteArrayON, firstBleDevice, firstGate)
                                turnOnOFDevice(byteArrayOF, secondBleDevice, secondGate)
                                btnStart.tag = "start"
                            }
                        }
                    } else if (tag == 2) {
                        startAnimation()
                    } else {
                        showDialog()
                    }
                } else {
                    startAnimation()
                }
            }
            btnEdit -> {
                if (tag == 1) {
                    setNumberPicker()
                }
                if (tag == 2) {
                    navigateToSetSchedule()
                }
            }
        }
    }

    fun turnOnOFDevice(input: ByteArray, bleDevice: BleDevice, gatt: BluetoothGatt) {
        bluetoothController.writeCommand(
            bleDevice,
            input,
            gatt.services.get(2).characteristics.get(0)
        )
    }

    fun setNonStopView() {
        tag = 0
        mistTv.visibility = View.INVISIBLE
        mistValue.visibility = View.INVISIBLE
        suspendTv.visibility = View.INVISIBLE
        suspendValue.visibility = View.INVISIBLE
        btnEdit.visibility = View.INVISIBLE
        secondLine.visibility = View.INVISIBLE
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
        )
        guideline.setGuidelinePercent(1f)
        nonStopImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop_orange_icon
            )
        )
        intervalImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_icon
            )
        )
        scheduleImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_icon
            )
        )
    }

    fun setIntervalView() {
        tag = 1
        mistTv.showWithAnimation()
        mistValue.showWithAnimation()
        suspendTv.showWithAnimation()
        suspendValue.showWithAnimation()
        btnEdit.showWithAnimation()
        secondLine.showWithAnimation()
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        nonStopImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop_icon
            )
        )
        intervalImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_orange_icon
            )
        )
        scheduleImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_icon
            )
        )
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.orange_circle)
        )
        guideline.setGuidelinePercent(0.65f)
    }

    fun setScheduleView() {
        tag = 2
        mistTv.showWithAnimation()
        mistValue.showWithAnimation()
        suspendTv.showWithAnimation()
        suspendValue.showWithAnimation()
        btnEdit.showWithAnimation()
        nonStopTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        intervalTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.imgGray))
        scheduleTv.setTextColor(ContextCompat.getColor(requireContext(), R.color.orange))
        nonStopImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.non_stop_icon
            )
        )
        intervalImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.interval_icon
            )
        )
        scheduleImg.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.schedule_orange_icon
            )
        )
        bleBg.setImageDrawable(
            ContextCompat.getDrawable(requireContext(), R.drawable.green_circle)
        )
        guideline.setGuidelinePercent(0.65f)
    }

    fun startAnimation() {
        motionLayout.transitionToEnd()
        motionLayout.transitionToStart()
        when (tag) {
            0 -> {
                tabName.text = resources.getString(R.string.non_stop)
                tab_icon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.non_stop_blue_icon
                    )
                )
            }
            1 -> {
                tabName.text = resources.getString(R.string.interval)
                tab_icon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.interval_blue_icon
                    )
                )
            }
            2 -> {
                tabName.text = resources.getString(R.string.schedule)
                tab_icon.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.calendar_blue_icon
                    )
                )
            }
        }
        if (intervalImg.visibility == View.VISIBLE) {
            setTabItemVisibility(true)
        } else {
            setTabItemVisibility(false)
        }
    }

    private fun showDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialog.setContentView(R.layout.fragment_start_global_mode_popup)
        val firstDevice = dialog.findViewById(R.id.firstDevice) as TextView
        val secondDevice = dialog.findViewById(R.id.secondDevice) as TextView
        val thirdDevice = dialog.findViewById(R.id.thirdDevice) as TextView
        val fourthDevice = dialog.findViewById(R.id.fourthDevice) as TextView
        val subTitle = dialog.findViewById(R.id.subTitle) as TextView
        val startBtn = dialog.findViewById(R.id.startBtn) as TextView
        val noBtn = dialog.findViewById(R.id.cancelBtn) as TextView
        if (tag == 0) {
            subTitle.text = resources.getString(R.string.start_global_mode)
        }
        if (tag == 1) {
            subTitle.text = resources.getString(R.string.device_are_offline)
        }
        startBtn.setOnClickListener {
            startAnimation()
            dialog.dismiss()
        }
        noBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

    private fun navigateToSetSchedule() {
        findNavController().navigate(R.id.action_schedule_to_set_schedule_fragment)
    }

    fun setNumberPicker() {
        numberPickerPopup = NumberPickerPopup()
        numberPickerPopup.isCancelable = false
        numberPickerPopup.show(childFragmentManager, "")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> {
                if (resultCode == Activity.RESULT_OK) {
                    val data = data?.extras

                    val mist = data?.getString("mist")
                    val suspend = data?.getString("suspend")
                    mistValue.text = mist
                    suspendValue.text = suspend
                }
            }
        }
    }

    //BLUETOOTH CONTROLL
    fun setFirstDevice() {
        val deviceOne = prefs.firstDevice
        if (deviceOne.length > 1) {
            val gson = Gson()
            val deviceOneObj: MyDevice
            deviceOneObj = gson.fromJson(deviceOne, MyDevice::class.java)
            firstDevice = deviceOneObj.name
        }
    }

    fun setSecondDevice() {
        val deviceTwo = prefs.secondDevice
        if (deviceTwo.length > 1) {
            val gson = Gson()
            val deviceTwoObj: MyDevice
            deviceTwoObj = gson.fromJson(deviceTwo, MyDevice::class.java)
            secondDevice = deviceTwoObj.name
        }
    }

    fun initBleConroller() {
        bluetoothController =
            BluetoothController(
                notifyCallback,
                null,
                null,
                writeCallback,
                requireContext()
            )
        bluetoothController.bluetoothManager
            .enableLog(true)
            .setReConnectCount(1, 4000)
            .setConnectOverTime(18000).operateTimeout = 4000

        connectionStateCoordinator.bluetoothController = bluetoothController
        bluetoothController.bluetoothAdapter.startDiscovery()
        connectionStateCoordinator.isDeviceConnected = false
        bluetoothController.bluetoothManager.init(requireActivity().application)
//        val scanRuleConfig = BleScanRuleConfig.Builder()
//            .setAutoConnect(true)
//            .setScanTimeOut(10000)
//            .build()
//        BleManager.getInstance().initScanRule(scanRuleConfig)
        //  bluetoothController.bluetoothManager.cancelScan()
        connectionStateCoordinator.listBleDevices.clear()
        bluetoothController.startScan()

    }

    private val writeCallback = object : BleWriteCallback() {
        override fun onWriteSuccess(current: Int, total: Int, justWrite: ByteArray?) {
            Log.e("D", "onWriteSuccess ")
            readResponse()
        }

        override fun onWriteFailure(exception: BleException?) {
            Log.e("D", "Notification faild " + exception?.description)
            Log.e("D", "Notification faild " + exception?.code)
        }

    }


    private val notifyCallback = object : BleNotifyCallback() {
        override fun onNotifySuccess() {
            Log.e("d", "USPJESNO ")
        }

        override fun onNotifyFailure(exception: BleException) {
            Log.e("d", " onNotifyFailure $exception")
        }

        override fun onCharacteristicChanged(data: ByteArray) {

            var newData: UIntArray = UIntArray(data.size)
            for ((index, byte) in data.withIndex()) {
                Log.e("D", "ByteArray " + index + "." + byte)
            }
            for ((index, byte) in data.withIndex()) {
                newData[index] = byte.toUInt()
                Log.e("D", "UIntArray " + index + "." + byte.toChar())
            }
            if (allDevices == 2) {
                readSecondResponse()
            }
            //     connectionStateCoordinator.bluetoothByteArray.value = newData
            var i = 0
//            var dataList = ArrayList<Int>()
            // val idArray: Array<Byte> = arrayOf(data[5], data[6], data[7], data[8])
        }
    }

    fun readResponse() {
        Log.e("D", "onConnectSuccess SERVICE SIZE " + firstGate.services.size)
        for (service in firstGate.services) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController.blueGattAdapter.addResult(service)
                    Log.e(
                        "d",
                        "SERVICE characteristics descriptors " + service.characteristics.get(
                            0
                        ).descriptors
                    )
                }
            }
        }
        bluetoothController.bleDeviceMain = firstBleDevice
        connectionStateCoordinator.gatt = firstGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)

        if (bluetoothController.blueGattAdapter.getCount() > 0) {
            val service = bluetoothController.blueGattAdapter.getItem(0)
            bluetoothController.readNotification(
                bluetoothController.bleDeviceMain,
                service?.characteristics!!.get(0)
            )
        } else {
            Toast.makeText(
                requireContext(),
                "Notifications faild",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun readSecondResponse() {
        Log.e("D", "onConnectSuccess SERVICE SIZE " + secondGate.services.size)
        for (service in secondGate.services) {
            if (service.characteristics.size > 0) {
                Log.e("d", "UUID " + service.characteristics.get(0).uuid)

                if (service.characteristics.get(0).uuid.toString()
                        .equals("0000ffe1-0000-1000-8000-00805f9b34fb")
                ) {
                    bluetoothController.blueGattAdapter.addResult(service)
                    Log.e(
                        "d",
                        "SERVICE characteristics descriptors " + service.characteristics.get(
                            0
                        ).descriptors
                    )
                }
            }
        }
        bluetoothController.bleDeviceMain = secondBleDevice
        connectionStateCoordinator.gatt = secondGate
        //   Log.e("D", "bleDevicee.mac " + bleDevicee.mac)

        if (bluetoothController.blueGattAdapter.getCount() > 0) {
            val service = bluetoothController.blueGattAdapter.getItem(0)
            bluetoothController.readNotification(
                bluetoothController.bleDeviceMain,
                service?.characteristics!!.get(0)
            )

        } else {
            Toast.makeText(
                requireContext(),
                "Notifications faild",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}


