package com.micahnyabuto.lifely.features.foods

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.micahnyabuto.lifely.core.data.local.IndigenousFood
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FoodScreen(viewModel: FoodViewModel = koinViewModel()) {
    val foods by viewModel.foods.collectAsState()

    LaunchedEffect(Unit) {
        println("Calling loadFoods()")
        viewModel.fetchFoods()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(100.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(foods) { food ->
            FoodGridItem(food)
        }
    }
}

@Composable
fun FoodGridItem(food: IndigenousFood) {
    val context = LocalContext.current
    val imageId = remember(food.imageName) {
        context.resources.getIdentifier(food.imageName, "drawable", context.packageName)
    }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { /* Handle click if needed */ },
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Column(modifier = Modifier.padding(8.dp)) {

//                if (imageId != 0) {
//                    Image(
//                        painter = painterResource(id = imageId),
//                        contentDescription = food.name,
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(120.dp),
//                        contentScale = ContentScale.Crop
//                    )
//                } else {
//                    Text(
//                        text = "No Image",
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(120.dp)
//                    )
//                }

                Spacer(modifier = Modifier.height(8.dp))
                Text(text = food.name, style = MaterialTheme.typography.titleMedium)
                Text(text = food.category)
                Text(text = "Calories: ${food.calories}")
            }
        }
        }


}

