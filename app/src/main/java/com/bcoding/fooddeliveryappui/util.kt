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
    Food(1, "Eybisi Salad Mix", "Bacon ipsum dolor amet ground round bacon cupim ribeye, shankle short ribs doner. Venison chicken ball tip, doner kevin buffalo porchetta beef bacon short loin pork loin boudin shoulder short ribs cow. Biltong pancetta turducken pork short.", 14.99, R.drawable.food3),
    Food(2, "Easy Greak Salad", "Sweet roll sweet roll jelly beans muffin chocolate cake wafer tiramisu. Gummies icing jujubes wafer toffee lollipop sugar plum. Cotton candy wafer pudding fruitcake jelly. Macaroon chupa chups pie pie candy wafer. Apple pie chupa chups.", 21.99, R.drawable.food2),
    Food(3, "Vegetable Salad", "Eat Write Live Guides sind Reiseführer für eine Generation, die sich die grundlegenden Infos zu Flug, Hotel oder geografischen Angaben sowieso über das Internet holt. Die Autorinnen geben diesen Personen einen Begleiter auf ihren Reisen.", 5.99, R.drawable.food3),
    Food(4, "Carbon Res", "Eat Write Live Guides sind Reiseführer für eine Generation, die sich die grundlegenden Infos zu Flug, Hotel oder geografischen Angaben sowieso über das Internet holt. Die Autorinnen geben diesen Personen einen Begleiter auf ihren Reisen.", 39.99, R.drawable.food2),
    Food(5, "Vegetable Salad", "Eat Write Live Guides sind Reiseführer für eine Generation, die sich die grundlegenden Infos zu Flug, Hotel oder geografischen Angaben sowieso über das Internet holt. Die Autorinnen geben diesen Personen einen Begleiter auf ihren Reisen.", 16.99, R.drawable.food3),
)

data class Menu(val id: Int, val title: String, @DrawableRes val icon: Int, val url: String)

val menuItems: List<Menu> = listOf(
    Menu(1, "Home", R.drawable.ic_home, "foods"),
    Menu(2, "Cart", R.drawable.ic_bag, "cart"),
    Menu(3, "Profile", R.drawable.ic_user, "profile"),
)

fun filterFood(id: String): Food? {
    return foods.find { it.id == id.toInt() }
}