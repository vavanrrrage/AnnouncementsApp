package com.example.announcements.data.network.validators

import com.example.announcements.data.network.model.entity.OfferEntity

class EntityValidator : IEntityValidator {
    override fun validate(entity: OfferEntity): Boolean {
        return !entity._id.isNullOrEmpty()
                && !entity.params?.house_addresses?.get(0)?.street?.name_ru.isNullOrEmpty()
                && !entity.params?.house_addresses?.get(0)?.house_number.isNullOrEmpty()
                && entity.params?.floor != null
                && entity.params.price != null
                && entity.params.rooms_count != null
                && entity.params.floors_count != null
                && entity.params.total_area != null
                && entity.params.living_area != null
    }
}