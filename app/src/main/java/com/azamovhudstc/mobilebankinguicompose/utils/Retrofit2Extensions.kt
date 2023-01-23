package com.azamovhudstc.mobilebankinguicompose.utils

import com.azamovhudstc.mobilebankinguicompose.data.remote.response.error.ErrorResponse
import com.google.gson.Gson
import retrofit2.Response

fun <T> Response<T>.func(): ResultData<T> {
    val data = this
    if (data.isSuccessful) {
        return if (data.body() != null) {
            val body = data.body()!!
            ResultData.Success(body)
        } else {
            ResultData.Error(Throwable("Body null"))
        }
    }
    val gson = Gson()
    val error = gson.fromJson(data.errorBody()?.string(), ErrorResponse::class.java)
    return ResultData.Error(Throwable(error.message))
}
