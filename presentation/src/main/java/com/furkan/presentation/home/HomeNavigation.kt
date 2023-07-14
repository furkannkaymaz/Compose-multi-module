package com.furkan.presentation.home

import android.content.Intent
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.furkan.utils.Const

fun NavGraphBuilder.homeScreen(
    onItemClick: (Int) -> Unit
) {
    composable(
        route = Const.Route.homeRoute,
        deepLinks = listOf(navDeepLink {
            uriPattern = "example://compose/home/{name}"
            action = Intent.ACTION_VIEW
        }),
        arguments = listOf(
            navArgument("name") {
                type = NavType.StringType
                defaultValue = ""
            }
        )
    ) { navBackStackEntry ->
        val argument = navBackStackEntry.arguments?.getString("name")
        HomeRoute(onItemClick = onItemClick, deeplinkData = argument)
    }
}