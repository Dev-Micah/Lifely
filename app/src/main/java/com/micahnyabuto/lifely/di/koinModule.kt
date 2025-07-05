package com.micahnyabuto.lifely.di

import androidx.room.Room
import com.micahnyabuto.lifely.core.data.local.FoodDatabase
import com.micahnyabuto.lifely.core.data.repository.FoodRepository
import com.micahnyabuto.lifely.core.data.repository.FoodRepositoryImpl
import com.micahnyabuto.lifely.core.data.repository.IndigenousFoodRepository
import com.micahnyabuto.lifely.features.foods.FoodViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.viewModel
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
    single<FoodRepository> {
        FoodRepositoryImpl(get())
    }
    single {
        IndigenousFoodRepository(get())
    }

    viewModel {
        FoodViewModel(get())
    }

}