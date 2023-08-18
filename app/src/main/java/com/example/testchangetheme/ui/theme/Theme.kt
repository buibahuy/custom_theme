package com.example.testchangetheme.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val CustomColor1 = CustomColor(
    backgroundColor = Color0xFF1FC9C9,
    buttonColor = Color0xFF240C5E,
    buttonTextColor = Color0xFF941616,
    textColor = Color0xFF1FC9C9
)

private val CustomColor2 = CustomColor(
    backgroundColor = Color0xFFD0BCFF,
    buttonColor = Color0xFF1FC9C9,
    buttonTextColor = Color0xFF941616,
    textColor = Color0xFF3B8A2A
)

private val CustomColor3 = CustomColor(
    backgroundColor = Color0xFF941616,
    buttonColor = Color0xFF3B8A2A,
    buttonTextColor = Color0xFF1FC9C9,
    textColor = Color0xFFD0BCFF
)

private val LocalColorsProvider = staticCompositionLocalOf {
    CustomColor1
}

@Composable
fun CustomLocalProvider(
    color: CustomColor,
    content: @Composable () -> Unit
) {
    val colorPlate = remember {
        color.copy()
    }
    colorPlate.updateColor(color = color)
    CompositionLocalProvider(LocalColorsProvider provides colorPlate, content = content)
}

private val CustomTheme.color : Pair<ColorScheme,CustomColor>
    get() = when(this) {
        CustomTheme.THEME_ONE -> lightColorScheme() to CustomColor1
        CustomTheme.THEME_TWO -> lightColorScheme().copy(primary = Color0xFF3B8A2A) to CustomColor2
        CustomTheme.THEME_THREE -> lightColorScheme().copy(primary = Color0xFF240C5E) to CustomColor3
    }

object CustomThemeMgr {
    val colors : CustomColor
        @Composable
        get() = LocalColorsProvider.current

    var customTheme by mutableStateOf(CustomTheme.THEME_ONE)
}

@Composable
fun CustomThemeApp(
    customTheme: CustomTheme = CustomThemeMgr.customTheme,
    content: @Composable () -> Unit
) {
    val (colorPlate,lcColor) = customTheme.color

    CustomLocalProvider(color = lcColor) {
        MaterialTheme(
            colorScheme = colorPlate,
            typography = Typography,
            content = content
        )
    }
}