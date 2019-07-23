package com.example.announcements.data.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.PositionalDataSource
import com.example.announcements.data.mappers.IOffersMapper
import com.example.announcements.data.network.NetworkState
import com.example.announcements.data.network.service.IApiService
import com.example.announcements.extensions.observeOnMain
import com.example.announcements.extensions.subscribeOnIO
import com.example.announcements.presentation.offers.list.OfferVM

class OffersDataSource(
    private val apiService: IApiService,
    private val offersMapper: IOffersMapper
) : PositionalDataSource<OfferVM>() {

    val networkState = MutableLiveData<NetworkState>()

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<OfferVM>) {
        networkState.postValue(NetworkState.LOADING)
        apiService.getOffers(params.requestedLoadSize, params.requestedStartPosition)
            .subscribeOnIO()
            .observeOnMain()
            .subscribe({
                networkState.postValue(NetworkState.LOADED)
                callback.onResult(offersMapper.map(it), 0)
            }, {
                networkState.postValue(NetworkState.error(it.message))
            })
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<OfferVM>) {
        networkState.postValue(NetworkState.LOADING)
        apiService.getOffers(params.loadSize, params.startPosition)
            .subscribeOnIO()
            .observeOnMain()
            .subscribe({
                networkState.postValue(NetworkState.LOADED)
                callback.onResult(offersMapper.map(it))
            }, {
                networkState.postValue(NetworkState.error(it.message))
            })
    }
}