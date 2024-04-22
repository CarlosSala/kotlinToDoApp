package com.example.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidmaster.todoapp.CategoriesViewHolder
import com.example.todoapp.TaskCategory
import com.example.todoapp.databinding.ItemTaskCategoryBinding


class CategoriesAdapter(private val categories: List<TaskCategory>, private val onItemSelected:(Int) -> Unit) :
    RecyclerView.Adapter<CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {

        val binding = ItemTaskCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return CategoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories[position], onItemSelected)
    }

    override fun getItemCount() = categories.size
}