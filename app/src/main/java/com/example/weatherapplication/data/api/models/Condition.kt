package com.example.weatherapplication.data.api.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Condition(
    @SerializedName("code")
    @Expose
    val code: Int,
    @SerializedName("icon")
    @Expose
    val icon: String,
    @SerializedName("text")
    @Expose
    val text: String
)