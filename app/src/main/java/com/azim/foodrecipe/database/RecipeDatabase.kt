package com.azim.foodrecipe.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.azim.foodrecipe.dao.RecipeDao
import com.azim.foodrecipe.entities.*
import com.azim.foodrecipe.entities.converter.CategoryListConverter
import com.azim.foodrecipe.entities.converter.MealsListConverter

@Database(entities = [Recipes::class, cetegoryitems::class, Category::class, Meal::class,MealsItems::class],version = 1,exportSchema = false )
@TypeConverters(CategoryListConverter::class , MealsListConverter::class)

abstract class RecipeDatabase : RoomDatabase() {
    companion object{
        var recipesDatabase:RecipeDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RecipeDatabase{
            if(recipesDatabase == null){
                recipesDatabase = Room.databaseBuilder(
                    context,
                    RecipeDatabase::class.java,
                    "recipe.db"
                ).build()
            }
            return recipesDatabase!!
        }
    }
    abstract fun recipeDao(): RecipeDao
}