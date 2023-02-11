package br.com.rodrigo.contactapp.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rodrigo.contactapp.database.ContactDAO
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
        private val contactDAO: ContactDAO
) : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            val contacts = contactDAO.getAll()
            contacts.collect { allContacts ->
                _uiState.value = _uiState.value.copy(
                    contacts = allContacts
                )
            }
        }
    }
}