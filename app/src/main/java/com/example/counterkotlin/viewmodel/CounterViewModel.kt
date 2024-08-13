package com.example.counterkotlin.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {
    private val counter = MutableLiveData(0)
    val count: LiveData<Int> = counter
    private val handler = Handler(Looper.getMainLooper())
    private var isCounting = false
    private val increment: Runnable = object : Runnable {
        override fun run() {
            counter.value = counter.value!! + 1
            handler.postDelayed(this, 1000)
        }
    }

    fun start() {
        if (!isCounting) {
            isCounting = true
            handler.post(increment)
        }
    }

    fun stop() {
        isCounting = false
        handler.removeCallbacks(increment)
    }

    fun reset() {
        isCounting = false
        handler.removeCallbacks(increment)
        counter.value = 0

    }

}


