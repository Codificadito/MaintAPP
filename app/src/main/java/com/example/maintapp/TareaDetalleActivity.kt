package com.example.maintapp

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class TareaDetalleActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ventana_operario_accion)

        // Obtener vistas
        val titleTextDetail = findViewById<TextView>(R.id.titleTextDetail)
        val descriptionTextDetail = findViewById<TextView>(R.id.descriptionTextDetail)
        val cardViewTitleDescription = findViewById<CardView>(R.id.cardViewTitleDescription)

        // Obtener datos de la tarea desde el Intent
        val taskTitle = intent.getStringExtra("tituloTarea")
        val taskDescription = intent.getStringExtra("descripcionTarea")
        val colorHex = intent.getStringExtra("colordetarea")

        // Log para verificar el valor de colorHex
        Log.d("TareaDetalleActivity", "Valor de colorHex: $colorHex")

        // Verifica si se recibió un valor hexadecimal de color
        if (colorHex != null) {
            val color = Color.parseColor(colorHex) // Convierte el valor hexadecimal en un color
            cardViewTitleDescription.setCardBackgroundColor(color)
        } else {
            // Maneja el caso en el que no se encontró un color
            cardViewTitleDescription.setCardBackgroundColor(ContextCompat.getColor(this, R.color.color_predeterminado))
            //cardViewTitleDescription.setBackgroundColor(ContextCompat.getColor(this, R.color.color_predeterminado))
        }

        // Llenar los campos con los datos de la tarea si están disponibles
        titleTextDetail.text = taskTitle
        descriptionTextDetail.text = taskDescription

        // Lógica para el botón "Atrás"
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressed() // Llama a onBackPressed para volver a la pantalla anterior
        }
    }
}