package br.com.rodrigo.contactapp.ui.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument
import br.com.rodrigo.contactapp.util.CONTACT_ID

sealed class AppDestination(
    val route: String,
    val routeWithArgument: String = "",
    val arguments: List<NamedNavArgument> = emptyList()
) {
    object Login : AppDestination(route = "login")
    object Registration : AppDestination(route = "login-form")
    object Home : AppDestination(route = "home")
    object FormContact : AppDestination(
        route = "form-contact",
        routeWithArgument = "form-contact/{$CONTACT_ID}",
        arguments = listOf(
            navArgument(CONTACT_ID) {
                defaultValue = 0L
                type = NavType.LongType
            }
        )
    )
    object ContactDetails : AppDestination(
        route = "contact-details",
        routeWithArgument = "contact-details/{$CONTACT_ID}",
        arguments = listOf(
            navArgument(CONTACT_ID) {
                defaultValue = 0L
                type = NavType.LongType
            }
        )
    )
}