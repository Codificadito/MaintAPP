package com.example.maintapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "task_table")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int, // Id de la tarea
    @ColumnInfo(name = "title")
    val title: String, // Título de la tarea
    @ColumnInfo(name = "description")
    val description: String, // Detalles de la tarea
    @ColumnInfo(name = "address")
    val address: String, // Dirección de la tarea
    @ColumnInfo(name = "state")
    val taskState: String, // Estado de la tarea (Pendiente, En Progreso, Completado)
    @ColumnInfo(name = "priority")
    val taskPriority: String,// Tipo de Tarea por prioridad (Mantenimiento, Incidencia, Urgencia)

    val imageResource: Int, // Recurso de imagen
): Serializable


