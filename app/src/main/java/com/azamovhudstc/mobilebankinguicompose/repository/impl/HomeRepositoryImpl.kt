package com.azamovhudstc.mobilebankinguicompose.repository.impl

import com.azamovhudstc.mobilebankinguicompose.data.local.MySharedPref
import com.azamovhudstc.mobilebankinguicompose.data.remote.api.HomeApi
import com.azamovhudstc.mobilebankinguicompose.repository.HomeRepository
import com.azamovhudstc.mobilebankinguicompose.utils.ResultData
import com.azamovhudstc.mobilebankinguicompose.utils.func
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.UserFullResponse
import uz.gita.mobilebanking.data.model.response.UserInfoResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeRepositoryImpl @Inject constructor(
    private val homeApi: HomeApi,
    private val localStorage: MySharedPref,
    private val gson: Gson
) : HomeRepository {

    override fun getTotalBalance() = flow<String> {
        val response = homeApi.getTotalBalance(localStorage.token).func()
        response.onSuccess {
            emit(it.totalBalance.toString())
        }
        response.onMessage {
            emit(it)
        }
        response.onError {
        }
    }

    override fun getUserInfo() = flow<ResultData<UserInfoResponse>> {
        val response = homeApi.getUserInfo(localStorage.token).func()
        emit(response)
    }

    override fun getUserFullInfo() = flow<ResultData<UserFullResponse>> {
        val response = homeApi.getUserFullInfo(localStorage.token).func()

        emit(response)

    }

    override fun logOut() {
    }
}