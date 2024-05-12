package com.example.todosync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.todosync.databinding.ActivityMainBinding
import com.example.todosync.databinding.ActivityUpdateTaskBinding

class UpdateTaskActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateTaskBinding
    private lateinit var db: TaskDatabaseHelper
    private var taskId: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDatabaseHelper(this)

        taskId = intent.getIntExtra("task_id", -1)
        if(taskId == -1){
            finish()
            return
        }

        val task = db.getTaskByID(taskId)
        binding.updateTitleEditText.setText(task.title)
        binding.updateContentEditText.setText(task.content)

        binding.updateSaveButton.setOnClickListener{
            val newTitle = binding.updateTitleEditText.text.toString()
            val newContent = binding.updateContentEditText.text.toString()
            val updatedTask = Task(taskId, newTitle, newContent)
            db.updateTask(updatedTask)
            finish()
            Toast.makeText(this, "Changes Saved", Toast.LENGTH_LONG).show()
        }

    }
}