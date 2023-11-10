package com.example.maintapp

import android.app.Application
import androidx.room.Room
import com.example.maintapp.data.TaskDB

class AppMantenimiento: Application() {

    companion object {
        lateinit var instance: AppMantenimiento

    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
