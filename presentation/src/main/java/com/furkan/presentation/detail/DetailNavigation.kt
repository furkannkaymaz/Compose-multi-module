package com.furkan.presentation.detail
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.furkan.presentation.home.HomeRoute
import com.furkan.utils.Const

fun NavGraphBuilder.detailScreen(
    onItemClick : () -> Unit
) {
    composable(Const.Route.detailRoute) {
        DetailRoute(
            onItemClick = onItemClick
        )
    }
}