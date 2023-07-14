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
        val argument = navBackStackEntry.arguments?.getInt("id")
        SearchRoute(onItemClick = onItemClick)
    }
}