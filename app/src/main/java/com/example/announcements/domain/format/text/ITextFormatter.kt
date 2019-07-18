package com.example.announcements.domain.format.text

interface ITextFormatter {
    fun formatPrice(price: Int): String
}