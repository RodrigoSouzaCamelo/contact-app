package br.com.rodrigo.contactapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.rodrigo.contactapp.R
import br.com.rodrigo.contactapp.ui.screens.form.FormContactScreen
import br.com.rodrigo.contactapp.ui.screens.form.FormContactViewModel
import br.com.rodrigo.contactapp.util.CONTACT_ID
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.formContactGraph(
    navController: NavHostController
) {
    composable(
        route = AppDestination.FormContact.routeWithArgument,
        arguments = AppDestination.FormContact.arguments
    ) { navBackStackEntry ->
        navBackStackEntry.arguments?.getLong(CONTACT_ID)?.let { idContato ->
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