package com.micahnyabuto.lifely

import android.app.Application
import com.micahnyabuto.lifely.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FoodApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@FoodApp)
            modules(appModule)
        }
    }

}