package com.matrix.recycler

import android.app.Dialog
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.matrix.recycler.databinding.ActivityMainBinding
import com.matrix.recycler.databinding.CustomDialogBinding


class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private val list = arrayListOf<TaskDataClass>()
    private lateinit var manager: LinearLayoutManager
    private val adapter: TaskRecyclerAdapter = TaskRecyclerAdapter(this,list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        manager = LinearLayoutManager(this)
        binding?.recycler?.layoutManager = manager
        binding?.recycler?.adapter = adapter

        binding?.fab?.setOnClickListener {
            showAddTaskDialog()
        }
    }

    private fun showAddTaskDialog() {
        val dialog = Dialog(this)
        val dialogBinding = CustomDialogBinding.inflate(layoutInflater)
        dialog.setContentView(dialogBinding.root)
        dialog.show()

        val priorities = arrayOf("Low", "Medium", "High")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, priorities)
        dialogBinding.spinnerPriority.adapter = adapter

        dialogBinding.btnAdd.setOnClickListener {
            val title = dialogBinding.etTitle.text.toString()
            val description = dialogBinding.etDescription.text.toString()
            val priority = dialogBinding.spinnerPriority.selectedItemPosition + 1

            if (title.isEmpty()) {
                dialogBinding.etTitle.error = "Enter something"
            } else if (description.isEmpty()) {
                dialogBinding.etDescription.error = "Enter something"
            } else {
                list.add(TaskDataClass(title, description, priority))
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
        }
    }
}
