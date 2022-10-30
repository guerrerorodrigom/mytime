@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)

package com.rodrigoguerrero.mytime.ui.timer

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TimerListScreen(
    firstTimerTimeInSeconds: Int?,
    navigateToNumberPadScreen: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TimerListViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.start(firstTimerTimeInSeconds)
    }

    val uiState by viewModel.uiState.collectAsState()
    if (uiState.isEmpty) {
        navigateToNumberPadScreen()
    }
    Scaffold(
        floatingActionButton = {},
        floatingActionButtonPosition = FabPosition.Center,
        containerColor = MyTimeTheme.color.background
    ) {
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .scrollable(state = rememberScrollState(), orientation = Orientation.Vertical),
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(uiState.timers) { timerItemState ->
                TimerCard(timerItemState = timerItemState) { timerId ->
                    viewModel.removeTimer(timerId)
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewTimerScreen() {
    MyTimeTheme {
        TimerListScreen(firstTimerTimeInSeconds = 0, navigateToNumberPadScreen = {})
    }
}
