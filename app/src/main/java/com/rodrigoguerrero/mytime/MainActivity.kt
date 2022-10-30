package com.rodrigoguerrero.mytime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rodrigoguerrero.mytime.ui.common.TimerTopBar
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme
import com.rodrigoguerrero.mytime.ui.timer.timerNavigation
import dagger.hilt.android.AndroidEntryPoint

@OptIn(ExperimentalMaterial3Api::class)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTimeTheme {
                val navController = rememberNavController()
                Scaffold(
                    containerColor = MyTimeTheme.color.background,
                    topBar = { TimerTopBar() },
                    bottomBar = {},
                ) { padding ->
                    NavHost(
                        navController = navController,
                        startDestination = "timer-screen"
                    ) {
                        composable("alarm-screen") {

                        }
                        composable("clock-screen") {

                        }
                        timerNavigation(navController = navController, padding = padding)
                        composable("stopwatch-screen") {

                        }
                        composable("bedtime-screen") {

                        }
                    }
                }
            }
        }
    }
}
