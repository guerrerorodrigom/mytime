package com.rodrigoguerrero.mytime.ui.timer.models

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update

data class NumberPadUiState(
    val isCtaVisible: Boolean = false,
    val hasSeconds: Boolean = false,
    val hasMinutes: Boolean = false,
    val hasHours: Boolean = false,
    val totalTime: TotalTime = TotalTime(0, 0, 0)
) {
    val totalTimeInSeconds: Int
        get() {
            with(totalTime) {
                return displaySeconds.toInt() + displayMinutes.toInt() * 60 + displayHours.toInt() * 3600
            }
        }
}

fun MutableStateFlow<NumberPadUiState>.updateTotalTime(totalTime: TotalTime, size: Int) {
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
