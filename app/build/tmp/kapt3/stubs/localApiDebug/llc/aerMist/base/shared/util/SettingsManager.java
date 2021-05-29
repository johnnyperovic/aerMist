package llc.aerMist.base.shared.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0010J\u0017\u0010\u0011\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0003J\u0014\u0010\u0016\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lllc/aerMist/base/shared/util/SettingsManager;", "", "prefsCache", "Lllc/aerMist/base/shared/util/PreferenceCache;", "(Lllc/aerMist/base/shared/util/PreferenceCache;)V", "attachBaseContext", "Landroid/content/Context;", "base", "changeLanguage", "", "activity", "Landroid/app/Activity;", "locale", "Ljava/util/Locale;", "changeUiMode", "uiMode", "", "setDefaultNightMode", "(Ljava/lang/Integer;)V", "setLocaleForApi24", "config", "Landroid/content/res/Configuration;", "updateSettings", "Companion", "app_localApiDebug"})
public final class SettingsManager {
    private final llc.aerMist.base.shared.util.PreferenceCache prefsCache = null;
    public static final llc.aerMist.base.shared.util.SettingsManager.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final android.content.Context attachBaseContext(@org.jetbrains.annotations.Nullable()
    android.content.Context base) {
        return null;
    }
    
    public final void changeLanguage(@org.jetbrains.annotations.Nullable()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.util.Locale locale) {
    }
    
    public final void changeUiMode(@org.jetbrains.annotations.Nullable()
    android.app.Activity activity, int uiMode) {
    }
    
    @kotlin.Suppress(names = {"DEPRECATION"})
    private final android.content.Context updateSettings(android.content.Context base) {
        return null;
    }
    
    private final void setDefaultNightMode(java.lang.Integer uiMode) {
    }
    
    @androidx.annotation.RequiresApi(api = android.os.Build.VERSION_CODES.N)
    private final void setLocaleForApi24(android.content.res.Configuration config, java.util.Locale locale) {
    }
    
    public SettingsManager(@org.jetbrains.annotations.NotNull()
    llc.aerMist.base.shared.util.PreferenceCache prefsCache) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0004"}, d2 = {"Lllc/aerMist/base/shared/util/SettingsManager$Companion;", "", "()V", "AppLanguage", "app_localApiDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lllc/aerMist/base/shared/util/SettingsManager$Companion$AppLanguage;", "", "(Ljava/lang/String;I)V", "MONTENEGRIN", "ENGLISH", "app_localApiDebug"})
        public static enum AppLanguage {
            /*public static final*/ MONTENEGRIN /* = new MONTENEGRIN() */,
            /*public static final*/ ENGLISH /* = new ENGLISH() */;
            
            AppLanguage() {
            }
        }
    }
}