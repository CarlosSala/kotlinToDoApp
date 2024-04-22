package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemTodoTaskBinding

class TasksAdapter(var taskList: List<Task>, private val onTaskSelected: (Int) -> Unit) :
    RecyclerView.Adapter<TasksViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {

        val binding =
            ItemTodoTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {

        val task = taskList[position]

        holder.render(task)

        // itemView is all cell where is the item
        // when there is a click, it is activated lambda function
        holder.itemView.setOnClickListener { onTaskSelected(position) }
    }

    override fun getItemCount() = taskList.size

}