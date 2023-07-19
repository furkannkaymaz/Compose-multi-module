package com.furkan.presentation.search


import com.furkan.uiModel.transportation.TransportationModelUi
import com.furkan.uiModel.transportation.TransportationUi

object SearchScreenData {
    const val searchQueryHome = "Bus"
    const val searchFail = ""
    const val errorMessage = "Item not found"

    val transportationList =
        TransportationModelUi(
            listOf(
                TransportationUi("Low", "Bus", 1),
                TransportationUi("High", "Train", 2),
                TransportationUi("Walking", "Low", 3)
            )
        )

}