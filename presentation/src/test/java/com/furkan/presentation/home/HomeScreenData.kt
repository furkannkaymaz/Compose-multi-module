package com.furkan.presentation.home

import com.furkan.uiModel.transportation.TransportationModelUi
import com.furkan.uiModel.transportation.TransportationUi

object HomeScreenData {

    val transportationList =
        TransportationModelUi(listOf(
            TransportationUi("Low","Bus",1),
            TransportationUi("High","Train",2),
            TransportationUi("Walking","Low",3)
        ))

    const val errorText = "Error Message"
}