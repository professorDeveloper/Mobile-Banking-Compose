package com.azamovhudstc.mobilebankinguicompose.screen.login.viewmodel

import android.content.Intent
import com.azamovhudstc.mobilebankinguicompose.utils.BaseViewModel
import kotlinx.coroutines.flow.StateFlow

interface LoginContract {
    sealed interface LoginIntent {
        data class PhoneEnter(
            val phone: String,
        ) : LoginIntent

        data class PasswordEnter(
            val password: String
        ) : LoginIntent

        object CreateAccount : LoginIntent
        object ClickLogin : LoginIntent
    }

    data class UiState(
        val phone: String,
        val password: String,
        var errorMessage:String,

        var progress:Boolean

    )

    interface LoginViewModel {
        val uiState: StateFlow<UiState>

        fun onEventDispatcher(intent: LoginIntent)


    }


}



