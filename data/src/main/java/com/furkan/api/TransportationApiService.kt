package com.furkan.api

import com.furkan.model.transportation.TransportationModel
import retrofit2.http.GET

interface TransportationApiService {

    @GET("api/data.json")
    suspend fun getTransportations(
    ): TransportationModel

}
