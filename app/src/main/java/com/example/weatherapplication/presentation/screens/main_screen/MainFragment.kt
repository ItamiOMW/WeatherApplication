package com.example.weatherapplication.presentation.screens.main_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.weatherapplication.R
import com.example.weatherapplication.WeatherApp
import com.example.weatherapplication.databinding.FragmentSearchBinding
import com.example.weatherapplication.domain.model.WeatherModel
import com.example.weatherapplication.presentation.adapters.list_cities_adapter.ListCitiesAdapter
import com.example.weatherapplication.presentation.viewmodel_factory.WeatherViewModelFactory
import javax.inject.Inject


class MainFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding
        get() = _binding ?: throw RuntimeException("FragmentSearchBinding is null")

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val component by lazy {
        (requireActivity().application as WeatherApp).component
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        component.inject(this)
        super.onCreate(savedInstanceState)
    }

    @Inject
    lateinit var viewModelFactory: WeatherViewModelFactory

    private lateinit var viewModel: MainViewModel

    private val citiesAdapter by lazy {
        ListCitiesAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        setupHourRV()
        observeLoading()
        setupSearchView()
    }

    private fun setupSearchView() {
        with(binding.searchCity) {
            clearFocus()
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    if (!query.isNullOrBlank()) {
                        viewModel.searchList(query)
                    }
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    if (!newText.isNullOrBlank()) {
                        viewModel.searchList(newText)
                    }
                    return true
                }
            })
        }
    }

    private fun setupHourRV() {
        binding.rvWeather.adapter = citiesAdapter
        viewModel.city.observe(viewLifecycleOwner) {
            if (it != null) {
                citiesAdapter.submitList(mutableListOf(it))
            }
            citiesAdapter.onItemClicked = {
                findNavController().navigate(
                    MainFragmentDirections.actionMainFragmentToDetailFragment(
                        it
                    )
                )
            }
        }
    }

    private fun observeLoading() {
        viewModel.isLoading.observe(viewLifecycleOwner) {
            if (it) {
                binding.progressBarLoading.visibility = View.VISIBLE
            } else {
                binding.progressBarLoading.visibility = View.GONE
            }
        }
    }


}