package com.example.maintapp.ui

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maintapp.model.Task
import com.example.maintapp.TaskAdapter
import com.example.maintapp.databinding.FragmentTasksBinding

class TasksFragment : Fragment() {
    private lateinit var binding: FragmentTasksBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasksBinding.inflate(inflater,container, false)
        val exampleTask1 = Task(1,"Limpieza", "descripcion limpieza", "Siempre viva 123", "Pendiente", "Mantenimiento",  R.drawable.arrow_down_float)
        val exampleTask2 = Task(2,"Arreglo", "descripcion arreglo", "Wallaby 42, Sidney", "Pendiente", "Incidencia",  R.drawable.arrow_down_float)
        val adapter = TaskAdapter(taskList = mutableListOf(exampleTask1, exampleTask2))
        binding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTask.adapter = adapter

        binding.btnCrearTarea.setOnClickListener {
            findNavController().navigate(com.example.maintapp.R.id.action_tasksFragment_to_createFragment)
        }

        return binding.root
    }

}