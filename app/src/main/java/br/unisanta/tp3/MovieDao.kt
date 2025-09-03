package br.unisanta.tp3.model

interface MovieDao {
    fun addMovie(movie: Movie)
    fun getMovies(): List<Movie>
}