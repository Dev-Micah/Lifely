package com.micahnyabuto.lifely.core.data.repository

import com.micahnyabuto.lifely.core.data.local.FoodDao
import com.micahnyabuto.lifely.core.data.local.FoodEntity
import kotlinx.coroutines.flow.Flow


class FoodRepositoryImpl(
        private val foodDao: FoodDao
    ) : FoodRepository {

    override suspend fun insertFood(food: FoodEntity) {
        foodDao.insertFood(food)
    }

    override suspend fun updateFood(food: FoodEntity) {
        foodDao.updateFood(food)
    }

    override suspend fun deleteFood(food: FoodEntity) {
        foodDao.deleteFood(food)
    }

    override fun getAllFoods(): Flow<List<FoodEntity>> {
        return foodDao.getAllFoods()
    }


}