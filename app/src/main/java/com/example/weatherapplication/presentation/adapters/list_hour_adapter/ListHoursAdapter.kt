package com.example.weatherapplication.presentation.adapters.list_hour_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.weatherapplication.databinding.HourWeatherItemBinding
import com.example.weatherapplication.databinding.WeatherItemBinding
import com.example.weatherapplication.domain.model.WeatherHourModel
import com.example.weatherapplication.domain.model.WeatherModel

class ListHoursAdapter(
) : ListAdapter<WeatherHourModel, ListHoursViewHolder>(ListHoursDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListHoursViewHolder {
        val binding = HourWeatherItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListHoursViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListHoursViewHolder, position: Int) {
        val item = currentList[position]
        with(holder.binding) {
            tvHour.text = item.time.substringAfter(" ")
            tvDegree.text = item.hourTemp
            Glide.with(holder.itemView)
                .load(item.hourIconSrc)
                .override(64, 64)
                .into(ivWeatherIcon)
        }

    }
}