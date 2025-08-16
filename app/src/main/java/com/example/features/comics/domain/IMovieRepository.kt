package com.example.features.comics.domain

import com.example.core.domain.DataError
import com.example.features.comics.domain.model.MovieResponse
import com.example.core.domain.Result

interface IMovieRepository {
    suspend fun getMovie(): Result<MovieResponse, DataError.Remote>
}