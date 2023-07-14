package com.furkan.presentation.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.furkan.utils.Const

fun NavGraphBuilder.searchScreen(
) {
    composable(
        route = Const.Route.searchRoute,
    ) { navBackStackEntry ->
        SearchRoute()
    }
}