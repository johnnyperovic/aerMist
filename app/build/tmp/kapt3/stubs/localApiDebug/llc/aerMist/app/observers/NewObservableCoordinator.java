package llc.aerMist.app.observers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR \u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001c\u0010(\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001c\u0010+\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010\'R\u001c\u0010.\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010%\"\u0004\b0\u0010\'R(\u00101\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u000102020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\r\"\u0004\b5\u0010\u000fR\u001a\u00106\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00108\"\u0004\b9\u0010:R\u001a\u0010;\u001a\u000207X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u00108\"\u0004\b<\u0010:R \u0010=\u001a\b\u0012\u0004\u0012\u0002070\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\r\"\u0004\b>\u0010\u000fR \u0010?\u001a\b\u0012\u0004\u0012\u0002070\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR \u0010A\u001a\b\u0012\u0004\u0012\u0002070\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\r\"\u0004\bB\u0010\u000fR \u0010C\u001a\b\u0012\u0004\u0012\u0002070\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\r\"\u0004\bD\u0010\u000fR*\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u000b0Fj\b\u0012\u0004\u0012\u00020\u000b`GX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR \u0010L\u001a\b\u0012\u0004\u0012\u0002020\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\r\"\u0004\bN\u0010\u000fR\u001c\u0010O\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u001f\"\u0004\bQ\u0010!R\u001c\u0010R\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010%\"\u0004\bT\u0010\'R\u001c\u0010U\u001a\u0004\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u001f\"\u0004\bW\u0010!R\u001c\u0010X\u001a\u0004\u0018\u00010#X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010%\"\u0004\bZ\u0010\'\u00a8\u0006["}, d2 = {"Lllc/aerMist/app/observers/NewObservableCoordinator;", "", "()V", "bleDevicePosition", "", "getBleDevicePosition", "()I", "setBleDevicePosition", "(I)V", "bleDisconnectDevices", "Landroidx/lifecycle/MutableLiveData;", "Lcom/clj/fastble/data/BleDevice;", "getBleDisconnectDevices", "()Landroidx/lifecycle/MutableLiveData;", "setBleDisconnectDevices", "(Landroidx/lifecycle/MutableLiveData;)V", "bluetoothByteArray", "", "getBluetoothByteArray", "setBluetoothByteArray", "bluetoothConnectionState", "getBluetoothConnectionState", "setBluetoothConnectionState", "bluetoothController", "Lllc/aerMist/app/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/app/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/app/helpers/BluetoothController;)V", "firstDevice", "getFirstDevice", "()Lcom/clj/fastble/data/BleDevice;", "setFirstDevice", "(Lcom/clj/fastble/data/BleDevice;)V", "firstGatt", "Landroid/bluetooth/BluetoothGatt;", "getFirstGatt", "()Landroid/bluetooth/BluetoothGatt;", "setFirstGatt", "(Landroid/bluetooth/BluetoothGatt;)V", "fourthDevice", "getFourthDevice", "setFourthDevice", "fourthGatt", "getFourthGatt", "setFourthGatt", "gatt", "getGatt", "setGatt", "idString", "", "kotlin.jvm.PlatformType", "getIdString", "setIdString", "isDeviceAuthorized", "", "()Z", "setDeviceAuthorized", "(Z)V", "isDeviceConnected", "setDeviceConnected", "isFirstTimeSynch", "setFirstTimeSynch", "isFourthTimeSynch", "setFourthTimeSynch", "isSecondTimeSynch", "setSecondTimeSynch", "isThirdTimeSynch", "setThirdTimeSynch", "listBleDevices", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getListBleDevices", "()Ljava/util/ArrayList;", "setListBleDevices", "(Ljava/util/ArrayList;)V", "mode", "getMode", "setMode", "secondDevice", "getSecondDevice", "setSecondDevice", "secondGatt", "getSecondGatt", "setSecondGatt", "thirdDevice", "getThirdDevice", "setThirdDevice", "thirdGatt", "getThirdGatt", "setThirdGatt", "app_localApiDebug"})
public final class NewObservableCoordinator {
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<com.clj.fastble.data.BleDevice> bluetoothConnectionState;
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
    private static com.clj.fastble.data.BleDevice firstDevice;
    @org.jetbrains.annotations.Nullable()
    private static com.clj.fastble.data.BleDevice secondDevice;
    @org.jetbrains.annotations.Nullable()
    private static com.clj.fastble.data.BleDevice thirdDevice;
    @org.jetbrains.annotations.Nullable()
    private static com.clj.fastble.data.BleDevice fourthDevice;
    @org.jetbrains.annotations.Nullable()
    private static android.bluetooth.BluetoothGatt gatt;
    @org.jetbrains.annotations.Nullable()
    private static llc.aerMist.app.helpers.BluetoothController bluetoothController;
    private static boolean isDeviceConnected = false;
    private static boolean isDeviceAuthorized = false;
    private static int bleDevicePosition = 0;
    @org.jetbrains.annotations.NotNull()
    private static androidx.lifecycle.MutableLiveData<java.lang.String> mode;
    @org.jetbrains.annotations.NotNull()
    public static final llc.aerMist.app.observers.NewObservableCoordinator INSTANCE = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<com.clj.fastble.data.BleDevice> getBluetoothConnectionState() {
        return null;
    }
    
    public final void setBluetoothConnectionState(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<com.clj.fastble.data.BleDevice> p0) {
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
    public final com.clj.fastble.data.BleDevice getFirstDevice() {
        return null;
    }
    
    public final void setFirstDevice(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.data.BleDevice getSecondDevice() {
        return null;
    }
    
    public final void setSecondDevice(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.data.BleDevice getThirdDevice() {
        return null;
    }
    
    public final void setThirdDevice(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.clj.fastble.data.BleDevice getFourthDevice() {
        return null;
    }
    
    public final void setFourthDevice(@org.jetbrains.annotations.Nullable()
    com.clj.fastble.data.BleDevice p0) {
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