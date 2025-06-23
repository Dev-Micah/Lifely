package com.micahnyabuto.lifely.core.navigation

import kotlinx.serialization.Serializable

sealed class Destinations {
    @Serializable
    object Home

    @Serializable
    object Foods

    @Serializable
    object LogMeal

    @Serializable
    object Profile

    @Serializable
    object Splash
}