package com.azamovhudstc.mobilebankinguicompose.screen.register

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.androidx.AndroidScreen
import cafe.adriel.voyager.hilt.getScreenModel
import com.azamovhudstc.mobilebankinguicompose.screen.login.viewmodel.LoginContract
import com.azamovhudstc.mobilebankinguicompose.screen.login.viewmodel.LoginViewModelImpl
import com.azamovhudstc.mobilebankinguicompose.screen.register.viewmodel.RegisterContract
import com.azamovhudstc.mobilebankinguicompose.screen.register.viewmodel.impl.RegisterViewModelImpl
import com.azamovhudstc.mobilebankinguicompose.ui.theme.MobileBankingUiComposeTheme
import com.azamovhudstc.mobilebankinguicompose.ui.theme.editTextColor
import com.azamovhudstc.mobilebankinguicompose.utils.PhoneMaskTransformation

class RegisterScreen : AndroidScreen() {
    @Composable
    override fun Content() {

        var viewModel = getScreenModel<RegisterViewModelImpl>()
        val uiState = viewModel.uiState.collectAsState().value
        RegisterScreenContent(uiState, viewModel::onEventDispatcher)

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreenContent(
    uiState: RegisterContract.UiState,
    events: (RegisterContract.RegisterIntent) -> Unit

) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Sign up",
            style = MaterialTheme.typography.headlineMedium
,
                    fontFamily = FontFamily.Serif,
            modifier = Modifier.clickable {

            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White)
                .padding(top = 20.dp, start = 27.dp, end = 35.dp)
        ) {
            Text(
                text = "First name",
                fontFamily = FontFamily.Serif,
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            TextField(
                value = uiState.firstName,
                onValueChange = {
                    events(RegisterContract.RegisterIntent.FirstNameEnter(it.trim().toString()))
                },

                colors =
                TextFieldDefaults.textFieldColors(
                    containerColor = editTextColor,
                    cursorColor = Color.Black,
                    disabledLabelColor = editTextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier

                    .height(56.dp)
                    .width(328.dp),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Last name",
                fontFamily = FontFamily.Serif,
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = uiState.lastName,
                onValueChange = {
                    events(RegisterContract.RegisterIntent.LastNameEnter(it))
                },

                colors =
                TextFieldDefaults.textFieldColors(
                    containerColor = editTextColor,
                    cursorColor = Color.Black,
                    disabledLabelColor = editTextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                modifier = Modifier

                    .height(56.dp)
                    .width(328.dp),
                shape = RoundedCornerShape(12.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))


            Text(
                text = "Date of Birth",
                fontFamily = FontFamily.Serif,
                style = MaterialTheme.typography.labelMedium,
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(start = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = uiState.bornDate,
                onValueChange = {
                    if (it.length <= 8) {
                        events(RegisterContract.RegisterIntent.BornDate(it))

                    }
                },
                visualTransformation = PhoneMaskTransformation("##/##/####"),

                colors =
                TextFieldDefaults.textFieldColors(
                    containerColor = editTextColor,
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
                text = "Phone number",
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(start = 8.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = uiState.phone,
                onValueChange = {
                    if (it.length <= 9) {
                        events(RegisterContract.RegisterIntent.PhoneEnter(it))
                    }
                },
                leadingIcon = {
                    Text(text = "+998")
                },
                visualTransformation = PhoneMaskTransformation("##-###-##-##"),

                colors = TextFieldDefaults.textFieldColors(
                    containerColor = editTextColor,
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
                fontFamily = FontFamily.Serif,
                textAlign = TextAlign.Start,
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier.padding(start = 8.dp)
            )


            Spacer(modifier = Modifier.height(8.dp))

            TextField(
                value = uiState.password,
                onValueChange = {
                    events(RegisterContract.RegisterIntent.PasswordEnter(it))
                },

                colors =
                TextFieldDefaults.textFieldColors(
                    containerColor = editTextColor,
                    cursorColor = Color.Black,
                    disabledLabelColor = editTextColor,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier

                    .height(56.dp)
                    .width(328.dp),
                shape = RoundedCornerShape(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column {
                Text(
                    text = "Gender",
                    fontFamily = FontFamily.Serif,
                    style = MaterialTheme.typography.labelMedium,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 8.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))
                Row(Modifier.selectableGroup(), verticalAlignment = Alignment.CenterVertically)
                {
                    RadioButton(
                        selected = uiState.gender,
                        onClick = { events(RegisterContract.RegisterIntent.GenderEnter(true)) }
                    )
                    Text(
                        text = "male",
                        fontFamily = FontFamily.Serif,
                        textAlign = TextAlign.Start,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 2.dp, end = 10.dp)
                    )
                    RadioButton(
                        selected = !uiState.gender,
                        onClick = { events(RegisterContract.RegisterIntent.GenderEnter(false)) }
                    )
                    Text(
                        text = "female",
                        fontFamily = FontFamily.Serif,
                        style = MaterialTheme.typography.labelMedium,
                        textAlign = TextAlign.Start,
                        modifier = Modifier.padding(start = 2.dp)
                    )
                }
            }


            Spacer(modifier = Modifier.height(16.dp))


            Box(
                Modifier
                    .fillMaxSize()
                    .padding(bottom = 50.dp), contentAlignment = Alignment.BottomCenter
            ) {

                Button(
                    onClick = {
                        events(RegisterContract.RegisterIntent.ClickRegister)
                    },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White,
                        containerColor = Color(0xFF3862F8), disabledContainerColor = editTextColor
                    ),
                    shape = RoundedCornerShape(12.dp), modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    Text(text = "Register")
                }

            }
        }
        if (uiState.progress) {
            Toast.makeText(LocalContext.current, uiState.errorMessage, Toast.LENGTH_LONG).show()

        }


    }
}


@Preview(showBackground = true)
@Composable
fun LoginDefaultPreview() {
    MobileBankingUiComposeTheme() {
        RegisterScreenContent(RegisterContract.UiState()) {

        }
    }
}