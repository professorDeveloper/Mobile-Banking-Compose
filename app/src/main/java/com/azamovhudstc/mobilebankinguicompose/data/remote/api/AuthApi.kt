package com.azamovhudstc.mobilebankinguicompose.data.remote.api

import com.azamovhudstc.mobilebankinguicompose.data.remote.request.login.LoginRequest
import com.azamovhudstc.mobilebankinguicompose.data.remote.request.register.SignUpRequest
import com.azamovhudstc.mobilebankinguicompose.data.remote.request.resend_verify.ResendVerifyRequestAndResponse
import com.azamovhudstc.mobilebankinguicompose.data.remote.request.verify.SignInVerifyRequest
import com.azamovhudstc.mobilebankinguicompose.data.remote.request.verify.SignUpVerifyRequest
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.login.LoginResponse
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.register.SignUpSuccessResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.verify.VerifyResponse

interface AuthApi {

    @POST("/v1/mobile-bank/auth/sign-up")
    suspend fun signUp(@Body signUpRequest: SignUpRequest) : Response<SignUpSuccessResponse>

    @POST("/v1/mobile-bank/auth/sign-up/verify")
    suspend fun signUpVerify(@Body signUpVerifyRequest: SignUpVerifyRequest) : Response<VerifyResponse>

    @POST("/v1/mobile-bank/auth/sign-in")
    suspend fun signIn(@Body signInRequest: LoginRequest) : Response<LoginResponse>

    @POST("/v1/mobile-bank/auth/sign-in/verify")
    suspend fun signInVerify(@Body signInVerifyRequest: SignInVerifyRequest) :Response<VerifyResponse>
    @POST("/v1/mobile-bank/auth/sign-up/resend")
    suspend fun signUpVerifyResend(@Body signInVerifyRequest: ResendVerifyRequestAndResponse) :Response<ResendVerifyRequestAndResponse>
    @POST("/v1/mobile-bank/auth/sign-in/resend")
    suspend fun signInVerifyResend(@Body signInVerifyRequest: ResendVerifyRequestAndResponse) :Response<ResendVerifyRequestAndResponse>

}