package com.example.weatherapplication.presentation.adapters.list_cities_adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapplication.domain.model.WeatherModel

class ListCitiesDiffUtil : DiffUtil.ItemCallback<WeatherModel>() {

    override fun areItemsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
        return oldItem.name == newItem.name
    }

    override fun areContentsTheSame(oldItem: WeatherModel, newItem: WeatherModel): Boolean {
        return newItem == oldItem
    }

}