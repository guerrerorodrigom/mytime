package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.ui.models.TimerUiState
import com.rodrigoguerrero.mytime.ui.models.TotalTime
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@Composable
fun TimerScreen(
    uiState: TimerUiState,
    onNumberClicked: (Int) -> Unit,
    onDeleteClicked: () -> Unit,
    onAddZerosClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TotalTime(
            totalTime = uiState.totalTime,
            modifier = Modifier.padding(vertical = 48.dp)
        )
        NumbersPad(onNumberClicked, onDeleteClicked, onAddZerosClicked)
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewTimerScreen() {
    MyTimeTheme {
        TimerScreen(
            uiState = TimerUiState(totalTime = TotalTime(0, 0, 0)),
            onDeleteClicked = {},
            onAddZerosClicked = {},
            onNumberClicked = {})
    }
}
