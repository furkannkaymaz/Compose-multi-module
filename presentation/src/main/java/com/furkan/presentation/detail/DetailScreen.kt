package com.furkan.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.furkan.compose_multi_module.presentation.R
import com.furkan.presentation.base.components.ErrorMessageCard
import com.furkan.presentation.base.components.NormalText
import com.furkan.presentation.base.components.ProgressBar
import com.furkan.presentation.base.components.TopContent

@Composable
fun DetailRoute(
    modifier: Modifier = Modifier,
    transportationId: Int,
    viewModel: DetailViewModel = hiltViewModel(),
    onBackPressed: () -> Unit
) {
    val transportationDetailState by viewModel.state.collectAsStateWithLifecycle()

    DetailScreen(
        transportationDetailState = transportationDetailState,
        modifier = modifier,
        transportationId = transportationId,
        getTransportations = { viewModel.getTransportations(transportationId) },
        onBackPressed = onBackPressed
    )
}

@Composable
fun DetailScreen(
    modifier: Modifier,
    transportationDetailState: TransportationDetailState,
    transportationId: Int,
    getTransportations: (Int) -> Unit,
    onBackPressed: () -> Unit
) {
    getTransportations.invoke(transportationId)

    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TopContent(onBackPressed = onBackPressed)

        when (transportationDetailState) {
            is TransportationDetailState.Error -> {
                ErrorMessageCard(
                    message = stringResource(R.string.txt_something_went_wrong),
                    icon = Icons.Default.Warning
                )
            }

            is TransportationDetailState.Loading -> {
                ProgressBar()
            }

            is TransportationDetailState.TransportationDataSuccess -> {
                DetailItem(
                    economyPercentage = transportationDetailState.transportation.economyPercentage,
                    environmentalImpact = transportationDetailState.transportation.environmentalImpact,
                    mostPreferedCountry = transportationDetailState.transportation.mostPreferedCountry
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
            fontSize = 22.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        NormalText(
            text = "Environmental Impact: $environmentalImpact",
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        NormalText(
            text = "Most Prefered Country: $mostPreferedCountry",
            fontSize = 18.sp,
        )
    }
}