package com.azamovhudstc.mobilebankinguicompose.data.remote.request.register

import com.google.gson.annotations.SerializedName

data class SignUpRequest(

	@field:SerializedName("password")
	val password: String,

	@field:SerializedName("gender")
	val gender: String,

	@field:SerializedName("phone")
	val phone: String,

	@field:SerializedName("born-date")
	val bornDate: String,

	@field:SerializedName("first-name")
	val firstName: String,

	@field:SerializedName("last-name")
	val lastName: String
)