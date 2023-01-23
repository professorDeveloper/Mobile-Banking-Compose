package com.azamovhudstc.mobilebankinguicompose.screen.main

import android.util.Log
import androidx.lifecycle.ViewModel
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import cafe.adriel.voyager.core.screen.Screen
import com.azamovhudstc.mobilebankinguicompose.navigation.AppNavigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class MainScreenModelImpl @Inject constructor(
    private val appNavigator: AppNavigator,
) : ScreenModel, MainContract.ViewModel {

    override val uiState = MutableStateFlow(MainContract.UiState())

    override fun onEventDispatcher(intent: MainContract.Intent) {
        when (intent) {
            is MainContract.Intent.Night -> {

            }
            is MainContract.Intent.Back -> {
                coroutineScope.launch { appNavigator.back() }
            }
        }
    }

    private fun reduce(block: (oldState: MainContract.UiState) -> MainContract.UiState) {
        val old = uiState.value
        uiState.value = block(old)
    }

    private suspend fun open(screen: Screen) {
        appNavigator.navigationTo(screen)
    }
}