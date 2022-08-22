package com.example.weatherapplication.data.repository_impl

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.weatherapplication.data.api.ApiService
import com.example.weatherapplication.data.api.models.WeatherDto
import com.example.weatherapplication.data.mapper.WeatherMapper
import com.example.weatherapplication.domain.model.WeatherModel
import com.example.weatherapplication.domain.repository.WeatherRepository
import retrofit2.Response
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: ApiService,
    private val mapper: WeatherMapper
) : WeatherRepository {

    override suspend fun searchCity(name: String): WeatherModel? {
        val response = getWeatherDtoResponse(name)
        response.body()?.toString()?.let { Log.d("FIX_BUG", it) }
        return when (response.isSuccessful) {
            true -> response.body()?.let { mapper.mapDtoToEntity(it) }
            false -> null
        }
    }

    override suspend fun getCityByLocation(latitude: String, longitude: String): WeatherModel? {
        val response = getWeatherDtoResponse(latitude, longitude)
        response.body()?.toString()?.let { Log.d("FIX_BUG", it) }
        return when (response.isSuccessful) {
            true -> response.body()?.let { mapper.mapDtoToEntity(it) }
            false -> null
        }
    }

    private suspend fun getWeatherDtoResponse(name: String): Response<WeatherDto> {
        return try {
            api.getWeatherByCity(name = name)
        } catch (e: Exception) {
            getWeatherDtoResponse(name = name)
        }
    }

    private suspend fun getWeatherDtoResponse(
        latitude: String,
        longitude: String
    ): Response<WeatherDto> {
        return try {
            api.getWeatherByLocation(coordinates = "$latitude,$longitude")
        } catch (e: Exception) {
            getWeatherDtoResponse(latitude, longitude)
        }
    }

}