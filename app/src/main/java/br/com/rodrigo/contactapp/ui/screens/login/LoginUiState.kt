package br.com.rodrigo.contactapp.ui.screens.login

data class LoginUiState(
    val user: String = "",
    val password: String = "",
    val showError: Boolean = false,
    val onError: (Boolean) -> Unit = {},
    val onChangeUser: (String) -> Unit = {},
    val onChangePassword: (String) -> Unit = {},
    val onClickSignIn: () -> Unit = {},
    val logged: Boolean = false
)
