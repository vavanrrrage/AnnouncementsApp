package com.example.announcements.config.di

import com.example.announcements.domain.format.text.ITextFormatter
import com.example.announcements.domain.format.text.TextFormatter
import org.koin.dsl.module.module
import java.text.DecimalFormatSymbols
import java.util.*

val formatModule = module {
    single<ITextFormatter> {
        TextFormatter(get(), get())
    }

    single<Locale> {
        Locale.getDefault()
    }

    single {
        DecimalFormatSymbols(get())
    }
}