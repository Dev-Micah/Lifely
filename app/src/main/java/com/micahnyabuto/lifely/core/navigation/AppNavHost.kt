package com.micahnyabuto.lifely.core.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.micahnyabuto.lifely.features.foods.FoodDetailsScreen
import com.micahnyabuto.lifely.features.foods.FoodScreen
import com.micahnyabuto.lifely.features.foods.FoodViewModel
import com.micahnyabuto.lifely.features.home.HomeScreen
import com.micahnyabuto.lifely.features.logmeal.LogMealScreen
import com.micahnyabuto.lifely.features.profile.ProfileScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun AppNavHost(
    modifier: Modifier= Modifier,
    navController: NavHostController
){
    val viewModel: FoodViewModel = koinViewModel()
    NavHost(
        navController = navController,
        modifier = Modifier,
        startDestination = Destinations.Home.route
    ){
        composable(Destinations.Home.route){
            HomeScreen()
        }
        composable(Destinations.Foods.route) {
            FoodScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
        composable(
            Destinations.Details.route,
            arguments = listOf(navArgument("foodName") { type = NavType.StringType })
        ) { backStackEntry ->
            val foodName = backStackEntry.arguments?.getString("foodName")
            val foods by viewModel.foods.collectAsState()

            LaunchedEffect(Unit) {
                viewModel.fetchFoods()
            }

            val food = foods.find { it.name == foodName }
            if (food != null) {
                FoodDetailsScreen(food)
            } else {
                Text("No Food Found")
            }
        }

        composable(
            Destinations.Meals.route
        ) {
            LogMealScreen()
        }
        composable(Destinations.Profile.route) {
            ProfileScreen()
        }
    }
}


