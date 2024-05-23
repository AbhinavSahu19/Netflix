package com.example.netflix

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModelProvider
import com.example.jetpack.ContentChooser
import com.example.jetpack.FeaturedSection
import com.example.jetpack.TopBar
import com.example.jetpack.Movies as Movies
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import com.example.jetpack.MovieItemUiModel


class MainActivity : ComponentActivity() {
    private lateinit var repo: Repo
    private lateinit var viewModelFactory: NetflixVIewModelFactory
    private lateinit var viewModel: NetflixViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.setDecorFitsSystemWindows(window, false)

        repo = Repo()
        viewModelFactory = NetflixVIewModelFactory(repo)
        viewModel = ViewModelProvider(this, viewModelFactory).get(NetflixViewModel::class.java)
        //viewModel.addMovie(MovieItemClass(R.drawable.img_1))
        viewModel.addMovie(MovieItemClass(R.drawable.img_2))
        viewModel.addMovie(MovieItemClass(R.drawable.img_3))
        viewModel.addMovie(MovieItemClass(R.drawable.img_4))
        viewModel.addMovie(MovieItemClass(R.drawable.img_5))
        viewModel.addMovie(MovieItemClass(R.drawable.img_6))
        viewModel.addMovie(MovieItemClass(R.drawable.img_7))
        viewModel.addMovie(MovieItemClass(R.drawable.img_8))
        viewModel.addMovie(MovieItemClass(R.drawable.img_9))
        viewModel.addMovie(MovieItemClass(R.drawable.img_11))
        viewModel.addMovie(MovieItemClass(R.drawable.img_12))
        viewModel.addMovie(MovieItemClass(R.drawable.img_13))
        viewModel.addMovie(MovieItemClass(R.drawable.img_14))
        viewModel.addMovie(MovieItemClass(R.drawable.img_15))
        viewModel.addMovie(MovieItemClass(R.drawable.img_16))

        setContent {
            MaterialTheme {
                Column(
                    modifier = Modifier.fillMaxSize()
                        .background(Color.Black)
                        .verticalScroll(rememberScrollState())
                ) {
                    TopBar()
                    ContentChooser()
                    FeaturedSection()

                    val movieList by viewModel.shuffledListOfMovieLiveData.observeAsState(emptyList())
                    var list = movieList.shuffled()
                    Movies(movieCategory = "Recently watched", list = list)
                    list = movieList.shuffled()
                    Movies(movieCategory = "Action", list = list)
                    list = movieList.shuffled()
                    Movies(movieCategory = "Adventure", list = list)
                    list = movieList.shuffled()
                    Movies(movieCategory = "Thriller", list = list)
                    list = movieList.shuffled()
                    Movies(movieCategory = "Crime Films", list = list)
//                    list = movieList.shuffled()
//                    Movies(movieCategory = "Documentary", list = list)

                }
            }

        }
    }
}
