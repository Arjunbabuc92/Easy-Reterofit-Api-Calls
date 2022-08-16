package com.gbs.reterofitsample.model.changepassword

import com.google.gson.annotations.SerializedName

data class ChangePasswordRequest(
    @SerializedName("old_password") var oldPassword: String? = null,
    @SerializedName("new_password") var newPassword: String? = null,
    @SerializedName("confirm_new_password") var confirmNewPassword: String? = null
)
