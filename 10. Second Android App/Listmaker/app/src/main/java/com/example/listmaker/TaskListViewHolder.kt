package com.example.listmaker

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_view_holder.view.*

class TaskListViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
    val taskTextView = itemView.textview_task
}