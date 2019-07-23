package com.example.announcements.presentation.details

import com.example.announcements.domain.contracts.IDetailsContract
import com.example.announcements.domain.model.Offer
import com.example.announcements.presentation.base.viewmodel.BaseViewModel

class DetailsViewModel(
    private val screen: DetailsScreen
) : BaseViewModel<DetailsState>(), IDetailsContract.IDetailsViewModel {
    override val state: DetailsState = DetailsState()

    override fun setupActions() {
        val offer = screen.offer

        state.price.value = offer.price.toString()
        state.rooms.value = offer.roomsCount.toString()
        state.address.value = getAddress(offer)
        state.floors.value = "${offer.floor}/${offer.floorsCount}"
        state.photoUrls.value = offer.photoUrls
    }

    private fun getAddress(offer: Offer): String {
        // todo add formatter for address
        return ""
    }
}