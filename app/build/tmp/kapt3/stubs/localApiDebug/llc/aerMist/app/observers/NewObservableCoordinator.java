package llc.aerMist.app.observers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00f8\u0001\u0000\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R(\u0010\u001a\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u000b0\u000b0\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010 \"\u0004\b$\u0010\"R*\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\'0&j\b\u0012\u0004\u0012\u00020\'`(X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006-"}, d2 = {"Lllc/aerMist/app/observers/NewObservableCoordinator;", "", "()V", "bluetoothByteArray", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/UIntArray;", "getBluetoothByteArray", "()Landroidx/lifecycle/MutableLiveData;", "setBluetoothByteArray", "(Landroidx/lifecycle/MutableLiveData;)V", "bluetoothConnectionState", "", "getBluetoothConnectionState", "setBluetoothConnectionState", "bluetoothController", "Lllc/aerMist/app/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/app/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/app/helpers/BluetoothController;)V", "gatt", "Landroid/bluetooth/BluetoothGatt;", "getGatt", "()Landroid/bluetooth/BluetoothGatt;", "setGatt", "(Landroid/bluetooth/BluetoothGatt;)V", "idString", "kotlin.jvm.PlatformType", "getIdString", "setIdString", "isDeviceAuthorized", "", "()Z", "setDeviceAuthorized", "(Z)V", "isDeviceConnected", "setDeviceConnected", "listBleDevices", "Ljava/util/ArrayList;", "Lcom/clj/fastble/data/BleDevice;", "Lkotlin/collections/ArrayList;", "getListBleDevices", "()Ljava/util/ArrayList;", "setListBleDevices", "(Ljava/util/ArrayList;)V", "app_localApiDebug"})
public final class NewObservableCoordinator {
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.String> bluetoothConnectionState;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<kotlin.UIntArray> bluetoothByteArray;
    @org.jetbrains.annotations.NotNull()
    private static java.util.ArrayList<com.clj.fastble.data.BleDevice> listBleDevices;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.String> idString;
    @org.jetbrains.annotations.Nullable()
    private static android.bluetooth.BluetoothGatt gatt;
    @org.jetbrains.annotations.Nullable()
    private static llc.aerMist.app.helpers.BluetoothController bluetoothController;
    private static boolean isDeviceConnected = false;
    private static boolean isDeviceAuthorized = false;
    public static final llc.aerMist.app.observers.NewObservableCoordinator INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getBluetoothConnectionState() {
        return null;
    }
    
    public final void setBluetoothConnectionState(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<kotlin.UIntArray> getBluetoothByteArray() {
        return null;
    }
    
    public final void setBluetoothByteArray(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<kotlin.UIntArray> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.clj.fastble.data.BleDevice> getListBleDevices() {
        return null;
    }
    
    public final void setListBleDevices(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.clj.fastble.data.BleDevice> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getIdString() {
        return null;
    }
    
    public final void setIdString(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getGatt() {
        return null;
    }
    
    public final void setGatt(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.helpers.BluetoothController getBluetoothController() {
        return null;
    }
    
    public final void setBluetoothController(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.helpers.BluetoothController p0) {
    }
    
    public final boolean isDeviceConnected() {
        return false;
    }
    
    public final void setDeviceConnected(boolean p0) {
    }
    
    public final boolean isDeviceAuthorized() {
        return false;
    }
    
    public final void setDeviceAuthorized(boolean p0) {
    }
    
    private NewObservableCoordinator() {
        super();
    }
}