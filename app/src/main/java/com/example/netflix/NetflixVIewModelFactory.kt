package com.example.netflix

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NetflixVIewModelFactory(
    private val repo: Repo
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NetflixViewModel(repo) as T
    }
}