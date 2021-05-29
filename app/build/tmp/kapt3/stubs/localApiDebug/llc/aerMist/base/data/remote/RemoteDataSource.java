package llc.aerMist.base.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\'\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lllc/aerMist/base/data/remote/RemoteDataSource;", "Lllc/aerMist/base/shared/base/BaseDataSource;", "apiService", "Lllc/aerMist/base/data/remote/ApiService;", "(Lllc/aerMist/base/data/remote/ApiService;)V", "authenticate", "Lllc/aerMist/base/shared/base/Resource;", "Lokhttp3/ResponseBody;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_localApiDebug"})
public final class RemoteDataSource extends llc.aerMist.base.shared.base.BaseDataSource {
    private final llc.aerMist.base.data.remote.ApiService apiService = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object authenticate(@org.jetbrains.annotations.NotNull()
    java.lang.String email, @org.jetbrains.annotations.NotNull()
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super llc.aerMist.base.shared.base.Resource<okhttp3.ResponseBody>> p2) {
        return null;
    }
    
    public RemoteDataSource(@org.jetbrains.annotations.NotNull()
    llc.aerMist.base.data.remote.ApiService apiService) {
        super();
    }
}