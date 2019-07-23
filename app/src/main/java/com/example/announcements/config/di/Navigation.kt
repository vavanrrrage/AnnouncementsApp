package com.example.announcements.config.di

import me.aartikov.alligator.AndroidNavigator
import me.aartikov.alligator.Navigator
import me.aartikov.alligator.navigationfactories.GeneratedNavigationFactory
import org.koin.dsl.module.module

val navigationModule = module {
    single {
        AndroidNavigator(GeneratedNavigationFactory())
    } bind Navigator::class
}