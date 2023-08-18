package com.example.testchangetheme.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

enum class CustomTheme {
    THEME_ONE, THEME_TWO, THEME_THREE,
}

val Color0xFFD0BCFF = Color(0xFFD0BCFF)
val Color0xFF3B8A2A = Color(0xFF3B8A2A)
val Color0xFF240C5E = Color(0xFF240C5E)
val Color0xFF941616 = Color(0xFF941616)
val Color0xFFCAA41E = Color(0xFFCAA41E)
val Color0xFF1FC9C9 = Color(0xFF1FC9C9)

@Stable
class CustomColor(
    backgroundColor: Color,
    buttonColor: Color,
    buttonTextColor: Color,
    textColor: Color
) {
    var backgroundColor by mutableStateOf(backgroundColor)
        private set

    var buttonColor by mutableStateOf(buttonColor)
        private set

    var buttonTextColor by mutableStateOf(buttonTextColor)
        private set

    var textColor by mutableStateOf(textColor)
        private set

    fun updateColor(color: CustomColor) {
        this.backgroundColor = color.backgroundColor
        this.buttonColor = color.buttonColor
        this.buttonTextColor = color.buttonTextColor
        this.textColor = color.textColor
    }

    fun copy() = CustomColor(backgroundColor, buttonColor, buttonTextColor, textColor)
}