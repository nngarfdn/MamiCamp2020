package com.raywenderlich.android.creatures.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.creatures.R
import com.raywenderlich.android.creatures.app.inflate
import com.raywenderlich.android.creatures.model.Food
import kotlinx.android.synthetic.main.list_item_food.view.*

class FoodAdapter(private val foods : MutableList<Food>) : RecyclerView.Adapter<FoodAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_food))
    }

    override fun getItemCount()= foods.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(foods.get(position))
    }

    fun updateFoods(foods: List<Food>) {
        this.foods.clear()
        this.foods.addAll(foods)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        private lateinit var food: Food

        fun bind (food: Food) {
            this.food = food
            val context = itemView.context
            itemView.foodImages.setImageResource(context.resources.getIdentifier(food.thumbail,null, context.packageName))
        }
    }

}