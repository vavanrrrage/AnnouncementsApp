package com.example.announcements.data.network.validators

import com.example.announcements.data.network.model.entity.OfferEntity

class EntityValidator : IEntityValidator {
    override fun validate(entity: OfferEntity): Boolean {
        return !entity._id.isNullOrEmpty()
                && !entity.params?.city?.name_ru.isNullOrEmpty()
                && !entity.params?.street?.name_ru.isNullOrEmpty()
                && !entity.params?.house_number.isNullOrEmpty()
                && !entity.params?.region?.name_ru.isNullOrEmpty()
                && entity.params?.floor != null
                && entity.params.price != null
                && entity.params.rooms_count != null
                && entity.params.floors_count != null
    }
}