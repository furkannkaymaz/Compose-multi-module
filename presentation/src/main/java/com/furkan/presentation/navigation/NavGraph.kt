package com.furkan.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.furkan.presentation.detail.detailScreen
import com.furkan.presentation.home.homeScreen
import com.furkan.utils.Const

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Const.Route.homeRoute
    ) {
        homeScreen(
            onItemClick = {
                //
            }
        )
        detailScreen({

        })
    }
}