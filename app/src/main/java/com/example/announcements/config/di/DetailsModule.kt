package com.example.announcements.config.di

import com.example.announcements.domain.contracts.IDetailsContract
import com.example.announcements.presentation.details.DetailsScreen
import com.example.announcements.presentation.details.DetailsViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val detailsModule = module {
    viewModel { (screen: DetailsScreen) ->
        DetailsViewModel(screen)
    }
    factory<IDetailsContract.IDetailsViewModel> {
        get<DetailsViewModel>()
    }
}