package com.furkan.presentation.detail

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.furkan.utils.Const

fun NavGraphBuilder.detailScreen(
) {
    composable(
        Const.Route.detailRoute.plus("?id={transportationId}"),
        content = {
            val transportationId = it.arguments?.getString("transportationId")
            DetailRoute(
                viewModel = hiltViewModel(),
                transportationId = transportationId?.toInt() ?: 0
            )
        }
    )
}