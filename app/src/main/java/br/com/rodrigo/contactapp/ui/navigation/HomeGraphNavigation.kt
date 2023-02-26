package br.com.rodrigo.contactapp.ui.navigation

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.rodrigo.contactapp.ui.screens.home.HomeScreen
import br.com.rodrigo.contactapp.ui.screens.home.HomeViewModel
import kotlinx.coroutines.launch

fun NavGraphBuilder.homeGraph(
    navController: NavHostController
) {
    composable(route = AppDestination.Home.route) {
        val viewModel = hiltViewModel<HomeViewModel>()
        val state by viewModel.uiState.collectAsState()

        val coroutineScope = rememberCoroutineScope()
        HomeScreen(
            state = state,
            onClickSignOut = {
                coroutineScope.launch {
                    viewModel.signOut(  )
                    navController.navigateToLogin()
                }
            },
            onClickOpenDetails = {
                navController.navigateToContactDetails(it)
            },
            onClickRegistration = {
                navController.navigateToFormContact()
            }
        )
    }
}