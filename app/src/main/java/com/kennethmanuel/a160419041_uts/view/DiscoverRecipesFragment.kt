package com.kennethmanuel.a160419041_uts.view

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.kennethmanuel.a160419041_uts.R
import com.kennethmanuel.a160419041_uts.viewmodel.RecipeModel
import kotlinx.android.synthetic.main.fragment_discover_recipes.*

class DiscoverRecipesFragment : Fragment() {
//    private lateinit var viewModel: RecipeModel
//    private val recipeListAdapter = RecipesListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_discover_recipes, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        buttonFilter.setOnClickListener{
//            val action = DiscoverRecipesFragmentDirections.actionItemDiscoverRecipesToSortDialogFragment()
//            Navigation.findNavController(it).navigate(action)
//        }
//
//        floatingActionButtonAddRecipes.setOnClickListener{
//            val action = DiscoverRecipesFragmentDirections.actionItemDiscoverRecipesToItemAddRecipes()
//            Navigation.findNavController(it).navigate(action)
//        }
//
//        viewModel = ViewModelProvider(this).get(RecipeModel::class.java)
//        viewModel.refresh()
//
//        recView.layoutManager = LinearLayoutManager(context)
//        recView.adapter = recipeListAdapter
//
//        refreshLayout.setOnRefreshListener {
//            recView.visibility = View.GONE
//            viewModel.refresh()
//            refreshLayout.isRefreshing = false
//        }
//        observeViewModel()
    }

//    fun observeViewModel(){
//        viewModel.recipeLD.observe(viewLifecycleOwner, Observer {
//            recipeListAdapter.updateRecipesList(it)
//        })
//    }
}