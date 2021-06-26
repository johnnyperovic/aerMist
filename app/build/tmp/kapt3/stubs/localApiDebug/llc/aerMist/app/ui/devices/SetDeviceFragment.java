package llc.aerMist.app.ui.devices;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00b8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0011\u0010\u009e\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00a0\u0001\u001a\u00020\u001bJ\u0011\u0010\u00a1\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00a0\u0001\u001a\u00020\u001bJ\u0011\u0010\u00a2\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00a0\u0001\u001a\u00020\u001bJ\b\u0010\u00a3\u0001\u001a\u00030\u009f\u0001J\b\u0010\u00a4\u0001\u001a\u00030\u009f\u0001J\b\u0010\u00a5\u0001\u001a\u00030\u009f\u0001J\u0010\u0010\u00a6\u0001\u001a\u00020P2\u0007\u0010\u00a7\u0001\u001a\u00020\u001bJ\u0012\u0010\u00a8\u0001\u001a\u00020\u001b2\u0007\u0010\u00a0\u0001\u001a\u00020\u001bH\u0002J\u0010\u0010\u00a9\u0001\u001a\u00020\u001b2\u0007\u0010\u00aa\u0001\u001a\u00020\u001bJ\u0010\u0010\u00ab\u0001\u001a\u00020\u001b2\u0007\u0010\u00ac\u0001\u001a\u00020\u001bJ\n\u0010\u00ad\u0001\u001a\u00030\u009f\u0001H\u0002J\u0016\u0010\u00ae\u0001\u001a\u00030\u009f\u00012\n\u0010\u00af\u0001\u001a\u0005\u0018\u00010\u00b0\u0001H\u0017J(\u0010\u00b1\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00b2\u0001\u001a\u00020P2\u0007\u0010\u00b3\u0001\u001a\u00020P2\n\u0010\u00b4\u0001\u001a\u0005\u0018\u00010\u00b5\u0001H\u0016J\u0016\u0010\u00b6\u0001\u001a\u00030\u009f\u00012\n\u0010\u00b7\u0001\u001a\u0005\u0018\u00010\u00b8\u0001H\u0016J.\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00b8\u00012\b\u0010\u00ba\u0001\u001a\u00030\u00bb\u00012\n\u0010\u00bc\u0001\u001a\u0005\u0018\u00010\u00bd\u00012\n\u0010\u00af\u0001\u001a\u0005\u0018\u00010\u00b0\u0001H\u0016J\u0011\u0010\u00be\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00a0\u0001\u001a\u00020\u001bJ!\u0010\u00bf\u0001\u001a\u00030\u009f\u00012\u0007\u0010\u00c0\u0001\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u00105\u001a\u000206J\b\u0010\u00c1\u0001\u001a\u00030\u009f\u0001J\b\u0010\u00c2\u0001\u001a\u00030\u009f\u0001J\b\u0010\u00c3\u0001\u001a\u00030\u009f\u0001J\b\u0010\u00c4\u0001\u001a\u00030\u009f\u0001J\b\u0010\u00c5\u0001\u001a\u00030\u009f\u0001J\b\u0010\u00c6\u0001\u001a\u00030\u009f\u0001J\u0012\u0010\u00c7\u0001\u001a\u00030\u009f\u00012\b\u0010\u00c8\u0001\u001a\u00030\u00c9\u0001J\b\u0010\u00ca\u0001\u001a\u00030\u009f\u0001J\b\u0010\u00cb\u0001\u001a\u00030\u009f\u0001R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001d\"\u0004\b.\u0010\u001fR\u001a\u0010/\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001d\"\u0004\b1\u0010\u001fR\u001a\u00102\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001d\"\u0004\b4\u0010\u001fR\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u00107\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u000fR\u0011\u00109\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\u000fR\u0011\u0010;\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u000fR\u0011\u0010=\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\u000fR\u0011\u0010?\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\u000fR\u0011\u0010A\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010\u000fR\u0011\u0010C\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010\u000fR\u0011\u0010E\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010\u000fR\u0011\u0010G\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010\u000fR\u001a\u0010I\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u000f\"\u0004\bK\u0010LR\u0011\u0010M\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\bN\u0010\u000fR\u001a\u0010O\u001a\u00020PX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u000e\u0010U\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\u001d\"\u0004\bX\u0010\u001fR\u0011\u0010Y\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\bZ\u0010\u000fR\u001a\u0010[\u001a\u00020\\X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u000e\u0010a\u001a\u00020bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010c\u001a\u00020d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bg\u0010h\u001a\u0004\be\u0010fR\u001a\u0010i\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bj\u0010\u001d\"\u0004\bk\u0010\u001fR\u0014\u0010l\u001a\u00020\u001bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bm\u0010\u001dR\u0014\u0010n\u001a\u00020\u001bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\bo\u0010\u001dR\u000e\u0010p\u001a\u00020qX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010r\u001a\u00020s8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bt\u0010uR\u0014\u0010x\u001a\u00020\u001bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\by\u0010\u001dR\u0014\u0010z\u001a\u00020\u001bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b{\u0010\u001dR\u0014\u0010|\u001a\u00020\u001bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b}\u0010\u001dR\u0014\u0010~\u001a\u00020\u001bX\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u007f\u0010\u001dR\u0016\u0010\u0080\u0001\u001a\u00020\u001bX\u0086D\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u001dR\u001d\u0010\u0082\u0001\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u001d\"\u0005\b\u0084\u0001\u0010\u001fR\u0013\u0010\u0085\u0001\u001a\u00020\r\u00a2\u0006\t\n\u0000\u001a\u0005\b\u0086\u0001\u0010\u000fR\u001d\u0010\u0087\u0001\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u001d\"\u0005\b\u0089\u0001\u0010\u001fR\u001d\u0010\u008a\u0001\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008b\u0001\u0010\u000f\"\u0005\b\u008c\u0001\u0010LR\u001d\u0010\u008d\u0001\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u008e\u0001\u0010\u001d\"\u0005\b\u008f\u0001\u0010\u001fR\u000f\u0010\u0090\u0001\u001a\u00020\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0001\u001a\u00020PX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0092\u0001\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u001d\"\u0005\b\u0094\u0001\u0010\u001fR\u001d\u0010\u0095\u0001\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010\u001d\"\u0005\b\u0097\u0001\u0010\u001fR\u001d\u0010\u0098\u0001\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010\u001d\"\u0005\b\u009a\u0001\u0010\u001fR\u001d\u0010\u009b\u0001\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010\u001d\"\u0005\b\u009d\u0001\u0010\u001f\u00a8\u0006\u00cc\u0001"}, d2 = {"Lllc/aerMist/app/ui/devices/SetDeviceFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "bleDevice", "Lcom/clj/fastble/data/BleDevice;", "bluetoothController", "Lllc/aerMist/app/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/app/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/app/helpers/BluetoothController;)V", "byteArrayOF", "", "getByteArrayOF", "()[B", "byteArrayON", "getByteArrayON", "charset", "Ljava/nio/charset/Charset;", "getCharset", "()Ljava/nio/charset/Charset;", "connectionStateCoordinator", "Lllc/aerMist/app/observers/NewObservableCoordinator;", "getConnectionStateCoordinator", "()Lllc/aerMist/app/observers/NewObservableCoordinator;", "dateAndTimeSynch", "", "getDateAndTimeSynch", "()Ljava/lang/String;", "setDateAndTimeSynch", "(Ljava/lang/String;)V", "daysInWeek", "", "getDaysInWeek", "()[I", "setDaysInWeek", "([I)V", "deviceObject", "Lllc/aerMist/app/models/MyDevice;", "getDeviceObject", "()Lllc/aerMist/app/models/MyDevice;", "setDeviceObject", "(Lllc/aerMist/app/models/MyDevice;)V", "firstTimer", "getFirstTimer", "setFirstTimer", "fourthTimer", "getFourthTimer", "setFourthTimer", "friday", "getFriday", "setFriday", "gatt", "Landroid/bluetooth/BluetoothGatt;", "intervalFR", "getIntervalFR", "intervalFS", "getIntervalFS", "intervalMo", "getIntervalMo", "intervalOn", "getIntervalOn", "intervalSA", "getIntervalSA", "intervalSS", "getIntervalSS", "intervalSU", "getIntervalSU", "intervalTH", "getIntervalTH", "intervalTu", "getIntervalTu", "intervalValue", "getIntervalValue", "setIntervalValue", "([B)V", "intervalWE", "getIntervalWE", "mainDevicePositon", "", "getMainDevicePositon", "()I", "setMainDevicePositon", "(I)V", "mistValueSeconds", "monday", "getMonday", "setMonday", "nonStopOn", "getNonStopOn", "numberPickerPopup", "Lllc/aerMist/app/ui/popup/NumberPickerPopup;", "getNumberPickerPopup", "()Lllc/aerMist/app/ui/popup/NumberPickerPopup;", "setNumberPickerPopup", "(Lllc/aerMist/app/ui/popup/NumberPickerPopup;)V", "payload", "Lllc/aerMist/app/models/BytePayload;", "prefs", "Lllc/aerMist/app/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/app/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "saturday", "getSaturday", "setSaturday", "scheduleFR", "getScheduleFR", "scheduleMo", "getScheduleMo", "scheduleModel", "Lllc/aerMist/app/models/ScheduleModel;", "scheduleModelArgs", "Lllc/aerMist/app/ui/devices/SetDeviceFragmentArgs;", "getScheduleModelArgs", "()Lllc/aerMist/app/ui/devices/SetDeviceFragmentArgs;", "scheduleModelArgs$delegate", "Landroidx/navigation/NavArgsLazy;", "scheduleSA", "getScheduleSA", "scheduleSU", "getScheduleSU", "scheduleTH", "getScheduleTH", "scheduleTu", "getScheduleTu", "scheduleWE", "getScheduleWE", "secondTimer", "getSecondTimer", "setSecondTimer", "sprayFriq", "getSprayFriq", "sprayFriquency", "getSprayFriquency", "setSprayFriquency", "sprayPDON", "getSprayPDON", "setSprayPDON", "sunday", "getSunday", "setSunday", "suspendValueSeconds", "tag", "thirdTimer", "getThirdTimer", "setThirdTimer", "thursday", "getThursday", "setThursday", "tuesday", "getTuesday", "setTuesday", "wednesday", "getWednesday", "setWednesday", "checkIntervalResponse", "", "response", "checkNonStopResponse", "checkScheduleRespone", "formatDateAndTime", "formatDaySchedule", "formatTimer", "getDayInWeek", "day", "getRegister", "getSeconds", "value", "getTimeFromSeconds", "seconds", "navigateToSetSchedule", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "id", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "readTimerSync", "sendCommand", "input", "setClickListener", "setIntervalView", "setMotionLayoutListener", "setNonStopView", "setNumberPicker", "setScheduleView", "setTabItemVisibility", "state", "", "setTouchSwipeListener", "startAnimationSendCommand", "app_localApiDebug"})
public final class SetDeviceFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private final kotlin.Lazy prefs$delegate = null;
    private int tag = 0;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.ui.popup.NumberPickerPopup numberPickerPopup;
    @org.jetbrains.annotations.NotNull()
    public llc.aerMist.app.helpers.BluetoothController bluetoothController;
    @org.jetbrains.annotations.NotNull()
    private final llc.aerMist.app.observers.NewObservableCoordinator connectionStateCoordinator = null;
    private com.clj.fastble.data.BleDevice bleDevice;
    private android.bluetooth.BluetoothGatt gatt;
    private llc.aerMist.app.models.BytePayload payload;
    private java.lang.String mistValueSeconds = "100";
    private java.lang.String suspendValueSeconds = "100";
    private final androidx.navigation.NavArgsLazy scheduleModelArgs$delegate = null;
    private llc.aerMist.app.models.ScheduleModel scheduleModel;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String dateAndTimeSynch = "EE00+YYYYMMDDHHNNSST";
    @org.jetbrains.annotations.NotNull()
    private final java.nio.charset.Charset charset = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] nonStopOn = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] byteArrayON = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] byteArrayOF = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalOn = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalMo = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalTu = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalWE = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalTH = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalFR = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalSA = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalSU = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalSS = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] intervalFS = null;
    @org.jetbrains.annotations.NotNull()
    private byte[] intervalValue;
    @org.jetbrains.annotations.NotNull()
    private byte[] sprayPDON;
    @org.jetbrains.annotations.NotNull()
    private final byte[] sprayFriq = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleMo = "EE0300";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleTu = "EE0301";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleWE = "EE0302";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleTH = "EE0303";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleFR = "EE0304";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleSA = "EE0305";
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String scheduleSU = "EE0306";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String monday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String tuesday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String wednesday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thursday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String friday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String saturday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String sunday = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstTimer = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondTimer = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdTimer = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourthTimer = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String sprayFriquency = "EE07000000SSS00PPP";
    @org.jetbrains.annotations.NotNull()
    public int[] daysInWeek;
    @org.jetbrains.annotations.NotNull()
    public llc.aerMist.app.models.MyDevice deviceObject;
    private int mainDevicePositon = 0;
    private java.util.HashMap _$_findViewCache;
    
    private final llc.aerMist.app.shared.util.PreferenceCache getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.ui.popup.NumberPickerPopup getNumberPickerPopup() {
        return null;
    }
    
    public final void setNumberPickerPopup(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.ui.popup.NumberPickerPopup p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.helpers.BluetoothController getBluetoothController() {
        return null;
    }
    
    public final void setBluetoothController(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.helpers.BluetoothController p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.observers.NewObservableCoordinator getConnectionStateCoordinator() {
        return null;
    }
    
    private final llc.aerMist.app.ui.devices.SetDeviceFragmentArgs getScheduleModelArgs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDateAndTimeSynch() {
        return null;
    }
    
    public final void setDateAndTimeSynch(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.nio.charset.Charset getCharset() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getNonStopOn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getByteArrayON() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getByteArrayOF() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalOn() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalMo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalTu() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalWE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalTH() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalFR() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalSA() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalSU() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalSS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalFS() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getIntervalValue() {
        return null;
    }
    
    public final void setIntervalValue(@org.jetbrains.annotations.NotNull()
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getSprayPDON() {
        return null;
    }
    
    public final void setSprayPDON(@org.jetbrains.annotations.NotNull()
    byte[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final byte[] getSprayFriq() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleMo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleTu() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleWE() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleTH() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleFR() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleSA() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleSU() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMonday() {
        return null;
    }
    
    public final void setMonday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTuesday() {
        return null;
    }
    
    public final void setTuesday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWednesday() {
        return null;
    }
    
    public final void setWednesday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThursday() {
        return null;
    }
    
    public final void setThursday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFriday() {
        return null;
    }
    
    public final void setFriday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSaturday() {
        return null;
    }
    
    public final void setSaturday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSunday() {
        return null;
    }
    
    public final void setSunday(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstTimer() {
        return null;
    }
    
    public final void setFirstTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondTimer() {
        return null;
    }
    
    public final void setSecondTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdTimer() {
        return null;
    }
    
    public final void setThirdTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourthTimer() {
        return null;
    }
    
    public final void setFourthTimer(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSprayFriquency() {
        return null;
    }
    
    public final void setSprayFriquency(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final int[] getDaysInWeek() {
        return null;
    }
    
    public final void setDaysInWeek(@org.jetbrains.annotations.NotNull()
    int[] p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.MyDevice getDeviceObject() {
        return null;
    }
    
    public final void setDeviceObject(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    public final int getMainDevicePositon() {
        return 0;
    }
    
    public final void setMainDevicePositon(int p0) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public final void formatDateAndTime() {
    }
    
    public final int getDayInWeek(@org.jetbrains.annotations.NotNull()
    java.lang.String day) {
        return 0;
    }
    
    public final void readTimerSync(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    private final java.lang.String getRegister(java.lang.String response) {
        return null;
    }
    
    public final void formatDaySchedule() {
    }
    
    public final void checkNonStopResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void checkIntervalResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void checkScheduleRespone(@org.jetbrains.annotations.NotNull()
    java.lang.String response) {
    }
    
    public final void formatTimer() {
    }
    
    public final void setClickListener() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View id) {
    }
    
    public final void setMotionLayoutListener() {
    }
    
    public final void setTouchSwipeListener() {
    }
    
    public final void setTabItemVisibility(boolean state) {
    }
    
    public final void startAnimationSendCommand() {
    }
    
    public final void sendCommand(@org.jetbrains.annotations.NotNull()
    byte[] input, @org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice bleDevice, @org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGatt gatt) {
    }
    
    public final void setNumberPicker() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void setNonStopView() {
    }
    
    public final void setIntervalView() {
    }
    
    public final void setScheduleView() {
    }
    
    private final void navigateToSetSchedule() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSeconds(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTimeFromSeconds(@org.jetbrains.annotations.NotNull()
    java.lang.String seconds) {
        return null;
    }
    
    public SetDeviceFragment() {
        super();
    }
}