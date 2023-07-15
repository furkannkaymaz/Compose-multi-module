package com.furkan.presentation.home

import android.util.Log
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
import androidx.compose.material.Card
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.furkan.compose_multi_module.presentation.R
import com.furkan.presentation.base.components.BoldText
import com.furkan.presentation.base.components.ErrorMessageCard
import com.furkan.presentation.base.components.ProgressBar
import com.furkan.presentation.base.components.SemiBoldText
import com.furkan.uiModel.transportation.TransportationUi
import com.furkan.utils.Screens

@Composable
fun HomeRoute(
    onItemClick: (Int) -> Unit,
    modifier: Modifier = Modifier,
    deeplinkData: String?,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val transportationState by viewModel.state.collectAsStateWithLifecycle()

    HomeScreen(
        state = transportationState,
        onItemClick = onItemClick,
        deeplinkData = deeplinkData,
        modifier = modifier,
    )
}

@Composable
fun HomeScreen(
    state: TransportationState,
    modifier: Modifier,
    deeplinkData: String?,
    onItemClick: (Int) -> Unit,
) {

    Log.d(Screens.HOME_SCREEN, " Deeplink Value : ${deeplinkData.toString()}")
    // adb shell am start -W -a android.intent.action.VIEW -d "example://compose/home/test"

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BoldText(text = stringResource(R.string.txt_transportation_types))

        when (state) {
            is TransportationState.Error -> {
                ErrorMessageCard(message = state.message, icon = Icons.Default.Warning)
            }

            is TransportationState.Loading -> {
                if (state.isLoading) {
                    ProgressBar()
                }
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
                type = "Type : ${item.type}",
                speedAdvantage = "Speed Advantage : ${item.speedAdvantage}",
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
            },
        backgroundColor = Color.LightGray

    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            BoldText(
                text = type,
                color = Color.Black,
                fontSize = 18.sp,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Divider(color = Color.Black, thickness = 1.dp)
            Spacer(modifier = Modifier.height(4.dp))
            SemiBoldText(
                text = speedAdvantage,
                fontSize = 14.sp
            )
        }
    }
}

