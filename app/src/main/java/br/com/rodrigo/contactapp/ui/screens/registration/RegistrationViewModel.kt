package br.com.rodrigo.contactapp.ui.screens.registration

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.ViewModel
import br.com.rodrigo.contactapp.preferences.PreferencesKey
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : ViewModel() {
    private val _uiState = MutableStateFlow(RegistrationUiState())
    val uiState: StateFlow<RegistrationUiState>
    get() = _uiState.asStateFlow()

    init {
        _uiState.update { state ->
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
    suspend fun saveLogin() {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.USER] =
                _uiState.value.user
            preferences[PreferencesKey.PASSWORD] =
                _uiState.value.password
        }
    }
}