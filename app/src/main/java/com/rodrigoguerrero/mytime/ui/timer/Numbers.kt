package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Backspace
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@Composable
fun NumbersPad(
    onNumberClicked: (Int) -> Unit,
    onDeleteClicked: () -> Unit,
    onAddZerosClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = modifier
    ) {
        NumberRow(1, 3, onNumberClicked = onNumberClicked)
        NumberRow(4, 6, onNumberClicked = onNumberClicked)
        NumberRow(7, 9, onNumberClicked = onNumberClicked)
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            TextButton(text = "00", onClicked = onAddZerosClicked)
            NumberButton(number = 0, onNumberClicked = onNumberClicked)
            IconAnimatedButton(
                icon = Icons.Filled.Backspace,
                tint = Color.White,
                contentDescription = "",
                onClicked = onDeleteClicked
            )
        }
    }
}

@Composable
private fun NumberRow(
    start: Int,
    end: Int,
    onNumberClicked: (Int) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(24.dp),
    ) {
        for (i in start..end) {
            NumberButton(number = i, onNumberClicked = onNumberClicked)
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewNumbers() {
    MyTimeTheme {
        NumbersPad(onNumberClicked = {}, onAddZerosClicked = {}, onDeleteClicked = {})
    }
}