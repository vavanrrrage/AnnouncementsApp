package com.example.announcements.data.network.mappers

import com.example.announcements.data.network.model.entity.OffersResponseEntity
import com.example.announcements.domain.model.Offer

interface IApiMapper {
    fun mapOffers(offersResponseEntity: OffersResponseEntity): List<Offer>
}