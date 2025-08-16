package com.example.features.comics.presentation.screen

import MovieCard
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.presentation.components.TopBarNavigation
import com.example.features.comics.presentation.action.MovieAction
import com.example.features.comics.presentation.state.MovieState
import androidx.compose.ui.Alignment

@Preview
@Composable
private fun MovieScreenPreview() {
    MaterialTheme {
        MovieScreen(
            state = MovieState(),
            onAction = {}
        )
    }
}


@Composable
fun MovieScreenRoot(
    state: MovieState,
    onAction: (MovieAction) -> Unit
) {
    MaterialTheme {
        MovieScreen(
            state = state,
            onAction = onAction,
        )
    }
}
@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun MovieScreen(
    state: MovieState,
    onAction: (MovieAction) -> Unit
) {
    val pullRefreshState = rememberPullRefreshState(
        refreshing = state.isLoading,
        onRefresh = { onAction(MovieAction.OnRefresh) }
    )

    Column(modifier = Modifier.fillMaxSize()) {
        TopBarNavigation(title = "Comics")

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .pullRefresh(pullRefreshState)
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(state.result?.movies ?: emptyList()) { movie ->
                    MovieCard(
                        title = movie.title,
                        subtitle = movie.overview,
                        imageUrl = "https://image.tmdb.org/t/p/w500${movie.posterPath}"
                    )
                }
            }

            PullRefreshIndicator(
                refreshing = state.isLoading,
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}
