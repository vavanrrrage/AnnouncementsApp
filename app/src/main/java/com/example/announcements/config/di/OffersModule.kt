package com.example.announcements.config.di

import com.example.announcements.domain.contracts.IOffersContract
import com.example.announcements.presentation.offers.OffersViewModel
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val offersModule = module {
    viewModel<OffersViewModel>()

    factory<IOffersContract.IOffersViewModel> {
        OffersViewModel(get(), get())
    }
}