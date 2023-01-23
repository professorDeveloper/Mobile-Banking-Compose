package com.azamovhudstc.mobilebankinguicompose.screen.register.viewmodel.impl

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import cafe.adriel.voyager.core.screen.Screen
import com.azamovhudstc.mobilebankinguicompose.data.remote.request.register.SignUpRequest
import com.azamovhudstc.mobilebankinguicompose.navigation.AppNavigator
import com.azamovhudstc.mobilebankinguicompose.repository.AuthRepository
import com.azamovhudstc.mobilebankinguicompose.screen.login.viewmodel.LoginContract
import com.azamovhudstc.mobilebankinguicompose.screen.register.viewmodel.RegisterContract
import com.azamovhudstc.mobilebankinguicompose.screen.verify.VerifyScreen
import com.azamovhudstc.mobilebankinguicompose.utils.SignType
import com.azamovhudstc.mobilebankinguicompose.utils.VerifyUtil
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class RegisterViewModelImpl @Inject constructor(
    private val repository: AuthRepository,
    private val appNavigator: AppNavigator
):RegisterContract.RegisterViewModel, ScreenModel {
    override val uiState = MutableStateFlow(RegisterContract.UiState())
    override fun onEventDispatcher(intent: RegisterContract.RegisterIntent) {
       when(intent){
           is RegisterContract.RegisterIntent.BornDate -> {
               reduce {
                   it.copy(bornDate = intent.bornDate, progress = false)
               }
           }
           RegisterContract.RegisterIntent.ClickRegister -> {
               val gender:Int=if (uiState.value.gender)0 else 1
               repository.signUp(SignUpRequest(uiState.value.password, gender.toString(),"+998"+uiState.value.phone,uiState.value.bornDate,uiState.value.firstName,uiState.value.lastName)).onEach {
                   reduce {
                       it.copy(progress =false )
                   }
                   it.onError {t->
                       reduce {
                           it.copy(errorMessage = t.message.toString(), progress = true)
                       }
                   }
                   it.onSuccess {
                       println("Success Register")
                       open(VerifyScreen())
                   }
               }.launchIn(coroutineScope)
           }
           is RegisterContract.RegisterIntent.FirstNameEnter -> {
               reduce {
                   it.copy(firstName = intent.firstName, progress = false)
               }
           }
           is RegisterContract.RegisterIntent.GenderEnter -> {
               reduce {
                   it.copy(gender = intent.gender, progress = false)
               }
           }
           is RegisterContract.RegisterIntent.LastNameEnter -> {
               reduce {
                   it.copy(lastName = intent.lastName, progress = false)
               }
           }
           is RegisterContract.RegisterIntent.PasswordEnter -> {
               reduce {
                   it.copy(password =intent.password , progress = false)
               }
           }
           is RegisterContract.RegisterIntent.PhoneEnter -> {
               reduce {
                   it.copy(phone =intent.phone , progress = false)
               }
           }
       }
    }
    private fun open(screen: Screen) {
        coroutineScope.launch {
            VerifyUtil.signType= SignType.SIGN_UP
            appNavigator.navigationTo(screen)
        }
    }


    private fun reduce(block: (oldState: RegisterContract.UiState) -> RegisterContract.UiState) {
        val old = uiState.value
        uiState.value = block(old)
    }
}