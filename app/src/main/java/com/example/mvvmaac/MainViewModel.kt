package com.example.mvvmaac

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    private var _count: MutableLiveData<Int> = MutableLiveData()
    private var _mathDouble: LiveData<Int> = Transformations.switchMap(_count) {
        repository.mathDouble(it)
    }

    val count: LiveData<Int>
        get() = _count

    val mathDouble: LiveData<Int>
        get() = _mathDouble

    fun countUp() {
        _count.value = repository.countUp(_count.value ?: 0)
    }

    fun countDown() {
        _count.value = repository.countDown(_count.value ?: 0)
    }
}