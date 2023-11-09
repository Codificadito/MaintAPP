package com.example.maintapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maintapp.databinding.ItemRecyclerviewTaskBinding

class TaskAdapter(private val taskList: MutableList<Task>): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(private val binding: ItemRecyclerviewTaskBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(task: Task){
            //se bindean las textviews con las propiedades del obj task recibido
            with(binding){
                taskTextViewId.text = task.id.toString()
                titleTextView.text = task.title
                addressTextView.text = task.address
                descriptionTextView.text = task.details
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