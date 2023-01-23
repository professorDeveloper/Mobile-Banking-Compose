package com.azamovhudstc.mobilebankinguicompose.data.remote.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.balance.BalanceResponse
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.UserFullResponse
import uz.gita.mobilebanking.data.model.response.UserInfoResponse

interface HomeApi {
    @GET("home/total-balance")
    suspend fun getTotalBalance(@Header("Bearer {data}") data: String): Response<BalanceResponse>

    @GET("home/user-info")
    suspend fun getUserInfo(@Header("Bearer {data}") data: String): Response<UserInfoResponse>

    @GET("home/user-info/details")
    suspend fun getUserFullInfo(@Header("Bearer {data}") data: String): Response<UserFullResponse>

}