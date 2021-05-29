package llc.aerMist.base.ui.search;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u000205H\u0002J\u0006\u00106\u001a\u000203J\u0006\u00107\u001a\u000203J\"\u00108\u001a\u0002032\u0006\u00109\u001a\u00020\u00042\u0006\u0010:\u001a\u00020\u00042\b\u0010;\u001a\u0004\u0018\u00010<H\u0016J&\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010B2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016J\u001a\u0010E\u001a\u0002032\u0006\u0010F\u001a\u00020>2\b\u0010C\u001a\u0004\u0018\u00010DH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010\'\u001a\u0004\b$\u0010%R\u0011\u0010(\u001a\u00020)\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001b\"\u0004\b.\u0010\u001dR\u001a\u0010/\u001a\u00020\u0013X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u001b\"\u0004\b1\u0010\u001d\u00a8\u0006G"}, d2 = {"Lllc/aerMist/base/ui/search/SearchFragment;", "Landroidx/fragment/app/Fragment;", "()V", "BLE_REQUEST_CODE", "", "adapter", "Lllc/aerMist/base/adapters/AvailableDevicesAdapter;", "addDeviceDialog", "Lllc/aerMist/base/ui/popup/AddDevicePopup;", "bluetoothController", "Lllc/aerMist/base/helpers/BluetoothController;", "getBluetoothController", "()Lllc/aerMist/base/helpers/BluetoothController;", "setBluetoothController", "(Lllc/aerMist/base/helpers/BluetoothController;)V", "bluetoothEnabled", "", "deviceDBList", "Ljava/util/ArrayList;", "", "getDeviceDBList", "()Ljava/util/ArrayList;", "setDeviceDBList", "(Ljava/util/ArrayList;)V", "deviceName", "firstDevice", "getFirstDevice", "()Ljava/lang/String;", "setFirstDevice", "(Ljava/lang/String;)V", "fourthDevice", "getFourthDevice", "setFourthDevice", "hasDevice", "prefs", "Lllc/aerMist/base/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/base/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "scanCallback", "Lcom/clj/fastble/callback/BleScanCallback;", "getScanCallback", "()Lcom/clj/fastble/callback/BleScanCallback;", "secondDevice", "getSecondDevice", "setSecondDevice", "thirdDevice", "getThirdDevice", "setThirdDevice", "deviceItemClicked", "", "device", "Lcom/clj/fastble/data/BleDevice;", "hasDevicesFromDB", "initRecycler", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "app_localApiDebug"})
public final class SearchFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy prefs$delegate = null;
    private final int BLE_REQUEST_CODE = 1;
    private boolean bluetoothEnabled = false;
    @org.jetbrains.annotations.NotNull()
    public llc.aerMist.base.helpers.BluetoothController bluetoothController;
    private llc.aerMist.base.adapters.AvailableDevicesAdapter adapter;
    private llc.aerMist.base.ui.popup.AddDevicePopup addDeviceDialog;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String firstDevice;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String secondDevice;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String thirdDevice;
    @org.jetbrains.annotations.NotNull()
    public java.lang.String fourthDevice;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.String> deviceDBList;
    private boolean hasDevice = false;
    private java.lang.String deviceName = "";
    @org.jetbrains.annotations.NotNull()
    private final com.clj.fastble.callback.BleScanCallback scanCallback = null;
    private java.util.HashMap _$_findViewCache;
    
    private final llc.aerMist.base.shared.util.PreferenceCache getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.base.helpers.BluetoothController getBluetoothController() {
        return null;
    }
    
    public final void setBluetoothController(@org.jetbrains.annotations.NotNull()
    llc.aerMist.base.helpers.BluetoothController p0) {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.String> getDeviceDBList() {
        return null;
    }
    
    public final void setDeviceDBList(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.String> p0) {
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
    
    public final void hasDevicesFromDB() {
    }
    
    public SearchFragment() {
        super();
    }
}