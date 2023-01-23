package com.azamovhudstc.mobilebankinguicompose.data.remote.response.register

import com.google.gson.annotations.SerializedName

data class SignUpSuccessResponse(

	@field:SerializedName("token")
	val token: String
)