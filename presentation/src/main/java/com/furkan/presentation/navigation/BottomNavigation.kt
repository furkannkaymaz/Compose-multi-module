package com.furkan.presentation.navigation

import com.furkan.compose_multi_module.presentation.R
import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.furkan.presentation.ui.theme.bottomNavColor
import com.furkan.utils.Const

sealed class Screen(val route: String, val title: String, @DrawableRes val image: Int) {
    object Home : Screen(Const.Route.homeRoute, "Home", R.drawable.ic_menu_home)
    object Search : Screen(Const.Route.searchRoute, "Search", R.drawable.ic_menu_search)
    object Settings : Screen(Const.Route.settingsRoute, "Settings", R.drawable.ic_menu_settings)
}

@Composable
fun BottomNavigation(navController: NavController, bottomBarState: MutableState<Boolean>) {
    val items = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Settings,
    )
    AnimatedVisibility(visible = bottomBarState.value,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it }),
        ) {
        BottomNavigation(
            backgroundColor = bottomNavColor,
            contentColor = Color.White
        ) {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            items.forEach { item ->
                BottomNavigationItem(
                    icon = { Icon(painterResource(id = item.image), contentDescription = item.title) },
                    label = {
                        Text(
                            text = item.title,
                            fontSize = 12.sp
                        )
                    },
                    selectedContentColor = Color.White,
                    unselectedContentColor = Color.Black.copy(0.9f),
                    alwaysShowLabel = true,
                    selected = currentRoute == item.route,
                    onClick = {
                        navController.navigate(item.route) {

                            navController.graph.startDestinationRoute?.let { screen_route ->
                                popUpTo(screen_route) {
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}