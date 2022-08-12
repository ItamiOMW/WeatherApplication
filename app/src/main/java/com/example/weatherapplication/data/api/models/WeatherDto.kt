package com.example.weatherapplication.data.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class WeatherDto(
    @SerializedName("current")
    @Expose
    val current: Current,
    @SerializedName("forecast")
    @Expose
    val forecast: Forecast,
    @SerializedName("location")
    @Expose
    val location: Location
)