@file:OptIn(ExperimentalFoundationApi::class)

package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NumbersPad(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp)
    ) {
        NumberRow(1, 3)
        NumberRow(4, 6)
        NumberRow(7, 9)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp),
        ) {
            NumberButton(number = "00")
            NumberButton(number = "0")
            IconAnimatedButton(
                icon = Icons.Filled.Backspace,
                tint = Color.White,
                contentDescription = ""
            )
        }
    }
}

@Composable
private fun NumberRow(start: Int, end: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        for (i in start..end) {
            NumberButton(number = i.toString())
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewNumbers() {
    MaterialTheme {
        NumbersPad()
    }
}