package com.example.features.comics.data.network

import com.example.core.domain.DataError
import com.example.core.domain.Result
import com.example.features.comics.data.network.dto.MovieResponseDto


interface IRemoteMovieDataSource {
    suspend fun getMovie(): Result<MovieResponseDto, DataError.Remote>

}