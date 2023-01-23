package com.azamovhudstc.mobilebankinguicompose.data.remote.request.verify

import com.google.gson.annotations.SerializedName

data class SignInVerifyRequest(

	@field:SerializedName("code")
	val code: String,

	@field:SerializedName("token")
	val token: String
)