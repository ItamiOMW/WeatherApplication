package com.example.weatherapplication

import android.app.Application
import com.example.weatherapplication.di.DaggerAppComponent

class WeatherApp : Application() {

    val component by lazy {
        DaggerAppComponent.factory().create(this)
    }

}