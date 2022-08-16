package com.gbs.easy_reterofit_call

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import com.gbs.easy_reterofit_call.utils.DownloadedData
import com.gbs.easy_reterofit_call.utils.ERROR
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCalls {
    val apiInterface = ApiHelper.getInstance()
        .create(ApiInterface::class.java)

    fun getJsonUsingRawJsonRequest(
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
                        Toast.makeText(context,responseJson.optString("message").toString(),Toast.LENGTH_LONG).show()
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
                Toast.makeText(context,"$url: Something went wrong please try after some time",Toast.LENGTH_LONG).show()
                completion(
                    DownloadedData(
                        ERROR.SERVER_ERROR,
                        "$url: Something went wrong please try after some time"
                    )
                )
            }
        })
    }

    fun getJsonUsingRawJsonRequestAndHeader(
        url: String,
        request: String,
        context: Context,
        userid:String,
        token:String,
        completion: (DownloadedData) -> Unit
    ) {
        val data: Call<String> =
            apiInterface.postApiWithHeader(
                url,
                userid,
                token,
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
                        Toast.makeText(context,responseJson.optString("message").toString(),Toast.LENGTH_LONG).show()
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
                Toast.makeText(context,"$url: Something went wrong please try after some time",Toast.LENGTH_LONG).show()
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