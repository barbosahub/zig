package com.example.features.comics.presentation.action

sealed interface MovieAction {
    data object OnRefresh : MovieAction

}