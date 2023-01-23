package com.azamovhudstc.mobilebankinguicompose.screen.login.viewmodel

import androidx.lifecycle.ViewModel
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import cafe.adriel.voyager.core.screen.Screen
import com.azamovhudstc.mobilebankinguicompose.data.remote.request.login.LoginRequest
import com.azamovhudstc.mobilebankinguicompose.navigation.AppNavigator
import com.azamovhudstc.mobilebankinguicompose.repository.AuthRepository
import com.azamovhudstc.mobilebankinguicompose.screen.register.RegisterScreen
import com.azamovhudstc.mobilebankinguicompose.screen.verify.VerifyScreen
import com.azamovhudstc.mobilebankinguicompose.utils.SignType
import com.azamovhudstc.mobilebankinguicompose.utils.VerifyUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class LoginViewModelImpl @Inject constructor(
    private val repository: AuthRepository,
    private val appNavigator: AppNavigator
) : LoginContract.LoginViewModel, ScreenModel {
    override val uiState = MutableStateFlow(
        LoginContract.UiState(
            phone = "", password = "",
            errorMessage = "",
            progress = false
        )
    )

    override fun onEventDispatcher(intent: LoginContract.LoginIntent) {
        when (intent) {
            LoginContract.LoginIntent.ClickLogin -> {
                   repository.login(LoginRequest(uiState.value.password,"+998"+uiState.value.phone)).onEach {
                     reduce {
                         it.copy(progress = false)
                     }
                       it.onSuccess {
                           println("Success Login")
                           open(VerifyScreen()) }
                       it.onError { t->
                           reduce {
                               it.copy(errorMessage = t.message.toString(), progress = true)
                           }

                       }

                   }.launchIn(coroutineScope)
              }
            LoginContract.LoginIntent.CreateAccount -> {
                open(RegisterScreen())
            }
            is LoginContract.LoginIntent.PasswordEnter -> {
                reduce {
                    it.copy(password = intent.password, progress = false)
                }
            }
            is LoginContract.LoginIntent.PhoneEnter -> {
                reduce {
                    it.copy(phone = intent.phone,progress = false)
                }
            }
        }
    }

    private fun open(screen: Screen) {
        coroutineScope.launch {
            VerifyUtil.signType=SignType.SIGN_IN
            appNavigator.navigationTo(screen)
        }
    }


    private fun reduce(block: (oldState: LoginContract.UiState) -> LoginContract.UiState) {
        val old = uiState.value
        uiState.value = block(old)
    }

}