package com.rodrigoguerrero.mytime.ui.timer.numberpad

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.rodrigoguerrero.mytime.ui.theme.MyTimeTheme
import com.rodrigoguerrero.mytime.ui.timer.TimerFab

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NumberPadScreen(
    modifier: Modifier = Modifier,
    viewModel: NumberPadViewModel = hiltViewModel(),
    onStartTimerClicked: (Int) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        containerColor = MyTimeTheme.color.background,
        floatingActionButton = {
            TimerFab(
                isVisible = uiState.isCtaVisible,
                onClicked =  {
                    onStartTimerClicked(uiState.totalTimeInSeconds)
                }
            )
        },
        floatingActionButtonPosition = FabPosition.Center
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TotalTime(
                totalTime = uiState.totalTime,
                hasSeconds = uiState.hasSeconds,
                hasMinutes = uiState.hasMinutes,
                hasHours = uiState.hasHours,
                modifier = Modifier.padding(vertical = 32.dp)
            )
            NumbersPad(
                onNumberClicked = viewModel::onNumberClicked,
                onDeleteClicked = viewModel::onDeleteClicked,
                onAddZerosClicked = viewModel::onAddZerosClicked
            )
        }
    }
}
