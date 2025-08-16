package com.example.features.comics.presentation.state

import com.example.features.comics.domain.model.MovieResponse

data class MovieState(
    val isLoading: Boolean = false,
    val result: MovieResponse? = null,
    val errorMessage: String? = null
)