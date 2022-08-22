package com.example.weatherapplication.domain.repository

import com.example.weatherapplication.domain.model.WeatherModel

interface WeatherRepository {

    suspend fun searchCity(name: String): WeatherModel?

    suspend fun getCityByLocation(latitude: String, longitude: String): WeatherModel?

}