package com.example.maintapp

import VentanaOperario
import ViewLogin
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
        setContentView(R.layout.login_view)

        // Reemplaza el contenedor con el fragmento ViewLogin
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, ViewLogin())
            .commit()

    }

    fun abrirVentanaUsuario() {
        val intent = Intent(this, AppMantenimiento::class.java)
        startActivity(intent)
    }

    fun abrirVentanaOperario() {
        val intent = Intent(this, VentanaOperario::class.java)
        startActivity(intent)
    }

    /*
    val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewTaskPend)
    val btnCrearr : Button = findViewById(R.id.btnCrearTareaa)
    val adapter = VentanaOperario()

    val intent = Intent(this, CreateActivity::class.java )
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = adapter

    btnCrearr.setOnClickListener{
        startActivity(intent)
    }
    */
}
