package com.example.announcements.data.mappers

import com.example.announcements.R
import com.example.announcements.data.providers.IResourcesProvider
import com.example.announcements.domain.model.Offer
import com.example.announcements.presentation.offers.list.OfferVM
import java.text.DecimalFormatSymbols
import java.util.*

class OffersMapper(
    private val resourcesProvider: IResourcesProvider,
    private val locale: Locale,
    private val decimalFormatSymbols: DecimalFormatSymbols
) : IOffersMapper {
    override fun map(offers: List<Offer>): List<OfferVM> {
        return offers.map {
            map(it)
        }
    }

    override fun map(offer: Offer): OfferVM {
        return OfferVM(
            offer.id,
            resourcesProvider.getString(R.string.address_format, offer.street, offer.houseNumber),
            resourcesProvider.getString(R.string.floor_format, offer.floor, offer.floorsCount),
            resourcesProvider.getString(R.string.rooms_format, offer.roomsCount),
            resourcesProvider.getString(R.string.price_format, getFormattedPrice(offer.price)),
            offer.kitchenArea?.let {
                resourcesProvider.getString(
                    R.string.plan_format,
                    offer.totalArea / 100,
                    offer.livingArea / 100,
                    it / 100
                )
            } ?: resourcesProvider.getString(
                R.string.plan_studio_format,
                offer.totalArea / 100,
                offer.livingArea / 100
            ),
            offer.photoUrls
        )
    }

    // поискал готовое решение, но ничего такого не нашел
    private fun getFormattedPrice(value: Int): String {
        val defaultFormatted = String.format(locale, "%,d", value)
        return defaultFormatted.replace(decimalFormatSymbols.groupingSeparator.toString(), " ")
    }
}