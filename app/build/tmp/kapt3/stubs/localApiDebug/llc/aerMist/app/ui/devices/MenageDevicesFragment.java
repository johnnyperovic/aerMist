package llc.aerMist.app.ui.devices;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u0010J\u0006\u0010\u001c\u001a\u00020\u0010J\u0006\u0010\u001d\u001a\u00020\u0010R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001e"}, d2 = {"Lllc/aerMist/app/ui/devices/MenageDevicesFragment;", "Landroidx/fragment/app/Fragment;", "()V", "connectionStateCoordinator", "Lllc/aerMist/app/observers/NewObservableCoordinator;", "getConnectionStateCoordinator", "()Lllc/aerMist/app/observers/NewObservableCoordinator;", "deviceTotalNumber", "", "prefs", "Lllc/aerMist/app/shared/util/PreferenceCache;", "getPrefs", "()Lllc/aerMist/app/shared/util/PreferenceCache;", "prefs$delegate", "Lkotlin/Lazy;", "onActivityCreated", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreate", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setFirstDevice", "setFourthDevice", "setSecondDevice", "setThirdDevice", "app_localApiDebug"})
public final class MenageDevicesFragment extends androidx.fragment.app.Fragment {
    private final kotlin.Lazy prefs$delegate = null;
    private int deviceTotalNumber = 0;
    @org.jetbrains.annotations.NotNull()
    private final llc.aerMist.app.observers.NewObservableCoordinator connectionStateCoordinator = null;
    private java.util.HashMap _$_findViewCache;
    
    private final llc.aerMist.app.shared.util.PreferenceCache getPrefs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.observers.NewObservableCoordinator getConnectionStateCoordinator() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
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
    
    public final void setFirstDevice() {
    }
    
    public final void setSecondDevice() {
    }
    
    public final void setThirdDevice() {
    }
    
    public final void setFourthDevice() {
    }
    
    public MenageDevicesFragment() {
        super();
    }
}