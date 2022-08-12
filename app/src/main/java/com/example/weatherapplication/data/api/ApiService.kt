package com.example.weatherapplication.data.api

import com.example.weatherapplication.data.api.models.WeatherDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET(FORECAST_ENDPOINT)
    suspend fun getWeatherByCity(
        @Query(QUERY_KEY_PARAM) key: String = API_KEY,
        @Query(QUERY_CITY_NAME_PARAM) name: String,
        @Query(QUERY_DAYS_PARAM) days: String = COUNT_FORECAST_DAYS,
    ): Response<WeatherDto>


    companion object {

        //QUERY PARAMS
        private const val QUERY_KEY_PARAM = "key"
        private const val QUERY_CITY_NAME_PARAM = "q"
        private const val QUERY_DAYS_PARAM = "days"

        //END POINTS
        private const val FORECAST_ENDPOINT = "forecast.json"

        //BASE URL
        const val BASE_URL = "http://api.weatherapi.com/v1/"

        //API KEY
        private const val API_KEY = "70cdcec3c253468ab9f100025220908"

        //COUNT OF FORECAST
        private const val COUNT_FORECAST_DAYS = "14"
    }
}