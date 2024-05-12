package com.example.todosync

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todosync.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main)

            val getStartedButton = findViewById<Button>(R.id.startButton)
            getStartedButton.setOnClickListener {
                val intent = Intent(this, MyTasksActivity::class.java)
                startActivity(intent)
            }
        }
}


