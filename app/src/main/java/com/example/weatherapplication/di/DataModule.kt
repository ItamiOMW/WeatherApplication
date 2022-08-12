package com.example.weatherapplication.di

import com.example.weatherapplication.data.api.ApiService
import com.example.weatherapplication.data.repository_impl.WeatherRepositoryImpl
import com.example.weatherapplication.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
interface DataModule {

    @Binds
    fun bindRepositoryImpl(repositoryImpl: WeatherRepositoryImpl): WeatherRepository

    companion object {

        @AppScope
        @Provides
        fun provideApi(): ApiService {
            return Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create()
        }
    }

}