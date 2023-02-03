package com.azim.foodrecipe.entities
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MealResponse(
    @SerializedName("meals")
    @Expose
    val mealsEntity: List<MealEntity>
)


data class MealEntity(
    @SerializedName("dateModified")
    @Expose
    val dateModified: String,
    @SerializedName("idMeal")
    @Expose
    val idMeal: String,
    @SerializedName("strArea")
    @Expose
    val strArea: String,
    @SerializedName("strCategory")
    @Expose
    val strCategory: String,
    @SerializedName("strCreativeCommonsConfirmed")
    @Expose
    val strCreativeCommonsConfirmed: String,
    @SerializedName("strDrinkAlternate")
    @Expose
    val strDrinkAlternate: String,
    @SerializedName("strImageSource")
    @Expose
    val strImageSource: String,
    @SerializedName("strIngredient1")
    @Expose
    val strIngredient1: String,
    @SerializedName("strIngredient10")
    @Expose
    val strIngredient10: String,
    @SerializedName("strIngredient11")
    @Expose
    val strIngredient11: String,
    @SerializedName("strIngredient12")
    @Expose
    val strIngredient12: String,
    @SerializedName("strIngredient13")
    @Expose
    val strIngredient13: String,
    @SerializedName("strIngredient14")
    @Expose
    val strIngredient14: String,
    @SerializedName("strIngredient15")
    @Expose
    val strIngredient15: String,
    @SerializedName("strIngredient16")
    @Expose
    val strIngredient16: String,
    @SerializedName("strIngredient17")
    @Expose
    val strIngredient17: String,
    @SerializedName("strIngredient18")
    @Expose
    val strIngredient18: String,
    @SerializedName("strIngredient19")
    @Expose
    val strIngredient19: String,
    @SerializedName("strIngredient2")
    @Expose
    val strIngredient2: String,
    @SerializedName("strIngredient20")
    @Expose
    val strIngredient20: String,
    @SerializedName("strIngredient3")
    @Expose
    val strIngredient3: String,
    @SerializedName("strIngredient4")
    @Expose
    val strIngredient4: String,
    @SerializedName("strIngredient5")
    @Expose
    val strIngredient5: String,
    @SerializedName("strIngredient6")
    @Expose
    val strIngredient6: String,
    @SerializedName("strIngredient7")
    @Expose
    val strIngredient7: String,
    @SerializedName("strIngredient8")
    @Expose
    val strIngredient8: String,
    @SerializedName("strIngredient9")
    @Expose
    val strIngredient9: String,
    @SerializedName("strInstructions")
    @Expose
    val strInstructions: String,
    @SerializedName("strMeal")
    @Expose
    val strMeal: String,
    @SerializedName("strMealThumb")
    @Expose
    val strMealThumb: String,
    @SerializedName("strMeasure1")
    @Expose
    val strMeasure1: String,
    @SerializedName("strMeasure10")
    @Expose
    val strMeasure10: String,
    @SerializedName("strMeasure11")
    @Expose
    val strMeasure11: String,
    @SerializedName("strMeasure12")
    @Expose
    val strMeasure12: String,
    @SerializedName("strMeasure13")
    @Expose
    val strMeasure13: String,
    @SerializedName("strMeasure14")
    @Expose
    val strMeasure14: String,
    @SerializedName("strMeasure15")
    @Expose
    val strMeasure15: String,
    @SerializedName("strMeasure16")
    @Expose
    val strMeasure16: String,
    @SerializedName("strMeasure17")
    @Expose
    val strMeasure17: String,
    @SerializedName("strMeasure18")
    @Expose
    val strMeasure18: String,
    @SerializedName("strMeasure19")
    @Expose
    val strMeasure19: String,
    @SerializedName("strMeasure2")
    @Expose
    val strMeasure2: String,
    @SerializedName("strMeasure20")
    @Expose
    val strMeasure20: String,
    @SerializedName("strMeasure3")
    @Expose
    val strMeasure3: String,
    @SerializedName("strMeasure4")
    @Expose
    val strMeasure4: String,
    @SerializedName("strMeasure5")
    @Expose
    val strMeasure5: String,
    @SerializedName("strMeasure6")
    @Expose
    val strMeasure6: String,
    @SerializedName("strMeasure7")
    @Expose
    val strMeasure7: String,
    @SerializedName("strMeasure8")
    @Expose
    val strMeasure8: String,
    @SerializedName("strMeasure9")
    @Expose
    val strMeasure9: String,
    @SerializedName("strSource")
    @Expose
    val strSource: String,
    @SerializedName("strTags")
    @Expose
    val strTags: String,
    @SerializedName("strYoutube")
    @Expose
    val strYoutube: String
)