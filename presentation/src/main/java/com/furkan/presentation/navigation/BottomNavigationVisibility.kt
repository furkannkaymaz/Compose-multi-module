package com.furkan.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.furkan.utils.Const

@Composable
fun BottomNavigationVisibility(navController : NavController,state :MutableState<Boolean>){

    val navBackStackEntry = navController.currentBackStackEntryAsState()
    when (navBackStackEntry.value?.destination?.route) {
        Const.Route.homeRoute -> {
            state.value = true
        }
        Const.Route.searchRoute -> {
            state.value = true
        }
        Const.Route.settingsRoute -> {
            state.value = true
        }
        else -> {
            state.value = false
        }
    }
}