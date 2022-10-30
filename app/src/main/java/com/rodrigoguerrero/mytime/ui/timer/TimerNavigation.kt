package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.rodrigoguerrero.mytime.ui.timer.numberpad.NumberPadScreen

fun NavGraphBuilder.timerNavigation(
    navController: NavController,
    padding: PaddingValues
) {
    navigation(
        startDestination = "number_pad_screen", // TODO: depends on if there are timers or not
        route = "timer_screen"
    ) {
        composable(route = "number_pad_screen") {
            NumberPadScreen(
                modifier = Modifier.padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                )
            ) { time ->
                navController.navigate(route = "timer_list_screen/firstTime=$time") {
                    popUpTo("number_pad_screen") {
                        inclusive = true
                    }
                }
            }
        }
        composable(
            route = "timer_list_screen/firstTime={time}",
            arguments = listOf(navArgument("time") {
                defaultValue = 0
                type = NavType.IntType
            })
        ) { backStackEntry ->
            if (backStackEntry.lifecycle.currentState == Lifecycle.State.RESUMED) {
                val firstTimerTime = backStackEntry.arguments?.getInt("time")
                TimerListScreen(
                    firstTimerTimeInSeconds = firstTimerTime,
                    modifier = Modifier.padding(
                        top = padding.calculateTopPadding(),
                        bottom = padding.calculateBottomPadding()
                    ),
                    navigateToNumberPadScreen = {
                        navController.navigate("number_pad_screen") {
                            popUpTo(backStackEntry.destination.route.orEmpty()) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
    }
}
