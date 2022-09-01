package com.gbs.easy_reterofit_call

import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {
    @POST
    fun postApiResponse(
        @Url url: String,
        @Body request: String
    ): Call<String>

    @POST
    fun postApiWithHeader(
        @Url url: String,
        @HeaderMap map: MutableMap<String, String>,
        @Body request: String,
    ): Call<String>
}