package com.example.weatherapplication.domain.usecases

import com.example.weatherapplication.domain.repository.WeatherRepository
import javax.inject.Inject

class GetCityByLocationUseCase @Inject constructor(private val weatherRepository: WeatherRepository) {

    suspend operator fun invoke(latitude: String, longitude: String) =
        weatherRepository.getCityByLocation(latitude, longitude)
}