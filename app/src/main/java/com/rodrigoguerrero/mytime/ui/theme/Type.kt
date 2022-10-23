package com.rodrigoguerrero.mytime.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rodrigoguerrero.mytime.R

private val Rubik = FontFamily(
    Font(resId = R.font.rubik_regular, style = FontStyle.Normal)
)

@Immutable
@Suppress("kotlin:S117")
data class MyTimeTypography(
    val H1: TextStyle = TextStyle(
        fontFamily = Rubik,
        fontSize = 50.sp,
        lineHeight =  28.sp,
        fontWeight = FontWeight.W400
    ),
    val H3: TextStyle = TextStyle(
        fontFamily = Rubik,
        fontSize = 25.sp,
        lineHeight =  28.sp,
        fontWeight = FontWeight.W400
    )
)

val LocalMyTimeTypography = staticCompositionLocalOf { MyTimeTypography() }