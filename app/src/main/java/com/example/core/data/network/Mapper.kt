package com.example.core.data.network

import com.example.features.comics.data.network.dto.MovieResponseDto
import com.example.features.comics.domain.model.MovieResponse

fun MovieResponseDto.toMovieResponse(): MovieResponse {
    return MovieResponse(
        page = page,
        movies = results
    )
}