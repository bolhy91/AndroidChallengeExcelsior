package com.bolhy91.androidchallengeexcelsior.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Purple80,
    primaryVariant = PurpleGrey80,
    secondary = PurpleGrey80,
    background = PurpleGrey80,
    )

private val LightColorPalette = lightColors(
    primary = Purple80,
    primaryVariant = PurpleGrey80,
    secondary = PurpleGrey80,
    background = PurpleGrey80,
)

@Composable
fun AndroidChallengeExcelsiorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}