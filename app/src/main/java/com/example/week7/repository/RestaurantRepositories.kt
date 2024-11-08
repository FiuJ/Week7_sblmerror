package com.example.week7.repository


import com.example.week7.model.Result
import com.example.week7.service.RestaurantService

class RestaurantRepositories(private val restaurantService: RestaurantService){
    suspend fun getAllRestaurant(): List<Result> {
        val listResult = restaurantService.getAllRestaurant()

        return listResult
    }

    suspend fun getRestaurantDetail(id: Int): Result{
        val respond = restaurantService.getDetailRestaurant(id)

        val restaurant = Result(
            id = respond.id,
            name = respond.name,
            rating = respond.rating,
            ratingCount = respond.ratingCount,
            distance = respond.distance,
            location = respond.location,
            description = respond.description

        )
        return restaurant
    }
}