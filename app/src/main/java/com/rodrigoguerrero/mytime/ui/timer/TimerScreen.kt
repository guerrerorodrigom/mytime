@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)

package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.ui.models.TimerScreen
import com.rodrigoguerrero.mytime.ui.models.TimerUiState
import com.rodrigoguerrero.mytime.ui.models.TotalTime
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@Composable
fun TimerScreen(
    uiState: TimerUiState,
    onNumberClicked: (Int) -> Unit,
    onDeleteClicked: () -> Unit,
    onAddZerosClicked: () -> Unit,
    onStartCountDown: () -> Unit,
    onStart: () -> Unit,
    modifier: Modifier = Modifier,
    screen: TimerScreen,
    millisUntilFinished: Int
) {
    Scaffold(
        containerColor = MyTimeTheme.color.background,
        topBar = { TimerTopBar() },
        bottomBar = {},
        floatingActionButton = { ScreenFab(isVisible = uiState.isCtaVisible, onStartCountDown) },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding()),
        ) {
            Column(
                modifier = modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                NumberPadScreen(
                    modifier = Modifier.padding(bottom = 16.dp),
                    uiState = uiState,
                    onNumberClicked = onNumberClicked,
                    onDeleteClicked = onDeleteClicked,
                    onAddZerosClicked = onAddZerosClicked,
                    isVisible = screen == TimerScreen.NUMBER_PAD
                )

                AnimatedVisibility(
                    visible = screen == TimerScreen.TIMER,
                    enter = slideInVertically() + fadeIn(),
                    exit = slideOutVertically()
                ) {
                    LaunchedEffect(key1 = Unit) {
//                    onStart()
                    }

                    TimerUi(
                        modifier = Modifier.padding(bottom = 16.dp),
                        remainingTime = (millisUntilFinished / 1000),
                        totalTime = 30
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
private fun PreviewTimerScreen() {
    MyTimeTheme {
        TimerScreen(
            uiState = TimerUiState(totalTime = TotalTime(0, 0, 0), false),
            onNumberClicked = {},
            onDeleteClicked = {},
            onAddZerosClicked = {},
            onStartCountDown = {},
            screen = TimerScreen.NUMBER_PAD,
            millisUntilFinished = 0,
            onStart = {}
        )
    }
}
