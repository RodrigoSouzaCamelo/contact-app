package br.com.rodrigo.contactapp.ui.navigation

sealed class AppDestination(val route: String) {
    object Default : AppDestination("default")
    object Home : AppDestination("home")
    object FormContact : AppDestination("form-contact")
}