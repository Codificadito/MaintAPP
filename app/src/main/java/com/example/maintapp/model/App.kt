package com.example.maintapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "task_table")
data class TaskExample(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "nombre")
    val name: String,
    @ColumnInfo(name = "descripcion")
    val description: String,
    @ColumnInfo(name = "prioridad")
    val priority: String,
    @ColumnInfo(name = "estado")
    val state: String
): Serializable
