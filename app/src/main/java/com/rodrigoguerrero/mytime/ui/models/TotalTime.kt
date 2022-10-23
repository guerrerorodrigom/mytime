package com.rodrigoguerrero.mytime.ui.models

data class TotalTime(
    private val seconds: Int,
    private val minutes: Int,
    private val hours: Int
) {
    val displaySeconds: String
        get() = formatTime(seconds)

    val displayMinutes: String
        get() = formatTime(minutes)

    val displayHours: String
        get() = formatTime(hours)

    private fun formatTime(time: Int): String {
        return when {
            time in 0..9 -> "0$time"
            time < 0 -> "00"
            time > 99 -> "99"
            else -> time.toString()
        }
    }
}
