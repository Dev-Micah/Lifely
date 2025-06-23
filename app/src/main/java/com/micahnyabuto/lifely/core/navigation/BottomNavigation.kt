package com.micahnyabuto.lifely.core.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.AddBox
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

enum class BottomNavigation(
    val label: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: Any

) {
    Home(
        label = "Home",
        selectedIcon = Icons.Default.Home,
        unselectedIcon = Icons.Default.Home,
        route = Destinations.Home
    ),
    Foods(
        label = "Foods",
        selectedIcon = Icons.Default.Category,
        unselectedIcon = Icons.Default.Category,
        route = Destinations.Foods
    ),
    LogMeal(
        label = "Log a meal",
        selectedIcon = Icons.Default.AddBox,
        unselectedIcon = Icons.Default.AddBox,
        route = Destinations.LogMeal
    ),
    Profile(
        label = "Profile",
        selectedIcon = Icons.Default.Person,
        unselectedIcon = Icons.Default.Person,
        route = Destinations.Profile
    )



}