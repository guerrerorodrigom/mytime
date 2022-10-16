package com.rodrigoguerrero.mytime

import android.os.CountDownTimer
import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CountDownViewModel : ViewModel() {

    fun count() {

    }
}

class Timer(
    private val millisInTheFuture: Long,
    private val interval: Long
) : CountDownTimer(millisInTheFuture, interval) {
    private val _millisUntilFinished = MutableStateFlow(millisInTheFuture)
    val millisUntilFinished: StateFlow<Long> = _millisUntilFinished

    override fun onTick(millisUntilFinished: Long) {
        Log.d("vanessa", "$millisUntilFinished")
        _millisUntilFinished.value = millisUntilFinished
    }

    override fun onFinish() {

    }

}