package com.example.week7.repository

import com.example.week7.service.RestaurantService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestaurantContainer {

//    private val BASE_URL = "http://10.0.2.2/"
    private val BASE_URL = "http://192.168.43.222/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    private val retrofitService: RestaurantService by lazy {
        retrofit.create(RestaurantService::class.java)
    }

    val restaurantRepositories: RestaurantRepositories by lazy {
        RestaurantRepositories(retrofitService)
    }
}