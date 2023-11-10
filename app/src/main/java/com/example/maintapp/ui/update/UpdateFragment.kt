package com.example.maintapp.ui.update

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.maintapp.R
import com.example.maintapp.databinding.FragmentUpdateBinding
import com.example.maintapp.model.Task
import com.example.maintapp.viewModel.TaskViewModel

class UpdateFragment : Fragment(), MenuProvider {

    private lateinit var binding: FragmentUpdateBinding
    private val taskViewModel by viewModels<TaskViewModel>()
    private var task: Task? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)


        //recuperamos los datos y casteamos como Task
        task = arguments?.getSerializable("task") as Task //bundle

        binding.editTitle.setText(task?.title)
        binding.editDescription.setText(task!!.description)
        binding.editAddress.setText(task!!.address)

        binding.btnUpdateTask.setOnClickListener {
            validateFields(task!!)
        }

        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(this, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root
    }

    private fun validateFields(task: Task) {
        val title = binding.editTitle.text.toString()
        val description = binding.editDescription.text.toString()
        val address = binding.editAddress.text.toString()

        if (title.isNotEmpty() && description.isNotEmpty() && address.isNotEmpty()) {
            val task =  task.copy(title=title, description = description, address = address)
            taskViewModel.updateTask(task = task)

            findNavController().navigate(R.id.action_updateFragment_to_tasksFragment)
        } else {
            Toast.makeText(requireContext(), "Complete todos los campos requeridos", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
        return when(menuItem.itemId) {
            R.id.menu_delete -> {
                deleteTask()
                true
            }

            else -> {
                false
            }
        }
    }

    private fun deleteTask() {
        val dialog = AlertDialog.Builder(requireContext())

        dialog.setTitle("Eliminar tarea")
        dialog.setMessage("¿Está Seguro que desea eliminar la tarea ${task!!.id} - ${task!!.title}?")

        dialog.setNegativeButton("No") { _,_ ->
            return@setNegativeButton
        }

        dialog.setPositiveButton("Si") {  _,_ ->
            taskViewModel.deleteTask(task = task!!)
            Toast.makeText(requireContext(), "Tarea eliminada correctamente", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_tasksFragment)
        }

        dialog.create().show()
    }

}