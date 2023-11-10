package com.example.maintapp.ui.create

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.maintapp.R
import com.example.maintapp.model.Task
import com.example.maintapp.databinding.FragmentCreateBinding
import com.example.maintapp.enums.TaskPriority
import com.example.maintapp.enums.TaskState
import com.example.maintapp.viewModel.TaskViewModel

class CreateFragment : Fragment() {

    private lateinit var binding: FragmentCreateBinding
    private val taskViewModel by viewModels<TaskViewModel>()

    var taskStateSelected: TaskState? = null
    var prioritySelected: TaskPriority? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  FragmentCreateBinding.inflate(inflater, container, false)

        //seleccion de estado
        val taskStatesList = TaskState.values()

        binding.spinnerEstado.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                taskStateSelected = taskStatesList.get(position)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                taskStateSelected = taskStatesList.get(0)
            }
        }

        //seleccion de prioridad
        val priorityList = TaskPriority.values()

        binding.spinnerEstado.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
                prioritySelected = priorityList.get(position)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                prioritySelected = priorityList.get(0)
            }
        }

        binding.btnCreateTask.setOnClickListener{

            //Obtengo los datos de la ui
            val title = binding.editTitle.text.toString()
            val description = binding.editDescription.text.toString()
            val address = binding.editAddress.text.toString()
            val taskState = taskStateSelected.toString()
            val taskPriority = prioritySelected.toString()

            //validaciones
            if(title.isNotEmpty() && description.isNotEmpty() && address.isNotEmpty()) {

                //creamos la nueva tarea
                val task = Task(id = 0, title = title, description = description, address = address, taskState = taskState, taskPriority = taskPriority, 1)

                //se lo pasamos al view model
                taskViewModel.insertTask(task = task)
                Log.d("CreateFragment", "tarea creada: $task")

                //volvemos al listado
                findNavController().navigate(R.id.action_createFragment_to_tasksFragment)

            } else {
                Toast.makeText(requireContext(), "Complete todos los campos requeridos!", Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }

}