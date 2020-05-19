package com.raywenderlich.android.creatures.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.creatures.R
import com.raywenderlich.android.creatures.app.inflate
import com.raywenderlich.android.creatures.model.Creature
import com.raywenderlich.android.creatures.model.CreatureStore
import kotlinx.android.synthetic.main.list_item_creature_with_food.view.*

class CreatureWithFoodAdapter(private val creatures: MutableList<Creature>) : RecyclerView.Adapter<CreatureWithFoodAdapter.ViewHolder>() {


    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    val holder = ViewHolder(parent.inflate(R.layout.list_item_creature_with_food))
        viewpool(holder)

    LinearSnapHelper().attachToRecyclerView(holder.itemView.foodRecycleView)
    return holder    }

    private fun viewpool(holder: CreatureWithFoodAdapter.ViewHolder) {
    var a = holder.itemView.foodRecycleView.recycledViewPool
        a = viewPool
    }

    override fun getItemCount() = creatures.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(creatures[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val adapter = FoodAdapter(mutableListOf())
        private lateinit var creature: Creature

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(creature: Creature) {
            this.creature = creature
            val context = itemView.context
            itemView.creatureImage.setImageResource(context.resources.getIdentifier(creature.uri, null, context.packageName))
            setupFoods()
        }

        override fun onClick(view: View) {
            val context = view.context
            val intent = CreatureActivity.newIntent(context, creature.id)
            context.startActivity(intent)
        }
            private fun setupFoods() {
        itemView.foodRecycleView.layoutManager= LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL, false)
                itemView.foodRecycleView.adapter = adapter

                val foods = CreatureStore.getCreatureFoods(creature)
                adapter.updateFoods(foods)
    }
    }


}
