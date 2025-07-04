package com.micahnyabuto.lifely

import android.app.Application
import com.micahnyabuto.lifely.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class FoodApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@FoodApp)
            modules(appModule)
        }
    }

}