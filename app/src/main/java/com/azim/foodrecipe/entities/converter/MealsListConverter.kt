package com.azim.foodrecipe.entities.converter

import androidx.room.TypeConverter
import com.azim.foodrecipe.entities.MealsItems
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MealsListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<MealsItems>):String?{
        if (category == null){
            return (null)
        }else{
            val gson = Gson()
            val type = object : TypeToken<MealsItems>(){

            }.type
            return gson.toJson(category,type)
        }
    }

    @TypeConverter
    fun toCategoryList ( categoryString: String):List<MealsItems>?{

            val gson = Gson()
            val type = object :TypeToken<MealsItems>(){

            }.type
            return  gson.fromJson(categoryString,type)

    }
}