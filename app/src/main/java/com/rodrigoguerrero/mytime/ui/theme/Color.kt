package com.rodrigoguerrero.mytime.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class MyTimeColors(
    val background: Color = Color(0x00000000),
    val surface: Color = Color(0xFF202429),

    val onSurface: Color = Color(0xFFFFFFFF),
    val onBackground: Color = Color(0xBFFFFFFF)
)

val LocalMyTimeColors = staticCompositionLocalOf { MyTimeColors() }
