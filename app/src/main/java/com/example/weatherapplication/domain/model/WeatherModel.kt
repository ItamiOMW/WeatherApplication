package com.example.weatherapplication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherModel(
    val name: String,
    val currentDate: String,
    val lastUpdate: String,
    val listHours: List<WeatherHourModel>,
    val listDays: List<WeatherDayModel>
): Parcelable
