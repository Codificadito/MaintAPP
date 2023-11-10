package com.example.maintapp.ui

import com.example.maintapp.R
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.maintapp.model.Task
import com.example.maintapp.TaskAdapter
import com.example.maintapp.databinding.FragmentTasksBinding
import com.example.maintapp.viewModel.TaskViewModel

class TasksFragment : Fragment(), MenuProvider {
    private lateinit var binding: FragmentTasksBinding

    private val taskViewModel by viewModels<TaskViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasksBinding.inflate(inflater,container, false)

        //tasks ejemplo
        val exampleTask1 = Task(1,"Limpieza", "descripcion limpieza", "Siempre viva 123", "Pendiente", "Mantenimiento",  com.google.android.material.R.drawable.ic_m3_chip_close)
        val exampleTask2 = Task(2,"Arreglo", "descripcion arreglo", "Wallaby 42, Sidney", "Pendiente", "Incidencia",  com.google.android.material.R.drawable.ic_clock_black_24dp)

        //deberia ir vacio el task adapter
        //val adapter = TaskAdapter(taskList = mutableListOf(exampleTask1, exampleTask2))

        val adapter = TaskAdapter()
        binding.recyclerViewTask.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTask.adapter = adapter


        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        binding.btnCrearTarea.setOnClickListener {
            findNavController().navigate(R.id.action_tasksFragment_to_createFragment)
        }

        //observador del adapter
        taskViewModel.readAllData.observe(viewLifecycleOwner) { taskList ->
            adapter.setTasks(tasks = taskList)
        }

        return binding.root
    }
    private fun deleteAll() {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setTitle("¿Quiere Eliminar Todos?")
        dialog.setMessage("¿Está Seguro?")

        dialog.setNegativeButton("No") { _, _ ->
            return@setNegativeButton
        }

        dialog.setPositiveButton("Si") { _, _ ->
            taskViewModel.deleteAllTasks()
        }

        dialog.create().show()
    }

    override fun onCreateMenu(menu : Menu, menuInflater : MenuInflater) {
        menuInflater.inflate(R.menu.delete_menu,menu)
    }

    override fun onMenuItemSelected(menuItem : MenuItem) : Boolean {
        return when (menuItem.itemId) {
            R.id.menu_delete -> {
                deleteAll()
                true
            }

            else -> {
                false
            }
        }
    }

}