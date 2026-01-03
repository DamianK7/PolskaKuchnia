package com.example.polskakuchnia.model

data class OrderItem(
    val name: String,
    val price: Double
)

data class PersonOrder(
    val items: MutableList<OrderItem> = mutableListOf()
) {
    fun total(): Double {
        return items.sumOf { it.price }
    }
}