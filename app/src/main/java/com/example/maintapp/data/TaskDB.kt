package com.example.maintapp.data

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.maintapp.AppMantenimiento
import com.example.maintapp.contants.Constants
import com.example.maintapp.model.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDB : RoomDatabase() {

    abstract fun taskDao(): TaskDao

    //instanciamos la base de datos con el companion object - SINGLETON
    companion object {
        @Volatile
        private var INSTANCE: TaskDB? = null

        fun getDatabase(): TaskDB {
            val tempInstance = INSTANCE

            if(tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    AppMantenimiento.instance.applicationContext,
                    TaskDB::class.java,
                    Constants.DB_NAME
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                return instance
            }
        }

    }

}
