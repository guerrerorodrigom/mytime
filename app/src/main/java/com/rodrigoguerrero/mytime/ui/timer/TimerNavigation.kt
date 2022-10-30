package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.rodrigoguerrero.mytime.ui.timer.numberpad.NumberPadScreen

fun NavGraphBuilder.timerNavigation(
    navController: NavController,
    padding: PaddingValues
) {
    navigation(
        startDestination = "number-pad-screen", // TODO: depends on if there are timers or not
        route = "timer-screen"
    ) {
        composable(route = "number-pad-screen") {
            NumberPadScreen(
                modifier = Modifier.padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                )
            ) {
                navController.navigate("timer-list-screen")
            }
        }
        composable(route = "timer-list-screen") {
            TimerListScreen(
                modifier = Modifier.padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                )
            )
        }
    }
}
