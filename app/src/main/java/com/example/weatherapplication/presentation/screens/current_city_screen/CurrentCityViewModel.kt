package com.example.weatherapplication.presentation.screens.current_city_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.domain.model.WeatherModel
import com.example.weatherapplication.domain.usecases.GetCityByLocationUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class CurrentCityViewModel @Inject constructor(
    private val getCityByLocationUseCase: GetCityByLocationUseCase
): ViewModel()  {

    private val _city = MutableLiveData<WeatherModel>()
    val city: LiveData<WeatherModel>
        get() = _city

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun getCity(latitude: String, longitude: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _city.value = getCityByLocationUseCase.invoke(latitude, longitude)
            _isLoading.value = false
        }
    }

}