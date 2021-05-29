package llc.aerMist.base.data.remote;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 0}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\t\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lllc/aerMist/base/data/remote/ApiService;", "", "authenticate", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "authenticationRequest", "Lllc/aerMist/base/vo/AuthenticationRequest;", "(Lllc/aerMist/base/vo/AuthenticationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "testRequest", "app_localApiDebug"})
public abstract interface ApiService {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/")
    public abstract java.lang.Object authenticate(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Body()
    llc.aerMist.base.vo.AuthenticationRequest authenticationRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> p1);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/")
    public abstract java.lang.Object refreshToken(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> p0);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "/posts/1")
    public abstract java.lang.Object testRequest(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<okhttp3.ResponseBody>> p0);
}