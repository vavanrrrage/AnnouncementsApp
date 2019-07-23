package com.example.announcements.config.di

import androidx.paging.PagedList
import com.example.announcements.data.providers.IResourcesProvider
import com.example.announcements.data.providers.ResourcesProvider
import org.koin.dsl.module.module

val uiModule = module {
    single<IResourcesProvider> {
        ResourcesProvider(get())
    }

    single {
        PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setPageSize(20)
            .build()
    }
}