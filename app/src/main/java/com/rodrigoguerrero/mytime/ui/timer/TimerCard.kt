package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.ui.timer.models.TimerItemState
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@Composable
fun TimerCard(
    timerItemState: TimerItemState,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(32.dp),
        colors = CardDefaults.cardColors(
            containerColor = MyTimeTheme.color.primary.copy(alpha = 0.15f),
            contentColor = MyTimeTheme.color.onBackground
        )
    ) {
        Column(
            modifier = Modifier.padding(all = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            TimerCardHeader(timerItemState.label)
            Row(modifier = Modifier.fillMaxWidth()) {
                CircularTimer(
                    remainingTime = timerItemState.remainingTime,
                    totalTime = timerItemState.totalTime,
                    size = 196.dp,
                    modifier = Modifier.padding(all = 16.dp)
                )
                TimerButtons(
                    isPaused = timerItemState.isPaused,
                    onPlayPauseClicked = {},
                    onPlusOneClicked = {})
            }
        }
    }
}

@Composable
private fun TimerButtons(
    isPaused: Boolean,
    onPlusOneClicked: () -> Unit,
    onPlayPauseClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(vertical = 16.dp)
            .fillMaxWidth()
            .height(196.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.End
    ) {
        PlusOneButton(onClicked = onPlusOneClicked)

        PlayPauseButton(isPaused = isPaused, onClicked = onPlayPauseClicked)
    }
}

@Composable
private fun PlayPauseButton(
    isPaused: Boolean,
    onClicked: () -> Unit
) {
    Button(
        onClick = onClicked,
        shape = RoundedCornerShape(32.dp),
        modifier = Modifier
            .padding(top = 8.dp)
            .width(128.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MyTimeTheme.color.secondary.copy(alpha = 0.5f),
            contentColor = MyTimeTheme.color.onSecondary
        )
    ) {
        Icon(
            imageVector = if (isPaused) Icons.Filled.PlayArrow else Icons.Filled.Pause,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp),
            contentDescription = ""
        )
    }
}

@Composable
private fun PlusOneButton(
    onClicked: () -> Unit
) {
    Button(
        onClick = onClicked,
        shape = RoundedCornerShape(32.dp),
        modifier = Modifier.width(128.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = MyTimeTheme.color.primary.copy(
                alpha = 0.5f
            )
        )
    ) {
        Text(
            text = "+1:00",
            style = MyTimeTheme.typography.H4,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 16.dp)
        )
    }
}

@Composable
private fun TimerCardHeader(label: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MyTimeTheme.typography.H4,
            modifier = Modifier.weight(1f)
        )
        Surface(
            shape = CircleShape,
            color = MyTimeTheme.color.primary.copy(alpha = 0.5f),
        ) {
            Icon(
                imageVector = Icons.Filled.Close,
                contentDescription = "",
                modifier = Modifier
                    .padding(all = 4.dp)
                    .size(16.dp)
            )
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewTimerCard() {
    MyTimeTheme {
        val timerItemState = TimerItemState(
            label = "5m timer",
            remainingTime = 25,
            totalTime = 60,
            isPaused = true,
            remainingTimeLabel = "5:00"
        )
        TimerCard(timerItemState = timerItemState)
    }
}