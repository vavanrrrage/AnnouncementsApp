package com.example.announcements.config.di

import com.example.announcements.data.network.api.OffersApi
import com.example.announcements.data.network.mappers.ApiMapper
import com.example.announcements.data.network.mappers.IApiMapper
import com.example.announcements.data.network.service.ApiService
import com.example.announcements.data.network.service.IApiService
import com.example.announcements.data.network.validators.EntityValidator
import com.example.announcements.data.network.validators.IEntityValidator
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<OffersApi> {
        get<Retrofit>().create<OffersApi>(
            OffersApi::class.java
        )
    }

    single<Retrofit> {
        Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https:api.n1.ru/api/v1/")
            .client(get())
            .build()
    }

    single<OkHttpClient> {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.addInterceptor(
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        )

        okHttpClientBuilder.build()
    }

    single {
        Gson()
    }

    single<IApiService> {
        ApiService(get(), get(), get())
    }

    single<IApiMapper> {
        ApiMapper(get())
    }

    single<IEntityValidator> {
        EntityValidator()
    }

}