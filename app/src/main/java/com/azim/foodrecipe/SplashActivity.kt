package com.azim.foodrecipe

import android.content.Intent
import android.net.eap.EapSessionConfig
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.azim.foodrecipe.database.RecipeDatabase
import com.azim.foodrecipe.entities.Category
import com.azim.foodrecipe.entities.Meal
import com.azim.foodrecipe.entities.MealsItems
import com.azim.foodrecipe.interfaces.GetDataService
import com.azim.foodrecipe.retrofitclient.RetrofitClientInstance
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions
import java.util.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.jar.Manifest

class SplashActivity : BaseActivity(), EasyPermissions.RationaleCallbacks, EasyPermissions.PermissionCallbacks {

    private var READ_STORAGE_PERM = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        readStorageTask()

        getStartBtn.setOnClickListener(){
            var intent = Intent(this@SplashActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    fun getCategories() {
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getCategoryList()
        call.enqueue(object : Callback<Category>{

            override fun onFailure(call: Call<Category>, t: Throwable) {
                Toast.makeText(this@SplashActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                    call: Call<Category>,
                    response: Response<Category>
            ) {
                for(arr in response.body()!!.categorieitems!!){
                    getMeal(arr.strcategory)
                }
                insertDataIntoRoomDb(response.body())
            }
        })
    }


    fun getMeal(categoryName:String) {
        val service = RetrofitClientInstance.retrofitInstance.create(GetDataService::class.java)
        val call = service.getMealList(categoryName)
        call.enqueue(object : Callback<Meal>{

            override fun onFailure(call: Call<Meal>, t: Throwable) {
                load.visibility = View.INVISIBLE
                Toast.makeText(this@SplashActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                    call: Call<Meal>,
                    response: Response<Meal>
            ) {
                insertMealDataIntoRoomDb(categoryName ,response.body())
            }
        })
    }

    fun insertDataIntoRoomDb(category: Category?){
        launch {
            this.let{
                for(arr in category!!.categorieitems!!){
                    RecipeDatabase.getDatabase(this@SplashActivity)
                            .recipeDao().insertCategory(arr)
                }
            }

        }

    }

    fun insertMealDataIntoRoomDb(categoryName: String,meal: Meal?){
        launch {
            this.let{
                for(arr in meal!!.mealsItems!!){
                    var mealItemModel = MealsItems(
                            arr.id,
                            arr.idMeal,
                            categoryName,
                            arr.strMeal,
                            arr.strMealThumb
                    )
                    RecipeDatabase.getDatabase(this@SplashActivity)
                            .recipeDao().insertMeal(mealItemModel)
                    Log.d("mealData", arr.toString())
                }
                getStartBtn.visibility = View.VISIBLE
            }

        }

    }

    fun clearDatabase(){
        launch {
            this.let {
                RecipeDatabase.getDatabase(this@SplashActivity).recipeDao().clearDb()
            }
        }
    }
    private fun hasReadStoragePermission():Boolean{
        return EasyPermissions.hasPermissions(this,android.Manifest.permission.READ_EXTERNAL_STORAGE)
    }
    private fun readStorageTask(){
        if(hasReadStoragePermission()){
            clearDatabase()
            getCategories()
        }else{
            EasyPermissions.requestPermissions(
                    this,
                    "This app needs acccess to your storage, Please allow",
                    READ_STORAGE_PERM,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
            )
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode,permissions,grantResults,this)
    }


    override fun onRationaleAccepted(requestCode: Int) {

    }

    override fun onRationaleDenied(requestCode: Int) {

    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

    }

    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {
        if(EasyPermissions.somePermissionPermanentlyDenied(this,perms)){
            AppSettingsDialog.Builder(this).build().show()
        }
    }


}