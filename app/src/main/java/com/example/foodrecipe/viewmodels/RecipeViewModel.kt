package com.example.foodrecipe.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodrecipe.data.api.Repository
import com.example.foodrecipe.data.model.FoodRecipe
import com.example.foodrecipe.tools.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response

class RecipeViewModel:ViewModel() {
    private val repository = Repository()
    var networkResult = MutableLiveData<NetworkResult>()

    fun loadFoodRecipe(options: Map<String,String>){
        //准备开始下载数据了
        networkResult.postValue(NetworkResult.Loading)

        viewModelScope.launch(Dispatchers.IO){
            val result = repository.getFoodRecipe(options)

            delay(4000)
            if (result.isSuccessful){
                //下载成功
                val recipe = result.body()!!
                networkResult.postValue(NetworkResult.Success(recipe))
            }else{
                //下载失败
                val message = result.message()
                networkResult.postValue(NetworkResult.Failure(message))
            }
        }
    }

    fun loadFoodRecipe(){
        val options = mapOf(
            Pair("type","main course"),
            Pair("diet","Vegan"),
            Pair("number","50")
        )
        loadFoodRecipe(options)
    }
}