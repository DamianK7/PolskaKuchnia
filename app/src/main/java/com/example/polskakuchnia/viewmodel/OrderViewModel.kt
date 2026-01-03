package com.example.polskakuchnia.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.polskakuchnia.model.OrderItem
import com.example.polskakuchnia.model.PersonOrder
import com.example.polskakuchnia.model.Order

class OrderViewModel : ViewModel() {

    val currentOrder = MutableLiveData(PersonOrder())
    val currentTotal = MutableLiveData(0.0)


    val orderState = MutableLiveData(Order())
    val grandTotal = MutableLiveData(0.0)

    fun addItem(name: String, price: Double) {
        val current = currentOrder.value ?: PersonOrder()
        current.items.add(OrderItem(name, price))

        currentOrder.value = current
        currentTotal.value = current.total()
    }

    fun confirmPerson() {
        val current = currentOrder.value ?: return

        if (current.items.isNotEmpty()) {

            val mainOrder = orderState.value ?: Order()

            mainOrder.add(current)

            orderState.value = mainOrder

            grandTotal.value = mainOrder.totalSum()

            currentOrder.value = PersonOrder()
            currentTotal.value = 0.0
        }
    }

    fun clearAll() {
        currentOrder.value = PersonOrder()
        currentTotal.value = 0.0

        val mainOrder = orderState.value ?: Order()
        mainOrder.clear()

        orderState.value = mainOrder
        grandTotal.value = 0.0
    }
}