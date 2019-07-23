package com.example.announcements.presentation.details

import androidx.lifecycle.MutableLiveData
import com.example.announcements.presentation.base.states.IState

class DetailsState(
    val price: MutableLiveData<String> = MutableLiveData(),
    val floors: MutableLiveData<String> = MutableLiveData(),
    val rooms: MutableLiveData<String> = MutableLiveData(),
    val plan: MutableLiveData<String> = MutableLiveData(),
    val address: MutableLiveData<String> = MutableLiveData(),
    val photoUrls: MutableLiveData<List<String>> = MutableLiveData()
) : IState