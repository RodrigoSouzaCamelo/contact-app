package br.com.rodrigo.contactapp.ui.navigation

import android.content.Intent
import android.net.Uri
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import br.com.rodrigo.contactapp.R
import br.com.rodrigo.contactapp.extensions.callPhone
import br.com.rodrigo.contactapp.extensions.sendSMS
import br.com.rodrigo.contactapp.extensions.showMessage
import br.com.rodrigo.contactapp.ui.screens.details.ContactDetailsScreen
import br.com.rodrigo.contactapp.ui.screens.details.ContactDetailsViewModel
import br.com.rodrigo.contactapp.util.CONTACT_ID
import kotlinx.coroutines.launch

fun NavGraphBuilder.contactDetailsGraph(
    navController: NavHostController
) {
    composable(
        route = AppDestination.ContactDetails.routeWithArgument,
        arguments = AppDestination.ContactDetails.arguments
    ) { navBackStackEntry ->
        navBackStackEntry.arguments?.getLong(CONTACT_ID)?.let { contactId ->
            val viewModel = hiltViewModel<ContactDetailsViewModel>()
            val state by viewModel.uiState.collectAsState()

            val coroutineScope = rememberCoroutineScope()
            val context = LocalContext.current

            ContactDetailsScreen(
                state = state,
                onClickSendSMS = { context.sendSMS(state.phone) },
                onClickCallPhone = { context.callPhone(state.phone) },
                onClickBack = { navController.popBackStack() },
                onClickEdit = { navController.navigateToFormContact(contactId) },
                onDeleteContact = {
                    coroutineScope.launch {
                        viewModel.delete()
                        context.showMessage(context.getString(R.string.contact_deleted))
                        navController.popBackStack()
                    }
                },
            )
        }
    }
}