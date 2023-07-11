package com.furkan.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailRoute(
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val transportationDetailState by viewModel.state.collectAsStateWithLifecycle()

    DetailScreen(
        state = transportationDetailState,
        onItemClick = onItemClick,
        modifier = modifier,
    )
}

@Composable
fun DetailScreen(
    state: TransportationDetailState,
    modifier: Modifier = Modifier,
    onItemClick: () -> Unit,
) {

}