package com.rodrigoguerrero.mytime.ui.timer.service

import android.app.Service
import android.content.Intent
import android.os.CountDownTimer
import android.os.IBinder
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TimerService : Service(), CoroutineScope {

    companion object {
        private val ONE_SECOND_INTERVAL = 1000L
    }

    private lateinit var countDownTimer: CountDownTimer

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.IO + job

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        countDownTimer = object :
            CountDownTimer(millisInFuture = 5000, countDownInterval = ONE_SECOND_INTERVAL) {
            override fun onTick(millisUntilFinished: Long) {
                TODO("Not yet implemented")
            }

            override fun onFinish() {
                TODO("Not yet implemented")
            }
        }

        launch {
            countDownTimer.start()
        }

        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }
}