package com.azamovhudstc.mobilebankinguicompose.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.azamovhudstc.mobilebankinguicompose.R
import com.azamovhudstc.mobilebankinguicompose.screen.login.LoginScreen
import com.azamovhudstc.mobilebankinguicompose.screen.main.MainScreen
import com.azamovhudstc.mobilebankinguicompose.ui.theme.splashBgColor
import org.orbitmvi.orbit.compose.collectAsState

class SplashScreen : Screen {
    private lateinit var navigator: Navigator

    @Composable

    override fun Content() {
        val viewModel: SplashViewModel = getViewModel<SplashViewModelImpl>()
        navigator = LocalNavigator.currentOrThrow
        SplashScreenContent(viewModel.collectAsState().value, navigator)

    }
    

    @Composable
    private fun SplashScreenContent(uiState: SplashUiState, navigator: Navigator) {

        Box(modifier = Modifier.fillMaxSize().background(splashBgColor)) {

            val contentDescriptionImage by remember {
                mutableStateOf("Splash")
            }

            Image(
                modifier = Modifier
                    .width(160.dp)
                    .height(160.dp)
                    .align(Alignment.Center),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = contentDescriptionImage,
            )
            LaunchedEffect(key1 = uiState.isOPenMain || uiState.isOpenLogin) {
//                Log.d("TTT", "SplashScreenContent:${uiState} ")

                if (uiState.isOPenMain) {
                    navigator.replace(MainScreen())
                }
                if (uiState.isOpenLogin) {
                    navigator.replace(LoginScreen())

                }
            }

        }
    }

    @Preview(showSystemUi = true)
    @Composable
    fun SplashScreenPreview() {
        SplashScreenContent(SplashUiState(), LocalNavigator.currentOrThrow)
    }
}