package com.azamovhudstc.mobilebankinguicompose.utils.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.azamovhudstc.mobilebankinguicompose.data.local.TypeLocal
import com.azamovhudstc.mobilebankinguicompose.ui.theme.Theme
import com.azamovhudstc.mobilebankinguicompose.ui.theme.text1Color
import com.azamovhudstc.mobilebankinguicompose.ui.theme.text2Color
import com.azamovhudstc.mobilebankinguicompose.ui.theme.text3Color

@Composable
fun MyDialog(setShowDialog: (Boolean) -> Unit) {


    Dialog(onDismissRequest = { setShowDialog(true) }) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Choose Theme",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontFamily = FontFamily.Default,
                                fontWeight = FontWeight.Bold
                            )

                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))



                    Button(
                        onClick = {
                            Theme.isDarkMode.value = 0
                            setShowDialog(false)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF5E9E9)),

                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Light Theme",color= Color.Black)
                    }

                    Spacer(modifier = Modifier.height(20.dp))



                    Button(
                        onClick = {
                            Theme.isDarkMode.value = 1
                            TypeLocal.themeIndex=1
                            setShowDialog(false)
                        },
                        shape = RoundedCornerShape(50.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF484948)),

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Dark Theme",color= Color.White)
                    }

                    Spacer(modifier = Modifier.height(20.dp))



                    Button(
                        onClick = {

                            Theme.isDarkMode.value = 2
                            TypeLocal.themeIndex=2
                            setShowDialog(false)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF838692)),
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Theme Blue",color= Color.White)
                    }

                    Spacer(modifier = Modifier.height(20.dp))


                }
            }
        }
    }
}