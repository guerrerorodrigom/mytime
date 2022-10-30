package com.rodrigoguerrero.mytime.ui.timer.navigation

import androidx.annotation.StringRes
import com.rodrigoguerrero.mytime.R

sealed class TimerDestinations(
    @StringRes val screenName: Int,
    val route: String,
    val destination: String
) {
    data class TimerListDestination(private val firstTime: Int = 0) : TimerDestinations(
        screenName = R.string.timer_screen,
        route = "timer_list_screen/firstTime={time}",
        destination = "timer_list_screen/firstTime=$firstTime"
    )

    object NumberPadDestination : TimerDestinations(
        screenName = R.string.timer_screen,
        route = "number_pad_screen",
        destination = "number_pad_screen"
    )
}

sealed class TimerArguments(val name: String) {
    object TimeArg : TimerArguments("time")
}
