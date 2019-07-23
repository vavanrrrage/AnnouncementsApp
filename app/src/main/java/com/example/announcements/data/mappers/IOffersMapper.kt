package com.example.announcements.data.mappers

import com.example.announcements.domain.model.Offer
import com.example.announcements.presentation.offers.list.OfferVM

interface IOffersMapper {
    fun map(offers: List<Offer>): List<OfferVM>

    fun map(offer: Offer): OfferVM
}