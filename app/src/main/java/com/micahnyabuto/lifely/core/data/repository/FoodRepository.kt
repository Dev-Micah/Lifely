package com.micahnyabuto.lifely.core.data.repository

import com.micahnyabuto.lifely.core.data.local.FoodEntity
import kotlinx.coroutines.flow.Flow

interface FoodRepository {
    suspend fun insertFood(food: FoodEntity)
    suspend fun updateFood(food: FoodEntity)
    suspend fun deleteFood(food: FoodEntity)
    fun getAllFoods(): Flow<List<FoodEntity>>
}