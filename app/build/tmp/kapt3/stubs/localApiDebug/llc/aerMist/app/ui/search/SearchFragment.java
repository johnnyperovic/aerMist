package llc.aerMist.app.ui.search;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0002J\u0006\u00100\u001a\u00020-J\"\u00101\u001a\u00020-2\u0006\u00102\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u000105H\u0016J&\u00106\u001a\u0004\u0018\u0001072\u0006\u00108\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u001a\u0010>\u001a\u00020-2\u0006\u0010?\u001a\u0002072\b\u0010<\u001a\u0004\u0018\u00010=H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\"\u001a\u00020#\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0015\"\u0004\b(\u0010\u0017R\u001a\u0010)\u001a\u00020\u0012X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017\u00a8\u0006@"}, d2 = {"Lllc/aerMist/app/ui/search/SearchFragment;", "Landroidx/fragment/app/Fragment;", "()V", "BLE_REQUEST_CODE", "", "adapter", "Lllc/aerMist/app/adapters/AvailableDevicesAdapter;", "addDeviceDialog", "Lllc/aerMist/app/ui/popup/AddDevicePopup;", "bluetoothController", "Lllc/aerMist/app/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/app/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/app/helpers/BluetoothController;)V", "bluetoothEnabled", "", "deviceName", "", "firstDevice", "getFirstDevice", "()Ljava/lang/String;", "setFirstDevice", "(Ljava/lang/String;)V", "fourthDevice", "getFourthDevice", "setFourthDevice", "hasDevice", "prefs", "Lllc/aerMist/app/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/app/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "scanCallback", "Lcom/clj/fastble/callback/BleScanCallback;", "getScanCallback", "()Lcom/clj/fastble/callback/BleScanCallback;", "secondDevice", "getSecondDevice", "setSecondDevice", "thirdDevice", "getThirdDevice", "setThirdDevice", "deviceItemClicked", "", "device", "Lcom/clj/fastble/data/BleDevice;", "initRecycler", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_localApiDebug"})
public final class SearchFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy prefs$delegate = null;
    private final int BLE_REQUEST_CODE = 1;
    private boolean bluetoothEnabled = false;
    @org.jetbrains.annotations.NotNull()
    public llc.aerMist.app.helpers.BluetoothController bluetoothController;
    private llc.aerMist.app.adapters.AvailableDevicesAdapter adapter;
    private llc.aerMist.app.ui.popup.AddDevicePopup addDeviceDialog;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String firstDevice;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String secondDevice;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String thirdDevice;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String fourthDevice;
    private boolean hasDevice = false;
    private java.lang.String deviceName = "";
    @org.jetbrains.annotations.NotNull()
    private final com.clj.fastble.callback.BleScanCallback scanCallback = null;
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
    public final java.lang.String getFirstDevice() {
        return null;
    }
    
    public final void setFirstDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
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
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void initRecycler() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.clj.fastble.callback.BleScanCallback getScanCallback() {
        return null;
    }
    
    private final void deviceItemClicked(com.clj.fastble.data.BleDevice device) {
    }
    
    public SearchFragment() {
        super();
    }
}