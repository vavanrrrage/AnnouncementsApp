package com.example.announcements.data.network.service

import com.example.announcements.domain.model.Offer
import io.reactivex.Single

interface IApiService {

    fun getOffers(limit: Int, offset: Int): Single<List<Offer>>

}