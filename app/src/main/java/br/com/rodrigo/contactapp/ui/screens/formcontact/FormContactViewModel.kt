package br.com.rodrigo.contactapp.ui.screens.formcontact

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import br.com.rodrigo.contactapp.extensions.convertToDate
import br.com.rodrigo.contactapp.extensions.convertToString
import br.com.rodrigo.contactapp.util.CONTACT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormContactViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val contactId = savedStateHandle.get<Long>(CONTACT_ID)

    private val _uiState = MutableStateFlow(FormContactUiState())
    val uiState: StateFlow<FormContactUiState>
        get() = _uiState.asStateFlow()


    init {
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

    fun setBirthdayText(textBirthday: String) {
        val textoAniversairo = _uiState.value.birthday?.convertToString() ?: textBirthday

        _uiState.update {
            it.copy(textBirthday = textoAniversairo)
        }
    }

    fun loadImage(url: String) {
        _uiState.value = _uiState.value.copy(
            profilePicture = url,
            showImageBoxDialog = false
        )
    }
}