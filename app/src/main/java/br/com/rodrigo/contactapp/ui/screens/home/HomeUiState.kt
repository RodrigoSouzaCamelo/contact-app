package br.com.rodrigo.contactapp.ui.screens.home

import br.com.rodrigo.contactapp.models.Contact

data class HomeUiState(
    val contacts: List<Contact> = emptyList()
)