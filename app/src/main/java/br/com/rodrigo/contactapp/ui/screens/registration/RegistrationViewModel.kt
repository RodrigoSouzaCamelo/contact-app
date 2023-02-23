package br.com.rodrigo.contactapp.ui.screens.registration

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegistrationViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegistrationUiState())
    val uiState: StateFlow<RegistrationUiState>
        get() = _uiState.asStateFlow()

    init {
        _uiState.update {state ->
            state.copy(
                onChangeName = {
                    _uiState.value = _uiState.value.copy(
                        name = it
                    )
                },
                onChangeUser = {
                    _uiState.value = _uiState.value.copy(
                        user = it
                    )
                },
                onChangePassword = {
                    _uiState.value = _uiState.value.copy(
                        password = it
                    )
                }
            )
        }
    }
}