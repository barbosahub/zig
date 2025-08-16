package com.example.di

import com.example.core.data.network.HttpClientFactory
import com.example.features.comics.data.network.IRemoteMovieDataSource
import com.example.features.comics.data.network.KtorRemoteMovieDataSource
import com.example.features.comics.domain.IMovieRepository
import com.example.features.comics.domain.repository.MovieRepository
import com.example.features.comics.presentation.viewmodel.MovieViewModel
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.bind
import org.koin.dsl.module

val sharedModule = module {
    // Data module
    single { HttpClientFactory.create() }

    // Remote
    singleOf(::KtorRemoteMovieDataSource).bind<IRemoteMovieDataSource>()

    // Repository
    singleOf(::MovieRepository).bind<IMovieRepository>()

    // Presentation modules
    viewModel { MovieViewModel(get()) }
}
