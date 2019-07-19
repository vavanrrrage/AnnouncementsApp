package com.example.announcements.presentation.details

import com.example.announcements.R
import com.example.announcements.domain.contracts.IDetailsContract
import com.example.announcements.presentation.base.views.BaseActivity

class DetailsActivity : BaseActivity<IDetailsContract.IDetailsViewModel, DetailsState>(),
    IDetailsContract.IDetailsView {
    override val layoutId: Int = R.layout.activity_details

    override fun setupViewModel() {
        viewModel = getViewModel<DetailsViewModel, DetailsScreen>()
    }
}