package com.example.foodrecipe.fragents.recipe

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipe.R
import com.example.foodrecipe.databinding.FragmentRecipesBinding
import kotlinx.coroutines.*

class RecipesFragment : Fragment() {
    lateinit var binding: FragmentRecipesBinding
    private val recipeAdapter = RecipeAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipesBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.shimmerRecyclerView.showShimmerAdapter()
        binding.shimmerRecyclerView.apply {
            layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)
            adapter = recipeAdapter
        }

        lifecycleScope.launch(Dispatchers.IO){
            delay(2000)
            withContext(Dispatchers.Main){
                binding.shimmerRecyclerView.hideShimmerAdapter()
            }
        }
    }

}