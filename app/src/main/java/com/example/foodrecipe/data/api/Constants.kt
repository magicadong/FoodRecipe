package com.example.foodrecipe.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Constants {
    private val BASE_URL = "https://api.spoonacular.com/recipes/"
    private val API_KEY = "1a0edebda73f4a17ad82375357e41313"
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val foodApi = retrofit.create(FoodRecipeApi::class.java)
}