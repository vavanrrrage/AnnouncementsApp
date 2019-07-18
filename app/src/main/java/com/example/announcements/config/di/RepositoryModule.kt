package com.example.announcements.config.di

import com.example.announcements.data.repository.IOffersRepository
import com.example.announcements.data.repository.OffersRepository
import org.koin.dsl.module.module

val repositoryModule = module {
    single<IOffersRepository> {
        OffersRepository(get())
    }
}