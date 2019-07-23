package com.example.announcements.presentation.offers

import com.example.announcements.presentation.base.events.IEvent

sealed class OffersEvents : IEvent {
    class ItemPressedEvent(
        val position: Int
    ) : OffersEvents()
}