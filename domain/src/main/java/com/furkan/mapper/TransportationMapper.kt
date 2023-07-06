package com.furkan.mapper

import com.furkan.base.BaseListMapper
import com.furkan.base.BaseMapper

import com.furkan.model.Transportation
import com.furkan.model.TransportationModel
import com.furkan.uiModel.TransportationModelUi
import com.furkan.uiModel.TransportationUi
import javax.inject.Inject

class TransportationMapper @Inject constructor() :
    BaseMapper<TransportationModel, TransportationModelUi> {

    override fun map(input: TransportationModel): TransportationModelUi {
        return TransportationModelUi(
            mapTransportation(input.transportation)
        )
    }
    private fun mapTransportation(input: List<Transportation>): List<TransportationUi> {
        return input.map {
            TransportationUi(
                speedAdvantage = it.speedAdvantage,
                type = it.type
            )
        }
    }

}