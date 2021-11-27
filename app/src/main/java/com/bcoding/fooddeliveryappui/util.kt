package com.bcoding.fooddeliveryappui

import androidx.annotation.DrawableRes

val categories = listOf<Any>(
    "All", "Healthy food", "Junk food", "Dessert", "Fast food", "Hamburger"
)

data class Food(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    @DrawableRes val image: Int,
)

val foods: List<Food> = listOf(
    Food(1, "Eybisi Salad Mix", "Mix Vegetables ingredients", 14.99, R.drawable.food3),
    Food(1, "Easy Greak Salad", "Loves and lemon", 21.99, R.drawable.food2),
    Food(1, "Vegetable Salad", "Mix Vegetables ingredients", 9.99, R.drawable.food3),
)

data class Menu(val id: Int, val title: String, @DrawableRes val icon: Int)

val menuItems: List<Menu> = listOf(
    Menu(1, "Home", R.drawable.ic_home),
    Menu(1, "Cart", R.drawable.ic_bag),
    Menu(1, "Profile", R.drawable.ic_user),
)