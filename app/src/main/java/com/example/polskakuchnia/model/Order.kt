package com.example.polskakuchnia.model

data class Order(
    val ordersList: MutableList<PersonOrder> = mutableListOf()
) {
    fun add(personOrder: PersonOrder) {
        ordersList.add(personOrder)
    }

    fun totalSum(): Double {
        return ordersList.sumOf { it.total() }
    }

    fun clear() {
        ordersList.clear()
    }
}