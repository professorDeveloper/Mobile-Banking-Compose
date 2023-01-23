package com.azamovhudstc.mobilebankinguicompose.screen.verify.viewmodel

import kotlinx.coroutines.flow.StateFlow

interface VerifyContract {
    sealed interface VerifyIntent {
        data class CodeEnter(
            val code: String,
        ) : VerifyIntent



        object ClickVerify : VerifyIntent
        object ClickResend : VerifyIntent
    }

    data class UiState(
        val code: String,
        var errorMessage: String,
        var resendTime:Int,
        var progress: Boolean

    )

    interface VerifyModel {
        val uiState: StateFlow<UiState>

        fun onEventDispatcher(intent: VerifyIntent)


    }
}


