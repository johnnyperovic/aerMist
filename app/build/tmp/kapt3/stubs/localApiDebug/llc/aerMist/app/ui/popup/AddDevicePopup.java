package llc.aerMist.app.ui.popup;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0002J$\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001c"}, d2 = {"Lllc/aerMist/app/ui/popup/AddDevicePopup;", "Landroidx/fragment/app/DialogFragment;", "device", "Lcom/clj/fastble/data/BleDevice;", "isFromSearch", "", "(Lcom/clj/fastble/data/BleDevice;Z)V", "getDevice", "()Lcom/clj/fastble/data/BleDevice;", "()Z", "prefs", "Lllc/aerMist/app/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/app/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "dismiss", "", "navigateToMyDevices", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "app_localApiDebug"})
public final class AddDevicePopup extends androidx.fragment.app.DialogFragment {
    private final kotlin.Lazy prefs$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final com.clj.fastble.data.BleDevice device = null;
    private final boolean isFromSearch = false;
    private java.util.HashMap _$_findViewCache;
    
    private final llc.aerMist.app.shared.util.PreferenceCache getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    private final void navigateToMyDevices() {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void dismiss() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.clj.fastble.data.BleDevice getDevice() {
        return null;
    }
    
    public final boolean isFromSearch() {
        return false;
    }
    
    public AddDevicePopup(@org.jetbrains.annotations.NotNull()
    com.clj.fastble.data.BleDevice device, boolean isFromSearch) {
        super();
    }
}