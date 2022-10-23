package com.rodrigoguerrero.mytime.timer

import androidx.lifecycle.ViewModel
import com.rodrigoguerrero.mytime.ui.models.TimerUiState
import com.rodrigoguerrero.mytime.ui.models.TotalTime
import com.rodrigoguerrero.mytime.ui.models.updateTotalTime
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TimerViewModel : ViewModel() {

    companion object {
        private const val QUEUE_CAPACITY = 6
    }

    private val _uiState =
        MutableStateFlow(TimerUiState(totalTime = TotalTime(0, 0, 0)))
    val uiState: StateFlow<TimerUiState> = _uiState

    private val numberQueue = ArrayDeque<Int>(initialCapacity = QUEUE_CAPACITY)

    fun onNumberClicked(number: Int) {
        try {
            if (numberQueue.size < QUEUE_CAPACITY) {
                numberQueue.addFirst(number)
                _uiState.updateTotalTime(totalTime = getTotalTime())
            }
        } catch (exception: IllegalStateException) {
            // NO-OP
        }
    }

    fun onAddZerosClicked() {
        onNumberClicked(0)
        onNumberClicked(0)
    }

    fun onDeleteClicked() {
        if (numberQueue.size > 0) {
            numberQueue.removeFirst()
            _uiState.updateTotalTime(totalTime = getTotalTime())
        }
    }

    private fun getTotalTime() = TotalTime(
        seconds = getCurrent(0, 1),
        minutes = getCurrent(2, 3),
        hours = getCurrent(4, 5)
    )

    private fun getCurrent(unitsIndex: Int, tensIndex: Int): Int {
        val units = numberQueue.getOrNull(unitsIndex)
        val tens = numberQueue.getOrNull(tensIndex)

        return when {
            tens != null && tens > 0 && units != null -> (tens * 10) + units
            tens == null && units != null -> units
            else -> 0
        }
    }
}