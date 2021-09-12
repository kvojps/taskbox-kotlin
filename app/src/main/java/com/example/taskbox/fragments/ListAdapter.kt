package com.example.taskbox.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.taskbox.R
import com.example.taskbox.data.Task
import kotlinx.android.synthetic.main.item_task.view.*

class ListAdapter : RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var taskList = emptyList<Task>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = taskList[position]
        holder.itemView.text_view.text = currentItem.task
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setTask (task: List<Task>) {
        this.taskList = task
        notifyDataSetChanged()
    }
}