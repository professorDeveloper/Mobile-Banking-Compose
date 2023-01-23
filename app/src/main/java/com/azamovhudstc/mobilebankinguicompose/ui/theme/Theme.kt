package com.azamovhudstc.mobilebankinguicompose.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.ViewCompat
import com.azamovhudstc.mobilebankinguicompose.data.local.TypeLocal


private val DarkColorScheme = darkColorScheme(
    primary = Purple80,//qizil
    secondary = PurpleGrey80,
    onPrimary=text1Color,
    surface= surface1Color,// un
    tertiary = Pink80,
    onBackground= Color.White,
    onSurface= onSurface1Color,//Text Uchun
    background = Purple80//Asosiy Background
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,//yashil
    secondary = PurpleGrey40,
    tertiary = Pink40,
    surface= surface2Color,//oq

    onSurface= onSurface2Color,
    background = Purple40,
    onBackground= Color.Black,
)

private val ThreeColorScheme = lightColorScheme(
    primary = Purple20,
    secondary = PurpleGrey40,
    onBackground= Color.White,
    tertiary = Pink40,
    onSurface= onSurface3Color,
    surface= surface3Color,
    background = Purple20

    /* Other default colors to override
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)
object Theme {
    val isDarkMode = mutableStateOf(TypeLocal.themeIndex)

}

object Type {
    val typeModeIndex = mutableStateOf(TypeLocal.typeFont)
    val typeArray= arrayOf(SmallTypography, NormalTypography, LargeTypography)
}


@Composable
fun MobileBankingUiComposeTheme(
    darkTheme: Int = Theme.isDarkMode.value,
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when(darkTheme) {

        0 -> LightColorScheme
        1 -> DarkColorScheme
        else -> ThreeColorScheme
    }
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            (view.context as Activity).window.statusBarColor = colorScheme.primary.toArgb()
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Type.typeArray[Type.typeModeIndex.value],
        content = content
    )

}