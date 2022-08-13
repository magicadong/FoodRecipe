package com.example.foodrecipe.data.api

import com.example.foodrecipe.data.model.FoodRecipe
import retrofit2.Response

class Repository {
    private val foodRecipeApi = Constants.foodApi

    suspend fun getFoodRecipe(options: Map<String,String>):Response<FoodRecipe>{
        return foodRecipeApi.getFoodRecipe(options)
    }
}