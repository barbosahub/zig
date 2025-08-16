package com.example.features.comics.domain.repository

import com.example.core.data.network.toMovieResponse
import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.core.domain.map
import com.example.features.comics.data.network.IRemoteMovieDataSource
import com.example.features.comics.domain.IMovieRepository
import com.example.features.comics.domain.model.MovieResponse

class MovieRepository(
    private val remoteMoviePreferencesDataSource: IRemoteMovieDataSource
) : IMovieRepository {

    override suspend fun getMovie(): Result<MovieResponse, DataError.Remote> {
        return remoteMoviePreferencesDataSource
            .getMovie().map { it.toMovieResponse() }
    }
}