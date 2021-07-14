package llc.aerMist.app.observers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010\'\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R(\u0010*\u001a\u0010\u0012\f\u0012\n +*\u0004\u0018\u00010\u00150\u00150\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000fR\u001a\u0010.\u001a\u00020/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020/X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00100\"\u0004\b4\u00102R \u00105\u001a\b\u0012\u0004\u0012\u00020/0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR \u00107\u001a\b\u0012\u0004\u0012\u00020/0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\r\"\u0004\b8\u0010\u000fR \u00109\u001a\b\u0012\u0004\u0012\u00020/0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR \u0010;\u001a\b\u0012\u0004\u0012\u00020/0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\r\"\u0004\b<\u0010\u000fR*\u0010=\u001a\u0012\u0012\u0004\u0012\u00020\u000b0>j\b\u0012\u0004\u0012\u00020\u000b`?X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR \u0010D\u001a\b\u0012\u0004\u0012\u00020\u00150\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR\u001c\u0010G\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010!\"\u0004\bI\u0010#R\u001c\u0010J\u001a\u0004\u0018\u00010\u001fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010!\"\u0004\bL\u0010#\u00a8\u0006M"}, d2 = {"Lllc/aerMist/app/observers/NewObservableCoordinator;", "", "()V", "bleDevicePosition", "", "getBleDevicePosition", "()I", "setBleDevicePosition", "(I)V", "bleDisconnectDevices", "Landroidx/lifecycle/MutableLiveData;", "Lcom/clj/fastble/data/BleDevice;", "getBleDisconnectDevices", "()Landroidx/lifecycle/MutableLiveData;", "setBleDisconnectDevices", "(Landroidx/lifecycle/MutableLiveData;)V", "bluetoothByteArray", "", "getBluetoothByteArray", "setBluetoothByteArray", "bluetoothConnectionState", "", "getBluetoothConnectionState", "setBluetoothConnectionState", "bluetoothController", "Lllc/aerMist/app/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/app/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/app/helpers/BluetoothController;)V", "firstGatt", "Landroid/bluetooth/BluetoothGatt;", "getFirstGatt", "()Landroid/bluetooth/BluetoothGatt;", "setFirstGatt", "(Landroid/bluetooth/BluetoothGatt;)V", "fourthGatt", "getFourthGatt", "setFourthGatt", "gatt", "getGatt", "setGatt", "idString", "kotlin.jvm.PlatformType", "getIdString", "setIdString", "isDeviceAuthorized", "", "()Z", "setDeviceAuthorized", "(Z)V", "isDeviceConnected", "setDeviceConnected", "isFirstTimeSynch", "setFirstTimeSynch", "isFourthTimeSynch", "setFourthTimeSynch", "isSecondTimeSynch", "setSecondTimeSynch", "isThirdTimeSynch", "setThirdTimeSynch", "listBleDevices", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getListBleDevices", "()Ljava/util/ArrayList;", "setListBleDevices", "(Ljava/util/ArrayList;)V", "mode", "getMode", "setMode", "secondGatt", "getSecondGatt", "setSecondGatt", "thirdGatt", "getThirdGatt", "setThirdGatt", "app_localApiDebug"})
public final class NewObservableCoordinator {
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.String> bluetoothConnectionState;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<char[]> bluetoothByteArray;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<com.clj.fastble.data.BleDevice> bleDisconnectDevices;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.Boolean> isFirstTimeSynch;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.Boolean> isSecondTimeSynch;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.Boolean> isThirdTimeSynch;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.Boolean> isFourthTimeSynch;
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
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.String> mode;
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
    public final androidx.lifecycle.MutableLiveData<com.clj.fastble.data.BleDevice> getBleDisconnectDevices() {
        return null;
    }
    
    public final void setBleDisconnectDevices(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.clj.fastble.data.BleDevice> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isFirstTimeSynch() {
        return null;
    }
    
    public final void setFirstTimeSynch(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isSecondTimeSynch() {
        return null;
    }
    
    public final void setSecondTimeSynch(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isThirdTimeSynch() {
        return null;
    }
    
    public final void setThirdTimeSynch(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isFourthTimeSynch() {
        return null;
    }
    
    public final void setFourthTimeSynch(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getMode() {
        return null;
    }
    
    public final void setMode(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    private NewObservableCoordinator() {
        super();
    }
}