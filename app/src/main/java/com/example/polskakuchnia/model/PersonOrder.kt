package com.example.polskakuchnia.model

data class PersonOrder(
    var soupName: String = "",
    var soupPrice: Double = 0.0,
    var mainDishName: String = "",
    var mainDishPrice: Double = 0.0,
    var drinkName: String = "",
    var drinkPrice: Double = 0.0
) {
    fun totalCost() = soupPrice + mainDishPrice + drinkPrice
}