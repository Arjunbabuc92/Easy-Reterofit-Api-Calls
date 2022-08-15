package com.gbs.reterofit_network_calls

import android.annotation.SuppressLint
import android.content.Context
import com.gbs.reterofit_network_calls.utils.DownloadedData
import com.gbs.reterofit_network_calls.utils.ERROR
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCalls {
    val apiInterface = ApiHelper.getInstance()
        .create(ApiInterface::class.java)

    fun getJson(
        url: String,
        request: String,
        context: Context,
        completion: (DownloadedData) -> Unit
    ) {
        val data: Call<String> =
            apiInterface.postApiResponse(
                url,
                request
            )
        data.enqueue(object : Callback<String> {
            @SuppressLint("SetJavaScriptEnabled")
            override fun onResponse(
                call: Call<String>,
                response: Response<String>
            ) {
                if (response.isSuccessful) {
                    val responseJson = JSONObject(response.body().toString())
                    if (responseJson.optBoolean("status")) {
                        completion(DownloadedData(ERROR.NONE, response.body().toString()))
                    } else {
                        completion(
                            DownloadedData(
                                ERROR.REQUEST_ERROR,
                                responseJson.optString("message").toString()
                            )
                        )
                    }
                }
            }

            override fun onFailure(call: Call<String?>, t: Throwable) {
                completion(
                    DownloadedData(
                        ERROR.SERVER_ERROR,
                        "$url: Something went wrong please try after some time"
                    )
                )
            }
        })
    }
}