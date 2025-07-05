package com.micahnyabuto.lifely.core.navigation

sealed class Destinations(val route: String) {
    object Foods : Destinations("foodList")
    object Details : Destinations("foodDetails/{foodName}")

    object Home : Destinations( "home")

    object Profile: Destinations ("profile")

    object Meals : Destinations("meals")

    object Splash: Destinations("splash")

    fun detailsRoute(foodName: String) = "foodDetails/$foodName"


}
