package com.example.maintapp

import VentanaOperario
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.ventana_operario)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclearViewTaskPend)
        val btnCrear : Button = findViewById(R.id.btnCrear)
        val adapter = VentanaOperario()

        val intent = Intent(this, CreateActivity::class.java )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnCrear.setOnClickListener{
            startActivity(intent)
        }
    }
}
