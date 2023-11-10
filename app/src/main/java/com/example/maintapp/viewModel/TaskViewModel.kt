package com.example.maintapp.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maintapp.model.Task
import com.example.maintapp.repository.TaskRepository
import kotlinx.coroutines.launch

class TaskViewModel() : ViewModel() {
    private val repository = TaskRepository()

    val readAllData: LiveData<List<Task>> = repository.readAllData

    fun insertTask(task:Task) {
        viewModelScope.launch {
            repository.insertTask(task = task)
        }
    }
    fun updateTask(task: Task) {
        viewModelScope.launch {
            repository.updateTask(task = task)
        }
    }

     fun deleteTask(task: Task) {
         viewModelScope.launch {
             repository.deleteTask(task = task)
         }
     }


     fun deleteAllTasks() {
         viewModelScope.launch {
             repository.deleteAllTasks()
         }
     }
}