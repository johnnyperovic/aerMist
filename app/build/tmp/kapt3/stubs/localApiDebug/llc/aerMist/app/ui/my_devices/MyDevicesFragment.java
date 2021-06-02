package llc.aerMist.app.ui.my_devices;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020=H\u0002J\u0012\u0010?\u001a\u00020=2\b\u0010@\u001a\u0004\u0018\u00010AH\u0017J&\u0010B\u001a\u0004\u0018\u00010C2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u00010G2\b\u0010@\u001a\u0004\u0018\u00010AH\u0016J\u0006\u0010#\u001a\u00020=J\u0006\u0010H\u001a\u00020=J\u0006\u0010I\u001a\u00020=J\u0006\u0010J\u001a\u00020=R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010-\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u0007\"\u0004\b/\u0010\tR\u000e\u00100\u001a\u000201X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u00102\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b6\u00107\u001a\u0004\b4\u00105R\u000e\u00108\u001a\u000209X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006K"}, d2 = {"Lllc/aerMist/app/ui/my_devices/MyDevicesFragment;", "Landroidx/fragment/app/Fragment;", "()V", "availableDevicesList", "", "Lcom/clj/fastble/data/BleDevice;", "getAvailableDevicesList", "()Ljava/util/List;", "setAvailableDevicesList", "(Ljava/util/List;)V", "bluetoothController", "Lllc/aerMist/app/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/app/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/app/helpers/BluetoothController;)V", "connectionStateCoordinator", "Lllc/aerMist/app/observers/NewObservableCoordinator;", "getConnectionStateCoordinator", "()Lllc/aerMist/app/observers/NewObservableCoordinator;", "deviceTotalNumber", "", "getDeviceTotalNumber", "()I", "setDeviceTotalNumber", "(I)V", "firstBleDevice", "getFirstBleDevice", "()Lcom/clj/fastble/data/BleDevice;", "setFirstBleDevice", "(Lcom/clj/fastble/data/BleDevice;)V", "firstDevice", "", "getFirstDevice", "()Ljava/lang/String;", "setFirstDevice", "(Ljava/lang/String;)V", "firstGate", "Landroid/bluetooth/BluetoothGatt;", "getFirstGate", "()Landroid/bluetooth/BluetoothGatt;", "setFirstGate", "(Landroid/bluetooth/BluetoothGatt;)V", "gattCallback", "Lcom/clj/fastble/callback/BleGattCallback;", "list", "getList", "setList", "notifyCallback", "Lcom/clj/fastble/callback/BleNotifyCallback;", "prefs", "Lllc/aerMist/app/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/app/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "scanCallback", "Lcom/clj/fastble/callback/BleScanCallback;", "writeCallback", "Lcom/clj/fastble/callback/BleWriteCallback;", "navigateToAvailableDevices", "", "navigateToMain", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setFourthDevice", "setSecondDevice", "setThirdDevice", "app_localApiDebug"})
public final class MyDevicesFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy prefs$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public llc.aerMist.app.helpers.BluetoothController bluetoothController;
    @org.jetbrains.annotations.NotNull()
    private final llc.aerMist.app.observers.NewObservableCoordinator connectionStateCoordinator = null;
    @org.jetbrains.annotations.NotNull()
    public java.util.List<? extends com.clj.fastble.data.BleDevice> availableDevicesList;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<? extends com.clj.fastble.data.BleDevice> list;
    private int deviceTotalNumber = 0;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String firstDevice;
    @org.jetbrains.annotations.NotNull()
    public com.clj.fastble.data.BleDevice firstBleDevice;
    @org.jetbrains.annotations.NotNull()
    public android.bluetooth.BluetoothGatt firstGate;
    private final com.clj.fastble.callback.BleWriteCallback writeCallback = null;
    private final com.clj.fastble.callback.BleScanCallback scanCallback = null;
    private final com.clj.fastble.callback.BleGattCallback gattCallback = null;
    private final com.clj.fastble.callback.BleNotifyCallback notifyCallback = null;
    private java.util.HashMap _$_findViewCache;
    
    private final llc.aerMist.app.shared.util.PreferenceCache getPrefs() {
        return null;
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
    public final java.util.List<com.clj.fastble.data.BleDevice> getAvailableDevicesList() {
        return null;
    }
    
    public final void setAvailableDevicesList(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.clj.fastble.data.BleDevice> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.clj.fastble.data.BleDevice> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends com.clj.fastble.data.BleDevice> p0) {
    }
    
    public final int getDeviceTotalNumber() {
        return 0;
    }
    
    public final void setDeviceTotalNumber(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstDevice() {
        return null;
    }
    
    public final void setFirstDevice(@org.jetbrains.annotations.NotNull()
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
    public final android.bluetooth.BluetoothGatt getFirstGate() {
        return null;
    }
    
    public final void setFirstGate(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetTextI18n"})
    @java.lang.Override()
    public void onActivityCreated(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void navigateToAvailableDevices() {
    }
    
    private final void navigateToMain() {
    }
    
    public final void setFirstDevice() {
    }
    
    public final void setSecondDevice() {
    }
    
    public final void setThirdDevice() {
    }
    
    public final void setFourthDevice() {
    }
    
    public MyDevicesFragment() {
        super();
    }
}