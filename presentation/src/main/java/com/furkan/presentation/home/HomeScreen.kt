package com.furkan.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkan.uiModel.transportation.TransportationUi

@Composable
fun HomeRoute(
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val transportationState by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = transportationState,
        onItemClick = onItemClick,
        modifier = modifier,
    )
}

@Composable
fun HomeScreen(
    state: TransportationState,
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        when (state) {
            is TransportationState.Error -> {
                // handle error
            }

            is TransportationState.Loading -> {
                // handle progress
            }

            is TransportationState.TransportationDataSuccess -> {
                state.transportation.transportation?.let {
                    TransportationList(transportationList = it, transportationClick = onItemClick)
                }
            }
        }
    }
}


@Composable
fun TransportationList(
    transportationList: List<TransportationUi>,
    transportationClick: (Int) -> Unit,
) {
    LazyColumn {
        items(transportationList) { item ->
            TransportationItem(
                type = "Type ${item.type}",
                speedAdvantage = "Speed Advantage ${item.speedAdvantage}",
                id = item.id,
                transportationClick = transportationClick
            )
        }
    }
}

@Composable
fun TransportationItem(
    type: String,
    speedAdvantage: String,
    id: Int,
    transportationClick: (Int) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(30.dp))
            .clickable {
                transportationClick(id)
            }
            .background(Color.Blue)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = type,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = speedAdvantage,
                color = Color.Black,
                fontSize = 14.sp
            )
        }
    }
}

