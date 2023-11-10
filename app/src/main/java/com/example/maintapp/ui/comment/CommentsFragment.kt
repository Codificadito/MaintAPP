package com.example.maintapp.ui.comment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.maintapp.R
import com.example.maintapp.databinding.FragmentCommentsBinding
import com.example.maintapp.enums.TaskPriority
import com.example.maintapp.model.Task

class CommentsFragment : Fragment() {

    private lateinit var binding: FragmentCommentsBinding
    private var task: Task? =  null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommentsBinding.inflate(inflater, container, false)

        task = arguments?.getSerializable("task") as Task //bundle

        binding.titleTextDetail.setText(task?.title)
        binding.descriptionTextDetail.setText(task!!.description)

        val stateColorHex = getColorForState(task!!.taskPriority, requireContext())
        binding.cardViewTitleDescription.setCardBackgroundColor(stateColorHex)


        //Navegacion a la lista de Tasks
        binding.backButton.setOnClickListener{
            findNavController().navigate(R.id.action_commentsFragment_to_tasksFragment)
        }

        //Navegacion a la edicion de la Task
        binding.editTaskButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putSerializable("task", task)
            findNavController().navigate(R.id.action_commentsFragment_to_updateFragment, bundle)
        }

        return binding.root
    }


    private fun getColorForState(taskPriority: String, context: Context): Int {
        return when (taskPriority) {
            TaskPriority.MANTENIMIENTO.toString() -> ContextCompat.getColor(context, R.color.color_mantenimiento)
            TaskPriority.INCIDENCIA.toString() -> ContextCompat.getColor(context, R.color.color_incidencia)
            TaskPriority.URGENCIA.toString() -> ContextCompat.getColor(context, R.color.color_urgencia)
            else -> ContextCompat.getColor(context, R.color.color_predeterminado)
        }
    }

}