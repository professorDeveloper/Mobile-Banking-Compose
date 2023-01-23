package com.azamovhudstc.mobilebankinguicompose.data.remote.response.balance

import com.google.gson.annotations.SerializedName

data class BalanceResponse(
    @SerializedName("total-balance")
    val totalBalance: Int
)