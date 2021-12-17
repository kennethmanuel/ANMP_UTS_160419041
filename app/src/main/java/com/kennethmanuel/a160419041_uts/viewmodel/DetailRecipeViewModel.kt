package com.kennethmanuel.a160419041_uts.viewmodel

import android.app.Application
import android.graphics.DiscretePathEffect
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.room.CoroutinesRoom
import com.kennethmanuel.a160419041_uts.model.Recipes
import com.kennethmanuel.a160419041_uts.util.buildDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

class DetailRecipeViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {
    val recipeLD = MutableLiveData<Recipes>()
    private val job = Job()

    fun addRecipe(recipes: Recipes) {
        launch {
            val db = buildDB(getApplication())
            db.recipesDao().insertAll(recipes)
        }
    }

    fun fetch(uuid: Int) {
        launch {
            val db = buildDB(getApplication())
            recipeLD.value = db.recipesDao().selectRecipes(uuid)
        }
    }

    fun update(name: String, category: String, ingredients: String, preparation: String, picURL: String, uuid: Int) {
        launch {
            val db = buildDB(getApplication())
            db.recipesDao().update(name, category, ingredients, preparation, picURL, uuid)
        }
    }

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}