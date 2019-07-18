package com.example.announcements.data.network.service

import com.example.announcements.data.error.exception.ApiException
import com.example.announcements.data.network.api.OffersApi
import com.example.announcements.data.network.mappers.IApiMapper
import com.example.announcements.domain.model.Offer
import io.reactivex.Single

class ApiService(
    private val offersApi: OffersApi,
    private val apiMapper: IApiMapper
) : IApiService {

    override fun getOffers(limit: Int, offset: Int): Single<List<Offer>> {
        return offersApi.getOffers(limit = limit, offset = offset)
            .map {
                apiMapper.mapOffers(it)
            }
            .onErrorResumeNext(
                Single.error(ApiException(""))
            )
    }
}