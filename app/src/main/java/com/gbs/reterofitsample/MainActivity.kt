package com.gbs.reterofitsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gbs.easy_reterofit_call.ApiCalls
import com.gbs.easy_reterofit_call.utils.ERROR
import com.gbs.reterofitsample.model.changepassword.ChangePasswordRequest
import com.gbs.reterofitsample.model.changepassword.ChangePasswordResponse
import com.gbs.reterofitsample.network.EndPoints
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiCalls = ApiCalls()
        val changePasswordRequest = ChangePasswordRequest("12345678","123456789","123456789")
        val map: MutableMap<String, String> = HashMap()
        map["userid"] = "101"
        apiCalls.getJsonUsingRawJsonRequestAndHeader(EndPoints.baseURL+EndPoints.changePassword,gson.toJson(changePasswordRequest),this,map){
            if(it.error== ERROR.NONE){
                val loginResponse = gson.fromJson(it.responseData, ChangePasswordResponse::class.java)
                Log.e("sample",loginResponse.toString())
            }
        }
    }
}
