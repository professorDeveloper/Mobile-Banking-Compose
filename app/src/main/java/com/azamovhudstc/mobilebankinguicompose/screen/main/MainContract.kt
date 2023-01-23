package com.azamovhudstc.mobilebankinguicompose.screen.main

import com.azamovhudstc.mobilebankinguicompose.data.remote.response.common.CardData
import kotlinx.coroutines.flow.StateFlow


interface MainContract {

    interface ViewModel {
        val uiState: StateFlow<UiState>

        fun onEventDispatcher(intent: Intent)
    }

    data class UiState(
        val totalBalance: String = "0",
        val cards: List<CardData> = emptyList()
    )

    sealed interface Intent {

        object Night : Intent
        object Back : Intent
    }
}