package com.example.announcements.presentation.details

import com.example.announcements.domain.contracts.IDetailsContract
import com.example.announcements.presentation.base.viewmodel.BaseViewModel

class DetailsViewModel(
    private val screen: DetailsScreen
) : BaseViewModel<DetailsState>(), IDetailsContract.IDetailsViewModel {
    override val state: DetailsState = DetailsState()

    override fun setupActions() {
        val offer = screen.offer

        state.price.value = offer.price
        state.rooms.value = offer.rooms.toString()
        state.address.value = offer.address
        state.floors.value = offer.floors
        state.photoUrls.value = offer.photos
    }
}