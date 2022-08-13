package com.example.foodrecipe.data.api

import com.example.foodrecipe.data.model.FoodRecipe
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface FoodRecipeApi {
    @GET("complexSearch?addRecipeInformation=true&fillIngredients=true&apiKey=1a0edebda73f4a17ad82375357e41313")
    suspend fun getFoodRecipe(@QueryMap options:Map<String,String>): Response<FoodRecipe>
}