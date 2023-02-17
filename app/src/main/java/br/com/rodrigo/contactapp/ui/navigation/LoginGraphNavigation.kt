package br.com.rodrigo.contactapp.ui.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.rodrigo.contactapp.ui.screens.login.LoginScreen
import br.com.rodrigo.contactapp.ui.screens.login.LoginViewModel
import kotlinx.coroutines.launch

fun NavGraphBuilder.loginGraph(
    navController: NavHostController
) {
    composable(
        route = AppDestination.Login.route,
    ) {
        val viewModel = hiltViewModel<LoginViewModel>()
        val state by viewModel.uiState.collectAsState()

        if (state.logged) {
            LaunchedEffect(Unit) {
                navController.navigateClean(AppDestination.Home.route)
            }
        }

        val coroutineScope = rememberCoroutineScope()

        LoginScreen(
            state = state,
            onClickLogin = {
                coroutineScope.launch {
                    viewModel.tryLogin()
                }
            },
            onClickRegistration = {

            }
        )

    }

    composable(
        route = AppDestination.LoginForm.route,
    ) {

    }
}