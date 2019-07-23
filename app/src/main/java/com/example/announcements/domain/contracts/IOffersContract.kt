package com.example.announcements.domain.contracts

import com.example.announcements.presentation.base.listeners.IItemClickListener
import com.example.announcements.presentation.base.viewmodel.IBaseViewModel
import com.example.announcements.presentation.base.views.IBaseView
import com.example.announcements.presentation.offers.OffersState
import com.example.announcements.presentation.offers.list.OfferVM

interface IOffersContract {
    interface IOffersView : IBaseView, IItemClickListener<OfferVM>

    interface IOffersViewModel : IBaseViewModel<OffersState>
}