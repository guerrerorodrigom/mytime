@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)

package com.rodrigoguerrero.mytime.ui.timer

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rodrigoguerrero.mytime.ui.models.TimerUiState
import com.rodrigoguerrero.mytime.ui.models.TotalTime
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme

@Composable
fun TimerScreen(
    uiState: TimerUiState,
    onNumberClicked: (Int) -> Unit,
    onDeleteClicked: () -> Unit,
    onAddZerosClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        containerColor = MyTimeTheme.color.background,
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp, horizontal = 32.dp)
            ) {
                Text(
                    text = "Timer",
                    style = MyTimeTheme.typography.H4.copy(color = MyTimeTheme.color.onBackground)
                )
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "",
                    tint = MyTimeTheme.color.onBackground
                )
            }
        },
        bottomBar = {}
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = it.calculateTopPadding(), bottom = it.calculateBottomPadding()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TotalTime(
                totalTime = uiState.totalTime,
                hasSeconds = uiState.hasSeconds,
                hasMinutes = uiState.hasMinutes,
                hasHours = uiState.hasHours,
                modifier = Modifier.padding(vertical = 48.dp)
            )
            NumbersPad(onNumberClicked, onDeleteClicked, onAddZerosClicked)

            Row(modifier = Modifier
                .padding(top = 16.dp)
                .height(90.dp)
            ) {
                AnimatedVisibility(
                    visible = uiState.isCtaVisible,
                    enter = scaleIn(),
                    exit = scaleOut()
                ) {

                    FloatingActionButton(
                        onClick = { /*TODO*/ },
                        modifier = Modifier.size(90.dp),
                        containerColor = MyTimeTheme.color.primary,
                        contentColor = MyTimeTheme.color.background,
                        shape = CircleShape
                    ) {
                        Icon(
                            imageVector = Icons.Filled.PlayArrow,
                            contentDescription = "",
                            tint = MyTimeTheme.color.background
                        )
                    }
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
            onDeleteClicked = {},
            onAddZerosClicked = {},
            onNumberClicked = {})
    }
}
