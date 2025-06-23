package com.micahnyabuto.lifely.features.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.micahnyabuto.lifely.features.home.components.HomeTopBar

@Composable
fun HomeScreen(){
    HomeTopBar()
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text("HomeScreen")
    }
}