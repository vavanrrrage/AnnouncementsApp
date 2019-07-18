package com.example.announcements.data.repository

import com.example.announcements.data.network.service.IApiService
import com.example.announcements.domain.model.Offer
import io.reactivex.Single

class OffersRepository(
    private val apiService: IApiService
) : IOffersRepository {
    override fun getOffers(limit: Int, offset: Int): Single<List<Offer>> {
        return apiService.getOffers(limit, offset)
    }
}