package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.ui.models.TimerUiState

@Composable
fun NumberPadScreen(
    modifier: Modifier,
    isVisible: Boolean,
    uiState: TimerUiState,
    onNumberClicked: (Int) -> Unit,
    onDeleteClicked: () -> Unit,
    onAddZerosClicked: () -> Unit
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(),
        exit = slideOutVertically() + fadeOut()
    ) {
        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TotalTime(
                totalTime = uiState.totalTime,
                hasSeconds = uiState.hasSeconds,
                hasMinutes = uiState.hasMinutes,
                hasHours = uiState.hasHours,
                modifier = Modifier.padding(vertical = 32.dp)
            )
            NumbersPad(onNumberClicked, onDeleteClicked, onAddZerosClicked)
        }
    }
}
