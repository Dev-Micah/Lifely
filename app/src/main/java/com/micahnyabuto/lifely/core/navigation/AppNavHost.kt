package com.micahnyabuto.lifely.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.micahnyabuto.lifely.features.foods.FoodScreen
import com.micahnyabuto.lifely.features.home.HomeScreen
import com.micahnyabuto.lifely.features.logmeal.LogMealScreen
import com.micahnyabuto.lifely.features.profile.ProfileScreen

@Composable
fun AppNavHost(
    modifier: Modifier= Modifier,
    navController: NavHostController
){
    NavHost(
        navController = navController,
        modifier = Modifier,
        startDestination = Destinations.Home
    ){
        composable<Destinations.Home> {
            HomeScreen()
        }
        composable<Destinations.Foods> {
            FoodScreen()
        }
        composable<Destinations.LogMeal> {
            LogMealScreen()
        }
        composable<Destinations.Profile> {
            ProfileScreen()
        }
    }
}