package com.example.todoapp

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.databinding.ItemTaskCategoryBinding


class CategoriesViewHolder(private val binding: ItemTaskCategoryBinding) : RecyclerView.ViewHolder(binding.root) {

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