package br.com.rodrigo.contactapp.ui.screens.details

import java.util.*

data class ContactDetailsUiState(
    val id: Long = 0L,
    val name: String = "",
    val lastname: String = "",
    val phone: String = "",
    val profilePicture: String = "",
    val birthday: Date? = null,
)