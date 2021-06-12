package llc.aerMist.app.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B?\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0010\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010<\u001a\u00020:J\u0018\u0010=\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u000f2\u0006\u0010>\u001a\u00020?J\u0018\u0010@\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u000f2\u0006\u0010>\u001a\u00020?J\u0006\u0010A\u001a\u00020:J\u0006\u0010B\u001a\u00020:J\u001e\u0010C\u001a\u00020:2\u0006\u0010;\u001a\u00020\u000f2\u0006\u0010D\u001a\u00020E2\u0006\u0010>\u001a\u00020?R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010$\u001a\u00020%\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0016\u00102\u001a\n 4*\u0004\u0018\u00010303X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108\u00a8\u0006F"}, d2 = {"Lllc/aerMist/app/helpers/BluetoothController;", "", "notifyCallback", "Lcom/clj/fastble/callback/BleNotifyCallback;", "notifyCallback2", "gattCallback", "Lcom/clj/fastble/callback/BleGattCallback;", "scanCallback", "Lcom/clj/fastble/callback/BleScanCallback;", "writeCallback", "Lcom/clj/fastble/callback/BleWriteCallback;", "applicationContext", "Landroid/content/Context;", "(Lcom/clj/fastble/callback/BleNotifyCallback;Lcom/clj/fastble/callback/BleNotifyCallback;Lcom/clj/fastble/callback/BleGattCallback;Lcom/clj/fastble/callback/BleScanCallback;Lcom/clj/fastble/callback/BleWriteCallback;Landroid/content/Context;)V", "bleDeviceMain", "Lcom/clj/fastble/data/BleDevice;", "getBleDeviceMain", "()Lcom/clj/fastble/data/BleDevice;", "setBleDeviceMain", "(Lcom/clj/fastble/data/BleDevice;)V", "blueGattAdapter", "Lllc/aerMist/app/adapters/BlueGattAdapter;", "getBlueGattAdapter", "()Lllc/aerMist/app/adapters/BlueGattAdapter;", "setBlueGattAdapter", "(Lllc/aerMist/app/adapters/BlueGattAdapter;)V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "setBluetoothAdapter", "(Landroid/bluetooth/BluetoothAdapter;)V", "bluetoothManager", "Lcom/clj/fastble/BleManager;", "getBluetoothManager", "()Lcom/clj/fastble/BleManager;", "connectionStateCoordinator", "Lllc/aerMist/app/observers/NewObservableCoordinator;", "getConnectionStateCoordinator", "()Lllc/aerMist/app/observers/NewObservableCoordinator;", "getGattCallback", "()Lcom/clj/fastble/callback/BleGattCallback;", "isMyDevice", "", "()Z", "setMyDevice", "(Z)V", "getNotifyCallback", "()Lcom/clj/fastble/callback/BleNotifyCallback;", "getNotifyCallback2", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "getScanCallback", "()Lcom/clj/fastble/callback/BleScanCallback;", "getWriteCallback", "()Lcom/clj/fastble/callback/BleWriteCallback;", "connect", "", "bleDevice", "initScanRule", "readNotification", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "readNotification2", "startConnectingMyDevices", "startScan", "writeCommand", "input", "", "app_localApiDebug"})
public final class BluetoothController {
    @org.jetbrains.annotations.NotNull()
    private android.bluetooth.BluetoothAdapter bluetoothAdapter;
    @org.jetbrains.annotations.Nullable()
    private com.clj.fastble.data.BleDevice bleDeviceMain;
    @org.jetbrains.annotations.NotNull()
    private llc.aerMist.app.adapters.BlueGattAdapter blueGattAdapter;
    @org.jetbrains.annotations.NotNull()
    private final com.clj.fastble.BleManager bluetoothManager = null;
    @org.jetbrains.annotations.NotNull()
    private final llc.aerMist.app.observers.NewObservableCoordinator connectionStateCoordinator = null;
    private final android.content.SharedPreferences prefs = null;
    private boolean isMyDevice = false;
    @org.jetbrains.annotations.Nullable()
    private final com.clj.fastble.callback.BleNotifyCallback notifyCallback = null;
    @org.jetbrains.annotations.Nullable()
    private final com.clj.fastble.callback.BleNotifyCallback notifyCallback2 = null;
    @org.jetbrains.annotations.Nullable()
    private final com.clj.fastble.callback.BleGattCallback gattCallback = null;
    @org.jetbrains.annotations.Nullable()
    private final com.clj.fastble.callback.BleScanCallback scanCallback = null;
    @org.jetbrains.annotations.Nullable()
    private final com.clj.fastble.callback.BleWriteCallback writeCallback = null;
    
    @org.jetbrains.annotations.NotNull()
    public final android.bluetooth.BluetoothAdapter getBluetoothAdapter() {
        return null;
    }
    
    public final void setBluetoothAdapter(@org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothAdapter p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.data.BleDevice getBleDeviceMain() {
        return null;
    }
    
    public final void setBleDeviceMain(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.adapters.BlueGattAdapter getBlueGattAdapter() {
        return null;
    }
    
    public final void setBlueGattAdapter(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.adapters.BlueGattAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.clj.fastble.BleManager getBluetoothManager() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.observers.NewObservableCoordinator getConnectionStateCoordinator() {
        return null;
    }
    
    public final boolean isMyDevice() {
        return false;
    }
    
    public final void setMyDevice(boolean p0) {
    }
    
    public final void readNotification(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice bleDevice, @org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGattCharacteristic characteristic) {
    }
    
    public final void readNotification2(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice bleDevice, @org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGattCharacteristic characteristic) {
    }
    
    public final void writeCommand(@org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice bleDevice, @org.jetbrains.annotations.NotNull()
    byte[] input, @org.jetbrains.annotations.NotNull()
    android.bluetooth.BluetoothGattCharacteristic characteristic) {
    }
    
    public final void connect(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice bleDevice) {
    }
    
    public final void startScan() {
    }
    
    public final void initScanRule() {
    }
    
    public final void startConnectingMyDevices() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.callback.BleNotifyCallback getNotifyCallback() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.callback.BleNotifyCallback getNotifyCallback2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.callback.BleGattCallback getGattCallback() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.callback.BleScanCallback getScanCallback() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.callback.BleWriteCallback getWriteCallback() {
        return null;
    }
    
    public BluetoothController(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.callback.BleNotifyCallback notifyCallback, @org.jetbrains.annotations.Nullable()
    com.clj.fastble.callback.BleNotifyCallback notifyCallback2, @org.jetbrains.annotations.Nullable()
    com.clj.fastble.callback.BleGattCallback gattCallback, @org.jetbrains.annotations.Nullable()
    com.clj.fastble.callback.BleScanCallback scanCallback, @org.jetbrains.annotations.Nullable()
    com.clj.fastble.callback.BleWriteCallback writeCallback, @org.jetbrains.annotations.NotNull()
    android.content.Context applicationContext) {
        super();
    }
}