package com.example.announcements.data.mappers

import com.example.announcements.R
import com.example.announcements.data.providers.IResourcesProvider
import com.example.announcements.domain.model.Offer
import com.example.announcements.presentation.offers.list.OfferVM

class OffersMapper(
    private val resourcesProvider: IResourcesProvider
) : IOffersMapper {
    override fun map(offers: List<Offer>): List<OfferVM> {
        return offers.map {
            map(it)
        }
    }

    override fun map(offer: Offer): OfferVM {
        return OfferVM(
            offer.id,
            resourcesProvider.getString(R.string.address_format, offer.city, offer.street, offer.houseNumber),
            resourcesProvider.getString(R.string.floor_format, offer.floor, offer.floorsCount),
            offer.roomsCount,
            resourcesProvider.getString(R.string.price_format, offer.price),
            offer.photoUrls
        )
    }
}