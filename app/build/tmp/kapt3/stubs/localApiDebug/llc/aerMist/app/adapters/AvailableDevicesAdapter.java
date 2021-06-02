package llc.aerMist.app.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB1\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006 "}, d2 = {"Lllc/aerMist/app/adapters/AvailableDevicesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lllc/aerMist/app/adapters/AvailableDevicesAdapter$DeviceViewHolder;", "availableDevices", "Ljava/util/ArrayList;", "Lcom/clj/fastble/data/BleDevice;", "Lkotlin/collections/ArrayList;", "clickListener", "Lkotlin/Function1;", "", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getAvailableDevices", "()Ljava/util/ArrayList;", "setAvailableDevices", "(Ljava/util/ArrayList;)V", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "isClickable", "", "()Z", "setClickable", "(Z)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DeviceViewHolder", "app_localApiDebug"})
public final class AvailableDevicesAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<llc.aerMist.app.adapters.AvailableDevicesAdapter.DeviceViewHolder> {
    private boolean isClickable = true;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<com.clj.fastble.data.BleDevice> availableDevices;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.clj.fastble.data.BleDevice, kotlin.Unit> clickListener = null;
    
    public final boolean isClickable() {
        return false;
    }
    
    public final void setClickable(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public llc.aerMist.app.adapters.AvailableDevicesAdapter.DeviceViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    llc.aerMist.app.adapters.AvailableDevicesAdapter.DeviceViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.clj.fastble.data.BleDevice> getAvailableDevices() {
        return null;
    }
    
    public final void setAvailableDevices(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.clj.fastble.data.BleDevice> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.clj.fastble.data.BleDevice, kotlin.Unit> getClickListener() {
        return null;
    }
    
    public AvailableDevicesAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.clj.fastble.data.BleDevice> availableDevices, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.clj.fastble.data.BleDevice, kotlin.Unit> clickListener) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\n\u00a8\u0006\u000b"}, d2 = {"Lllc/aerMist/app/adapters/AvailableDevicesAdapter$DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "bind", "", "device", "Lcom/clj/fastble/data/BleDevice;", "clickListener", "Lkotlin/Function1;", "app_localApiDebug"})
    public static final class DeviceViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.clj.fastble.data.BleDevice device, @org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super com.clj.fastble.data.BleDevice, kotlin.Unit> clickListener) {
        }
        
        public DeviceViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}