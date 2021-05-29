package llc.aerMist.base.shared.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010)\u001a\u00020*R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR$\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00148F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\n \u001c*\u0004\u0018\u00010\u001b0\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR$\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000bR$\u0010$\u001a\u00020#2\u0006\u0010\u0005\u001a\u00020#8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(\u00a8\u0006,"}, d2 = {"Lllc/aerMist/base/shared/util/PreferenceCache;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "accessToken", "getAccessToken", "()Ljava/lang/String;", "setAccessToken", "(Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "firstDevice", "getFirstDevice", "setFirstDevice", "fourthDevice", "getFourthDevice", "setFourthDevice", "Ljava/util/Locale;", "locale", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "secondDevice", "getSecondDevice", "setSecondDevice", "thirdDevice", "getThirdDevice", "setThirdDevice", "", "uiMode", "getUiMode", "()I", "setUiMode", "(I)V", "clear", "", "Companion", "app_localApiDebug"})
public final class PreferenceCache {
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private static final java.lang.String AUTH_TOKEN = "authentication_token";
    private static final java.lang.String REFRESH_TOKEN = "refresh_token";
    private static final java.lang.String LOCALE = "locale";
    private static final java.lang.String UI_MODE = "ui_mode";
    private static final java.lang.String FIRST_DEVICE = "first_device";
    private static final java.lang.String SECOND_DEVICE = "second_device";
    private static final java.lang.String THIRD_DEVICE = "third_device";
    private static final java.lang.String FOURTH_DEVICE = "fourth_device";
    public static final llc.aerMist.base.shared.util.PreferenceCache.Companion Companion = null;
    
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
    public final java.lang.String getAccessToken() {
        return null;
    }
    
    public final void setAccessToken(@org.jetbrains.annotations.NotNull()
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
    
    public final void clear() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    public PreferenceCache(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lllc/aerMist/base/shared/util/PreferenceCache$Companion;", "", "()V", "AUTH_TOKEN", "", "FIRST_DEVICE", "FOURTH_DEVICE", "LOCALE", "REFRESH_TOKEN", "SECOND_DEVICE", "THIRD_DEVICE", "UI_MODE", "app_localApiDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}