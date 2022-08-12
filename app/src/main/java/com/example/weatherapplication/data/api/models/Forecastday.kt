package com.example.weatherapplication.data.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Forecastday(
    @SerializedName("astro")
    @Expose
    val astro: Astro,
    @SerializedName("date")
    @Expose
    val date: String,
    @SerializedName("date_epoch")
    @Expose
    val date_epoch: Int,
    @SerializedName("day")
    @Expose
    val day: Day,
    @SerializedName("hour")
    @Expose
    val hour: List<Hour>
)