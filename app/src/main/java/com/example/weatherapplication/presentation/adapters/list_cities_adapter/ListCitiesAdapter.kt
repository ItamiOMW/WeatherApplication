package com.example.weatherapplication.presentation.adapters.list_cities_adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.example.weatherapplication.databinding.WeatherItemBinding
import com.example.weatherapplication.domain.model.WeatherModel

class ListCitiesAdapter(
) : ListAdapter<WeatherModel, ListCitiesViewHolder>(ListCitiesDiffUtil()) {

    var onItemClicked: ((WeatherModel) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCitiesViewHolder {
        val binding = WeatherItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ListCitiesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListCitiesViewHolder, position: Int) {
        val item = currentList[position]
        with(holder.binding) {
            Glide.with(holder.itemView)
                .load(item.listDays[0].dayIconSrc)
                .override(64, 64)
                .into(ivWeatherIcon)
            tvDegree.text = item.listDays[0].dayTemp
            tvNameCity.text = item.name
        }
        holder.itemView.setOnClickListener {
            onItemClicked?.invoke(item)
        }
    }
}