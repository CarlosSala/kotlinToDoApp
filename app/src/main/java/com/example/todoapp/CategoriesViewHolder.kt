package com.example.androidmaster.todoapp

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.TaskCategory
import com.example.todoapp.databinding.ItemTaskCategoryBinding


class CategoriesViewHolder(val binding: ItemTaskCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {

        val color = if (taskCategory.isSelected) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        binding.root.setCardBackgroundColor(ContextCompat.getColor(binding.root.context, color))

        // layoutPosition to get position
        itemView.setOnClickListener { onItemSelected(layoutPosition) }

        when (taskCategory) {
            TaskCategory.Business -> {
               binding.tvCategoryName.text = "Business"
                binding.vDivider.setBackgroundColor(
                    ContextCompat.getColor(binding.vDivider.context, R.color.todo_business_category)
                )
            }
            TaskCategory.Other -> {
               binding.tvCategoryName.text = "Others"
                binding.vDivider.setBackgroundColor(
                    ContextCompat.getColor(binding.vDivider.context, R.color.todo_other_category)
                )
            }
            TaskCategory.Personal -> {
               binding.tvCategoryName.text = "Personal"
                binding.vDivider.setBackgroundColor(
                    ContextCompat.getColor(binding.vDivider.context, R.color.todo_personal_category)
                )
            }
        }
    }

}