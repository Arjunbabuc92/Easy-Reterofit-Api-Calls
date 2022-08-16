package com.gbs.easy_reterofit_call

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

object ApiHelper {
    fun getInstance(): Retrofit {
        val client = OkHttpClient.Builder()
            .connectTimeout(60, java.util.concurrent.TimeUnit.SECONDS)
            .readTimeout(60, java.util.concurrent.TimeUnit.SECONDS).build()
        return Retrofit.Builder()
            .baseUrl("https://gbs-plus.com")
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(client)
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()
    }
}