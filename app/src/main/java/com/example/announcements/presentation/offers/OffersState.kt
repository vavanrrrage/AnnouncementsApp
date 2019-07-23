package com.example.announcements.presentation.offers

import androidx.lifecycle.MutableLiveData
import androidx.paging.PagedList
import com.example.announcements.data.network.NetworkState
import com.example.announcements.presentation.base.states.BaseState
import com.example.announcements.presentation.offers.list.OfferVM

class OffersState(
    val networkState: MutableLiveData<NetworkState>,
    val offersPagedList: MutableLiveData<PagedList<OfferVM>>
) : BaseState()