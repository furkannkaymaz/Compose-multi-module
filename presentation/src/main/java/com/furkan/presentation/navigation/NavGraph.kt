package com.furkan.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.furkan.presentation.detail.detailScreen
import com.furkan.presentation.favorites.favoritesScreen
import com.furkan.presentation.home.homeScreen
import com.furkan.presentation.search.searchScreen
import com.furkan.presentation.settings.settingScreen
import com.furkan.utils.Const

@Composable
fun NavGraph(navController : NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Const.Route.homeRoute,
    ) {
        homeScreen(
            onItemClick = {
                navController.navigateDetail(it)
            }
        )
        detailScreen()
        searchScreen()
        settingScreen()
        favoritesScreen()
    }
}