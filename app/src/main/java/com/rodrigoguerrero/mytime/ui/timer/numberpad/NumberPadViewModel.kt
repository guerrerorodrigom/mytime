package com.rodrigoguerrero.mytime.ui.timer.numberpad

import androidx.lifecycle.ViewModel
import com.rodrigoguerrero.mytime.ui.timer.models.NumberPadUiState
import com.rodrigoguerrero.mytime.ui.timer.models.updateTotalTime
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class NumberPadViewModel @Inject constructor() : ViewModel() {

    companion object {
        private const val QUEUE_CAPACITY = 6
    }

    private val _uiState = MutableStateFlow(NumberPadUiState())
    val uiState: StateFlow<NumberPadUiState> = _uiState

    private val numberQueue = ArrayDeque<Int>(initialCapacity = QUEUE_CAPACITY)

    fun onNumberClicked(number: Int) {
        try {
            if (numberQueue.size < QUEUE_CAPACITY && !(number == 0 && numberQueue.size == 0)) {
                numberQueue.addFirst(number)
                _uiState.updateTotalTime(totalTime = getTotalTime(), numberQueue.size)
            }
        } catch (exception: IllegalStateException) {
            // NO-OP
        }
    }

    fun onDeleteClicked() {
        if (numberQueue.size > 0) {
            numberQueue.removeFirst()
        }
        _uiState.updateTotalTime(totalTime = getTotalTime(), numberQueue.size)
    }

    fun onAddZerosClicked() {
        onNumberClicked(0)
        onNumberClicked(0)
    }

    private fun getTotalTime() = com.rodrigoguerrero.mytime.ui.timer.models.TotalTime(
        seconds = getCurrent(0, 1),
        minutes = getCurrent(2, 3),
        hours = getCurrent(4, 5)
    )

    private fun getCurrent(unitsIndex: Int, tensIndex: Int): Int {
        val units = numberQueue.getOrNull(unitsIndex)
        val tens = numberQueue.getOrNull(tensIndex)

        return when {
            tens != null && tens > 0 && units != null -> (tens * 10) + units
            (tens == null || tens == 0) && units != null -> units
            else -> 0
        }
    }
}
