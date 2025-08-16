package com.example.features.comics.domain.model

import com.example.features.comics.data.network.dto.MovieDto
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    val page: Int,
    val movies: List<MovieDto>
)