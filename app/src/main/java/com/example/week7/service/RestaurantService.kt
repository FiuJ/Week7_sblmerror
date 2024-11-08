package com.example.week7.service

import com.example.week7.model.Restaurant
import com.example.week7.model.Result
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantService {
    @GET("restaurant_api.php")
    suspend fun getAllRestaurant(): Restaurant

    @GET("restaurant_api.php")
    suspend fun getDetailRestaurant(
        @Query("id") id: Int
    ): Result
}