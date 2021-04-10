package com.example.android.marsrealestate

import android.app.Application
import com.example.android.marsrealestate.di.appModule
import com.example.android.marsrealestate.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MarsRealEstateApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MarsRealEstateApplication)
            modules(listOf(appModule, viewModelModule))
        }
    }
}