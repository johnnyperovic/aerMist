package llc.aerMist.app.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\bX\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u00ab\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\b\b\u0002\u0010 \u001a\u00020\u0003\u0012\b\b\u0002\u0010!\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\"J\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u0006H\u00c6\u0003J\t\u0010?\u001a\u00020\u0006H\u00c6\u0003J\t\u0010@\u001a\u00020\u0006H\u00c6\u0003J\t\u0010A\u001a\u00020\u0006H\u00c6\u0003J\t\u0010B\u001a\u00020\u0006H\u00c6\u0003J\t\u0010C\u001a\u00020\u0006H\u00c6\u0003J\t\u0010D\u001a\u00020\u0006H\u00c6\u0003J\t\u0010E\u001a\u00020\u0003H\u00c6\u0003J\t\u0010F\u001a\u00020\u0003H\u00c6\u0003J\t\u0010G\u001a\u00020\u0006H\u00c6\u0003J\t\u0010H\u001a\u00020\u0003H\u00c6\u0003J\t\u0010I\u001a\u00020\u0003H\u00c6\u0003J\t\u0010J\u001a\u00020\u0003H\u00c6\u0003J\t\u0010K\u001a\u00020\u0006H\u00c6\u0003J\t\u0010L\u001a\u00020\u0003H\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\t\u0010N\u001a\u00020\u0006H\u00c6\u0003J\t\u0010O\u001a\u00020\u0003H\u00c6\u0003J\t\u0010P\u001a\u00020\u0003H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0006H\u00c6\u0003J\t\u0010R\u001a\u00020\u0003H\u00c6\u0003J\t\u0010S\u001a\u00020\u0006H\u00c6\u0003J\t\u0010T\u001a\u00020\u0003H\u00c6\u0003J\t\u0010U\u001a\u00020\u0003H\u00c6\u0003J\t\u0010V\u001a\u00020\u0006H\u00c6\u0003J\t\u0010W\u001a\u00020\u0006H\u00c6\u0003J\t\u0010X\u001a\u00020\u0006H\u00c6\u0003J\t\u0010Y\u001a\u00020\u0006H\u00c6\u0003J\t\u0010Z\u001a\u00020\u0006H\u00c6\u0003J\u00b5\u0002\u0010[\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00032\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00032\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00062\b\b\u0002\u0010 \u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\\\u001a\u00020\u00062\b\u0010]\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010^\u001a\u00020_H\u00d6\u0001J\t\u0010`\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0014\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0016\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0011\u0010\u001d\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u0011\u0010\u001e\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0011\u0010\u001f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\'R\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\'R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\'R\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\'R\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\'R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\'R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\'R\u0011\u0010\u0012\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\'R\u0011\u0010 \u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0011\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\'R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010$R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010$R\u0011\u0010\u0010\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\'R\u0011\u0010\u0017\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010$R\u0011\u0010\u0018\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010$R\u0011\u0010\u0019\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u0010\'R\u0011\u0010\u0011\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\'R\u0011\u0010!\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0011\u0010\u001a\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0011\u0010\u001b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u0011\u0010\u001c\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\'R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010\'R\u0011\u0010\f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\'R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010\'R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010$\u00a8\u0006a"}, d2 = {"Lllc/aerMist/app/models/MyDevice;", "", "name", "", "newName", "isConnected", "", "workingTime", "isOn", "isNonStop", "isSparayMode", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday", "isSprayPerDay", "isFriquencyPerDay", "firstStartTime", "firstStopTime", "firstTimerActive", "secondStartTime", "secondStopTime", "secondTimerActive", "thirdStartTime", "thirdStopTime", "thirdTimerActive", "fourtStartTime", "fourtStopTime", "fourthTimerActive", "mistTime", "suspendTime", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZZZZZZZZZZZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getFirstStartTime", "()Ljava/lang/String;", "getFirstStopTime", "getFirstTimerActive", "()Z", "getFourtStartTime", "getFourtStopTime", "getFourthTimerActive", "getFriday", "getMistTime", "getMonday", "getName", "getNewName", "getSaturday", "getSecondStartTime", "getSecondStopTime", "getSecondTimerActive", "getSunday", "getSuspendTime", "getThirdStartTime", "getThirdStopTime", "getThirdTimerActive", "getThursday", "getTuesday", "getWednesday", "getWorkingTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "", "toString", "app_localApiDebug"})
public final class MyDevice {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String name = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String newName = null;
    private final boolean isConnected = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String workingTime = null;
    private final boolean isOn = false;
    private final boolean isNonStop = false;
    private final boolean isSparayMode = false;
    private final boolean monday = false;
    private final boolean tuesday = false;
    private final boolean wednesday = false;
    private final boolean thursday = false;
    private final boolean friday = false;
    private final boolean saturday = false;
    private final boolean sunday = false;
    private final boolean isSprayPerDay = false;
    private final boolean isFriquencyPerDay = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String firstStartTime = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String firstStopTime = null;
    private final boolean firstTimerActive = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String secondStartTime = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String secondStopTime = null;
    private final boolean secondTimerActive = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String thirdStartTime = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String thirdStopTime = null;
    private final boolean thirdTimerActive = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String fourtStartTime = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String fourtStopTime = null;
    private final boolean fourthTimerActive = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String mistTime = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String suspendTime = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNewName() {
        return null;
    }
    
    public final boolean isConnected() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWorkingTime() {
        return null;
    }
    
    public final boolean isOn() {
        return false;
    }
    
    public final boolean isNonStop() {
        return false;
    }
    
    public final boolean isSparayMode() {
        return false;
    }
    
    public final boolean getMonday() {
        return false;
    }
    
    public final boolean getTuesday() {
        return false;
    }
    
    public final boolean getWednesday() {
        return false;
    }
    
    public final boolean getThursday() {
        return false;
    }
    
    public final boolean getFriday() {
        return false;
    }
    
    public final boolean getSaturday() {
        return false;
    }
    
    public final boolean getSunday() {
        return false;
    }
    
    public final boolean isSprayPerDay() {
        return false;
    }
    
    public final boolean isFriquencyPerDay() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstStartTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstStopTime() {
        return null;
    }
    
    public final boolean getFirstTimerActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondStartTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondStopTime() {
        return null;
    }
    
    public final boolean getSecondTimerActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdStartTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdStopTime() {
        return null;
    }
    
    public final boolean getThirdTimerActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourtStartTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourtStopTime() {
        return null;
    }
    
    public final boolean getFourthTimerActive() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMistTime() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSuspendTime() {
        return null;
    }
    
    public MyDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String newName, boolean isConnected, @org.jetbrains.annotations.NotNull()
    java.lang.String workingTime, boolean isOn, boolean isNonStop, boolean isSparayMode, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday, boolean isSprayPerDay, boolean isFriquencyPerDay, @org.jetbrains.annotations.NotNull()
    java.lang.String firstStartTime, @org.jetbrains.annotations.NotNull()
    java.lang.String firstStopTime, boolean firstTimerActive, @org.jetbrains.annotations.NotNull()
    java.lang.String secondStartTime, @org.jetbrains.annotations.NotNull()
    java.lang.String secondStopTime, boolean secondTimerActive, @org.jetbrains.annotations.NotNull()
    java.lang.String thirdStartTime, @org.jetbrains.annotations.NotNull()
    java.lang.String thirdStopTime, boolean thirdTimerActive, @org.jetbrains.annotations.NotNull()
    java.lang.String fourtStartTime, @org.jetbrains.annotations.NotNull()
    java.lang.String fourtStopTime, boolean fourthTimerActive, @org.jetbrains.annotations.NotNull()
    java.lang.String mistTime, @org.jetbrains.annotations.NotNull()
    java.lang.String suspendTime) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean component12() {
        return false;
    }
    
    public final boolean component13() {
        return false;
    }
    
    public final boolean component14() {
        return false;
    }
    
    public final boolean component15() {
        return false;
    }
    
    public final boolean component16() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component18() {
        return null;
    }
    
    public final boolean component19() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    public final boolean component22() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component23() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component24() {
        return null;
    }
    
    public final boolean component25() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component26() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component27() {
        return null;
    }
    
    public final boolean component28() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component29() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final llc.aerMist.app.models.MyDevice copy(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    java.lang.String newName, boolean isConnected, @org.jetbrains.annotations.NotNull()
    java.lang.String workingTime, boolean isOn, boolean isNonStop, boolean isSparayMode, boolean monday, boolean tuesday, boolean wednesday, boolean thursday, boolean friday, boolean saturday, boolean sunday, boolean isSprayPerDay, boolean isFriquencyPerDay, @org.jetbrains.annotations.NotNull()
    java.lang.String firstStartTime, @org.jetbrains.annotations.NotNull()
    java.lang.String firstStopTime, boolean firstTimerActive, @org.jetbrains.annotations.NotNull()
    java.lang.String secondStartTime, @org.jetbrains.annotations.NotNull()
    java.lang.String secondStopTime, boolean secondTimerActive, @org.jetbrains.annotations.NotNull()
    java.lang.String thirdStartTime, @org.jetbrains.annotations.NotNull()
    java.lang.String thirdStopTime, boolean thirdTimerActive, @org.jetbrains.annotations.NotNull()
    java.lang.String fourtStartTime, @org.jetbrains.annotations.NotNull()
    java.lang.String fourtStopTime, boolean fourthTimerActive, @org.jetbrains.annotations.NotNull()
    java.lang.String mistTime, @org.jetbrains.annotations.NotNull()
    java.lang.String suspendTime) {
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
}