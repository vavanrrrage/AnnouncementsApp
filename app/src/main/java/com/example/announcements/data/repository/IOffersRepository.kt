package com.example.announcements.data.repository

import com.example.announcements.domain.model.Offer
import io.reactivex.Single

interface IOffersRepository {
    fun getOffers(limit: Int, offset: Int): Single<List<Offer>>
}