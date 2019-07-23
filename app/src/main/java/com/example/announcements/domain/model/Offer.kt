package com.example.announcements.domain.model

class Offer(
    val id: String,
    val street: String,
    val houseNumber: String,
    val floor: Int,
    val floorsCount: Int,
    val roomsCount: Int,
    val photoUrls: List<String>,
    val price: Int,
    val totalArea: Int,
    val livingArea: Int,
    val kitchenArea: Int?
)