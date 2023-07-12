package com.furkan.presentation.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailRoute(
    modifier: Modifier = Modifier,
    transportationId: Int,
    viewModel: DetailViewModel = hiltViewModel()
) {

    DetailScreen(
        viewModel = viewModel,
        transportationId = transportationId,
        modifier = modifier,
    )
}

@Composable
fun DetailScreen(
    modifier: Modifier,
    viewModel: DetailViewModel,
    transportationId: Int
) {
    viewModel.getTransportations(transportationId)
    val newsDetailState by viewModel.state.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        when (val value = newsDetailState) {
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
        Text(
            text = "economyPercentage: $economyPercentage",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Desc: $environmentalImpact",
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "URL: $mostPreferedCountry",
            fontSize = 14.sp,
        )
    }
}