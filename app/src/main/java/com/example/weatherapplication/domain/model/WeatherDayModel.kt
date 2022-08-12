package com.example.weatherapplication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherDayModel(
    val dayDate: String,
    val dayTemp: String,
    val dayIconSrc: String
): Parcelable
