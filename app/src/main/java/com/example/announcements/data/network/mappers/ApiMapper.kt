package com.example.announcements.data.network.mappers

import com.example.announcements.data.network.model.entity.OfferEntity
import com.example.announcements.data.network.model.entity.OffersResponseEntity
import com.example.announcements.data.network.validators.IEntityValidator
import com.example.announcements.domain.model.Offer

class ApiMapper(
    private val entityValidator: IEntityValidator
) : IApiMapper {
    override fun mapOffers(offersResponseEntity: OffersResponseEntity): List<Offer> {
        return offersResponseEntity.result
            .filter { entityValidator.validate(it) }
            .map { parseEntity(it) }
    }

    private fun parseEntity(entity: OfferEntity): Offer {
        return Offer(
            entity._id ?: "",
            entity.params?.house_addresses?.get(0)?.street?.name_ru ?: "",
            entity.params?.house_addresses?.get(0)?.house_number ?: "",
            entity.params?.floor ?: 1,
            entity.params?.floors_count ?: 1,
            entity.params?.rooms_count ?: 1,
            entity.photos?.map { it.photo ?: "" } ?: emptyList(),
            entity.params?.price ?: 0,
            entity.params?.total_area ?: 0,
            entity.params?.living_area ?: 0,
            entity.params?.kitchen_area
        )
    }

}