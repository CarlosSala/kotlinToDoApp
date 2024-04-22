package com.example.todoapp

// isSelected is for all object, true makes that all categories are blue
sealed class TaskCategory(var isSelected: Boolean = true) {

    data object Personal : TaskCategory()
    data object Business : TaskCategory()
    data object Other : TaskCategory()
}
