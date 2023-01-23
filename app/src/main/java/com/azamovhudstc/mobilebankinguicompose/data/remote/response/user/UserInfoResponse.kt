package com.azamovhudstc.mobilebankinguicompose.data.remote.response.user

import com.google.gson.annotations.SerializedName
import kotlin.String

data class UserInfoResponse(
		@SerializedName("firsrt-name")
	val firstName: String,
		@SerializedName("age")
	val age: Int,
		@SerializedName("gender-type")
	val gender: Int
)