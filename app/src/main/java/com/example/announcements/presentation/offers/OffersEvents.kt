package com.example.announcements.presentation.offers

import com.example.announcements.presentation.base.events.IEvent
import com.example.announcements.presentation.offers.list.OfferVM

sealed class OffersEvents : IEvent {
    class OfferPressedEvent(
        val offerVM: OfferVM
    ) : OffersEvents()
}