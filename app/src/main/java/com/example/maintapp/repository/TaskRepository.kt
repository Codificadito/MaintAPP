package com.example.maintapp.repository

import androidx.lifecycle.LiveData
import com.example.maintapp.data.TaskDao
import com.example.maintapp.model.Task

class TaskRepository(private val taskDao: TaskDao) {
    val readAllData:LiveData<List<Task>> = taskDao.readAllData()
}