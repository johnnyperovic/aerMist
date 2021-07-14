package llc.aerMist.app.ui.devices;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u000e\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0006J\u0018\u0010I\u001a\u00020G2\u0006\u0010J\u001a\u00020\u001e2\u0006\u0010K\u001a\u00020,H\u0002J\b\u0010L\u001a\u00020GH\u0002J\u0012\u0010M\u001a\u00020G2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\"\u0010P\u001a\u00020G2\u0006\u0010Q\u001a\u00020\u00182\u0006\u0010R\u001a\u00020\u00182\b\u0010S\u001a\u0004\u0018\u00010TH\u0016J\u0012\u0010U\u001a\u00020G2\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J&\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010Y\u001a\u00020Z2\b\u0010[\u001a\u0004\u0018\u00010\\2\b\u0010N\u001a\u0004\u0018\u00010OH\u0016J\u0006\u0010]\u001a\u00020GJ\u0006\u0010^\u001a\u00020GJ\u0006\u0010_\u001a\u00020GJ\u0006\u0010`\u001a\u00020GJ\u0006\u0010a\u001a\u00020GJ\u0016\u0010b\u001a\u00020G2\u0006\u0010c\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u001eJ\u0016\u0010d\u001a\u00020G2\u0006\u0010c\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u001eJ\u0016\u0010e\u001a\u00020G2\u0006\u0010c\u001a\u00020\u00182\u0006\u0010J\u001a\u00020\u001eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010 \"\u0004\b\'\u0010\"R\u000e\u0010(\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b2\u00103R\u000e\u00106\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000207X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010 \"\u0004\b>\u0010\"R\u000e\u0010?\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010A\u001a\u00020\u001eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010 \"\u0004\bC\u0010\"R\u000e\u0010D\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006f"}, d2 = {"Lllc/aerMist/app/ui/devices/MenageDevicesFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/view/View$OnClickListener;", "()V", "bleList", "Ljava/util/ArrayList;", "Lcom/clj/fastble/data/BleDevice;", "connectionStateCoordinator", "Lllc/aerMist/app/observers/NewObservableCoordinator;", "getConnectionStateCoordinator", "()Lllc/aerMist/app/observers/NewObservableCoordinator;", "deviceFourObj", "Lllc/aerMist/app/models/MyDevice;", "getDeviceFourObj", "()Lllc/aerMist/app/models/MyDevice;", "setDeviceFourObj", "(Lllc/aerMist/app/models/MyDevice;)V", "deviceOneObj", "getDeviceOneObj", "setDeviceOneObj", "deviceThreeObj", "getDeviceThreeObj", "setDeviceThreeObj", "deviceTotalNumber", "", "deviceTwoObj", "getDeviceTwoObj", "setDeviceTwoObj", "firstBleDevice", "firstDeviceNewName", "", "getFirstDeviceNewName", "()Ljava/lang/String;", "setFirstDeviceNewName", "(Ljava/lang/String;)V", "firstDevicePostion", "fourthBleDevice", "fourthDeviceNewName", "getFourthDeviceNewName", "setFourthDeviceNewName", "fourthDevicePosition", "gattCallback", "Lcom/clj/fastble/callback/BleGattCallback;", "isFirstConnected", "", "isFourthConnected", "isSecondConnected", "isThirdConnected", "prefs", "Lllc/aerMist/app/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/app/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "removeDevicePopup", "Lllc/aerMist/app/ui/popup/RemoveDevicePopup;", "renameDeviceDialog", "Lllc/aerMist/app/ui/popup/RenameDevicePopup;", "resetFilterDialog", "secondBleDevice", "secondDeviceNewName", "getSecondDeviceNewName", "setSecondDeviceNewName", "secondDevicePosition", "thirdBleDevice", "thirdDeviceNewName", "getThirdDeviceNewName", "setThirdDeviceNewName", "thirdDevicePosition", "totalNumber", "connectDevice", "", "bleDevice", "navigateToDevice", "name", "isConnected", "navigateToSearchFragment", "onActivityCreated", "savedInstanceState", "Landroid/os/Bundle;", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onClick", "id", "Landroid/view/View;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setClickListener", "setFirstDevice", "setFourthDevice", "setSecondDevice", "setThirdDevice", "showRemoveDialog", "positon", "showRenameDialog", "showResetFilterDialog", "app_localApiDebug"})
public final class MenageDevicesFragment extends androidx.fragment.app.Fragment implements android.view.View.OnClickListener {
    private final kotlin.Lazy prefs$delegate = null;
    private int deviceTotalNumber = 0;
    private int totalNumber = 0;
    private com.clj.fastble.data.BleDevice firstBleDevice;
    private com.clj.fastble.data.BleDevice secondBleDevice;
    private com.clj.fastble.data.BleDevice thirdBleDevice;
    private com.clj.fastble.data.BleDevice fourthBleDevice;
    @org.jetbrains.annotations.NotNull()
    private final llc.aerMist.app.observers.NewObservableCoordinator connectionStateCoordinator = null;
    private java.util.ArrayList<com.clj.fastble.data.BleDevice> bleList;
    private int firstDevicePostion = 0;
    private boolean isFirstConnected = false;
    private int secondDevicePosition = 0;
    private boolean isSecondConnected = false;
    private int thirdDevicePosition = 0;
    private boolean isThirdConnected = false;
    private int fourthDevicePosition = 0;
    private boolean isFourthConnected = false;
    private llc.aerMist.app.ui.popup.RenameDevicePopup renameDeviceDialog;
    private llc.aerMist.app.ui.popup.RemoveDevicePopup resetFilterDialog;
    private llc.aerMist.app.ui.popup.RemoveDevicePopup removeDevicePopup;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String firstDeviceNewName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String secondDeviceNewName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String thirdDeviceNewName = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fourthDeviceNewName = "";
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceOneObj;
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceTwoObj;
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceThreeObj;
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.app.models.MyDevice deviceFourObj;
    private final com.clj.fastble.callback.BleGattCallback gattCallback = null;
    private java.util.HashMap _$_findViewCache;
    
