package com.kennethmanuel.a160419041_uts.view

import android.os.Bundle
import android.telecom.Call
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.workDataOf
import com.kennethmanuel.a160419041_uts.R
import com.kennethmanuel.a160419041_uts.databinding.FragmentAddRecipesBinding
import com.kennethmanuel.a160419041_uts.model.Recipes
import com.kennethmanuel.a160419041_uts.util.RecipeWalker
import com.kennethmanuel.a160419041_uts.viewmodel.DetailRecipeViewModel
import java.util.concurrent.TimeUnit

class AddRecipesFragment : Fragment(), RecipeAdd {
    private lateinit var viewModel: DetailRecipeViewModel
    private lateinit var dataBinding: FragmentAddRecipesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_recipes, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailRecipeViewModel::class.java)
        dataBinding.recipe = Recipes("", "", "", "", "", 0)
        dataBinding.listener = this
    }

    override fun onRecipeAdd(v: View) {
        viewModel.addRecipe(dataBinding.recipe!!)
        Toast.makeText(v.context, "Recipe added", Toast.LENGTH_SHORT).show()
        val myWorkRequest= OneTimeWorkRequestBuilder<RecipeWalker>()
            .setInitialDelay(5, TimeUnit.SECONDS)
            .setInputData(
                workDataOf(
                    "title" to "Data Recipe Added",
                    "message" to "A new Recipe has been created")
            )
            .build()
        WorkManager.getInstance(requireContext()).enqueue(myWorkRequest)
//        Navigation.findNavController(v).popBackStack()
    }
}