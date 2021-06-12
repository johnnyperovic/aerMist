package llc.aerMist.app.ui.devices;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020-2\b\u0010/\u001a\u0004\u0018\u000100H\u0017J\"\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020+2\u0006\u00103\u001a\u00020+2\b\u00104\u001a\u0004\u0018\u000105H\u0016J\u0012\u00106\u001a\u00020-2\b\u00107\u001a\u0004\u0018\u000108H\u0016J&\u00109\u001a\u0004\u0018\u0001082\u0006\u0010:\u001a\u00020;2\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\u0006\u0010>\u001a\u00020-J\u0006\u0010?\u001a\u00020-J\u0006\u0010@\u001a\u00020-J\u0006\u0010A\u001a\u00020-J\u0006\u0010B\u001a\u00020-J\u0006\u0010C\u001a\u00020-J\u000e\u0010D\u001a\u00020-2\u0006\u0010E\u001a\u00020FJ\u0006\u0010G\u001a\u00020-J\u0006\u0010H\u001a\u00020-J\u001e\u0010I\u001a\u00020-2\u0006\u0010J\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020#X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010$\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b&\u0010\'R\u000e\u0010*\u001a\u00020+X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006K"}, d2 = {"Lllc/aerMist/app/ui/devices/SetDeviceFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "bleDevice", "Lcom/clj/fastble/data/BleDevice;", "bluetoothController", "Lllc/aerMist/app/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/app/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/app/helpers/BluetoothController;)V", "byteArrayOF", "", "getByteArrayOF", "()[B", "byteArrayON", "getByteArrayON", "charset", "Ljava/nio/charset/Charset;", "getCharset", "()Ljava/nio/charset/Charset;", "connectionStateCoordinator", "Lllc/aerMist/app/observers/NewObservableCoordinator;", "getConnectionStateCoordinator", "()Lllc/aerMist/app/observers/NewObservableCoordinator;", "gatt", "Landroid/bluetooth/BluetoothGatt;", "numberPickerPopup", "Lllc/aerMist/app/ui/popup/NumberPickerPopup;", "getNumberPickerPopup", "()Lllc/aerMist/app/ui/popup/NumberPickerPopup;", "setNumberPickerPopup", "(Lllc/aerMist/app/ui/popup/NumberPickerPopup;)V", "payload", "Lllc/aerMist/app/models/BytePayload;", "prefs", "Lllc/aerMist/app/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/app/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "tag", "", "navigateToSetSchedule", "", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "id", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setClickListener", "setIntervalView", "setMotionLayoutListener", "setNonStopView", "setNumberPicker", "setScheduleView", "setTabItemVisibility", "state", "", "setTouchSwipeListener", "startAnimationSendCommand", "turnOnOFDevice", "input", "app_localApiDebug"})
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
    @org.jetbrains.annotations.NotNull()
    private final java.nio.charset.Charset charset = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] byteArrayON = null;
    @org.jetbrains.annotations.NotNull()
    private final byte[] byteArrayOF = null;
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
    
    public final void turnOnOFDevice(@org.jetbrains.annotations.NotNull()
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
    
    public SetDeviceFragment() {
        super();
    }
}