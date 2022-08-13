package com.example.foodrecipe.fragents.recipe

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipe.R
import com.example.foodrecipe.databinding.FragmentRecipesBinding
import com.example.foodrecipe.tools.NetworkResult
import com.example.foodrecipe.viewmodels.RecipeViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*

class RecipesFragment : Fragment() {
    lateinit var binding: FragmentRecipesBinding
    private val recipeAdapter = RecipeAdapter()
    private val model:RecipeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.shimmerRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            adapter = recipeAdapter
        }

        model.networkResult.observe(viewLifecycleOwner){ result ->
            when(result){
                is NetworkResult.Loading ->{
                    binding.shimmerRecyclerView.showShimmerAdapter()
                }
                is NetworkResult.Success ->{
                    binding.shimmerRecyclerView.hideShimmerAdapter()
                    //刷新数据
                }
                is NetworkResult.Failure ->{
                    binding.shimmerRecyclerView.hideShimmerAdapter()
                    Snackbar.make(binding.shimmerRecyclerView,result.message,Snackbar.LENGTH_LONG).show()
                }
            }
        }
        model.loadFoodRecipe()
    }

}