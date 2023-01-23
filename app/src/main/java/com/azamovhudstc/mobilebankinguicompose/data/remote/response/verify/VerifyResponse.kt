package com.azamovhudstc.mobilebankinguicompose.data.remote.response.verify

import com.google.gson.annotations.SerializedName

data class VerifyResponse(

	@field:SerializedName("refresh-token")
	val refreshToken: String,

	@field:SerializedName("access-token")
	val accessToken: String
)