package com.azamovhudstc.mobilebankinguicompose.screen.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.azamovhudstc.mobilebankinguicompose.data.local.MySharedPref
import com.azamovhudstc.mobilebankinguicompose.screen.splash.SplashUiState
import com.azamovhudstc.mobilebankinguicompose.screen.splash.SplashViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl @Inject constructor(
    private val mySharedPref: MySharedPref
) : SplashViewModel, ViewModel() {

    override val container: Container<SplashUiState, Nothing> = container(SplashUiState())

    init {
        viewModelScope.launch {
            delay(2000)
            intent {
                reduce {
                    if (mySharedPref.token.isEmpty()) state.copy(isOpenLogin = true)else
                    state.copy(isOPenMain = true)
                }
            }
        }
    }

    override fun onEventDispatcher(intent: Unit) {}
}