package com.example.announcements.domain.contracts

import com.example.announcements.presentation.base.viewmodel.IBaseViewModel
import com.example.announcements.presentation.base.views.IBaseView
import com.example.announcements.presentation.details.DetailsState

interface IDetailsContract {
    interface IDetailsView : IBaseView

    interface IDetailsViewModel : IBaseViewModel<DetailsState>
}