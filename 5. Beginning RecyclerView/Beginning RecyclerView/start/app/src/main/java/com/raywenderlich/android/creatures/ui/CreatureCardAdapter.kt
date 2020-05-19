package com.raywenderlich.android.creatures.ui

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.core.content.ContextCompat
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.RecyclerView
import com.raywenderlich.android.creatures.R
import com.raywenderlich.android.creatures.app.Constans
import com.raywenderlich.android.creatures.app.inflate
import com.raywenderlich.android.creatures.model.Creature
import kotlinx.android.synthetic.main.list_item_creature.view.creatureImage
import kotlinx.android.synthetic.main.list_item_creature_card.view.creatureCard
import kotlinx.android.synthetic.main.list_item_creature_card.view.fullname
import kotlinx.android.synthetic.main.list_item_creature_card.view.nameHolder
import kotlinx.android.synthetic.main.list_item_creature_card_jupiter.view.*
import java.util.*
import java.util.Collections.swap

class CreatureCardAdapter(private val creatures: MutableList<Creature>)
    : RecyclerView.Adapter<CreatureCardAdapter.ViewHolder>(), ItemTouchHelperListener {


    var scrollDirection = ScrolDirection.DOWN
    var jupiterSpanSize = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            ViewType.OTHER.ordinal -> ViewHolder(parent.inflate(R.layout.list_item_creature_card))
            ViewType.MARS.ordinal -> ViewHolder(parent.inflate(R.layout.list_item_creature_card_mars))
            ViewType.JUPITER.ordinal -> ViewHolder(parent.inflate(R.layout.list_item_creature_card_jupiter))
            else -> throw IllegalAccessException()
        }
    }

    override fun getItemCount() = creatures.size

    override fun getItemViewType(position: Int): Int {

        return when (creatures[position].planet) {
            Constans.JUPITER -> ViewType.JUPITER.ordinal
            Constans.MARS -> ViewType.MARS.ordinal
            else -> ViewType.OTHER.ordinal
        }

    }

    fun spanSizeAtPosition(position: Int): Int {
        return if (creatures[position].planet == Constans.JUPITER) {
            jupiterSpanSize
        } else {
            1
        }
    }

    override fun onItemMove(recyclerView: RecyclerView, fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition){
                Collections.swap(creatures, i, i +1)
            }
        } else{
            for (i in fromPosition downTo  toPosition + 1) {
                Collections.swap(creatures,i,i-1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(creatures[position])
    }

    override fun onItemDismiss(viewHolder: RecyclerView.ViewHolder, position: Int) {
       
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private lateinit var creature: Creature

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(creature: Creature) {
            this.creature = creature
            val context = itemView.context
            val imageresources = context.resources.getIdentifier(creature.uri, null, context.packageName)
            itemView.creatureImage.setImageResource(imageresources)
            itemView.fullname.text = creature.fullName
            setBackgroundColors(context, imageresources)
            animateView(itemView)
        }

        override fun onClick(view: View) {
            val context = view.context
            val intent = CreatureActivity.newIntent(context, creature.id)
            context.startActivity(intent)
        }

        fun setBackgroundColors(context: Context, imageresources: Int) {
            val image = BitmapFactory.decodeResource(context.resources, imageresources)
            Palette.from(image).generate { palette ->
                val backgroundColor = palette!!.getDominantColor(ContextCompat.getColor(context, R.color.colorPrimary))
                itemView.creatureCard.setBackgroundColor(backgroundColor)
                itemView.nameHolder.setBackgroundColor(backgroundColor)
                val textColor = if (isColordark(backgroundColor)) Color.WHITE else Color.BLACK
                itemView.fullname.setTextColor(textColor)
                if (itemView.slogan != null) {
                    itemView.slogan.setTextColor(textColor)
                }
            }
        }

        private fun isColordark(color: Int): Boolean {
            val darkness = 1 - (0.299 * Color.red(color) + 0.537 * Color.green(color) + 0.114 * Color.blue(color)) // 255
            return darkness >= 0.5
        }

        private fun animateView(viewToAnimate: View) {
            if (viewToAnimate.animation == null) {

                val animation = AnimationUtils.loadAnimation(viewToAnimate.context, R.anim.scale_xy)
                viewToAnimate.animation = animation
            }
        }
    }

    enum class ScrolDirection {
        UP, DOWN
    }

    enum class ViewType {
        JUPITER, MARS, OTHER
    }


}
