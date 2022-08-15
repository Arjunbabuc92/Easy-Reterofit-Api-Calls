package com.gbs.reterofitsample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.gbs.reterofitsample.model.login.LoginRequest
import com.gbs.reterofitsample.model.login.LoginResponse
import com.gbs.reterofitsample.network.EndPoints
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    val gson = Gson()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val apiCalls = ApiCalls()
//        val loginRequest = LoginRequest("1234567891@getnada.com","Ancy@1998")
//        apiCalls.getJson(EndPoints.baseURL+EndPoints.loginEndPoint,gson.toJson(loginRequest),this){
//            if(it.error==ERROR.NONE){
//                val loginResponse = gson.fromJson(it.responseData, LoginResponse::class.java)
//                Log.e("sample",loginResponse.toString())
//            }
//        }
    }
}