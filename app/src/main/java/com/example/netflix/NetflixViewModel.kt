package com.example.netflix

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NetflixViewModel(
    private val repo: Repo
): ViewModel() {
    val listOfMovieLiveData = MutableLiveData<List<MovieItemClass>>()
    val shuffledListOfMovieLiveData = MutableLiveData<List<MovieItemClass>>()

    fun getAllData(){
        val allMovies = repo.getListOfMovieItems()
        listOfMovieLiveData.value = allMovies
    }
    fun addMovie(movieItem: MovieItemClass){
        repo.addMovieToList(movieItem)
        listOfMovieLiveData.value = repo.getListOfMovieItems()
        shuffledListOfMovieLiveData.value = repo.getShuffledListOfMovieItems()
    }
    fun getShuffledList(){
        val allShuffledMovie = repo.getShuffledListOfMovieItems()
        shuffledListOfMovieLiveData.value = allShuffledMovie
    }
}