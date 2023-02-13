package br.com.rodrigo.contactapp.ui.screens.details

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rodrigo.contactapp.database.ContactDAO
import br.com.rodrigo.contactapp.models.Contact
import br.com.rodrigo.contactapp.util.CONTACT_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactDetailsViewModel @Inject constructor(
    private val contactDAO: ContactDAO,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val contactId = savedStateHandle.get<Long>(CONTACT_ID)

    private val _uiState = MutableStateFlow(ContactDetailsUiState())
    val uiState: StateFlow<ContactDetailsUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            loadContact()
        }
    }

    private suspend fun loadContact() {
        contactId?.let { it ->
            val contactResult = contactDAO.getById(it)
            contactResult.collect { contactCollected ->
                contactCollected?.let(::setUiState)
            }
        }
    }

    private fun setUiState(contact: Contact) {
        with(contact) {
            _uiState.update {
                it.copy(
                    id = id,
                    name = name,
                    lastname = lastname,
                    phone = phone,
                    profilePicture = profilePicture,
                    birthday = birthday
                )
            }
        }
    }

    suspend fun delete() {
        contactId?.let {
            contactDAO.delete(it)
        }
    }
}