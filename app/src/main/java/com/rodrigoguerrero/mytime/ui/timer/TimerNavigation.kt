package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.rodrigoguerrero.mytime.ui.timer.navigation.TimerArguments.TimeArg
import com.rodrigoguerrero.mytime.ui.timer.navigation.TimerDestinations.NumberPadDestination
import com.rodrigoguerrero.mytime.ui.timer.navigation.TimerDestinations.TimerListDestination
import com.rodrigoguerrero.mytime.ui.timer.navigation.numberPadDestination
import com.rodrigoguerrero.mytime.ui.timer.navigation.timerListDestination
import com.rodrigoguerrero.mytime.ui.timer.numberpad.NumberPadScreen

fun NavGraphBuilder.timerNavigation(
    navController: NavController,
    padding: PaddingValues
) {
    navigation(
        startDestination = NumberPadDestination.destination, // TODO: depends on if there are timers or not
        route = "timer_screen"
    ) {
        numberPadDestination(navController, padding)
        timerListDestination(navController, padding)
    }
}

fun NavOptionsBuilder.removeBackStackEntry(backStackEntry: NavBackStackEntry) {
    popUpTo(backStackEntry.destination.route.orEmpty()) {
        inclusive = true
    }
}

@Composable
fun NavBackStackEntry.NavigateWhenResumed(navigate: @Composable () -> Unit) {
    if (lifecycle.currentState == Lifecycle.State.RESUMED) {
        navigate()
    }
}
