package com.example.announcements.config.di

import com.example.announcements.data.datasource.OffersDataSource
import org.koin.dsl.module.module

val dataSourceModule = module {

    single {
        OffersDataSource(get(), get())
    }
}