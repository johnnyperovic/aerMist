package llc.aerMist.base.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u000f*\u00020\u000bH\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u00020\n*\u00020\u000b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lllc/aerMist/base/data/remote/TokenRefreshAuthenticator;", "Lokhttp3/Authenticator;", "()V", "userRepository", "Lllc/aerMist/base/data/repo/UserRepository;", "getUserRepository", "()Lllc/aerMist/base/data/repo/UserRepository;", "setUserRepository", "(Lllc/aerMist/base/data/repo/UserRepository;)V", "retryCount", "", "Lokhttp3/Response;", "getRetryCount", "(Lokhttp3/Response;)I", "authenticate", "Lokhttp3/Request;", "route", "Lokhttp3/Route;", "response", "createSignedRequest", "app_localApiDebug"})
public final class TokenRefreshAuthenticator implements okhttp3.Authenticator {
    @org.jetbrains.annotations.Nullable()
    private llc.aerMist.base.data.repo.UserRepository userRepository;
    
    @org.jetbrains.annotations.Nullable()
    public final llc.aerMist.base.data.repo.UserRepository getUserRepository() {
        return null;
    }
    
    public final void setUserRepository(@org.jetbrains.annotations.Nullable()
    llc.aerMist.base.data.repo.UserRepository p0) {
    }
    
    private final int getRetryCount(okhttp3.Response $this$retryCount) {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public okhttp3.Request authenticate(@org.jetbrains.annotations.Nullable()
    okhttp3.Route route, @org.jetbrains.annotations.NotNull()
    okhttp3.Response response) {
        return null;
    }
    
    private final okhttp3.Request createSignedRequest(okhttp3.Response $this$createSignedRequest) {
        return null;
    }
    
    public TokenRefreshAuthenticator() {
        super();
    }
}