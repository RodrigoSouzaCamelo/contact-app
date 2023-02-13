package br.com.rodrigo.contactapp.ui.screens.form

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rodrigo.contactapp.R
import br.com.rodrigo.contactapp.database.ContactDAO
import br.com.rodrigo.contactapp.extensions.convertToDate
import br.com.rodrigo.contactapp.extensions.convertToString
import br.com.rodrigo.contactapp.models.Contact
import br.com.rodrigo.contactapp.util.CONTACT_ID
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormContactViewModel @Inject constructor(
    private val contactDAO: ContactDAO,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val contactId = savedStateHandle.get<Long>(CONTACT_ID)

    private val _uiState = MutableStateFlow(FormContactUiState())
    val uiState: StateFlow<FormContactUiState>
        get() = _uiState.asStateFlow()

    init {
        viewModelScope.launch { loadContact() }

        _uiState.update { state ->
            state.copy(onChangeName = {
                _uiState.value = _uiState.value.copy(
                    name = it
                )
            }, onChangeLastname = {
                _uiState.value = _uiState.value.copy(
                    lastname = it
                )
            }, onChangePhone = {
                _uiState.value = _uiState.value.copy(
                    phone = it
                )
            }, onChangeProfilePicture = {
                _uiState.value = _uiState.value.copy(
                    profilePicture = it
                )
            }, onChangeBirthday = {
                _uiState.value = _uiState.value.copy(
                    birthday = it.convertToDate(),
                    showBoxDialogDate = false
                )
            }, onShowImageBoxDialog = {
                _uiState.value = _uiState.value.copy(
                    showImageBoxDialog = it
                )
            }, onShowBoxDialogDate = {
                _uiState.value = _uiState.value.copy(
                    showBoxDialogDate = it
                )
            })
        }
    }

    private suspend fun loadContact() {
        contactId?.let { id ->
            val contactFlow = contactDAO.getById(id)
            contactFlow.collect { contact ->
                contact?.let { setContactInUiState(it) }
            }
        }
    }

    private fun setContactInUiState(contact: Contact) {
        _uiState.update { state ->
            with(contact) {
                state.copy(
                    id = id,
                    name = name,
                    lastname = lastname,
                    phone = phone,
                    profilePicture = profilePicture,
                    birthday = birthday,
                    titleAppbar = R.string.title_edit_contact
                )
            }
        }
    }

    suspend fun save() {
        viewModelScope.launch {
            with(_uiState.value) {
                var contact = Contact(
                    id = id,
                    name = name,
                    lastname = lastname,
                    profilePicture = profilePicture,
                    birthday = birthday,
                    phone = phone,
                )
                contactDAO.insert(contact)
            }
        }
    }

    fun setBirthdayText(textBirthday: String) {
        val textBirthdayFormatted = _uiState.value.birthday?.convertToString() ?: textBirthday

        _uiState.update {
            it.copy(textBirthday = textBirthdayFormatted)
        }
    }

    fun loadImage(url: String) {
        _uiState.value = _uiState.value.copy(
            profilePicture = url,
            showImageBoxDialog = false
        )
    }
}