package com.rodrigoguerrero.mytime.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier

object MyTimeTheme {
    val typography: MyTimeTypography
        @Composable
        get() = LocalMyTimeTypography.current

    val color: MyTimeColors
        @Composable
        get() = LocalMyTimeColors.current
}

@Composable
fun MyTimeTheme(
    content: @Composable () -> Unit
) {
    val colors = MyTimeColors()
    val typography = MyTimeTypography()

    CompositionLocalProvider(
        LocalMyTimeColors provides colors,
        LocalMyTimeTypography provides typography
    ) {
        content()
    }
}
