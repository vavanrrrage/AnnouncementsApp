package com.example.announcements.domain.format.text

import java.text.DecimalFormatSymbols
import java.util.*

class TextFormatter(
    private val locale: Locale,
    private val decimalFormatSymbols: DecimalFormatSymbols
) : ITextFormatter {
    override fun formatPrice(price: Int): String {
        val defaultFormatted = String.format(locale, "%,d", price)
        return defaultFormatted.replace(decimalFormatSymbols.groupingSeparator.toString(), " ")
    }
}