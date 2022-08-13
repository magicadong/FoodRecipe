package com.example.foodrecipe.fragents.recipe

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipe.databinding.RecipeRowLayoutBinding

class RecipeAdapter:RecyclerView.Adapter<RecipeAdapter.MyViewHolde>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolde {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecipeRowLayoutBinding.inflate(inflater,parent,false)
        return MyViewHolde(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolde, position: Int) {

    }

    override fun getItemCount(): Int {
        return 30
    }

    class MyViewHolde(val binding:RecipeRowLayoutBinding):RecyclerView.ViewHolder(binding.root){

    }
}