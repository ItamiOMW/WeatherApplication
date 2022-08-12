package com.example.weatherapplication.presentation.screens.detail_screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.weatherapplication.R
import com.example.weatherapplication.WeatherApp
import com.example.weatherapplication.databinding.FragmentDetailBinding
import com.example.weatherapplication.domain.model.WeatherModel
import com.example.weatherapplication.presentation.adapters.list_days_adapter.ListDaysAdapter
import com.example.weatherapplication.presentation.adapters.list_hour_adapter.ListHoursAdapter
import com.example.weatherapplication.presentation.viewmodel_factory.WeatherViewModelFactory
import javax.inject.Inject


class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding: FragmentDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentDetailBinding is null")

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val daysAdapter by lazy {
        ListDaysAdapter()
    }

    private val hoursAdapter by lazy {
        ListHoursAdapter()
    }

    private val args by navArgs<DetailFragmentArgs>()

    private lateinit var weatherModel: WeatherModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        weatherModel = args.weatherModel
        binding.tvCurrentDate.text = weatherModel.currentDate
        binding.tvNameCity.text = weatherModel.name
        setupDaysRV()
        setupHoursRV()
    }

    private fun setupDaysRV() {
        binding.rvWeekWeather.adapter = daysAdapter
        Log.d("TEST_BUG", weatherModel.listDays.toString())
        daysAdapter.submitList(weatherModel.listDays)
    }

    private fun setupHoursRV() {
        binding.rvHourWeather.adapter = hoursAdapter
        hoursAdapter.submitList(weatherModel.listHours)
    }

}