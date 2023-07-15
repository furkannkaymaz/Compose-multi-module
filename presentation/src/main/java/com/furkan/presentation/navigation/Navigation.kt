package com.furkan.presentation.navigation

import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.furkan.utils.Const

fun NavController.navigateDetail(
    transportationId: Int,
    navOptions: NavOptions? = null
) {
    this.navigate(
        Const.Route.detailRoute.plus("?id=${transportationId}"),
        navOptions
    )
}

fun NavController.navigateWebView(
    url: String,
    navOptions: NavOptions? = null
) {
    this.navigate(
        Const.Route.webViewRoute.plus("?url=${url}"),
        navOptions
    )
}