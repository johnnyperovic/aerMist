package llc.aerMist.base.adapters;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lllc/aerMist/base/adapters/HomeFragmentAdapter;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "intervalFragment", "Lllc/aerMist/base/ui/home/interval/IntervalFragment;", "nonStopFragment", "Lllc/aerMist/base/ui/home/nonStop/NonStopFragment;", "scheduleFragment", "Lllc/aerMist/base/ui/home/schedulere/ScheduleFragment;", "createFragment", "position", "", "getItemCount", "app_localApiDebug"})
public final class HomeFragmentAdapter extends androidx.viewpager2.adapter.FragmentStateAdapter {
    private final llc.aerMist.base.ui.home.nonStop.NonStopFragment nonStopFragment = null;
    private final llc.aerMist.base.ui.home.schedulere.ScheduleFragment scheduleFragment = null;
    private final llc.aerMist.base.ui.home.interval.IntervalFragment intervalFragment = null;
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public androidx.fragment.app.Fragment createFragment(int position) {
        return null;
    }
    
    public HomeFragmentAdapter(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment) {
        super(null);
    }
}