package com.example.maintapp

import android.app.Application
import androidx.room.Room
import com.example.maintapp.data.TaskDB

class AppMantenimiento: Application() {

    companion object {
        lateinit var instance: AppMantenimiento
        var db: TaskDB? = null
        fun getDatabase(): TaskDB? {
            return db
        }

    }

    override fun onCreate() {
        super.onCreate()
        db= Room.databaseBuilder(applicationContext, TaskDB::class.java,"DB").allowMainThreadQueries().build()
        instance = this
    }
}
