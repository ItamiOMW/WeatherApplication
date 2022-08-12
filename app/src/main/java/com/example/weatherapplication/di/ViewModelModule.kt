package com.example.weatherapplication.di

import androidx.lifecycle.ViewModel
import com.example.weatherapplication.presentation.screens.main_screen.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}