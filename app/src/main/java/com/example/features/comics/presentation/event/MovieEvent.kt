package com.example.features.comics.presentation.event

sealed interface MovieEvent {
    data object NavigateToDetail : MovieEvent
}