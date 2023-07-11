package com.furkan.presentation.home


import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.furkan.utils.Const

fun NavGraphBuilder.homeScreen(
    onItemClick: (String) -> Unit
) {
    composable(Const.Route.homeRoute) {
        HomeRoute(
            onItemClick = onItemClick
        )
    }
}