package com.furkan.presentation.favorites

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.furkan.utils.Const

fun NavGraphBuilder.favoritesScreen(
) {
    composable(
        route = Const.Route.favRoute,
    ) { navBackStackEntry ->
        FavoritesRoute()
    }
}