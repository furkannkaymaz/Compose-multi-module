package com.furkan.model.transportation_detail

data class TransportationDetailItem(
    val economyPercentage: String,
    val environmentalImpact: String,
    val id: Int,
    val mostPreferedCountry: String,
    val type: String,
    val usagePercentage: String
)