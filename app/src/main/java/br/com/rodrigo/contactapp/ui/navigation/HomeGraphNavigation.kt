package br.com.rodrigo.contactapp.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import br.com.rodrigo.contactapp.ui.screens.home.HomeScreen
import br.com.rodrigo.contactapp.ui.screens.home.HomeViewModel

fun NavGraphBuilder.homeGraph(
    navController: NavHostController
) {
    composable(route = AppDestination.Home.route) {
        val viewModel = hiltViewModel<HomeViewModel>()
        val state by viewModel.uiState.collectAsState()

        HomeScreen(
            state = state,
            onClickOpenDetails = {
                navController.navigateToContactDetails(it)
            },
            onClickRegistration = {
                navController.navigateToFormContact()
            }
        )
    }
}