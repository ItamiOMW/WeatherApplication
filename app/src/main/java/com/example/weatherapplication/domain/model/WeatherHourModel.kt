package com.example.weatherapplication.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WeatherHourModel (
    val time: String,
    val hourIconSrc: String,
    val hourTemp: String,
): Parcelable