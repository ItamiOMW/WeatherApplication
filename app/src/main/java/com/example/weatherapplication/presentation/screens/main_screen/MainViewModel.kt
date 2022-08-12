package com.example.weatherapplication.presentation.screens.main_screen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapplication.domain.model.WeatherModel
import com.example.weatherapplication.domain.usecases.SearchCityUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val searchCityUseCase: SearchCityUseCase
) : ViewModel() {

    private val _city = MutableLiveData<WeatherModel>()
    val city: LiveData<WeatherModel>
        get() = _city

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    fun searchList(name: String) {
        viewModelScope.launch {
            _isLoading.value = true
            _city.value = searchCityUseCase.invoke(name)
            _isLoading.value = false
        }
    }
}