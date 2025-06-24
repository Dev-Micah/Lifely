package com.micahnyabuto.lifely.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.micahnyabuto.lifely.core.data.local.FoodDatabase
import com.micahnyabuto.lifely.core.data.repository.FoodRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module{
    single{
        Room.databaseBuilder(
            androidContext(),
            FoodDatabase::class.java,
            "food"
        ).build()
    }

    single {
        get<FoodDatabase>().foodDao()
    }
    single {
        FoodRepositoryImpl(get())
    }

}