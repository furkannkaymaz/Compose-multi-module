package com.furkan.mapper

import com.furkan.base.BaseMapper
import com.furkan.model.transportation_detail.TransportationDetail
import com.furkan.model.transportation_detail.TransportationDetailItem
import com.furkan.uiModel.transportation_detail.TransportationUiDetail
import com.furkan.uiModel.transportation_detail.TransportationUiDetailItem
import javax.inject.Inject

class TransportationDetailMapper @Inject constructor() :
    BaseMapper<TransportationDetail, TransportationUiDetail> {

    override fun map(input: TransportationDetail): TransportationUiDetail {
        return TransportationUiDetail(
            mapTransportationDetail(input.transportationDetail)
        )
    }

    private fun mapTransportationDetail(input: List<TransportationDetailItem>): List<TransportationUiDetailItem> {
        return input.map {
            TransportationUiDetailItem(
                economyPercentage = it.economyPercentage,
                environmentalImpact = it.environmentalImpact,
                id = it.id,
                mostPreferedCountry = it.mostPreferedCountry,
                type = it.type,
                usagePercentage = it.usagePercentage
            )
        }
    }

}