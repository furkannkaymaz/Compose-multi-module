package com

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.navigation.compose.rememberNavController
import com.furkan.presentation.navigation.BottomNavigation
import com.furkan.presentation.navigation.BottomNavigationVisibility
import com.furkan.presentation.navigation.NavGraph

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenView() {
    val navController = rememberNavController()
    val bottomBarState = rememberSaveable { (mutableStateOf(true)) }
    BottomNavigationVisibility(navController = navController, state = bottomBarState)
    Scaffold(
        bottomBar = {
            BottomNavigation(navController = navController, bottomBarState = bottomBarState)
        }
    ) {
        NavGraph(
            navController = navController,
        )
    }
}

