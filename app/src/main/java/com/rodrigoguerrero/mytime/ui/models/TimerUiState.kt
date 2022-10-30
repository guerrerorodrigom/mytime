package com.rodrigoguerrero.mytime.ui.models

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

data class TimerUiState(
    val totalTime: TotalTime = TotalTime(0, 0, 0),
    val isCtaVisible: Boolean = false,
    val hasSeconds: Boolean = false,
    val hasMinutes: Boolean = false,
    val hasHours: Boolean = false,
    val timerScreen: TimerScreen = TimerScreen.NUMBER_PAD
)

enum class TimerScreen {
    NUMBER_PAD, TIMER
}

fun MutableStateFlow<TimerUiState>.updateTotalTime(totalTime: TotalTime, size: Int) {
    update {
        it.copy(
            totalTime = totalTime,
            isCtaVisible = size > 0,
            hasSeconds = size > 0,
            hasMinutes = size > 2,
            hasHours = size > 4
        )
    }
}

fun MutableStateFlow<TimerUiState>.updateScreen(screen: TimerScreen) {
    update { it.copy(timerScreen = screen) }
}
