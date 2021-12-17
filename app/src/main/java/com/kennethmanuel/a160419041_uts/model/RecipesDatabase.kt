package com.kennethmanuel.a160419041_uts.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kennethmanuel.a160419041_uts.util.MIGRATION_1_2
import com.kennethmanuel.a160419041_uts.util.MIGRATION_2_3

@Database(entities = arrayOf(Recipes::class), version=3)
abstract class RecipesDatabase:RoomDatabase() {
    abstract fun recipesDao():RecipesDao

    companion object {
        @Volatile private var instance: RecipesDatabase ?= null

        private val LOCK = Any()

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            RecipesDatabase::class.java,
            "newrecipesdb"
        )
            .addMigrations(MIGRATION_1_2, MIGRATION_2_3)
            .build()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK)
        {
            instance ?: buildDatabase(context).also {
                instance = it
            }
        }

    }
}