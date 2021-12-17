package com.kennethmanuel.a160419041_uts.model

import androidx.room.*

@Dao
interface RecipesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg recipes: Recipes)

    @Query("SELECT * FROM recipes")
    suspend fun selectAllRecipes(): List<Recipes>

    @Query("SELECT * FROM recipes WHERE uuid= :id")
    suspend fun selectRecipes(id:Int): Recipes

    @Query("SELECT * FROM recipes WHERE is_liked=1")
    suspend fun selectIsLiked(): List<Recipes>

    @Query("UPDATE recipes SET name=:name, category=:category, ingredients=:ingredients, preparation=:preparation, picURL=:picURL WHERE uuid=:id")
    suspend fun update(name: String, category: String, ingredients: String, preparation: String, picURL: String, id: Int)

    @Query("UPDATE recipes SET is_liked=1 WHERE uuid=:uuid")
    suspend fun updateLiked(uuid:Int)

    @Delete
    suspend fun deleteRecipes(recipes: Recipes)
}