package llc.aerMist.app.ui.home;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0006\u0010\\\u001a\u00020]J\b\u0010^\u001a\u00020]H\u0002J\"\u0010_\u001a\u00020]2\u0006\u0010`\u001a\u00020\u00052\u0006\u0010a\u001a\u00020\u00052\b\u0010b\u001a\u0004\u0018\u00010cH\u0016J\u0012\u0010d\u001a\u00020]2\b\u0010e\u001a\u0004\u0018\u00010fH\u0016J&\u0010g\u001a\u0004\u0018\u00010f2\u0006\u0010h\u001a\u00020i2\b\u0010j\u001a\u0004\u0018\u00010k2\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\u001a\u0010n\u001a\u00020]2\u0006\u0010o\u001a\u00020f2\b\u0010l\u001a\u0004\u0018\u00010mH\u0017J\u0006\u0010p\u001a\u00020]J\u0006\u0010q\u001a\u00020]J\u0006\u0010r\u001a\u00020]J\u0006\u0010s\u001a\u00020]J\u0006\u0010t\u001a\u00020]J\u0006\u0010u\u001a\u00020]J\u0006\u0010v\u001a\u00020]J\u0006\u0010w\u001a\u00020]J\u0006\u0010x\u001a\u00020]J\u0006\u0010L\u001a\u00020]J\u000e\u0010y\u001a\u00020]2\u0006\u0010z\u001a\u000208J\u0006\u0010{\u001a\u00020]J\b\u0010|\u001a\u00020]H\u0002J\u0006\u0010}\u001a\u00020]J \u0010~\u001a\u00020]2\u0006\u0010\u007f\u001a\u00020\u00112\u0007\u0010\u0080\u0001\u001a\u00020\u001f2\u0007\u0010\u0081\u0001\u001a\u00020\'R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010!\"\u0004\b.\u0010#R\u001a\u0010/\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010)\"\u0004\b6\u0010+R\u000e\u00107\u001a\u000208X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020:X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020<X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001b\u0010A\u001a\u00020B8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bC\u0010DR\u001a\u0010G\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010!\"\u0004\bI\u0010#R\u001a\u0010J\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u00101\"\u0004\bL\u00103R\u001a\u0010M\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010)\"\u0004\bO\u0010+R\u000e\u0010P\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010!\"\u0004\bS\u0010#R\u001a\u0010T\u001a\u00020%X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u00101\"\u0004\bV\u00103R\u001a\u0010W\u001a\u00020\'X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010)\"\u0004\bY\u0010+R\u000e\u0010Z\u001a\u00020[X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0082\u0001"}, d2 = {"Lllc/aerMist/app/ui/home/HomeFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "allDevices", "", "getAllDevices", "()I", "setAllDevices", "(I)V", "bluetoothController", "Lllc/aerMist/app/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/app/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/app/helpers/BluetoothController;)V", "byteArrayOF", "", "getByteArrayOF", "()[B", "byteArrayON", "getByteArrayON", "charset", "Ljava/nio/charset/Charset;", "getCharset", "()Ljava/nio/charset/Charset;", "connectionStateCoordinator", "Lllc/aerMist/app/observers/NewObservableCoordinator;", "getConnectionStateCoordinator", "()Lllc/aerMist/app/observers/NewObservableCoordinator;", "firstBleDevice", "Lcom/clj/fastble/data/BleDevice;", "getFirstBleDevice", "()Lcom/clj/fastble/data/BleDevice;", "setFirstBleDevice", "(Lcom/clj/fastble/data/BleDevice;)V", "firstDevice", "", "firstGate", "Landroid/bluetooth/BluetoothGatt;", "getFirstGate", "()Landroid/bluetooth/BluetoothGatt;", "setFirstGate", "(Landroid/bluetooth/BluetoothGatt;)V", "fourthBleDevice", "getFourthBleDevice", "setFourthBleDevice", "fourthDevice", "getFourthDevice", "()Ljava/lang/String;", "setFourthDevice", "(Ljava/lang/String;)V", "fourthGate", "getFourthGate", "setFourthGate", "isFirstDevice", "", "notifyCallback", "Lcom/clj/fastble/callback/BleNotifyCallback;", "numberPickerPopup", "Lllc/aerMist/app/ui/popup/NumberPickerPopup;", "getNumberPickerPopup", "()Lllc/aerMist/app/ui/popup/NumberPickerPopup;", "setNumberPickerPopup", "(Lllc/aerMist/app/ui/popup/NumberPickerPopup;)V", "prefs", "Lllc/aerMist/app/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/app/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "secondBleDevice", "getSecondBleDevice", "setSecondBleDevice", "secondDevice", "getSecondDevice", "setSecondDevice", "secondGate", "getSecondGate", "setSecondGate", "tag", "thirdBleDevice", "getThirdBleDevice", "setThirdBleDevice", "thirdDevice", "getThirdDevice", "setThirdDevice", "thirdGate", "getThirdGate", "setThirdGate", "writeCallback", "Lcom/clj/fastble/callback/BleWriteCallback;", "initBleConroller", "", "navigateToSetSchedule", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "id", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "readResponse", "readSecondResponse", "setClickListener", "setFirstDevice", "setIntervalView", "setMotionLayoutListener", "setNonStopView", "setNumberPicker", "setScheduleView", "setTabItemVisibility", "state", "setTouchSwipeListener", "showDialog", "startAnimation", "turnOnOFDevice", "input", "bleDevice", "gatt", "app_localApiDebug"})
public final class HomeFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private final kotlin.Lazy prefs$delegate = null;
    private int tag = 0;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.ui.popup.NumberPickerPopup numberPickerPopup;
    @org.jetbrains.annotations.NotNull()
    public llc.aerMist.app.helpers.BluetoothController bluetoothController;
    @org.jetbrains.annotations.NotNull()
    private final llc.aerMist.app.observers.NewObservableCoordinator connectionStateCoordinator = null;
    private java.lang.String firstDevice = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondDevice = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdDevice = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourthDevice = "";
    @org.jetbrains.annotations.NotNull()
    public com.clj.fastble.data.BleDevice firstBleDevice;
    @org.jetbrains.annotations.NotNull()
    public com.clj.fastble.data.BleDevice secondBleDevice;
    @org.jetbrains.annotations.NotNull()
    public com.clj.fastble.data.BleDevice thirdBleDevice;
    @org.jetbrains.annotations.NotNull()
    public com.clj.fastble.data.BleDevice fourthBleDevice;
    @org.jetbrains.annotations.NotNull()
    public android.bluetooth.BluetoothGatt firstGate;
    @org.jetbrains.annotations.NotNull()
    public android.bluetooth.BluetoothGatt secondGate;
    @org.jetbrains.annotations.NotNull()
    public android.bluetooth.BluetoothGatt thirdGate;
    @org.jetbrains.annotations.NotNull()
    public android.bluetooth.BluetoothGatt fourthGate;
    private boolean isFirstDevice = true;
    @org.jetbrains.annotations.NotNull()
    private final java.nio.charset.Charset charset = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] byteArrayON = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] byteArrayOF = null;
    private int allDevices = 0;
    private final com.clj.fastble.callback.BleWriteCallback writeCallback = null;
    private final com.clj.fastble.callback.BleNotifyCallback notifyCallback = null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondDevice() {
        return null;
    }
    
    public final void setSecondDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdDevice() {
        return null;
    }
    
    public final void setThirdDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourthDevice() {
        return null;
    }
    
    public final void setFourthDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.clj.fastble.data.BleDevice getFirstBleDevice() {
        return null;
    }
    
    public final void setFirstBleDevice(@org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.clj.fastble.data.BleDevice getSecondBleDevice() {
        return null;
    }
    
    public final void setSecondBleDevice(@org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.clj.fastble.data.BleDevice getThirdBleDevice() {
        return null;
    }
    
    public final void setThirdBleDevice(@org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.clj.fastble.data.BleDevice getFourthBleDevice() {
        return null;
    }
    
    public final void setFourthBleDevice(@org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.bluetooth.BluetoothGatt getFirstGate() {
        return null;
    }
    
    public final void setFirstGate(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.bluetooth.BluetoothGatt getSecondGate() {
        return null;
    }
    
    public final void setSecondGate(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.bluetooth.BluetoothGatt getThirdGate() {
        return null;
    }
    
    public final void setThirdGate(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.bluetooth.BluetoothGatt getFourthGate() {
        return null;
    }
    
    public final void setFourthGate(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.nio.charset.Charset getCharset() {
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
    
    public final int getAllDevices() {
        return 0;
    }
    
    public final void setAllDevices(int p0) {
    }
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void setTouchSwipeListener() {
    }
    
    public final void setMotionLayoutListener() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    public final void setClickListener() {
    }
    
    public final void setTabItemVisibility(boolean state) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View id) {
    }
    
    public final void turnOnOFDevice(@org.jetbrains.annotations.NotNull()
    byte[] input, @org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice bleDevice, @org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGatt gatt) {
    }
    
    public final void setNonStopView() {
    }
    
    public final void setIntervalView() {
    }
    
    public final void setScheduleView() {
    }
    
    public final void startAnimation() {
    }
    
    private final void showDialog() {
    }
    
    private final void navigateToSetSchedule() {
    }
    
    public final void setNumberPicker() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public final void setFirstDevice() {
    }
    
    public final void setSecondDevice() {
    }
    
    public final void initBleConroller() {
    }
    
    public final void readResponse() {
    }
    
    public final void readSecondResponse() {
    }
    
    public HomeFragment() {
        super();
    }
}