package com.example.announcements.data.network.validators

import com.example.announcements.data.network.model.entity.OfferEntity

interface IEntityValidator {
    fun validate(entity: OfferEntity): Boolean
}