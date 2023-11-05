package com.example.maintapp

import android.app.Application

class AppMantenimiento: Application() {

    companion object {
        lateinit var instance: AppMantenimiento
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
