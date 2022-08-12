package com.example.weatherapplication.presentation.adapters.list_days_adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.weatherapplication.databinding.SmallWeatherItemBinding
import com.example.weatherapplication.databinding.WeatherItemBinding
import com.example.weatherapplication.domain.model.WeatherDayModel
import com.example.weatherapplication.domain.model.WeatherModel

class ListDaysAdapter(
) : ListAdapter<WeatherDayModel, ListDaysViewHolder>(ListDaysDiffUtil()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListDaysViewHolder {
        val binding = SmallWeatherItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListDaysViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListDaysViewHolder, position: Int) {
        val item = currentList[position]
        Log.d("TEST_BUG", currentList.size.toString())
        with(holder.binding) {
            tvDate.text = item.dayDate
            tvDegree.text = item.dayTemp
            Glide.with(holder.itemView)
                .load(item.dayIconSrc)
                .override(64, 64)
                .into(ivWeatherIcon)
        }
    }
}