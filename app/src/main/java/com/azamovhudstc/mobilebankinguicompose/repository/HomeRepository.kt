package com.azamovhudstc.mobilebankinguicompose.repository

import com.azamovhudstc.mobilebankinguicompose.utils.ResultData
import kotlinx.coroutines.flow.Flow
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.UserFullResponse
import uz.gita.mobilebanking.data.model.response.UserInfoResponse

interface HomeRepository {
    fun getTotalBalance(): Flow<String>

    fun logOut()
    fun getUserInfo(): Flow<ResultData<UserInfoResponse>>
    fun getUserFullInfo(): Flow<ResultData<UserFullResponse>>
}