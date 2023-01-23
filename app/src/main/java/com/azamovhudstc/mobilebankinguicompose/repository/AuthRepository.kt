package com.azamovhudstc.mobilebankinguicompose.repository

import com.azamovhudstc.mobilebankinguicompose.data.remote.request.login.LoginRequest
import com.azamovhudstc.mobilebankinguicompose.data.remote.request.register.SignUpRequest
import com.azamovhudstc.mobilebankinguicompose.data.remote.request.resend_verify.ResendVerifyRequestAndResponse
import com.azamovhudstc.mobilebankinguicompose.data.remote.request.verify.SignUpVerifyRequest
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.login.LoginResponse
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.register.SignUpSuccessResponse
import com.azamovhudstc.mobilebankinguicompose.utils.ResultData
import kotlinx.coroutines.flow.Flow
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.verify.VerifyResponse

interface AuthRepository {
    fun login(request: LoginRequest):Flow<ResultData<LoginResponse>>
    fun signInVerify(token:String):Flow<ResultData<VerifyResponse>>
    fun signUpVerify(token:String):Flow<ResultData<VerifyResponse>>
    fun signUp(verifyRequest: SignUpRequest):Flow<ResultData<SignUpSuccessResponse>>
    fun signUpResend(): Flow<ResultData<ResendVerifyRequestAndResponse>>
    fun signInResend(): Flow<ResultData<ResendVerifyRequestAndResponse>>
}