package com.example.coolweather

import android.app.Application
import android.content.Context

class CoolWeatherApplication : Application() {
    companion object {
        const val TOKEN = "nlVriiHvYkWQAMbd"
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}