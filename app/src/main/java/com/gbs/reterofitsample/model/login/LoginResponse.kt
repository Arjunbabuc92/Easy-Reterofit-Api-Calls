package com.gbs.reterofitsample.model.login

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("message") var message: String? = null,
    @SerializedName("data") var data: LoginData? = LoginData()
)

data class LoginData(
    @SerializedName("user_id") var userId: String? = null,
    @SerializedName("token") var token: String? = null,
    @SerializedName("server_date") var serverDate: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("email") var email: String? = null,
    @SerializedName("phone") var phone: String? = null,
    @SerializedName("details") var details: ArrayList<String> = arrayListOf(),
    @SerializedName("members") var members: ArrayList<String> = arrayListOf(),
    @SerializedName("events") var events: ArrayList<String> = arrayListOf(),
    @SerializedName("tasks") var tasks: ArrayList<String> = arrayListOf(),
    @SerializedName("notifications") var notifications: ArrayList<String> = arrayListOf()
)
