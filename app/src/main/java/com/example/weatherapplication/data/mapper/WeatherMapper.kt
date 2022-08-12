package com.example.weatherapplication.data.mapper

import com.example.weatherapplication.data.api.models.Forecast
import com.example.weatherapplication.data.api.models.Forecastday
import com.example.weatherapplication.data.api.models.WeatherDto
import com.example.weatherapplication.domain.model.WeatherDayModel
import com.example.weatherapplication.domain.model.WeatherHourModel
import com.example.weatherapplication.domain.model.WeatherModel
import javax.inject.Inject

class WeatherMapper @Inject constructor() {

    fun mapDtoToEntity(model: WeatherDto) = WeatherModel(
        name = model.location.name,
        currentDate = model.location.localtime,
        lastUpdate = model.current.last_updated,
        listHours = mapForecastDayToListHours(model.forecast.forecastday[0]),
        listDays = mapListForecastDayToListDays(model.forecast.forecastday)
    )

    private fun mapForecastDayToListHours(forecastday: Forecastday): List<WeatherHourModel> {
        return forecastday.hour.map {
            WeatherHourModel(
                it.time,
                "http://" + it.condition.icon,
                it.temp_c.toString()
            )
        }
    }

    private fun mapListForecastDayToListDays(forecast: List<Forecastday>): List<WeatherDayModel> {
        return forecast.map {
            WeatherDayModel(
                it.date,
                it.day.avgtemp_c.toString(),
                "http://" + it.day.condition.icon
            )
        }
    }
}