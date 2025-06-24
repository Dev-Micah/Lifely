package com.micahnyabuto.lifely.core.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFood (food: FoodEntity)

    @Update
    suspend fun updateFood (food: FoodEntity)

    @Delete
    suspend fun deleteFood (food: FoodEntity)

    @Query("SELECT * FROM food ORDER BY date DESC")
    fun getAllFoods (): Flow<List<FoodEntity>>

    @Query("SELECT * FROM food WHERE category = :category ORDER BY date DESC")
    fun getFoodsByCategory(category: String): Flow<List<FoodEntity>>

}