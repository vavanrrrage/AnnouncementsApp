package com.example.announcements.config.di

import com.example.announcements.domain.format.text.ITextFormatter
import com.example.announcements.domain.format.text.TextFormatter
import org.koin.dsl.module.module

val formatModule = module {
    single<ITextFormatter> {
        TextFormatter()
    }
}