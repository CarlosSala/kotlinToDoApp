package com.example.todoapp

import android.content.res.ColorStateList
import android.graphics.Paint
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemTodoTaskBinding

class TasksViewHolder(private var binding: ItemTodoTaskBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render(task: Task) {

        if (task.isSelected) {
            binding.tvTask.paintFlags = binding.tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            binding.tvTask.paintFlags =
                binding.tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        binding.tvTask.text = task.name
        binding.cbTask.isChecked = task.isSelected

        val color = when (task.category) {
            TaskCategory.Business -> R.color.todo_business_category
            TaskCategory.Other -> R.color.todo_other_category
            TaskCategory.Personal -> R.color.todo_personal_category
        }

        binding.cbTask.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(binding.cbTask.context, color)
        )
    }
}