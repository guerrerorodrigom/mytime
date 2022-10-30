package com.rodrigoguerrero.mytime.ui.timer.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.rodrigoguerrero.mytime.ui.timer.NavigateWhenResumed
import com.rodrigoguerrero.mytime.ui.timer.numberpad.NumberPadScreen
import com.rodrigoguerrero.mytime.ui.timer.removeBackStackEntry

fun NavGraphBuilder.numberPadDestination(
    navController: NavController,
    padding: PaddingValues
) {
    composable(route = TimerDestinations.NumberPadDestination.route) { backStackEntry ->
        backStackEntry.NavigateWhenResumed {
            NumberPadScreen(
                modifier = Modifier.padding(
                    top = padding.calculateTopPadding(),
                    bottom = padding.calculateBottomPadding()
                )
            ) { time ->
                navController.navigate(route = TimerDestinations.TimerListDestination(time).destination) {
                    removeBackStackEntry(backStackEntry)
                }
            }
        }
    }
}