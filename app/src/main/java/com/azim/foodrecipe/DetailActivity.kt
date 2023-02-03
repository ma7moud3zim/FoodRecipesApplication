package com.azim.foodrecipe

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.azim.foodrecipe.entities.*
import com.azim.foodrecipe.interfaces.GetDataService
import com.azim.foodrecipe.retrofitclient.RetrofitClientInstance
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_splash.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailActivity : BaseActivity() {

    var youtubeLink = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        var id = intent.getStringExtra("id")
        getSpecificItem(id!!)

        img_toolbar_back_btn.setOnClickListener {
            finish()
        }

        yt_button.setOnClickListener {
            val uri = Uri.parse(youtubeLink)
            val intent = Intent(Intent.ACTION_VIEW, uri)
            startActivity(intent)
        }


    }

    private fun getSpecificItem(id:String) {
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getSpecificIdItem(id)

        call.enqueue(object : Callback<MealResponse> {

            override fun onFailure(call: Call<MealResponse>, t: Throwable) {
                Toast.makeText(this@DetailActivity, "LOL", Toast.LENGTH_SHORT).show()
            }


            override fun onResponse(
                    call: Call<MealResponse>,
                    response: Response<MealResponse>
            ) {


                Glide.with(this@DetailActivity).load(response.body()!!.mealsEntity[0].strMealThumb).into(img_item)


                detail_category.text = response.body()!!.mealsEntity[0].strMeal
                var ingredient = "${response.body()!!.mealsEntity[0].strIngredient1}      ${response.body()!!.mealsEntity[0].strMeasure1}\n"

                if(response.body()!!.mealsEntity[0].strIngredient2 != "")
                    ingredient += "${response.body()!!.mealsEntity[0].strIngredient2}      ${response.body()!!.mealsEntity[0].strMeasure2}\n"
                if(response.body()!!.mealsEntity[0].strIngredient3 != "")
                    ingredient += "${response.body()!!.mealsEntity[0].strIngredient3}      ${response.body()!!.mealsEntity[0].strMeasure3}\n"
                if(response.body()!!.mealsEntity[0].strIngredient4 != "")
                    ingredient +=  "${response.body()!!.mealsEntity[0].strIngredient4}      ${response.body()!!.mealsEntity[0].strMeasure4}\n"
                if(response.body()!!.mealsEntity[0].strIngredient5 != "")
                    ingredient +=  "${response.body()!!.mealsEntity[0].strIngredient5}      ${response.body()!!.mealsEntity[0].strMeasure5}\n"
                if(response.body()!!.mealsEntity[0].strIngredient6 != "")
                    ingredient +=  "${response.body()!!.mealsEntity[0].strIngredient6}      ${response.body()!!.mealsEntity[0].strMeasure6}\n"
                if(response.body()!!.mealsEntity[0].strIngredient7 != "")
                    ingredient +=   "${response.body()!!.mealsEntity[0].strIngredient7}      ${response.body()!!.mealsEntity[0].strMeasure7}\n"
                if(response.body()!!.mealsEntity[0].strIngredient8 != "")
                    ingredient +=   "${response.body()!!.mealsEntity[0].strIngredient8}      ${response.body()!!.mealsEntity[0].strMeasure8}\n"
                if(response.body()!!.mealsEntity[0].strIngredient9 != "")
                    ingredient +=  "${response.body()!!.mealsEntity[0].strIngredient9}      ${response.body()!!.mealsEntity[0].strMeasure9}\n"
                if(response.body()!!.mealsEntity[0].strIngredient10 != "")
                    ingredient +=  "${response.body()!!.mealsEntity[0].strIngredient10}      ${response.body()!!.mealsEntity[0].strMeasure10}\n"
                if(response.body()!!.mealsEntity[0].strIngredient11 != "")
                    ingredient +=  "${response.body()!!.mealsEntity[0].strIngredient11}      ${response.body()!!.mealsEntity[0].strMeasure11}\n"
                if(response.body()!!.mealsEntity[0].strIngredient12 != "")
                    ingredient +=   "${response.body()!!.mealsEntity[0].strIngredient12}      ${response.body()!!.mealsEntity[0].strMeasure12}\n"
                if(response.body()!!.mealsEntity[0].strIngredient13 != "")
                    ingredient +=   "${response.body()!!.mealsEntity[0].strIngredient13}      ${response.body()!!.mealsEntity[0].strMeasure13}\n"
                if(response.body()!!.mealsEntity[0].strIngredient14 != "")
                    ingredient += "${response.body()!!.mealsEntity[0].strIngredient14}      ${response.body()!!.mealsEntity[0].strMeasure14}\n"
                if(response.body()!!.mealsEntity[0].strIngredient15 != "")
                    ingredient +=   "${response.body()!!.mealsEntity[0].strIngredient15}      ${response.body()!!.mealsEntity[0].strMeasure15}\n"
                if(response.body()!!.mealsEntity[0].strIngredient16 != "")
                    ingredient += "${response.body()!!.mealsEntity[0].strIngredient16}      ${response.body()!!.mealsEntity[0].strMeasure16}\n"
                if(response.body()!!.mealsEntity[0].strIngredient17 != "")
                    ingredient +=  "${response.body()!!.mealsEntity[0].strIngredient17}      ${response.body()!!.mealsEntity[0].strMeasure17}\n"
                if(response.body()!!.mealsEntity[0].strIngredient18 != "")
                    ingredient +=  "${response.body()!!.mealsEntity[0].strIngredient18}      ${response.body()!!.mealsEntity[0].strMeasure18}\n"
                if(response.body()!!.mealsEntity[0].strIngredient19 != "")
                    ingredient +=  "${response.body()!!.mealsEntity[0].strIngredient19}      ${response.body()!!.mealsEntity[0].strMeasure19}\n"
                if(response.body()!!.mealsEntity[0].strIngredient20 != "")
                    ingredient += "${response.body()!!.mealsEntity[0].strIngredient20}      ${response.body()!!.mealsEntity[0].strMeasure20}\n"

                        tv_ingredients.text = ingredient
                       tv_instructions.text = response.body()!!.mealsEntity[0].strInstructions
                    if (response.body()!!.mealsEntity[0].strSource != null){
                        youtubeLink = response.body()!!.mealsEntity[0].strSource
                    }else{
                        yt_button.visibility = View.GONE
                    }
                }


        })
    }


}