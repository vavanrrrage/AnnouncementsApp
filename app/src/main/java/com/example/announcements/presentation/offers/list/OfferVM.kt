package com.example.announcements.presentation.offers.list

data class OfferVM(
    val id: String,
    val address: String,
    val floors: String,
    val rooms: Int,
    val price: String,
    val photos: List<String>
)