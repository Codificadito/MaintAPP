package com.example.maintapp.model

import java.io.Serializable

data class TaskExampleData(
    val id:Int,
    val name: String,
    val description: String,
    val priority: String,
    val state: String
) : Serializable
