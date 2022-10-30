package com.rodrigoguerrero.mytime.ui.timer.models

data class TimerUiState(
    val timers: List<TimerItemState> = listOf(),
    val isEmpty: Boolean = false
)
