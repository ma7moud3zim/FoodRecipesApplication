package com.azim.foodrecipe.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.azim.foodrecipe.entities.*

@Dao
interface RecipeDao {

    @Query("SELECT * From cetegoryitems ORDER BY id DESC")
    suspend fun getAllCategory() : List<cetegoryitems>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(categoryItems: cetegoryitems?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeal(MealItems: MealsItems?)

    @Query ("Delete from cetegoryitems")
    suspend fun clearDb()

    @Query("SELECT * From MealsItems where categoryName = :cat ORDER BY id DESC")
    suspend fun getSpecificMealList(cat : String) : List<MealsItems>

}