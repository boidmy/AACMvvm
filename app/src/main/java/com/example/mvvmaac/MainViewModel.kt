package com.example.mvvmaac

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class MainViewModel(private val repository: MainRepository) : ViewModel() {
    private val _count: MutableLiveData<Int> = MutableLiveData()
    private val _mathDouble: LiveData<Int> = Transformations.switchMap(_count) {
        repository.mathDouble(it)
    }
    private val _mathTriple: LiveData<Int> = Transformations.map(_count) {
        it*3
    }

    val count: LiveData<Int>
        get() = _count

    val mathDouble: LiveData<Int>
        get() = _mathDouble

    val mathTriple: LiveData<Int>
        get() = _mathTriple

    fun countUp() {
        _count.value = repository.countUp(_count.value ?: 0)
    }

    fun countDown() {
        _count.value = repository.countDown(_count.value ?: 0)
    }
}