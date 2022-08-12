package com.example.weatherapplication.domain.usecases

import com.example.weatherapplication.domain.repository.WeatherRepository
import javax.inject.Inject

class SearchCityUseCase @Inject constructor (private val repository: WeatherRepository) {

    suspend operator fun invoke(name: String) = repository.searchCity(name)

}