package com.example.announcements.presentation.details

import com.example.announcements.domain.model.Offer
import me.aartikov.alligator.Screen
import java.io.Serializable

class DetailsScreen(
    val offer: Offer
) : Screen, Serializable