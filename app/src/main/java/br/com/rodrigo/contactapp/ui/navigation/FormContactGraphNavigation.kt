package br.com.rodrigo.contactapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import br.com.rodrigo.contactapp.R
import br.com.rodrigo.contactapp.ui.screens.form.FormContactScreen
import br.com.rodrigo.contactapp.ui.screens.form.FormContactViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.formContactGraph(
    navController: NavHostController
) {
    composable(
        route = "${AppDestination.FormContact.route}/{contact-id}",
        arguments = listOf(
            navArgument("contact-id") {
                defaultValue = 0L
                type = NavType.LongType
            }
        )
    ) { navBackStackEntry ->
        navBackStackEntry.arguments?.getLong(
            "contact-id"
        )?.let { idContato ->

            val viewModel = hiltViewModel<FormContactViewModel>()
            val state by viewModel.uiState.collectAsState()
            val context = LocalContext.current

            LaunchedEffect(state.birthday) {
                viewModel.setBirthdayText(
                    context.getString(R.string.birthday)
                )
            }

            val coroutineScope = rememberCoroutineScope()

            FormContactScreen(
                state = state,
                onClickSave = {
                    coroutineScope.launch {
                        viewModel.save()
                        navController.popBackStack()
                    }
                },
                onLoadImage = {
                    viewModel.loadImage(it)
                }
            )
        }
    }
}