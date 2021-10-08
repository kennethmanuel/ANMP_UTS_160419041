package com.kennethmanuel.a160419041_uts.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.kennethmanuel.a160419041_uts.model.Recipe

class RecipeFavoriteModel(application: Application) : AndroidViewModel(application) {
    val recipeLD = MutableLiveData<List<Recipe>>()

    fun refresh()
    {
        val recipe1 = Recipe(
            "1",
            "Veggie Fried Rice",
            "Main course",
            "oil, carrot, garlic, onion, bell pepper, brocolli, pea, corn, egg, white rice, soy sauce, sesame oil, pepper",
            "Het oil, add ingredients, cook, enjoy!",
            "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fimg.buzzfeed.com%2Fthumbnailer-prod-us-east-1%2F97aa9be31408452591baef80ebc6b52c%2FBFV24904_FriedRice4Ways_FB1080SQ.jpg%3Foutput-quality%3D60%26resize%3D1000%3A*&f=1&nofb=1"
        )

        val recipe = arrayListOf<Recipe>(recipe1)
        recipeLD.value = recipe
    }
}
