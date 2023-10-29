package com.example.maintapp

data class Task(
    val title: String, // Título de la tarea
    val details: String, // Detalles de la tarea
    val address: String, // Dirección de la tarea
    val imageResource: Int, // Recurso de imagen
    val urgency: String // Estado de urgencia (Mantenimiento, Incidencia, Urgencia)
)
