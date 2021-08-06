package llc.aerMist.app.shared.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 [2\u00020\u0001:\u0001[B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010P\u001a\u00020QJ\u0006\u0010R\u001a\u00020QJ\u0006\u0010S\u001a\u00020QJ\u0006\u0010T\u001a\u00020QJ\u0006\u0010U\u001a\u00020QJ\u0006\u0010V\u001a\u00020QJ\u0006\u0010W\u001a\u00020QJ\u0006\u0010X\u001a\u00020QJ\u0006\u0010Y\u001a\u00020QJ\u0006\u0010Z\u001a\u00020QR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR$\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR$\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\rR$\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001b\u0010\u000b\"\u0004\b\u001c\u0010\rR$\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u001d8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R$\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u001d8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R$\u0010$\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\u001d8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R$\u0010\'\u001a\u00020&2\u0006\u0010\u0007\u001a\u00020&8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010,\u001a\n .*\u0004\u0018\u00010-0-X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010/\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b0\u0010\u000b\"\u0004\b1\u0010\rR$\u00102\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\rR$\u00105\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b6\u0010\u000b\"\u0004\b7\u0010\rR$\u00108\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b9\u0010\u000b\"\u0004\b:\u0010\rR$\u0010;\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b<\u0010\u000b\"\u0004\b=\u0010\rR$\u0010>\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b?\u0010\u000b\"\u0004\b@\u0010\rR$\u0010A\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bB\u0010\u000b\"\u0004\bC\u0010\rR$\u0010D\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010\rR$\u0010G\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bH\u0010\u000b\"\u0004\bI\u0010\rR$\u0010K\u001a\u00020J2\u0006\u0010\u0007\u001a\u00020J8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O\u00a8\u0006\\"}, d2 = {"Lllc/aerMist/app/shared/util/PreferenceCache;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "value", "", "deviceState", "getDeviceState", "()Ljava/lang/String;", "setDeviceState", "(Ljava/lang/String;)V", "firstBleDevice", "getFirstBleDevice", "setFirstBleDevice", "firstDevice", "getFirstDevice", "setFirstDevice", "fourthBleDevice", "getFourthBleDevice", "setFourthBleDevice", "fourthDevice", "getFourthDevice", "setFourthDevice", "intervalModel", "getIntervalModel", "setIntervalModel", "", "isDeleted", "()Z", "setDeleted", "(Z)V", "isFromHomeScreen", "setFromHomeScreen", "isOneDevice", "setOneDevice", "Ljava/util/Locale;", "locale", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "scheduleModel", "getScheduleModel", "setScheduleModel", "secondBleDevice", "getSecondBleDevice", "setSecondBleDevice", "secondDevice", "getSecondDevice", "setSecondDevice", "startWorkingTimeFD", "getStartWorkingTimeFD", "setStartWorkingTimeFD", "startWorkingTimeFRD", "getStartWorkingTimeFRD", "setStartWorkingTimeFRD", "startWorkingTimeSD", "getStartWorkingTimeSD", "setStartWorkingTimeSD", "startWorkingTimeTD", "getStartWorkingTimeTD", "setStartWorkingTimeTD", "thirdBleDevice", "getThirdBleDevice", "setThirdBleDevice", "thirdDevice", "getThirdDevice", "setThirdDevice", "", "uiMode", "getUiMode", "()I", "setUiMode", "(I)V", "cleanFirstDevice", "", "cleanFirstFilter", "cleanFourthDevice", "cleanFourthFilter", "cleanSecondDevice", "cleanSecondFilter", "cleanThirdDevice", "cleanThirdFilter", "clear", "clearDelete", "Companion", "app_localApiDebug"})
public final class PreferenceCache {
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private static final java.lang.String AUTH_TOKEN = "authentication_token";
    private static final java.lang.String REFRESH_TOKEN = "refresh_token";
    private static final java.lang.String LOCALE = "locale";
    private static final java.lang.String UI_MODE = "ui_mode";
    private static final java.lang.String FIRST_DEVICE = "first_device";
    private static final java.lang.String SCHEDULE_MODEL = "schedule_model";
    private static final java.lang.String DEVICE_STATE = "device_state";
    private static final java.lang.String SECOND_DEVICE = "second_device";
    private static final java.lang.String THIRD_DEVICE = "third_device";
    private static final java.lang.String FOURTH_DEVICE = "fourth_device";
    private static final java.lang.String FIRST_BLE_DEVICE = "first_ble_device";
    private static final java.lang.String SECOND_BLE_DEVICE = "second_ble_device";
    private static final java.lang.String THIRD_BLE_DEVICE = "third_ble_device";
    private static final java.lang.String FOURTH_BLE_DEVICE = "fourth_ble_device";
    private static final java.lang.String INTERVAL_MODEL = "interval_model";
    private static final java.lang.String START_WORKING_TIME_FD = "start_working_time_fd";
    private static final java.lang.String START_WORKING_TIME_SD = "start_working_time_sd";
    private static final java.lang.String START_WORKING_TIME_TD = "start_working_time_td";
    private static final java.lang.String START_WORKING_TIME_FRD = "start_working_time_frd";
    private static final java.lang.String IS_ONE_DEVICE = "isOneDevice";
    private static final java.lang.String IS_FROM_HOME_SCREEN = "isFromHomeScreen";
    private static final java.lang.String IS_DELETED = "isDeleted";
    @org.jetbrains.annotations.NotNull()
    public static final llc.aerMist.app.shared.util.PreferenceCache.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Locale getLocale() {
        return null;
    }
    
    public final void setLocale(@org.jetbrains.annotations.NotNull()
    java.util.Locale value) {
    }
    
    public final int getUiMode() {
        return 0;
    }
    
    public final void setUiMode(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStartWorkingTimeFD() {
        return null;
    }
    
    public final void setStartWorkingTimeFD(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStartWorkingTimeSD() {
        return null;
    }
    
    public final void setStartWorkingTimeSD(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStartWorkingTimeTD() {
        return null;
    }
    
    public final void setStartWorkingTimeTD(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStartWorkingTimeFRD() {
        return null;
    }
    
    public final void setStartWorkingTimeFRD(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final boolean isOneDevice() {
        return false;
    }
    
    public final void setOneDevice(boolean value) {
    }
    
    public final boolean isDeleted() {
        return false;
    }
    
    public final void setDeleted(boolean value) {
    }
    
    public final boolean isFromHomeScreen() {
        return false;
    }
    
    public final void setFromHomeScreen(boolean value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getScheduleModel() {
        return null;
    }
    
    public final void setScheduleModel(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDeviceState() {
        return null;
    }
    
    public final void setDeviceState(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getIntervalModel() {
        return null;
    }
    
    public final void setIntervalModel(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstDevice() {
        return null;
    }
    
    public final void setFirstDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFirstBleDevice() {
        return null;
    }
    
    public final void setFirstBleDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondBleDevice() {
        return null;
    }
    
    public final void setSecondBleDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdBleDevice() {
        return null;
    }
    
    public final void setThirdBleDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourthBleDevice() {
        return null;
    }
    
    public final void setFourthBleDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSecondDevice() {
        return null;
    }
    
    public final void setSecondDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getThirdDevice() {
        return null;
    }
    
    public final void setThirdDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFourthDevice() {
        return null;
    }
    
    public final void setFourthDevice(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void clearDelete() {
    }
    
    public final void clear() {
    }
    
    public final void cleanFirstDevice() {
    }
    
    public final void cleanSecondDevice() {
    }
    
    public final void cleanThirdDevice() {
    }
    
    public final void cleanFourthDevice() {
    }
    
    public final void cleanFirstFilter() {
    }
    
    public final void cleanSecondFilter() {
    }
    
    public final void cleanThirdFilter() {
    }
    
    public final void cleanFourthFilter() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public PreferenceCache(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lllc/aerMist/app/shared/util/PreferenceCache$Companion;", "", "()V", "AUTH_TOKEN", "", "DEVICE_STATE", "FIRST_BLE_DEVICE", "FIRST_DEVICE", "FOURTH_BLE_DEVICE", "FOURTH_DEVICE", "INTERVAL_MODEL", "IS_DELETED", "IS_FROM_HOME_SCREEN", "IS_ONE_DEVICE", "LOCALE", "REFRESH_TOKEN", "SCHEDULE_MODEL", "SECOND_BLE_DEVICE", "SECOND_DEVICE", "START_WORKING_TIME_FD", "START_WORKING_TIME_FRD", "START_WORKING_TIME_SD", "START_WORKING_TIME_TD", "THIRD_BLE_DEVICE", "THIRD_DEVICE", "UI_MODE", "app_localApiDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}