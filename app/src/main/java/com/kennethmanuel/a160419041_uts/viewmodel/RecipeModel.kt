package com.kennethmanuel.a160419041_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.kennethmanuel.a160419041_uts.model.Recipes
import com.kennethmanuel.a160419041_uts.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class RecipeModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val recipeLD = MutableLiveData<List<Recipes>>()
    private var job = Job()

    fun refresh()
    {
        launch {
            val db = buildDB(getApplication())
            recipeLD.value = db.recipesDao().selectAllRecipes()
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}