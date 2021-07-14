package llc.aerMist.app.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004BY\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0002\u0010\u0010J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u00c6\u0003J\u0011\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u00c6\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\fH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0016J\u000b\u0010 \u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003Jb\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u00c6\u0001\u00a2\u0006\u0002\u0010#J\b\u0010$\u001a\u00020%H\u0016J\u0013\u0010&\u001a\u00020\f2\b\u0010\'\u001a\u0004\u0018\u00010(H\u00d6\u0003J\t\u0010)\u001a\u00020%H\u00d6\u0001J\t\u0010*\u001a\u00020\u000eH\u00d6\u0001J\u0018\u0010+\u001a\u00020,2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010-\u001a\u00020%H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a\u00a8\u0006/"}, d2 = {"Lllc/aerMist/app/models/ScheduleModel;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "days", "", "timer", "", "Lllc/aerMist/app/models/TimerModel;", "timerToSend", "nonStop", "", "mist", "", "suspend", "([ILjava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)V", "getDays", "()[I", "getMist", "()Ljava/lang/String;", "getNonStop", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSuspend", "getTimer", "()Ljava/util/List;", "getTimerToSend", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "([ILjava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;)Lllc/aerMist/app/models/ScheduleModel;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "app_localApiDebug"})
public final class ScheduleModel implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable()
    private final int[] days = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<llc.aerMist.app.models.TimerModel> timer = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<llc.aerMist.app.models.TimerModel> timerToSend = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean nonStop = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String mist = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String suspend = null;
    public static final llc.aerMist.app.models.ScheduleModel.CREATOR CREATOR = null;
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final int[] getDays() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<llc.aerMist.app.models.TimerModel> getTimer() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<llc.aerMist.app.models.TimerModel> getTimerToSend() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getNonStop() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getMist() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSuspend() {
        return null;
    }
    
    public ScheduleModel(@org.jetbrains.annotations.Nullable()
    int[] days, @org.jetbrains.annotations.Nullable()
    java.util.List<llc.aerMist.app.models.TimerModel> timer, @org.jetbrains.annotations.Nullable()
    java.util.List<llc.aerMist.app.models.TimerModel> timerToSend, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean nonStop, @org.jetbrains.annotations.Nullable()
    java.lang.String mist, @org.jetbrains.annotations.Nullable()
    java.lang.String suspend) {
        super();
    }
    
    public ScheduleModel() {
        super();
    }
    
    public ScheduleModel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final int[] component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<llc.aerMist.app.models.TimerModel> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<llc.aerMist.app.models.TimerModel> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.ScheduleModel copy(@org.jetbrains.annotations.Nullable()
    int[] days, @org.jetbrains.annotations.Nullable()
    java.util.List<llc.aerMist.app.models.TimerModel> timer, @org.jetbrains.annotations.Nullable()
    java.util.List<llc.aerMist.app.models.TimerModel> timerToSend, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean nonStop, @org.jetbrains.annotations.Nullable()
    java.lang.String mist, @org.jetbrains.annotations.Nullable()
    java.lang.String suspend) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lllc/aerMist/app/models/ScheduleModel$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lllc/aerMist/app/models/ScheduleModel;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lllc/aerMist/app/models/ScheduleModel;", "app_localApiDebug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<llc.aerMist.app.models.ScheduleModel> {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public llc.aerMist.app.models.ScheduleModel createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public llc.aerMist.app.models.ScheduleModel[] newArray(int size) {
            return null;
        }
        
        private CREATOR() {
            super();
        }
    }
}