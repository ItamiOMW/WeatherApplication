package com.example.weatherapplication.presentation.adapters.list_hour_adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapplication.domain.model.WeatherHourModel
import com.example.weatherapplication.domain.model.WeatherModel

class ListHoursDiffUtil : DiffUtil.ItemCallback<WeatherHourModel>() {

    override fun areItemsTheSame(oldItem: WeatherHourModel, newItem: WeatherHourModel): Boolean {
        return oldItem.time == newItem.time
    }

    override fun areContentsTheSame(oldItem: WeatherHourModel, newItem: WeatherHourModel): Boolean {
        return newItem == oldItem
    }

}