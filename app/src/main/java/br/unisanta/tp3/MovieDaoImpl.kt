package br.unisanta.tp3.model

class MovieDaoImpl : MovieDao {
    companion object {
        private val movies = mutableListOf<Movie>()
    }

    override fun addMovie(movie: Movie) {
        movies.add(movie)
    }

    override fun getMovies(): List<Movie> {
        return movies
    }
}