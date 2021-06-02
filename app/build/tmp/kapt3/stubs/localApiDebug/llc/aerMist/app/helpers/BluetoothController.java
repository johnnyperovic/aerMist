package llc.aerMist.app.helpers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u0010\u0010;\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u000eJ\u0006\u0010>\u001a\u00020<J\u0006\u0010?\u001a\u00020<J\u0018\u0010@\u001a\u00020<2\b\u0010=\u001a\u0004\u0018\u00010\u000e2\u0006\u0010A\u001a\u00020BJ\u0006\u0010C\u001a\u00020<J\u001e\u0010D\u001a\u00020<2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010E\u001a\u00020F2\u0006\u0010A\u001a\u00020BR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u001a\u0010)\u001a\u00020*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010+\"\u0004\b,\u0010-R*\u0010.\u001a\u0012\u0012\u0004\u0012\u00020\u000e0/j\b\u0012\u0004\u0012\u00020\u000e`0X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:\u00a8\u0006G"}, d2 = {"Lllc/aerMist/app/helpers/BluetoothController;", "", "notifyCallback", "Lcom/clj/fastble/callback/BleNotifyCallback;", "gattCallback", "Lcom/clj/fastble/callback/BleGattCallback;", "scanCallback", "Lcom/clj/fastble/callback/BleScanCallback;", "writeCallback", "Lcom/clj/fastble/callback/BleWriteCallback;", "applicationContext", "Landroid/content/Context;", "(Lcom/clj/fastble/callback/BleNotifyCallback;Lcom/clj/fastble/callback/BleGattCallback;Lcom/clj/fastble/callback/BleScanCallback;Lcom/clj/fastble/callback/BleWriteCallback;Landroid/content/Context;)V", "bleDeviceMain", "Lcom/clj/fastble/data/BleDevice;", "getBleDeviceMain", "()Lcom/clj/fastble/data/BleDevice;", "setBleDeviceMain", "(Lcom/clj/fastble/data/BleDevice;)V", "blueGattAdapter", "Lllc/aerMist/app/adapters/BlueGattAdapter;", "getBlueGattAdapter", "()Lllc/aerMist/app/adapters/BlueGattAdapter;", "setBlueGattAdapter", "(Lllc/aerMist/app/adapters/BlueGattAdapter;)V", "bluetoothAdapter", "Landroid/bluetooth/BluetoothAdapter;", "getBluetoothAdapter", "()Landroid/bluetooth/BluetoothAdapter;", "setBluetoothAdapter", "(Landroid/bluetooth/BluetoothAdapter;)V", "bluetoothManager", "Lcom/clj/fastble/BleManager;", "getBluetoothManager", "()Lcom/clj/fastble/BleManager;", "connectionStateCoordinator", "Lllc/aerMist/app/observers/NewObservableCoordinator;", "getConnectionStateCoordinator", "()Lllc/aerMist/app/observers/NewObservableCoordinator;", "getGattCallback", "()Lcom/clj/fastble/callback/BleGattCallback;", "isMyDevice", "", "()Z", "setMyDevice", "(Z)V", "list", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getList", "()Ljava/util/ArrayList;", "setList", "(Ljava/util/ArrayList;)V", "getNotifyCallback", "()Lcom/clj/fastble/callback/BleNotifyCallback;", "getScanCallback", "()Lcom/clj/fastble/callback/BleScanCallback;", "getWriteCallback", "()Lcom/clj/fastble/callback/BleWriteCallback;", "connect", "", "bleDevice", "disconnect", "initScanRule", "readNotification", "characteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "startScan", "writeCommand", "input", "", "app_localApiDebug"})
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
    private boolean isMyDevice = false;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.clj.fastble.data.BleDevice> list;
    @org.jetbrains.annotations.Nullable()
    private final com.clj.fastble.callback.BleNotifyCallback notifyCallback = null;
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.clj.fastble.data.BleDevice> getList() {
        return null;
    }
    
    public final void setList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.clj.fastble.data.BleDevice> p0) {
    }
    
    public final void readNotification(@org.jetbrains.annotations.Nullable()
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
    
    public final void disconnect() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.callback.BleNotifyCallback getNotifyCallback() {
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
    com.clj.fastble.callback.BleGattCallback gattCallback, @org.jetbrains.annotations.Nullable()
    com.clj.fastble.callback.BleScanCallback scanCallback, @org.jetbrains.annotations.Nullable()
    com.clj.fastble.callback.BleWriteCallback writeCallback, @org.jetbrains.annotations.NotNull()
    android.content.Context applicationContext) {
        super();
    }
}