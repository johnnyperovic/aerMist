package llc.aerMist.app.ui.devices;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0016\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020_J\u0006\u0010`\u001a\u00020\\J\u0016\u0010a\u001a\u00020\\2\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020_J\u0018\u0010b\u001a\u00020\\2\u0006\u0010c\u001a\u00020\'2\u0006\u0010d\u001a\u00020<H\u0002J\b\u0010e\u001a\u00020\\H\u0002J\u0012\u0010f\u001a\u00020\\2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\"\u0010i\u001a\u00020\\2\u0006\u0010j\u001a\u00020\u00102\u0006\u0010k\u001a\u00020\u00102\b\u0010l\u001a\u0004\u0018\u00010mH\u0016J\u0012\u0010n\u001a\u00020\\2\b\u0010o\u001a\u0004\u0018\u00010pH\u0016J&\u0010q\u001a\u0004\u0018\u00010p2\u0006\u0010r\u001a\u00020s2\b\u0010t\u001a\u0004\u0018\u00010u2\b\u0010g\u001a\u0004\u0018\u00010hH\u0016J\u0006\u0010v\u001a\u00020\\J\u0006\u0010w\u001a\u00020\\J\u0006\u0010x\u001a\u00020\\J\u0006\u0010y\u001a\u00020\\J\u0006\u0010z\u001a\u00020\\J\u0016\u0010{\u001a\u00020\\2\u0006\u0010|\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\'J\u0016\u0010}\u001a\u00020\\2\u0006\u0010|\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\'J\u0016\u0010~\u001a\u00020\\2\u0006\u0010|\u001a\u00020\u00102\u0006\u0010c\u001a\u00020\'R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\u0010\u0010%\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0010\u00103\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00104\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010)\"\u0004\b6\u0010+R\u000e\u00107\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u00108\u001a\u0004\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u00100\"\u0004\b:\u00102R\u000e\u0010;\u001a\u00020<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020<X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010@\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bB\u0010CR\u000e\u0010F\u001a\u00020GX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010)\"\u0004\bM\u0010+R\u000e\u0010N\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010O\u001a\u0004\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u00100\"\u0004\bQ\u00102R\u0010\u0010R\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010S\u001a\u00020\'X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bT\u0010)\"\u0004\bU\u0010+R\u000e\u0010V\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010W\u001a\u0004\u0018\u00010.X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u00100\"\u0004\bY\u00102R\u000e\u0010Z\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u007f"}, d2 = {"Lllc/aerMist/app/ui/devices/MenageDevicesFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "bleList", "Ljava/util/ArrayList;", "Lcom/clj/fastble/data/BleDevice;", "charset", "Ljava/nio/charset/Charset;", "getCharset", "()Ljava/nio/charset/Charset;", "connectionStateCoordinator", "Lllc/aerMist/app/observers/NewObservableCoordinator;", "getConnectionStateCoordinator", "()Lllc/aerMist/app/observers/NewObservableCoordinator;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "deviceFourObj", "Lllc/aerMist/app/models/MyDevice;", "getDeviceFourObj", "()Lllc/aerMist/app/models/MyDevice;", "setDeviceFourObj", "(Lllc/aerMist/app/models/MyDevice;)V", "deviceOneObj", "getDeviceOneObj", "setDeviceOneObj", "deviceThreeObj", "getDeviceThreeObj", "setDeviceThreeObj", "deviceTotalNumber", "deviceTwoObj", "getDeviceTwoObj", "setDeviceTwoObj", "firstBleDevice", "firstDeviceNewName", "", "getFirstDeviceNewName", "()Ljava/lang/String;", "setFirstDeviceNewName", "(Ljava/lang/String;)V", "firstDevicePostion", "firstGate", "Landroid/bluetooth/BluetoothGatt;", "getFirstGate", "()Landroid/bluetooth/BluetoothGatt;", "setFirstGate", "(Landroid/bluetooth/BluetoothGatt;)V", "fourthBleDevice", "fourthDeviceNewName", "getFourthDeviceNewName", "setFourthDeviceNewName", "fourthDevicePosition", "fourthGate", "getFourthGate", "setFourthGate", "isFirstConnected", "", "isFourthConnected", "isSecondConnected", "isThirdConnected", "prefs", "Lllc/aerMist/app/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/app/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "removeDevicePopup", "Lllc/aerMist/app/ui/popup/RemoveDevicePopup;", "renameDeviceDialog", "Lllc/aerMist/app/ui/popup/RenameDevicePopup;", "secondBleDevice", "secondDeviceNewName", "getSecondDeviceNewName", "setSecondDeviceNewName", "secondDevicePosition", "secondGate", "getSecondGate", "setSecondGate", "thirdBleDevice", "thirdDeviceNewName", "getThirdDeviceNewName", "setThirdDeviceNewName", "thirdDevicePosition", "thirdGate", "getThirdGate", "setThirdGate", "totalNumber", "checkDisconectView", "", "bleDevice", "gattCallback", "Lcom/clj/fastble/callback/BleGattCallback;", "checkTotalNumber", "connectDevice", "navigateToDevice", "name", "isConnected", "navigateToSearchFragment", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "id", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setClickListener", "setFirstDevice", "setFourthDevice", "setSecondDevice", "setThirdDevice", "showRemoveDialog", "positon", "showRenameDialog", "showResetFilterDialog", "app_localApiDebug"})
public final class MenageDevicesFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private final kotlin.Lazy prefs$delegate = null;
    private int deviceTotalNumber = 0;
    private int totalNumber = 0;
    private com.clj.fastble.data.BleDevice firstBleDevice;
    private com.clj.fastble.data.BleDevice secondBleDevice;
    private com.clj.fastble.data.BleDevice thirdBleDevice;
    private com.clj.fastble.data.BleDevice fourthBleDevice;
    @org.jetbrains.annotations.Nullable()
    private android.bluetooth.BluetoothGatt firstGate;
    @org.jetbrains.annotations.Nullable()
    private android.bluetooth.BluetoothGatt secondGate;
    @org.jetbrains.annotations.Nullable()
    private android.bluetooth.BluetoothGatt thirdGate;
    @org.jetbrains.annotations.Nullable()
    private android.bluetooth.BluetoothGatt fourthGate;
    private int counter = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.nio.charset.Charset charset = null;
    @org.jetbrains.annotations.NotNull()
    private final llc.aerMist.app.observers.NewObservableCoordinator connectionStateCoordinator = null;
    private java.util.ArrayList<com.clj.fastble.data.BleDevice> bleList;
    private int firstDevicePostion = 0;
    private boolean isFirstConnected = false;
    private int secondDevicePosition = 0;
    private boolean isSecondConnected = false;
    private int thirdDevicePosition = 0;
    private boolean isThirdConnected = false;
    private int fourthDevicePosition = 0;
    private boolean isFourthConnected = false;
    private llc.aerMist.app.ui.popup.RenameDevicePopup renameDeviceDialog;
    private llc.aerMist.app.ui.popup.RemoveDevicePopup removeDevicePopup;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstDeviceNewName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondDeviceNewName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdDeviceNewName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourthDeviceNewName = "";
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceOneObj;
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceTwoObj;
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceThreeObj;
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceFourObj;
    private java.util.HashMap _$_findViewCache;
    
    private final llc.aerMist.app.shared.util.PreferenceCache getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getFirstGate() {
        return null;
    }
    
    public final void setFirstGate(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getSecondGate() {
        return null;
    }
    
    public final void setSecondGate(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getThirdGate() {
        return null;
    }
    
    public final void setThirdGate(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getFourthGate() {
        return null;
    }
    
    public final void setFourthGate(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    public final int getCounter() {
        return 0;
    }
    
    public final void setCounter(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.nio.charset.Charset getCharset() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.observers.NewObservableCoordinator getConnectionStateCoordinator() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstDeviceNewName() {
        return null;
    }
    
    public final void setFirstDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondDeviceNewName() {
        return null;
    }
    
    public final void setSecondDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdDeviceNewName() {
        return null;
    }
    
    public final void setThirdDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourthDeviceNewName() {
        return null;
    }
    
    public final void setFourthDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceOneObj() {
        return null;
    }
    
    public final void setDeviceOneObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceTwoObj() {
        return null;
    }
    
    public final void setDeviceTwoObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceThreeObj() {
        return null;
    }
    
    public final void setDeviceThreeObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceFourObj() {
        return null;
    }
    
    public final void setDeviceFourObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
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
    
    public final void checkDisconectView(@org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice bleDevice, @org.jetbrains.annotations.NotNull()
    com.clj.fastble.callback.BleGattCallback gattCallback) {
    }
    
    public final void checkTotalNumber() {
    }
    
    public final void connectDevice(@org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice bleDevice, @org.jetbrains.annotations.NotNull()
    com.clj.fastble.callback.BleGattCallback gattCallback) {
    }
    
    public final void showRenameDialog(int positon, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void showRemoveDialog(int positon, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void showResetFilterDialog(int positon, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void setFirstDevice() {
    }
    
    public final void setSecondDevice() {
    }
    
    public final void setThirdDevice() {
    }
    
    public final void setFourthDevice() {
    }
    
    public final void setClickListener() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View id) {
    }
    
    private final void navigateToDevice(java.lang.String name, boolean isConnected) {
    }
    
    private final void navigateToSearchFragment() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public MenageDevicesFragment() {
        super();
    }
}