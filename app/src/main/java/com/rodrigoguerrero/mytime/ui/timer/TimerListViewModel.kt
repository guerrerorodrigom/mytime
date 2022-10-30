package com.rodrigoguerrero.mytime.ui.timer

import androidx.lifecycle.ViewModel
import com.rodrigoguerrero.mytime.ui.timer.models.TimerUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class TimerListViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(TimerUiState())
    val uiState: StateFlow<TimerUiState> = _uiState


}