package com.azamovhudstc.mobilebankinguicompose.data.remote.api

import com.azamovhudstc.mobilebankinguicompose.data.remote.response.common.CardData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header

interface CardApi {
    @GET("card")
    suspend fun getAllCards(@Header("Bearer {data}") data: String): Response<List<CardData>>

}