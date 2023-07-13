package com.furkan.presentation.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.furkan.presentation.base.components.NormalText

@Composable
fun DetailRoute(
    modifier: Modifier = Modifier,
    transportationId: Int,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val transportationDetailState by viewModel.state.collectAsStateWithLifecycle()

    DetailScreen(
        transportationDetailState = transportationDetailState,
        modifier = modifier,
        transportationId = transportationId,
        getTransportations = { viewModel.getTransportations(transportationId) }
    )
}

@Composable
fun DetailScreen(
    modifier: Modifier,
    transportationDetailState: TransportationDetailState,
    transportationId: Int,
    getTransportations: (Int) -> Unit
) {
    getTransportations.invoke(transportationId)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        when (val value = transportationDetailState) {
            is TransportationDetailState.Error -> {
                // handle error
            }

            is TransportationDetailState.Loading -> {
                // handle progress
            }

            is TransportationDetailState.TransportationDataSuccess -> {
                DetailItem(
                    economyPercentage = value.transportation.economyPercentage,
                    environmentalImpact = value.transportation.environmentalImpact,
                    mostPreferedCountry = value.transportation.mostPreferedCountry
                )
            }
        }
    }
}

@Composable
fun DetailItem(
    economyPercentage: String,
    environmentalImpact: String,
    mostPreferedCountry: String,
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        NormalText(
            text = "EconomyPercentage: $economyPercentage",
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        NormalText(
            text = "Desc: $environmentalImpact",
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        NormalText(
            text = "URL: $mostPreferedCountry",
            fontSize = 14.sp,
        )
    }
}