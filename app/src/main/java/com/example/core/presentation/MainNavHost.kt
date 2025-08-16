package com.example.core.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.features.comics.presentation.screen.MovieScreenRoot
import com.example.features.comics.presentation.viewmodel.MovieViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun MainNavHost() {
    Scaffold { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            val viewModel: MovieViewModel = koinViewModel()
            val state = viewModel.state.collectAsStateWithLifecycle().value
            val onAction = viewModel::onAction

            MovieScreenRoot(
                state,
                onAction
            )
        }
    }
}

