package com.azim.foodrecipe.interfaces

import com.azim.foodrecipe.entities.Category
import com.azim.foodrecipe.entities.Meal
import com.azim.foodrecipe.entities.MealResponse
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query
import java.util.*

interface GetDataService {
    @GET("categories.php")
    fun getCategoryList(): Call<Category>


    @GET("filter.php")
    fun getMealList(@Query("c") category: String): Call<Meal>

    @GET("lookup.php")
    fun getSpecificIdItem(@Query("i")id: String): Call<MealResponse>

}