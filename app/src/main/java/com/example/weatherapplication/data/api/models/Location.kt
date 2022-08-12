package com.example.weatherapplication.data.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Location(
    val country: String,
    val lat: Double,
    @SerializedName("localtime")
    @Expose
    val localtime: String,
    val localtime_epoch: Int,
    val lon: Double,
    @SerializedName("name")
    @Expose
    val name: String,
    val region: String,
    val tz_id: String
)