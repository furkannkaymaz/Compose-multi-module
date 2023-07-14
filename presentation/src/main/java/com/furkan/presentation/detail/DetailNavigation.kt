package com.furkan.presentation.detail

import android.content.Intent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navDeepLink
import com.furkan.utils.Const

fun NavGraphBuilder.detailScreen(
    onBackPressed: () -> Unit
) {
    composable(
        route =Const.Route.detailRoute.plus("?id={transportationId}"),
        deepLinks = listOf(navDeepLink {
            uriPattern = "example://compose/detail/{transportationId}"
            action = Intent.ACTION_VIEW
        }),
        arguments = listOf(
            navArgument("transportationId") {
                type = NavType.StringType
                defaultValue = ""
            }
        ),
        content = {
            val transportationId = it.arguments?.getString("transportationId")
            val deeplink = it.arguments?.getString("transportationId")
            val value  = if (deeplink.isNullOrEmpty()){
                deeplink
            }else{
                transportationId
            }
            DetailRoute(
                viewModel = hiltViewModel(),
                transportationId = value?.toInt() ?: 0,
                onBackPressed = onBackPressed
            )
        }
    )
}