package com.furkan.presentation.search

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.furkan.utils.Const

fun NavGraphBuilder.searchScreen(
    onItemClick: (Int) -> Unit
) {
    composable(
        route = Const.Route.searchRoute,
    ) { navBackStackEntry ->
        SearchRoute(onItemClick = onItemClick)
    }
}