package com.azamovhudstc.mobilebankinguicompose.screen.splash

import com.azamovhudstc.mobilebankinguicompose.utils.BaseViewModel


interface SplashViewModel : BaseViewModel<Unit, SplashUiState, Nothing>

data class SplashUiState(
    val isOpenLogin: Boolean = false,
    val isOPenMain: Boolean = false
)