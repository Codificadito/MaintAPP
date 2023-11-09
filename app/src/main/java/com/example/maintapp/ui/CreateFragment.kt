package com.example.maintapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.maintapp.R
import com.example.maintapp.model.Task
import com.example.maintapp.databinding.FragmentCreateBinding
import com.example.maintapp.enums.TaskPriority
import com.example.maintapp.enums.TaskState

class CreateFragment : Fragment() {

    private lateinit var binding: FragmentCreateBinding
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
            val title = binding.editTitle.text.toString()
            val description = binding.editDescription.text.toString()
            val address = binding.editAddress.text.toString()
            val taskState = taskStateSelected.toString()
            val taskPriority = prioritySelected.toString()

            //validaciones
            if(title.isNotEmpty() && description.isNotEmpty() && address.isNotEmpty()){
                val task = Task(0, title, description, address, taskState, taskPriority, 1)
                findNavController().navigate(R.id.action_createFragment_to_tasksFragment)
            } else {
                Toast.makeText(requireContext(), "Complete todos los campos requeridos!", Toast.LENGTH_SHORT).show()
            }

        }

        return binding.root
    }

}