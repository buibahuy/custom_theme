package com.example.testchangetheme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.testchangetheme.ui.theme.CustomTheme
import com.example.testchangetheme.ui.theme.CustomThemeApp
import com.example.testchangetheme.ui.theme.CustomThemeMgr

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomThemeApp {
                Greeting()
            }
        }
    }
}

@Composable
fun Greeting() {
    Surface(color = CustomThemeMgr.colors.backgroundColor) {
        Box(modifier = Modifier.fillMaxSize()) {
            Button(
                onClick = {
                    CustomThemeMgr.customTheme = when (CustomThemeMgr.customTheme){
                        CustomTheme.THEME_ONE -> CustomTheme.THEME_TWO
                        CustomTheme.THEME_TWO -> CustomTheme.THEME_THREE
                        CustomTheme.THEME_THREE -> CustomTheme.THEME_ONE
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = CustomThemeMgr.colors.buttonColor,
                    contentColor = CustomThemeMgr.colors.buttonTextColor
                )
            ) {

            }
        }
    }
}