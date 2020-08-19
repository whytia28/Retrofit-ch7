package com.example.retrofitchapter7

import android.app.Application
import com.example.retrofitchapter7.di.appModule
import org.koin.core.context.startKoin

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule)
        }
    }
}