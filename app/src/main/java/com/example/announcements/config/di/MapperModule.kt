package com.example.announcements.config.di

import com.example.announcements.data.mappers.IOffersMapper
import com.example.announcements.data.mappers.OffersMapper
import org.koin.dsl.module.module

val mapperModule = module {
    single<IOffersMapper> {
        OffersMapper(get(), get(), get())
    }
}