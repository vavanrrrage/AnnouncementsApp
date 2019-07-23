package com.example.announcements.domain.contracts

import com.example.announcements.presentation.base.viewmodel.IBaseViewModel
import com.example.announcements.presentation.base.views.IBaseView
import com.example.announcements.presentation.offers.OffersState

interface IOffersContract {
    interface IOffersView : IBaseView

    interface IOffersViewModel : IBaseViewModel<OffersState>
}