    private final llc.aerMist.app.shared.util.PreferenceCache getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.observers.NewObservableCoordinator getConnectionStateCoordinator() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstDeviceNewName() {
        return null;
    }
    
    public final void setFirstDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondDeviceNewName() {
        return null;
    }
    
    public final void setSecondDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdDeviceNewName() {
        return null;
    }
    
    public final void setThirdDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourthDeviceNewName() {
        return null;
    }
    
    public final void setFourthDeviceNewName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceOneObj() {
        return null;
    }
    
    public final void setDeviceOneObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceTwoObj() {
        return null;
    }
    
    public final void setDeviceTwoObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceThreeObj() {
        return null;
    }
    
    public final void setDeviceThreeObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.app.models.MyDevice getDeviceFourObj() {
        return null;
    }
    
    public final void setDeviceFourObj(@org.jetbrains.annotations.Nullable()
    llc.aerMist.app.models.MyDevice p0) {
    }
    
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
    
    public final void connectDevice(@org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice bleDevice) {
    }
    
    public final void showRenameDialog(int positon, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void showRemoveDialog(int positon, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void showResetFilterDialog(int positon, @org.jetbrains.annotations.NotNull()
    java.lang.String name) {
    }
    
    public final void setFirstDevice() {
    }
    
    public final void setSecondDevice() {
    }
    
    public final void setThirdDevice() {
    }
    
    public final void setFourthDevice() {
    }
    
    public final void setClickListener() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View id) {
    }
    
    private final void navigateToDevice(java.lang.String name, boolean isConnected) {
    }
    
    private final void navigateToSearchFragment() {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    public MenageDevicesFragment() {
        super();
    }
}