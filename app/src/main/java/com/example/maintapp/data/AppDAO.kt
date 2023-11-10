package com.example.maintapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.maintapp.model.Task
import com.google.firebase.firestore.auth.User


@Dao
interface TaskDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(task: Task)


    @Query("SELECT * FROM task_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Task>>

    @Update
    suspend fun update(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("DELETE FROM task_table")
    suspend fun deleteAll()
}
