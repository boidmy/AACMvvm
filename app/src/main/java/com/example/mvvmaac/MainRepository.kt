package com.example.mvvmaac

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainRepository {

    private val mathDouble: MutableLiveData<Int> = MutableLiveData()

    fun countUp(count: Int): Int {
        return count + 1
    }

    fun countDown(count: Int): Int {
        return count - 1
    }

    fun mathDouble(count: Int): LiveData<Int> {
        mathDouble.value = count*2
        return mathDouble
    }
}