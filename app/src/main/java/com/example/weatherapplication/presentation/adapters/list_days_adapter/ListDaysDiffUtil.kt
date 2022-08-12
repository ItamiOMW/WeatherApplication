package com.example.weatherapplication.presentation.adapters.list_days_adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapplication.domain.model.WeatherDayModel
import com.example.weatherapplication.domain.model.WeatherModel

class ListDaysDiffUtil : DiffUtil.ItemCallback<WeatherDayModel>() {

    override fun areItemsTheSame(oldItem: WeatherDayModel, newItem: WeatherDayModel): Boolean {
        return oldItem.dayDate == newItem.dayDate
    }

    override fun areContentsTheSame(oldItem: WeatherDayModel, newItem: WeatherDayModel): Boolean {
        return newItem == oldItem
    }

}