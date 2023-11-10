package com.example.maintapp.repository

import androidx.lifecycle.LiveData
import com.example.maintapp.data.TaskDB
import com.example.maintapp.data.TaskDao
import com.example.maintapp.model.Task

class TaskRepository {

    private val taskDao = TaskDB.getDatabase().taskDao()
    val readAllData:LiveData<List<Task>> = taskDao.readAllData()

    suspend fun insertTask(task: Task) {
        taskDao.insert(task = task )
    }
    suspend fun updateTask(task: Task) {
        taskDao.update(task = task)
    }

//    suspend fun deleteTask(task: Task) {
//        taskDao.deleteTask(task = task)
//    }
//    suspend fun deleteAllTasks() {
//        taskDao.deleteAll()
//    }
}