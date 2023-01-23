package com.azamovhudstc.mobilebankinguicompose.screen.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.azamovhudstc.mobilebankinguicompose.R
import com.azamovhudstc.mobilebankinguicompose.screen.login.viewmodel.LoginContract
import com.azamovhudstc.mobilebankinguicompose.screen.login.viewmodel.LoginViewModelImpl
import com.azamovhudstc.mobilebankinguicompose.screen.verify.VerifyScreen
import com.azamovhudstc.mobilebankinguicompose.ui.theme.buttonColor
import com.azamovhudstc.mobilebankinguicompose.ui.theme.editTextColor
import com.azamovhudstc.mobilebankinguicompose.utils.PhoneMaskTransformation

class LoginScreen : AndroidScreen() {

    @Composable
    override fun Content() {
        var viewModel = getScreenModel<LoginViewModelImpl>()
        val uiState = viewModel.uiState.collectAsState().value
        LoginUi(uiState, viewModel::onEventDispatcher)

    }

    @Composable
    fun LoginUi(
        uiState: LoginContract.UiState,
        events: (LoginContract.LoginIntent) -> Unit
    ) {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Sign in",
                    color=MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.headlineMedium
                    ,        fontFamily = FontFamily.Serif,
                    modifier = Modifier.clickable {

                    }
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = Color.White)
                        .padding(top = 80.dp, start = 27.dp, end = 35.dp)
                ) {
                    Text(
                        text = "Phone number",
                        fontFamily = FontFamily.Serif,
                        color=MaterialTheme.colorScheme.onBackground,

                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    TextField(
                        value = uiState.phone,
                        visualTransformation = PhoneMaskTransformation("##-###-##-##"),
                        leadingIcon = {
                            androidx.compose.material3.Text(text = "+998", modifier = Modifier.padding(bottom =5.dp ))

                        },
                        onValueChange = {
                            if (it.length <= 9) {
                                events(LoginContract.LoginIntent.PhoneEnter(it))
                            }
                        },

                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = editTextColor,
                            cursorColor = Color.Black,
                            disabledLabelColor = editTextColor,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),

                        modifier = Modifier

                            .height(56.dp)
                            .width(328.dp),
                        shape = RoundedCornerShape(12.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = "Password",
                        color=MaterialTheme.colorScheme.onBackground,
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 8.dp)
                    )

                    Spacer(modifier = Modifier.height(8.dp))
                    var passwordVisibility: Boolean by remember { mutableStateOf(false) }

                    TextField(
                        value = uiState.password,
                        onValueChange = {
                            events(LoginContract.LoginIntent.PasswordEnter(it))
                        },

                        colors =
                        TextFieldDefaults.textFieldColors(
                            backgroundColor = editTextColor,
                            cursorColor = Color.Black,
                            disabledLabelColor = editTextColor,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        modifier = Modifier

                            .height(56.dp)
                            .width(328.dp),
                        shape = RoundedCornerShape(12.dp),
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Create Account", color = Color(0xFF3862F8),
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.clickable {
                            events(LoginContract.LoginIntent.CreateAccount)

                        })
                    Box(
                        Modifier
                            .fillMaxSize()
                            .padding(bottom = 59.dp), contentAlignment = Alignment.BottomCenter
                    ) {

                        Button(
                            onClick = {
                                events(LoginContract.LoginIntent.ClickLogin)
                            },
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Color.White,
                                backgroundColor = buttonColor,
                                disabledBackgroundColor = editTextColor
                            ),
                            shape = RoundedCornerShape(12.dp), modifier = Modifier
                                .fillMaxWidth()
                                .height(48.dp)
                        ) {
                            Text(text = "Login",color=Color.White)
                        }

                    }

                }


            }
            if (uiState.progress) {
                Toast.makeText(LocalContext.current, uiState.errorMessage, Toast.LENGTH_LONG).show()
            }
        }
    }

    @Composable
    @Preview
    fun LoginUiPreview() {
        LoginUi(LoginContract.UiState("+998", "", "",false)) {}
    }
}