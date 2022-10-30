package com.rodrigoguerrero.mytime.ui.timer.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.rodrigoguerrero.mytime.ui.timer.NavigateWhenResumed
import com.rodrigoguerrero.mytime.ui.timer.TimerListScreen
import com.rodrigoguerrero.mytime.ui.timer.numberpad.NumberPadScreen
import com.rodrigoguerrero.mytime.ui.timer.removeBackStackEntry

fun NavGraphBuilder.timerListDestination(
    navController: NavController,
    padding: PaddingValues
) {
    composable(
        route = TimerDestinations.TimerListDestination().route,
        arguments = listOf(navArgument(TimerArguments.TimeArg.name) {
            defaultValue = 0
            type = NavType.IntType
        })
    ) { backStackEntry ->
        backStackEntry.NavigateWhenResumed {
            val firstTimerTime = backStackEntry.arguments?.getInt(TimerArguments.TimeArg.name)
            TimerListScreen(
                screenName = TimerDestinations.TimerListDestination().screenName,
                firstTimerTimeInSeconds = firstTimerTime,
                modifier = Modifier.padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                ),
                navigateToNumberPadScreen = {
                    navController.navigate(route = TimerDestinations.NumberPadDestination.destination) {
                        removeBackStackEntry(backStackEntry)
                    }
                }
            )
        }
    }
}
