package com.azamovhudstc.mobilebankinguicompose.data.remote.response.common

data class CardData(
	val id: Int,
	val name: String,
	val amount: Int,
	val owner: String,
	val pan: String,
	val expiredYear: Int,
	val expiredMonth: Int,
	val themeType: Int,
	val isVisible: Boolean,
)
