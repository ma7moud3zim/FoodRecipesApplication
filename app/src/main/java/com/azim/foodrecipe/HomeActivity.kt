package com.azim.foodrecipe

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.azim.foodrecipe.adapter.MainCategoryAdapter
import com.azim.foodrecipe.adapter.SubCategoryAdapter
import com.azim.foodrecipe.database.RecipeDatabase
import com.azim.foodrecipe.entities.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.coroutines.launch


class HomeActivity : BaseActivity() {

    var arrMainCategory = ArrayList<cetegoryitems>()
    var arrSubCategory = ArrayList<MealsItems>()

    var mainCategoryAdapter = MainCategoryAdapter()
    var subCategoryAdapter = SubCategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Initialize the adapters of Main Recycle view with empty data
        mainCateg.layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)

        subCateg.layoutManager = LinearLayoutManager(this@HomeActivity, LinearLayoutManager.HORIZONTAL, false)
        subCateg.setHasFixedSize(true)

        getDataFromDb()
        mainCategoryAdapter.setClickListner(onClicked)
        subCategoryAdapter.setClickListner(onClickedSub)

    }

    override fun onResume() {
        super.onResume()
        // Setting the Adapters of Recycle views
        mainCateg.adapter = mainCategoryAdapter
        subCateg.adapter = subCategoryAdapter


    }

    private val onClicked = object : MainCategoryAdapter.OnItemClickListener{
        override fun onClicked(categoryName: String) {
            getMealDataFromDb(categoryName)
        }

    }


    private val onClickedSub = object : SubCategoryAdapter.OnItemClickListener{

        override fun onClicked(id: String) {
            var intent = Intent( this@HomeActivity ,DetailActivity::class.java)
            intent.putExtra("id",id)
            startActivity(intent)
        }

    }

    private fun getDataFromDb(){
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getAllCategory()
                arrMainCategory = cat as ArrayList<cetegoryitems>

                arrMainCategory.reverse()

                // Putting the default category
                getMealDataFromDb(arrMainCategory[0].strcategory)

                mainCategoryAdapter.setData(arrMainCategory)
                mainCategoryAdapter.notifyDataSetChanged();

               // mainCateg.adapter = mainCategoryAdapter
                
                /*
                val manager = LinearLayoutManager(this@HomeActivity)
                mainCateg.layoutManager = manager
                mainCateg.setHasFixedSize(true)
                mainCateg.setAdapter(mainCategoryAdapter)
                 */
            }

        }
    }


    private fun getMealDataFromDb(categoryName: String){
        tvCateg.text = "$categoryName Dishes"
        launch {
            this.let {
                var cat = RecipeDatabase.getDatabase(this@HomeActivity).recipeDao().getSpecificMealList(categoryName)
                arrSubCategory = cat as ArrayList<MealsItems>
                // Setting my data from database
                subCategoryAdapter.setData(arrSubCategory)

                subCategoryAdapter.notifyDataSetChanged();


                //subCategoryAdapter.setData(arrSubCategory)
                /* val manager = LinearLayoutManager(this@HomeActivity)
                subCateg.layoutManager = manager
                subCateg.setHasFixedSize(true)
                subCateg.setAdapter(subCategoryAdapter)
                */
            }

        }

    }


}