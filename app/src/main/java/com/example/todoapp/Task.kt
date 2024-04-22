package com.example.todoapp

import com.example.todoapp.TaskCategory

data class Task (val name:String, val category: TaskCategory, var isSelected:Boolean = false)