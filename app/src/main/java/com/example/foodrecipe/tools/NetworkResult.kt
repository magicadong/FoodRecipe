package com.example.foodrecipe.tools

import com.example.foodrecipe.data.model.FoodRecipe
import retrofit2.Response

sealed class NetworkResult{
    object Loading:NetworkResult()
    class Success(val foodRecipe: FoodRecipe):NetworkResult()
    class Failure(val message:String):NetworkResult()
}
