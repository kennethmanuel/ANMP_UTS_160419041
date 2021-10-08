package com.kennethmanuel.a160419041_uts.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.kennethmanuel.a160419041_uts.R
import com.kennethmanuel.a160419041_uts.viewmodel.RecipeFavoriteModel
import com.kennethmanuel.a160419041_uts.viewmodel.RecipeModel
import kotlinx.android.synthetic.main.fragment_discover_recipes.*
import kotlinx.android.synthetic.main.fragment_favorite_recipes.*

class FavoriteRecipesFragment : Fragment() {
    private lateinit var viewModel: RecipeFavoriteModel
    private val favoriteListAdapter = FavoriteListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favorite_recipes, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RecipeFavoriteModel::class.java)
        viewModel.refresh()

        recViewFavorite.layoutManager = LinearLayoutManager(context)
        recViewFavorite.adapter = favoriteListAdapter

        refreshLayoutFavorite.setOnRefreshListener {
            recViewFavorite.visibility = View.GONE
            viewModel.refresh()
            refreshLayoutFavorite.isRefreshing = false
        }
        observeViewModel()
    }
    fun observeViewModel(){
        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
            favoriteListAdapter.updateRecipesList(it)
        })
    }
}