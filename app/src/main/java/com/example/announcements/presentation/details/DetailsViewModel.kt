package com.example.announcements.presentation.details

import com.example.announcements.domain.contracts.IDetailsContract
import com.example.announcements.presentation.base.viewmodel.BaseViewModel

class DetailsViewModel(
    private val screen: DetailsScreen
) : BaseViewModel<DetailsState>(), IDetailsContract.IDetailsViewModel {
    override val state: DetailsState = DetailsState()
}