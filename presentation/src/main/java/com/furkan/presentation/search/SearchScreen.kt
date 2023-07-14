package com.furkan.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.furkan.presentation.base.components.ErrorMessageCard
import com.furkan.presentation.base.components.ProgressBar
import com.furkan.presentation.base.components.SearchBox
import com.furkan.presentation.home.TransportationList

@Composable
fun SearchRoute(
    modifier: Modifier = Modifier,
    viewModel: SearchViewModel = hiltViewModel(),
    onItemClick: (Int) -> Unit,
) {

    val transportationState by viewModel.state.collectAsStateWithLifecycle()

    SearchScreen(
        modifier = modifier,
        state = transportationState,
        onQueryTextChange = {
            viewModel.onQueryTextChange(it)
        },
        onItemClick = onItemClick,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    modifier: Modifier,
    state: TransportationSearchState,
    onQueryTextChange: (String) -> Unit,
    onItemClick: (Int) -> Unit,

) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBox(placeholder = "Search", onTextChange = {
            onQueryTextChange(it)
        })
        when (state) {
            is TransportationSearchState.Error -> {
                ErrorMessageCard(message = state.message, icon = Icons.Default.Warning)
            }

            is TransportationSearchState.Loading -> {
                if (state.isLoading) {
                    ProgressBar()
                }
            }

            is TransportationSearchState.TransportationDataSuccess -> {
                state.transportation.transportation?.let {
                    TransportationList(transportationList = it, transportationClick = onItemClick)
                }
            }
        }
    }
}