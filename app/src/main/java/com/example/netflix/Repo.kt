package com.example.netflix

class Repo {
    private val listOfMovies = mutableListOf<MovieItemClass>()

    fun getListOfMovieItems() = listOfMovies

    fun addMovieToList(movieItem: MovieItemClass){
        listOfMovies.add(movieItem)
    }

    fun getShuffledListOfMovieItems() = listOfMovies.shuffled()
}