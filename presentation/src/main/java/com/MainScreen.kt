package com

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.furkan.presentation.navigation.BottomNavigation
import com.furkan.presentation.navigation.BottomNavigationVisibility
import com.furkan.presentation.navigation.NavGraph


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    BottomNavigationVisibility(navController = navController, state = bottomBarState)
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController, bottomBarState = bottomBarState)
        },
    ) {
        Box(modifier = Modifier.padding(it)) {
            NavGraph(
                navController = navController,
            )
        }
    }
}

