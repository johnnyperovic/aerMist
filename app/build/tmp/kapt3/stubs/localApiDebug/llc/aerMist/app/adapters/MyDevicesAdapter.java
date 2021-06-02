package llc.aerMist.app.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001eB\'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\u0010\tJ\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0016H\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001f"}, d2 = {"Lllc/aerMist/app/adapters/MyDevicesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lllc/aerMist/app/adapters/MyDevicesAdapter$DeviceViewHolder;", "availableDevices", "", "Lllc/aerMist/app/models/MyDevice;", "clickListener", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getAvailableDevices", "()Ljava/util/List;", "setAvailableDevices", "(Ljava/util/List;)V", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "isClickable", "", "()Z", "setClickable", "(Z)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeviceViewHolder", "app_localApiDebug"})
public final class MyDevicesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<llc.aerMist.app.adapters.MyDevicesAdapter.DeviceViewHolder> {
    private boolean isClickable = true;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<llc.aerMist.app.models.MyDevice> availableDevices;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<llc.aerMist.app.models.MyDevice, kotlin.Unit> clickListener = null;
    
    public final boolean isClickable() {
        return false;
    }
    
    public final void setClickable(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public llc.aerMist.app.adapters.MyDevicesAdapter.DeviceViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.adapters.MyDevicesAdapter.DeviceViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<llc.aerMist.app.models.MyDevice> getAvailableDevices() {
        return null;
    }
    
    public final void setAvailableDevices(@org.jetbrains.annotations.NotNull()
    java.util.List<llc.aerMist.app.models.MyDevice> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<llc.aerMist.app.models.MyDevice, kotlin.Unit> getClickListener() {
        return null;
    }
    
    public MyDevicesAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<llc.aerMist.app.models.MyDevice> availableDevices, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super llc.aerMist.app.models.MyDevice, kotlin.Unit> clickListener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n\u00a8\u0006\u000b"}, d2 = {"Lllc/aerMist/app/adapters/MyDevicesAdapter$DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "device", "Lllc/aerMist/app/models/MyDevice;", "clickListener", "Lkotlin/Function1;", "app_localApiDebug"})
    public static final class DeviceViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        llc.aerMist.app.models.MyDevice device, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super llc.aerMist.app.models.MyDevice, kotlin.Unit> clickListener) {
        }
        
        public DeviceViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}