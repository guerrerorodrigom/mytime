@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)

package com.rodrigoguerrero.mytime.ui.timer

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TimerListScreen(
    modifier: Modifier = Modifier,
    viewModel: TimerListViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        floatingActionButton = {},
        floatingActionButtonPosition = FabPosition.Center
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical)
        ) {
            items(uiState.timers) { timerItemState ->
                TimerCard(timerItemState = timerItemState)
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewTimerScreen() {
    MyTimeTheme {
        TimerListScreen()
    }
}
