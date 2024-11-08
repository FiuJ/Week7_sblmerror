package com.example.week7.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week7.model.Result
import com.example.week7.repository.RestaurantContainer
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RestaurantDetailViewModel: ViewModel() {

    private val _restaurantDetail = MutableStateFlow<Result>(Result())
    val restaurantDetail: StateFlow<Result> = _restaurantDetail

    fun setRestaurant(id: Int){
        viewModelScope.launch {
            val restaurant = RestaurantContainer().restaurantRepositories.getRestaurantDetail(id)
            _restaurantDetail.value = _restaurantDetail.value.copy(
                restaurant.id,
                restaurant.name,
                restaurant.rating,
                restaurant.ratingCount,
                restaurant.distance,
                restaurant.location,
                restaurant.description
            )
        }
    }


}