package com.azim.foodrecipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.azim.foodrecipe.R
import com.azim.foodrecipe.entities.cetegoryitems
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_rv_main_category.view.*



class MainCategoryAdapter : RecyclerView.Adapter<MainCategoryAdapter.RecipeViewHolder>() {

    var listner: OnItemClickListener? = null
    var ctx : Context? = null
    var arrMainCategory = ArrayList<cetegoryitems>()

    class RecipeViewHolder(view: View) :RecyclerView.ViewHolder(view){}

    fun setData(arrData : List<cetegoryitems>){
        arrMainCategory = arrData as ArrayList<cetegoryitems>
    }

    fun setClickListner(listner1:OnItemClickListener){
        listner = listner1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        ctx = parent.context
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rv_main_category,parent,false))
    }

    override fun getItemCount(): Int {
        return arrMainCategory.size
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        holder.itemView.dshs.text = arrMainCategory[position].strcategory

        Glide.with(ctx!!).load(arrMainCategory[position].strcategorythumb).into(holder.itemView.imgDsh)

        holder.itemView.rootView.setOnClickListener {
            listner!!.onClicked(arrMainCategory[position].strcategory)
        }
    }

    interface OnItemClickListener{
        fun onClicked(categoryName :String)
    }
}
