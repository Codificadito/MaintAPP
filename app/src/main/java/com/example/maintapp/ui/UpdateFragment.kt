package com.example.maintapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.maintapp.R
import com.example.maintapp.databinding.FragmentUpdateBinding
import com.example.maintapp.model.Task

class UpdateFragment : Fragment() {

    private lateinit var binding: FragmentUpdateBinding
    private var task: Task? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdateBinding.inflate(inflater, container, false)

        //recuperamos los datos y casteamos como Task
        task = arguments?.getSerializable("task") as Task
        binding.editTitle.setText(task?.title)
        binding.editDescription.setText(task!!.description)
        binding.editAddress.setText(task!!.address)

        binding.btnUpdateTask.setOnClickListener {
            val title = binding.editTitle.text.toString()
            val description = binding.editDescription.text.toString()
            val address = binding.editAddress.text.toString()

            findNavController().navigate(R.id.action_updateFragment_to_tasksFragment)

        }

        return binding.root
    }

}