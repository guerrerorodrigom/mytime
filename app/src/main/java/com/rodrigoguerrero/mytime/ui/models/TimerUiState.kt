package com.rodrigoguerrero.mytime.ui.models

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

data class TimerUiState(
    val totalTime: TotalTime
)

fun MutableStateFlow<TimerUiState>.updateTotalTime(totalTime: TotalTime) {
    update { it.copy(totalTime = totalTime) }
}
