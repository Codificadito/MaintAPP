package com.example.maintapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class CreateActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.create_screen)

    }
}