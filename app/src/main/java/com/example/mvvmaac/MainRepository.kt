package com.example.mvvmaac

import androidx.lifecycle.MutableLiveData

class MainRepository {

    private val mathDouble: MutableLiveData<Int> = MutableLiveData()

    fun countUp(count: Int): Int {
        return count + 1
    }

    fun countDown(count: Int): Int {
        return count - 1
    }

    fun mathDouble(count: Int): MutableLiveData<Int> {
        mathDouble.value = count*3
        return mathDouble
    }
}