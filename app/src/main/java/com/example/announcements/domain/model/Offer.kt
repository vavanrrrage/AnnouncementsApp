package com.example.announcements.domain.model

class Offer(
    val id: String,
    val city: String,
    val street: String,
    val houseNumber: String,
    val floor: Int,
    val floorsCount: Int,
    val roomsCount: Int,
    val photoUrls: List<String>,
    val price: Int
)