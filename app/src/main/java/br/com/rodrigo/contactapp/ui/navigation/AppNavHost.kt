package br.com.rodrigo.contactapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Login.route,
        modifier = modifier
    ) {
        loginGraph(navController)
        homeGraph(navController)
        formContactGraph(navController)
        contactDetailsGraph(navController)
    }
}

fun NavHostController.navigateClean(route: String) = this.navigate(route) {
    popUpTo(0)
}

fun NavHostController.navigateToFormContact(contactId: Long = 0L) {
    navigate("${AppDestination.FormContact.route}/$contactId")
}

fun NavHostController.navigateToContactDetails(contactId: Long) {
    navigate("${AppDestination.ContactDetails.route}/$contactId")
}