package br.com.rodrigo.contactapp.ui.screens.registration

data class RegistrationUiState(
    val name: String = "",
    val user: String = "",
    val password: String = "",
    val onChangeName: (String) -> Unit = {},
    val onChangeUser: (String) -> Unit = {},
    val onChangePassword: (String) -> Unit = {},
    val onClickSave: () -> Unit = {}
)
