package com.rodrigoguerrero.mytime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rodrigoguerrero.mytime.ui.theme.MytimeTheme
import com.rodrigoguerrero.mytime.ui.timer.TimerUi

class MainActivity : ComponentActivity() {
    private val viewModel: CountDownViewModel by viewModels()
    private val timer = Timer(30000, 1000)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MytimeTheme {
                val tick by timer.millisUntilFinished.collectAsState()

                LaunchedEffect(key1 = Unit) {
                    timer.start()
                }

                TimerUi(remainingTime = (tick / 1000).toInt(), totalTime = 30)
            }
        }
    }
}
