package llc.aerMist.app.observers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001c\u0010#\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR(\u0010&\u001a\u0010\u0012\f\u0012\n \'*\u0004\u0018\u00010\u00110\u00110\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010\u000fR\u001a\u0010*\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010,\"\u0004\b0\u0010.R*\u00101\u001a\u0012\u0012\u0004\u0012\u00020302j\b\u0012\u0004\u0012\u000203`4X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001c\u00109\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u001d\"\u0004\b;\u0010\u001fR\u001c\u0010<\u001a\u0004\u0018\u00010\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001d\"\u0004\b>\u0010\u001f\u00a8\u0006?"}, d2 = {"Lllc/aerMist/app/observers/NewObservableCoordinator;", "", "()V", "bleDevicePosition", "", "getBleDevicePosition", "()I", "setBleDevicePosition", "(I)V", "bluetoothByteArray", "Landroidx/lifecycle/MutableLiveData;", "", "getBluetoothByteArray", "()Landroidx/lifecycle/MutableLiveData;", "setBluetoothByteArray", "(Landroidx/lifecycle/MutableLiveData;)V", "bluetoothConnectionState", "", "getBluetoothConnectionState", "setBluetoothConnectionState", "bluetoothController", "Lllc/aerMist/app/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/app/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/app/helpers/BluetoothController;)V", "firstGatt", "Landroid/bluetooth/BluetoothGatt;", "getFirstGatt", "()Landroid/bluetooth/BluetoothGatt;", "setFirstGatt", "(Landroid/bluetooth/BluetoothGatt;)V", "fourthGatt", "getFourthGatt", "setFourthGatt", "gatt", "getGatt", "setGatt", "idString", "kotlin.jvm.PlatformType", "getIdString", "setIdString", "isDeviceAuthorized", "", "()Z", "setDeviceAuthorized", "(Z)V", "isDeviceConnected", "setDeviceConnected", "listBleDevices", "Ljava/util/ArrayList;", "Lcom/clj/fastble/data/BleDevice;", "Lkotlin/collections/ArrayList;", "getListBleDevices", "()Ljava/util/ArrayList;", "setListBleDevices", "(Ljava/util/ArrayList;)V", "secondGatt", "getSecondGatt", "setSecondGatt", "thirdGatt", "getThirdGatt", "setThirdGatt", "app_localApiDebug"})
public final class NewObservableCoordinator {
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.String> bluetoothConnectionState;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<char[]> bluetoothByteArray;
    @org.jetbrains.annotations.NotNull()
    private static java.util.ArrayList<com.clj.fastble.data.BleDevice> listBleDevices;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.String> idString;
    @org.jetbrains.annotations.Nullable()
    private static android.bluetooth.BluetoothGatt firstGatt;
    @org.jetbrains.annotations.Nullable()
    private static android.bluetooth.BluetoothGatt secondGatt;
    @org.jetbrains.annotations.Nullable()
    private static android.bluetooth.BluetoothGatt thirdGatt;
    @org.jetbrains.annotations.Nullable()
    private static android.bluetooth.BluetoothGatt fourthGatt;
    @org.jetbrains.annotations.Nullable()
    private static android.bluetooth.BluetoothGatt gatt;
    @org.jetbrains.annotations.Nullable()
    private static llc.aerMist.app.helpers.BluetoothController bluetoothController;
    private static boolean isDeviceConnected = false;
    private static boolean isDeviceAuthorized = false;
    private static int bleDevicePosition = 0;
    public static final llc.aerMist.app.observers.NewObservableCoordinator INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getBluetoothConnectionState() {
        return null;
    }
    
    public final void setBluetoothConnectionState(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<char[]> getBluetoothByteArray() {
        return null;
    }
    
    public final void setBluetoothByteArray(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<char[]> p0) {
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
    public final android.bluetooth.BluetoothGatt getFirstGatt() {
        return null;
    }
    
    public final void setFirstGatt(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getSecondGatt() {
        return null;
    }
    
    public final void setSecondGatt(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getThirdGatt() {
        return null;
    }
    
    public final void setThirdGatt(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.bluetooth.BluetoothGatt getFourthGatt() {
        return null;
    }
    
    public final void setFourthGatt(@org.jetbrains.annotations.Nullable()
    android.bluetooth.BluetoothGatt p0) {
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
    
    public final int getBleDevicePosition() {
        return 0;
    }
    
    public final void setBleDevicePosition(int p0) {
    }
    
    private NewObservableCoordinator() {
        super();
    }
}