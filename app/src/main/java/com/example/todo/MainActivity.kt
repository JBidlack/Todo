package com.example.todo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        todoAdapter = TodoAdapter(mutableListOf())

        binding.rvToDoItems.adapter = todoAdapter
        binding.rvToDoItems.layoutManager = LinearLayoutManager(this)

        binding.btnTodo.setOnClickListener {
            val todoTitle = binding.etToDoTitle.text.toString()
            if(todoTitle.isNotEmpty()){
                val todo = Todo(todoTitle)
                todoAdapter.addTodo(todo)
                binding.etToDoTitle.text.clear()
            }
        }

        binding.btnDeleteDoneTodo.setOnClickListener {
            todoAdapter.deleteDone()
        }
    }
}