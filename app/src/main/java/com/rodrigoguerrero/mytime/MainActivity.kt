package com.rodrigoguerrero.mytime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.rodrigoguerrero.mytime.ui.models.TotalTime
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme
import com.rodrigoguerrero.mytime.ui.timer.TimerScreen

class MainActivity : ComponentActivity() {
    private val viewModel: CountDownViewModel by viewModels()
    private val timer = Timer(30000, 1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTimeTheme {
//                val tick by timer.millisUntilFinished.collectAsState()
//
//                LaunchedEffect(key1 = Unit) {
//                    timer.start()
//                }
//
//                TimerUi(remainingTime = (tick / 1000).toInt(), totalTime = 30)
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MyTimeTheme.color.background)
                ) {
                    TimerScreen(totalTime = TotalTime(0, 0, 0))
                }
            }
        }
    }
}
