package llc.aerMist.base.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0007H\u0016R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0082\u000e\u00a2\u0006\b\n\u0000\"\u0004\b\t\u0010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lllc/aerMist/base/data/remote/AuthorizationInterceptor;", "Lokhttp3/Interceptor;", "Lllc/aerMist/base/data/remote/AccessTokenListener;", "prefsCache", "Lllc/aerMist/base/shared/util/PreferenceCache;", "(Lllc/aerMist/base/shared/util/PreferenceCache;)V", "value", "", "accessToken", "setAccessToken", "(Ljava/lang/String;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "onChanged", "", "newToken", "app_localApiDebug"})
public final class AuthorizationInterceptor implements okhttp3.Interceptor, llc.aerMist.base.data.remote.AccessTokenListener {
    private java.lang.String accessToken = "";
    private final llc.aerMist.base.shared.util.PreferenceCache prefsCache = null;
    
    private final void setAccessToken(java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
    
    @java.lang.Override()
    public void onChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String newToken) {
    }
    
    public AuthorizationInterceptor(@org.jetbrains.annotations.NotNull()
    llc.aerMist.base.shared.util.PreferenceCache prefsCache) {
        super();
    }
}