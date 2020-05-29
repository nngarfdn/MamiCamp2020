package com.example.listmaker

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.todo_list_view_holder.view.*

class ToDoListViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

    var listPositionTextView = itemView.itemNumber
    var listTitleTextView = itemView.itemString


}