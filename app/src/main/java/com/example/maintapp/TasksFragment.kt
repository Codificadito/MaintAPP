package com.example.maintapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maintapp.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {
    private lateinit var binding: FragmentTasksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasksBinding.inflate(inflater,container, false)
        val exampleTask = Task(1,"Limpieza", "descripcion limpieza", "Siempre viva 123", android.R.drawable.arrow_down_float, "Pendiente", "Mantenimiento")
        val adapter = TaskAdapter(taskList = mutableListOf(exampleTask))
        binding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTask.adapter = adapter

        return binding.root
    }

}