package com.furkan.presentation.home

import android.util.Log
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.compose.runtime.getValue

@Composable
fun HomeScreen(name: String, modifier: Modifier = Modifier, viewModel: HomeViewModel = hiltViewModel()) {

    val transportationState by viewModel.state.collectAsStateWithLifecycle()

    when(val value = transportationState){
        is TransportationState.Error -> {
            Log.d("State","Error")
        }
        is TransportationState.Loading -> {
            Log.d("State","Loading")
        }
        is TransportationState.TransportationDataSuccess -> {
            Log.d("State", value.transportation.toString())
        }
    }
}

