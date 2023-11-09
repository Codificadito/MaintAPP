package com.example.maintapp

data class Task(
    val id: Int, // Id de la tarea
    val title: String, // Título de la tarea
    val details: String, // Detalles de la tarea
    val address: String, // Dirección de la tarea
    val imageResource: Int, // Recurso de imagen
    val taskState: String, // Estado de la tarea (Pendiente, En Progreso, Terminada)
    val urgency: String // Tipo de Tarea por prioridad (Mantenimiento, Incidencia, Urgencia)
)
