package com.example.mvvmaac

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    private val _count: MutableLiveData<Int> = MutableLiveData(0)

    val count: LiveData<Int>
        get() = _count

    fun countUp() {
        _count.value = repository.countUp(_count.value ?: 0)
    }

    fun countDown() {
        _count.value = repository.countDown(_count.value ?: 0)
    }
}