package com.gbs.reterofit_network_calls

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Url

interface ApiInterface {
    @POST
    fun postApiResponse(
        @Url url: String,
        @Body request: String
    ): Call<String>
}