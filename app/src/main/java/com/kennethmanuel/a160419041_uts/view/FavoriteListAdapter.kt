package com.kennethmanuel.a160419041_uts.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.kennethmanuel.a160419041_uts.R
import com.kennethmanuel.a160419041_uts.model.Recipe
import com.kennethmanuel.a160419041_uts.util.loadImage
import kotlinx.android.synthetic.main.recipe_list_card.view.*

class FavoriteListAdapter(private val recipeList: ArrayList<Recipe>):RecyclerView.Adapter<FavoriteListAdapter.FavoriteViewHolder>(){
    class FavoriteViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    fun updateRecipesList(newRecipesList: List<Recipe>){
        recipeList.clear()
        recipeList.addAll(newRecipesList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recipe_list_card, parent, false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
//        holder.view.textRecipeName.text = recipeList[position].name.toString()
//        holder.view.imgFood.loadImage(recipeList[position].picURL.toString(), holder.view.progressBar)
//        holder.view.textCoursesType.text = recipeList[position].category.toString()
//
//        holder.view.buttonViewRecipe.setOnClickListener {
//            val id = recipeList[position].id.toString()
//            val action = DiscoverRecipesFragmentDirections.actionItemDiscoverRecipesToRecipesDetailFragment()
//            Navigation.findNavController(it).navigate(action)
//        }

    }

    override fun getItemCount(): Int {
        return recipeList.size
    }
}
