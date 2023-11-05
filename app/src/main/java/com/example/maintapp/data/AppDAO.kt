package com.example.maintapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.maintapp.model.Task


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(task: Task)


    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<Task>>

    @Update
    fun update(task: Task)
}
