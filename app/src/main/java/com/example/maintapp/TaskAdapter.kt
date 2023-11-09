package com.example.maintapp

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.maintapp.databinding.ItemRecyclerviewTaskBinding
import com.example.maintapp.model.Task

class TaskAdapter(private val taskList: MutableList<Task>): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(private val binding: ItemRecyclerviewTaskBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(task: Task){
            //se bindean las textviews con las propiedades del obj task recibido
            with(binding){
                taskTextViewId.text = task.id.toString()
                titleTextView.text = task.title
                addressTextView.text = task.address
                descriptionTextView.text = task.description

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
        val task = taskList.get(position)
        holder.bind(task = task)
    }

    override fun getItemCount(): Int {
        return taskList.size
    }

}