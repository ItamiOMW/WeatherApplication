package com.example.weatherapplication.domain.repository

import androidx.lifecycle.LiveData
import com.example.weatherapplication.domain.model.WeatherModel

interface WeatherRepository {

    suspend fun searchCity(name: String): WeatherModel?

}