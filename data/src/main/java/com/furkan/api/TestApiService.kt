package com.furkan.api

import retrofit2.http.GET

internal interface TestApiService {

    @GET("test/transportation")
    suspend fun getTransportations(
    ): List<Nothing>

}
