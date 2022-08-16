package com.gbs.reterofitsample.model.changepassword

import com.google.gson.annotations.SerializedName

data class ChangePasswordResponse(
    @SerializedName("status") var status: Boolean? = null,
    @SerializedName("message") var message: String? = null
)
