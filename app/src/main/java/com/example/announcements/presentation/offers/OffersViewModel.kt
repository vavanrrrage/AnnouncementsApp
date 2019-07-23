package com.example.announcements.presentation.offers

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.announcements.data.datasource.OffersDataSource
import com.example.announcements.domain.contracts.IOffersContract
import com.example.announcements.domain.executor.MainThreadExecutor
import com.example.announcements.presentation.base.events.IEvent
import com.example.announcements.presentation.base.viewmodel.BaseViewModel
import com.example.announcements.presentation.details.DetailsScreen
import com.example.announcements.presentation.offers.list.OfferVM
import java.util.concurrent.Executors

class OffersViewModel(
    private val dataSource: OffersDataSource,
    private val config: PagedList.Config
) : BaseViewModel<OffersState>(), IOffersContract.IOffersViewModel {
    override val state: OffersState = OffersState(
        dataSource.networkState,
        MutableLiveData()
    )

    override fun setup(forceUse: Boolean) {
        val pagedList: PagedList<OfferVM> = PagedList.Builder(dataSource, config)
            .setNotifyExecutor(MainThreadExecutor())
            .setFetchExecutor(Executors.newSingleThreadExecutor())
            .build()

        state.offersPagedList.value = pagedList
    }

    override fun onEventChanged(event: IEvent) {
        when (event) {
            is OffersEvents.OfferPressedEvent -> {
                navigator.goForward(DetailsScreen(event.offerVM))
            }
        }
    }
}