package com.rodrigoguerrero.mytime.ui.timer.models

data class TimerItemState(
    val id: String,
    val label: String,
    val remainingTimeLabel: String,
    val remainingTime: Int,
    val isPaused: Boolean,
    val totalTime: Int
)
