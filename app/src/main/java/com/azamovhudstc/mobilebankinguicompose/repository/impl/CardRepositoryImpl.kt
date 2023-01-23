package com.azamovhudstc.mobilebankinguicompose.repository.impl

import com.azamovhudstc.mobilebankinguicompose.data.local.MySharedPref
import com.azamovhudstc.mobilebankinguicompose.data.remote.api.CardApi
import com.azamovhudstc.mobilebankinguicompose.data.remote.response.common.CardData
import com.azamovhudstc.mobilebankinguicompose.repository.CardRepository
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CardRepositoryImpl @Inject constructor(
    private val cardApi: CardApi,
    private val localStorage: MySharedPref,
    private val gson: Gson
) : CardRepository {

    override fun getAllCards(): Flow<Result<List<CardData>>>  = flow{}
//        val responcardApi.getTotalBalance(localStorage.tempToken)
//        if (response.isSuccessful) {
//            response.body()?.let {
//                emit(Result.success(it.totalBalance.toString()))
//            }
//        } else emit(Result.failure(Exception(gsonConverter(response))))
//    }.catch
//    { emit(Result.failure(Exception(it.message))) }
//    .flowOn(Dispatchers.IO)se =




//    override fun logOut() {
//        localStorage.startScreen = StartScreenEnum.LOGIN
//    }
}