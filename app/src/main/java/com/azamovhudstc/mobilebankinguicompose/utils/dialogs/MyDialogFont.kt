package com.azamovhudstc.mobilebankinguicompose.utils.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.azamovhudstc.mobilebankinguicompose.ui.theme.Type

@Composable
fun MyDialogFont(setShowDialog: (Boolean) -> Unit) {


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
                            text = "Choose  Size",
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
                            Type.typeModeIndex.value=0
                            TypeLocal.typeFont=0
                            setShowDialog(false)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colorScheme.primary),

                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Font Small",color= MaterialTheme.colorScheme.onBackground)
                    }

                    Spacer(modifier = Modifier.height(20.dp))



                    Button(
                        onClick = {
                            Type.typeModeIndex.value=1
                            TypeLocal.typeFont=1
                            setShowDialog(false)
                        },
                        shape = RoundedCornerShape(50.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor =MaterialTheme.colorScheme.primary),

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Font Normal",color= MaterialTheme.colorScheme.onBackground)
                    }

                    Spacer(modifier = Modifier.height(20.dp))



                    Button(
                        onClick = {


                            Type.typeModeIndex.value=2
                            TypeLocal.typeFont=2
                            setShowDialog(false)
                        },
                        colors = ButtonDefaults.buttonColors(backgroundColor =MaterialTheme.colorScheme.primary),
                        shape = RoundedCornerShape(50.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                    ) {
                        Text(text = "Font Large",color= MaterialTheme.colorScheme.onBackground)
                    }

                    Spacer(modifier = Modifier.height(20.dp))


                }
            }
        }
    }
}