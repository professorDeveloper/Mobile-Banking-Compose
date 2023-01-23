package com.azamovhudstc.mobilebankinguicompose.screen.register.viewmodel

import kotlinx.coroutines.flow.StateFlow

interface RegisterContract {
    sealed interface RegisterIntent {
        data class FirstNameEnter(
            val firstName: String,
        ) : RegisterIntent
        data class LastNameEnter(
            val lastName: String,
        ) : RegisterIntent
        data class PhoneEnter(
            val phone: String,
        ) : RegisterIntent

        data class BornDate(
            val bornDate: String,
        ) : RegisterIntent

        data class PasswordEnter(
            val password: String
        ) : RegisterIntent

        data class GenderEnter(
            val gender: Boolean
        ) : RegisterIntent


        object ClickRegister : RegisterIntent
    }

    data class UiState(
        val firstName: String="",
        val lastName: String="",
        val bornDate: String="",
        val phone: String="",
        val password: String="",
        var errorMessage:String="",
        var gender:Boolean=true,
        var progress:Boolean=false

    )

    interface RegisterViewModel {
        val uiState: StateFlow<UiState>

        fun onEventDispatcher(intent: RegisterIntent)


    }


}