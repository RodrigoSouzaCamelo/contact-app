package br.com.rodrigo.contactapp.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import br.com.rodrigo.contactapp.ui.screens.home.HomeScreen

fun NavGraphBuilder.homeGraph(
    navController: NavHostController
) {
    navigation(
        startDestination = AppDestination.Home.route,
        route = AppDestination.Default.route,
    ) {
        composable(route = AppDestination.Home.route) {
            HomeScreen()
        }
    }
}