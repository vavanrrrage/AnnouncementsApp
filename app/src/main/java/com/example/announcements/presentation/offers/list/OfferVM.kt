package com.example.announcements.presentation.offers.list

import java.io.Serializable

data class OfferVM(
    val id: String,
    val address: String,
    val floors: String,
    val rooms: String,
    val price: String,
    val plan: String,
    val photos: List<String>
) : Serializable