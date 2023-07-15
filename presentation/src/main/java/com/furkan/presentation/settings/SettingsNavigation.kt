package com.furkan.presentation.settings

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.furkan.utils.Const

fun NavGraphBuilder.settingScreen(
    onWebViewClick: (String) -> Unit
) {
    composable(
        route = Const.Route.settingsRoute,
    ) { navBackStackEntry ->
        SettingsRoute(giveMeStarClick = onWebViewClick)
    }
}