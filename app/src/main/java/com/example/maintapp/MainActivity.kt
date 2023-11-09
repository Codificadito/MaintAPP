package com.example.maintapp

import VentanaOperario
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.ventana_operario)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclearViewTaskPend)
        val btnCrearr : Button = findViewById(R.id.btnCrearTareaa)
        val adapter = VentanaOperario()

        val intent = Intent(this, CreateActivity::class.java )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        btnCrearr.setOnClickListener{
            startActivity(intent)
        }
    }
}
