package com.azamovhudstc.mobilebankinguicompose.data.remote.response.user

import com.google.gson.annotations.SerializedName

data class UserFullResponse(
	@SerializedName("gender")
	val gender: Int,
	@SerializedName("phone")
	val phone: String,
	@SerializedName("born-date")
	val bornDate: Long,
	@SerializedName("first-name")
	val firstName: String,
	@SerializedName("last-name")
	val lastName: String
)