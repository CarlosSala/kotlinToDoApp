package com.example.todoapp

import android.app.Dialog
import android.os.Bundle
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.todoapp.databinding.ActivityMainBinding
import com.example.todoapp.databinding.DialogTaskBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bindingDialog: DialogTaskBinding

    // list of elements for first RV
    private val categoryList = listOf(
        TaskCategory.Business,
        TaskCategory.Personal,
        TaskCategory.Other
    )

    // list of elements for second RV
    private val tasks = mutableListOf(

        Task("TestBusiness", TaskCategory.Business),
        Task("TestPersonal", TaskCategory.Personal),
        Task("TestOther", TaskCategory.Other)
    )

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var tasksAdapter: TasksAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        initListeners()
    }

    private fun initListeners() {

        binding.fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {

        val dialog = Dialog(this)

        bindingDialog = DialogTaskBinding.inflate(layoutInflater)
        dialog.setContentView(bindingDialog.root)

        bindingDialog.btnAddTask.setOnClickListener {

            val currentTask = bindingDialog.etDialogNewTask.text.toString()

            if (currentTask.isNotEmpty()) {

                val selectedIdRB = bindingDialog.rgDialog.checkedRadioButtonId
                val selectedRadioButton: RadioButton =
                    bindingDialog.rgDialog.findViewById(selectedIdRB)

                val currentCategory: TaskCategory = when (selectedRadioButton.text) {

                    getString(R.string.todo_dialog_business) -> TaskCategory.Business
                    getString(R.string.todo_dialog_personal) -> TaskCategory.Personal
                    else -> TaskCategory.Other
                }

                tasks.add(Task(currentTask, currentCategory))
                updateTasks()
                dialog.hide()
            }
        }

        dialog.show()
    }

    private fun initUI() {

        rvCategories = binding.rvCategories
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        categoriesAdapter = CategoriesAdapter(categoryList) {
                position -> updateCategories(position)
        }

        rvCategories.adapter = categoriesAdapter

        rvTasks = binding.rvTask
        rvTasks.layoutManager = LinearLayoutManager(this)

        tasksAdapter = TasksAdapter(tasks) { position -> onItemSelected(position) }
        rvTasks.adapter = tasksAdapter
    }

    private fun onItemSelected(position: Int) {

        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateCategories(position: Int) {

        categoryList[position].isSelected = !categoryList[position].isSelected
        categoriesAdapter.notifyItemChanged(position)
        updateTasks()
    }

    private fun updateTasks() {

        // only show task of categories selected
        val selectedCategories: List<TaskCategory> = categoryList.filter { it.isSelected }
        val newTasks = tasks.filter { selectedCategories.contains(it.category) }
        tasksAdapter.taskList = newTasks
        tasksAdapter.notifyDataSetChanged()
    }
}