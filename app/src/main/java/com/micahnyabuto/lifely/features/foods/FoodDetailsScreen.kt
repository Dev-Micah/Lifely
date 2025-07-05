package com.micahnyabuto.lifely.features.foods

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.micahnyabuto.lifely.core.data.local.IndigenousFood

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodDetailsScreen(food: IndigenousFood) {
    val context = LocalContext.current
    val imageId = remember(food.imageName) {
        context.resources.getIdentifier(food.imageName, "drawable", context.packageName)
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(food.name) }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            if (imageId != 0) {
                Image(
                    painter = painterResource(id = imageId),
                    contentDescription = food.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentScale = ContentScale.Crop
                )
            } else {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No Image")
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Category: ${food.category}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Calories: ${food.calories}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Description:", style = MaterialTheme.typography.titleMedium)
            Text(text = food.description)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Benefits:", style = MaterialTheme.typography.titleMedium)
            Text(text = food.benefits)
        }
    }
}
