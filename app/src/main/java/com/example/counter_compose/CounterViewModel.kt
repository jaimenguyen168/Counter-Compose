package com.example.counter_compose

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private val _repo: CounterRepository by lazy {
        CounterRepository()
    }
    private val _count = mutableIntStateOf(this._repo.getCounter().count)

    val count: MutableState<Int> = _count

    fun increment() {
        this._repo.incrementCounter()
        _count.intValue = this._repo.getCounter().count
    }

    fun decrement() {
        this._repo.decrementCounter()
        _count.intValue = this._repo.getCounter().count
    }
}

//class CounterViewModel : ViewModel() {
//    private val _count = mutableIntStateOf(0)
//    val count : MutableState<Int> = _count
//
//    fun increment() {
//        _count.intValue++
//    }
//
//    fun decrement() {
//        _count.intValue--
//    }
//}