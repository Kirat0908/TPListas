package br.unisanta.tp3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.tp3.model.Task
import br.unisanta.tp3.model.TaskDaoImpl

class TasksActivity : AppCompatActivity() {

    private val taskDao = TaskDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks)

        val edtName = findViewById<EditText>(R.id.edt_Name)
        val edtDescription = findViewById<EditText>(R.id.edt_Description)
        val btnAddTask = findViewById<Button>(R.id.btn_AddTask)
        val rvTasks = findViewById<RecyclerView>(R.id.rv_Tasks)

        val tasks = taskDao.getTasks()
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = TaskAdapter(tasks) { position ->
            tasks[position].isCompleted = true
            rvTasks.adapter?.notifyItemChanged(position)
        }

        btnAddTask.setOnClickListener {
            val name = edtName.text.toString()
            val description = edtDescription.text.toString()
            if (name.isNotEmpty() && description.isNotEmpty()) {
                taskDao.addTask(Task(name, description))
                rvTasks.adapter?.notifyDataSetChanged()
                edtName.text.clear()
                edtDescription.text.clear()
            }
        }
    }
}