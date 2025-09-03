package br.unisanta.tp3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnMovies = findViewById<Button>(R.id.btnMovies)
        val btnTasks = findViewById<Button>(R.id.btnTasks)

        btnMovies.setOnClickListener {
            startActivity(Intent(this, MoviesActivity::class.java))
        }

        btnTasks.setOnClickListener {
            startActivity(Intent(this, TasksActivity::class.java))
        }
    }
}