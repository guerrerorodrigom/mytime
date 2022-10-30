package com.rodrigoguerrero.mytime.ui.timer

import androidx.lifecycle.ViewModel
import com.rodrigoguerrero.mytime.ui.timer.models.TimerItemState
import com.rodrigoguerrero.mytime.ui.timer.models.TimerUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.*
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

@HiltViewModel
class TimerListViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(TimerUiState())
    val uiState: StateFlow<TimerUiState> = _uiState

    fun start(timeInSeconds: Int?) {

        timeInSeconds?.let {
            _uiState.update {
                it.copy(
                    timers = listOf(
                        TimerItemState(
                            label = "label",
                            remainingTimeLabel = timeInSeconds.toString(),
                            remainingTime = timeInSeconds,
                            isPaused = false,
                            totalTime = timeInSeconds,
                            id = UUID.randomUUID().toString()
                        )
                    )
                )
            }
        }
    }

    fun removeTimer(timerId: String) {
        _uiState.update { state ->
            val timers = state.timers.filter { it.id != timerId }
            state.copy(timers = timers, isEmpty = timers.isEmpty())
        }
    }
}
