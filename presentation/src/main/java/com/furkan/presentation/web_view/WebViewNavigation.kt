package com.furkan.presentation.web_view

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.furkan.utils.Const

fun NavGraphBuilder.webViewScreen() {
    composable(
        Const.Route.webViewRoute.plus("?url={url}"),
        content = {
            val url = it.arguments?.getString("url")
            WebScreenRoute(
                url = url ?: ""
            )
        }
    )
}