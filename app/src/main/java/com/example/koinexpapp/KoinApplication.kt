package com.example.koinexpapp

import android.app.Application

class KoinApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@KoinApplication)
            modules(userDB,mainViewModel,)
        }
    }
}