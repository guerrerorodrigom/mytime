package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.ui.models.TotalTime
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@Composable
fun TimerScreen(
    totalTime: TotalTime,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TotalTime(totalTime = totalTime, modifier = Modifier.padding(vertical = 48.dp))
        NumbersPad()
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewTimerScreen() {
    MyTimeTheme {
        TimerScreen(totalTime = TotalTime(0, 0, 0))
    }
}
