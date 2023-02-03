package com.azim.foodrecipe.entities.converter

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.azim.foodrecipe.entities.Category
import com.azim.foodrecipe.entities.cetegoryitems
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CategoryListConverter {
    @TypeConverter
    fun fromCategoryList(category: List<cetegoryitems>):String?{
        if (category == null){
            return (null)
        }else{
            val gson = Gson()
            val type = object : TypeToken<cetegoryitems>(){

            }.type
            return gson.toJson(category,type)
        }
    }

    @TypeConverter
    fun toCategoryList ( categoryString: String):List<cetegoryitems>?{

            val gson = Gson()
            val type = object :TypeToken<cetegoryitems>(){

            }.type
            return  gson.fromJson(categoryString,type)

    }
}