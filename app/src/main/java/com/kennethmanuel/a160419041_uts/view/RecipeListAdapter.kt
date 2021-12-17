package com.kennethmanuel.a160419041_uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kennethmanuel.a160419041_uts.R
import com.kennethmanuel.a160419041_uts.databinding.RecipeListCardBinding
import com.kennethmanuel.a160419041_uts.model.Recipe
import com.kennethmanuel.a160419041_uts.model.Recipes
import com.kennethmanuel.a160419041_uts.util.loadImage
import kotlinx.android.synthetic.main.recipe_list_card.view.*

class RecipesListAdapter(private val recipeList: ArrayList<Recipes>):RecyclerView.Adapter<RecipesListAdapter.RecipesViewHolder>(), RecipeCardToDetail{
    class RecipesViewHolder(var view: RecipeListCardBinding) : RecyclerView.ViewHolder(view.root)

    fun updateRecipesList(newRecipesList: List<Recipes>){
        recipeList.clear()
        recipeList.addAll(newRecipesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<RecipeListCardBinding>(inflater, R.layout.recipe_list_card, parent, false)
        return RecipesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        holder.view.recipe = recipeList[position]
        holder.view.listener = this
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    override fun onRecipeCardToDetail(v: View) {
        val uuid = v.tag.toString().toInt()
        val action = DiscoverRecipesFragmentDirections.actionItemDiscoverRecipesToRecipesDetailFragment(uuid)

        Navigation.findNavController(v).navigate(action)
    }
}