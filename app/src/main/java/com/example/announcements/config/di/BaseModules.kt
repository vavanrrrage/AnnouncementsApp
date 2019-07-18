package com.example.announcements.config.di

import org.koin.dsl.module.Module

object BaseModules {
    fun getAllModules(): List<Module> {
        return listOf(
            networkModule,
            repositoryModule,
            formatModule
        )
    }
}