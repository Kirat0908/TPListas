package br.unisanta.tp3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.unisanta.tp3.model.Movie
import br.unisanta.tp3.model.MovieDaoImpl

class MoviesActivity : AppCompatActivity() {

    private val movieDao = MovieDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)

        val edtTitle = findViewById<EditText>(R.id.edt_Title)
        val edtDirector = findViewById<EditText>(R.id.edt_Director)
        val btnAddMovie = findViewById<Button>(R.id.btn_AddMovie)
        val rvMovies = findViewById<RecyclerView>(R.id.rv_Movies)

        val movies = movieDao.getMovies()
        rvMovies.layoutManager = LinearLayoutManager(this)
        rvMovies.adapter = MovieAdapter(movies)

        btnAddMovie.setOnClickListener {
            val title = edtTitle.text.toString()
            val director = edtDirector.text.toString()
            if (title.isNotEmpty() && director.isNotEmpty()) {
                movieDao.addMovie(Movie(title, director))
                rvMovies.adapter?.notifyDataSetChanged()
                edtTitle.text.clear()
                edtDirector.text.clear()
            }
        }
    }
}