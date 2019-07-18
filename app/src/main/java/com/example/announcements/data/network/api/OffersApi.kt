package com.example.announcements.data.network.api

import com.example.announcements.data.network.model.entity.OffersResponseEntity
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface OffersApi {
    @GET("offers")
    fun getOffers(
        @Query("filter[region_id]") regionId: String = "1054",
        @Query("query[0][deal_type]") dealType: String = "sell",
        @Query("query[0][rubric]") rubric: String = "flats",
        @Query("query[0][status]") status: String = "published",
        @Query("sort") sort: String = "-creation_date",
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Single<OffersResponseEntity>
}