package com.example.weatherapplication.di

import android.app.Application
import com.example.weatherapplication.presentation.screens.current_city_screen.CurrentLocationWeatherFragment
import com.example.weatherapplication.presentation.screens.detail_screen.DetailFragment
import com.example.weatherapplication.presentation.screens.main_screen.MainFragment
import dagger.BindsInstance
import dagger.Component

@AppScope
@Component(modules = [DataModule::class, ViewModelModule::class])
interface AppComponent {

    fun inject(fragment: MainFragment)

    fun inject(fragment: DetailFragment)

    fun inject(fragment: CurrentLocationWeatherFragment)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): AppComponent
    }
}