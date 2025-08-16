package com.example.features.comics.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.onError
import com.example.core.domain.onSuccess
import com.example.features.comics.domain.IMovieRepository
import com.example.features.comics.presentation.action.MovieAction
import com.example.features.comics.presentation.event.MovieEvent
import com.example.features.comics.presentation.state.MovieState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MovieViewModel(
    val movieRepository: IMovieRepository
) : ViewModel() {
    private val _state = MutableStateFlow(MovieState())

    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Companion.WhileSubscribed(5000L),
        initialValue = _state.value
    )

    init {
        getMovie()
    }

    private val _event = Channel<MovieEvent>()
    val event = _event.receiveAsFlow()

    fun onAction(action: MovieAction) {
        when (action) {
            is MovieAction.OnRefresh -> getMovie()
        }
    }

    private fun getMovie() = viewModelScope.launch {
        delay(2000) // Delay somente para simular um loading de servidor

        _state.update {
            it.copy(
                isLoading = true,
                result = null,
                errorMessage = null
            )
        }

        movieRepository.getMovie()
            .onSuccess { result ->
                _state.update {
                    it.copy(
                        isLoading = false,
                        result = result,
                        errorMessage = null
                    )
                }
            }
            .onError { error ->
                Log.e("getMovie", "error: $error")
            }
    }
}