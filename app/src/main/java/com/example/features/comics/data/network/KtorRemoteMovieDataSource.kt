package com.example.features.comics.data.network


import com.example.core.data.network.safeCall
import com.example.core.domain.DataError
import com.example.features.comics.data.network.dto.MovieResponseDto
import com.example.core.domain.Result
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.header

private const val BEARER_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIyNjhkZWYxNjU1YzRiNGJlYWRkNjUxYjdjNDcyZjllZCIsIm5iZiI6MTc1NTI4NjgwNS44NTc5OTk4LCJzdWIiOiI2ODlmOGQxNTYzODFlM2UzNjg2NzgyZDkiLCJzY29wZXMiOlsiYXBpX3JlYWQiXSwidmVyc2lvbiI6MX0.GJ54cPKJEe6o9nhTYTKG4oH5alHzvLlTSYK_v4lt--M"
private const val BASE_URL = "https://api.themoviedb.org/3/trending/movie"


class KtorRemoteMovieDataSource(
    private val httpClient: HttpClient
) : IRemoteMovieDataSource {

    override suspend fun getMovie(): Result<MovieResponseDto, DataError.Remote> {
        return safeCall<MovieResponseDto> {
            httpClient.get("${BASE_URL}/day") {
                header("Authorization", "Bearer $BEARER_TOKEN")
            }
        }
    }
}