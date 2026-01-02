package com.example.polskakuchnia.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {

    private val _currentTotal = MutableLiveData(0.0)
    val currentTotal: LiveData<Double> get() = _currentTotal

    fun setSoupPrice(price: Double) {
        _currentTotal.value = price
    }
}