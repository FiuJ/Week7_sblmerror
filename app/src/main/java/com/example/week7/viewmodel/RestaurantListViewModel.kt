package com.example.week7.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week7.model.Restaurant
import com.example.week7.model.Result
import com.example.week7.repository.RestaurantContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RestaurantListViewModel: ViewModel() {

    private val _restaurant = MutableStateFlow<List<Result>>(emptyList())
    val restaurant: StateFlow<List<Result>> = _restaurant

    init {
        loadRestaurant()
    }

    private fun loadRestaurant(){
        viewModelScope.launch {
            val data = RestaurantContainer().restaurantRepositories.getAllRestaurant()
            _restaurant.value = data
        }
    }

}