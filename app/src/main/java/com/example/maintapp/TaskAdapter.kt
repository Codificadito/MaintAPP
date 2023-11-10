package com.example.maintapp

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.maintapp.databinding.ItemRecyclerviewTaskBinding
import com.example.maintapp.enums.TaskPriority
import com.example.maintapp.model.Task

class TaskAdapter(): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var taskList = emptyList<Task>()

    inner class TaskViewHolder(private val binding: ItemRecyclerviewTaskBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(task: Task){
            //se bindean las textviews con las propiedades del obj task recibido
            with(binding){
                val id = task.id.toString()
                taskTextViewId.text = "Id: $id -"
                titleTextView.text = task.title
                addressTextView.text = task.address
                descriptionTextView.text = task.description
                stateChip.text = task.taskState

                val stateColorHex = getColorForState(task.taskPriority, itemView.context)
                val cardView = itemView.findViewById<CardView>(R.id.layoutItemRecycler)
                cardView.setCardBackgroundColor(stateColorHex)

                root.setOnClickListener {
                    Log.d("taskAdapter","la tarea es: $task" ) //log para ver la task a editar
                    val bundle = Bundle()
                    bundle.putSerializable("task", task)
                    itemView.findNavController().navigate(R.id.action_tasksFragment_to_updateFragment, bundle)
                }

            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskAdapter.TaskViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerviewTaskBinding.inflate(inflater, parent, false)
        return TaskViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: TaskAdapter.TaskViewHolder, position: Int) {
        val task = taskList[position]
        holder.bind(task = task)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

    fun setTasks(tasks: List<Task>) {
        taskList = tasks
        notifyDataSetChanged()
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