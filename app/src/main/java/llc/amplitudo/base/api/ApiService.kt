package llc.amplitudo.base.api

import llc.amplitudo.base.vo.AuthenticationRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.*

interface ApiService {

    @POST("/authenticate")
    suspend fun authenticate(@Body authRequest: AuthenticationRequest): Response<ResponseBody>
}