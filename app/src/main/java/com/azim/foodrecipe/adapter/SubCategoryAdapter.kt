package com.azim.foodrecipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azim.foodrecipe.R
import com.azim.foodrecipe.entities.MealsItems
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_rv_sub_category.view.*

class SubCategoryAdapter : RecyclerView.Adapter<SubCategoryAdapter.RecipeViewHolder>() {

    var listner: OnItemClickListener? = null
    var ctx : Context? = null
    var arrSubCategory = ArrayList<MealsItems>()

    class RecipeViewHolder(view : View) :RecyclerView.ViewHolder(view){}

    fun setData(arrData : List<MealsItems>){
        arrSubCategory = arrData as ArrayList<MealsItems>
    }

    fun setClickListner(listner1: OnItemClickListener){
        listner = listner1
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_sub_category,parent,false))
    }

    override fun getItemCount(): Int {
        return arrSubCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.dshName.text = arrSubCategory[position].strMeal

        Glide.with(ctx!!).load(arrSubCategory[position].strMealThumb).into(holder.itemView.img_dsh)

        holder.itemView.rootView.setOnClickListener {
            listner!!.onClicked(arrSubCategory[position].idMeal)
        }
    }

    interface OnItemClickListener{
        fun onClicked(id :String)
    }

}
