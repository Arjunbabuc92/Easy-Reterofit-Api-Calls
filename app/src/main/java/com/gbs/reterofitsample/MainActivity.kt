package com.gbs.reterofitsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gbs.easy_reterofit_call.ApiCalls
import com.gbs.easy_reterofit_call.utils.ERROR
import com.gbs.reterofitsample.model.changepassword.ChangePasswordRequest
import com.gbs.reterofitsample.model.changepassword.ChangePasswordResponse
import com.gbs.reterofitsample.model.login.LoginRequest
import com.gbs.reterofitsample.model.login.LoginResponse
import com.gbs.reterofitsample.network.EndPoints
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val apiCalls = ApiCalls()
        val changePasswordRequest = ChangePasswordRequest("12345678","123456789","123456789")
        apiCalls.getJsonUsingRawJsonRequestAndHeader(EndPoints.baseURL+EndPoints.changePassword,gson.toJson(changePasswordRequest),this,"101","6b16d46e7155b977155cc2bae4c74dba"){
            if(it.error== ERROR.NONE){
                val loginResponse = gson.fromJson(it.responseData, ChangePasswordResponse::class.java)
                Log.e("sample",loginResponse.toString())
            }
        }
    }
}
