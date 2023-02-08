package br.com.rodrigo.contactapp.ui.screens.formcontact

import androidx.annotation.StringRes
import br.com.rodrigo.contactapp.R
import java.util.*

data class FormContactUiState (
    val id: Long = 0L,
    val name: String = "",
    val lastname: String = "",
    val phone: String = "",
    val profilePicture: String = "",
    val birthday: Date? = null,
    val showImageBoxDialog: Boolean = false,
    val showBoxDialogDate: Boolean = false,
    val onChangeName: (String) -> Unit = {},
    val onChangeLastname: (String) -> Unit = {},
    val onChangePhone: (String) -> Unit = {},
    val onChangeProfilePicture: (String) -> Unit = {},
    val onChangeBirthday: (String) -> Unit = {},
    val onShowImageBoxDialog: (show: Boolean) -> Unit = {},
    val onShowBoxDialogDate: (show: Boolean) -> Unit = {},
    val textBirthday: String = "",
    @StringRes
    val titleAppbar: Int? = R.string.title_registration_contact,
)