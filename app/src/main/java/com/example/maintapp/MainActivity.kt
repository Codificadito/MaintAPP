package com.example.maintapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.ventana_operario)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclearViewTaskPend)
        val adapter = VentanaOperario()

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter




    }


}