package com.azamovhudstc.mobilebankinguicompose.repository

import com.azamovhudstc.mobilebankinguicompose.data.remote.response.common.CardData
import kotlinx.coroutines.flow.Flow

interface CardRepository {
    fun getAllCards(): Flow<Result<List<CardData>>>

}