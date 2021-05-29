package llc.aerMist.base.data.repo;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0010\u001a\u00020\u000eJF\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u000b0\n\"\u0004\b\u0000\u0010\u00122\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u000b0\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0014H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lllc/aerMist/base/data/repo/UserRepository;", "", "remoteDataSource", "Lllc/aerMist/base/data/remote/RemoteDataSource;", "accessTokenListener", "Lllc/aerMist/base/data/remote/AccessTokenListener;", "authenticator", "Lllc/aerMist/base/data/remote/TokenRefreshAuthenticator;", "(Lllc/aerMist/base/data/remote/RemoteDataSource;Lllc/aerMist/base/data/remote/AccessTokenListener;Lllc/aerMist/base/data/remote/TokenRefreshAuthenticator;)V", "authenticate", "Landroidx/lifecycle/LiveData;", "Lllc/aerMist/base/shared/base/Resource;", "Lokhttp3/ResponseBody;", "email", "", "password", "refreshToken", "retrieve", "T", "networkCall", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/LiveData;", "app_localApiDebug"})
public final class UserRepository {
    private final llc.aerMist.base.data.remote.RemoteDataSource remoteDataSource = null;
    private final llc.aerMist.base.data.remote.AccessTokenListener accessTokenListener = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<llc.aerMist.base.shared.base.Resource<okhttp3.ResponseBody>> authenticate(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String refreshToken() {
        return null;
    }
    
    private final <T extends java.lang.Object>androidx.lifecycle.LiveData<llc.aerMist.base.shared.base.Resource<T>> retrieve(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super llc.aerMist.base.shared.base.Resource<T>>, ? extends java.lang.Object> networkCall) {
        return null;
    }
    
    public UserRepository(@org.jetbrains.annotations.NotNull()
    llc.aerMist.base.data.remote.RemoteDataSource remoteDataSource, @org.jetbrains.annotations.NotNull()
    llc.aerMist.base.data.remote.AccessTokenListener accessTokenListener, @org.jetbrains.annotations.NotNull()
    llc.aerMist.base.data.remote.TokenRefreshAuthenticator authenticator) {
        super();
    }
}