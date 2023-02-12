package br.com.rodrigo.contactapp.ui.screens.formcontact

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.contactapp.ui.theme.ContactAppTheme
import androidx.compose.material3.OutlinedTextField
import br.com.rodrigo.contactapp.R
import br.com.rodrigo.contactapp.ui.components.ImageBoxDialog
import br.com.rodrigo.contactapp.ui.components.boxDialogDate
import br.com.rodrigo.contactapp.ui.screens.formcontact.components.FormContactAppBar
import coil.compose.AsyncImage
import coil.request.ImageRequest

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormContactScreen(
    state: FormContactUiState,
    modifier: Modifier = Modifier,
    onClickSave: () -> Unit = {},
    onLoadImage: (String) -> Unit = {}
) {
    Scaffold(
        topBar = {
            state.titleAppbar?.let { title ->
                FormContactAppBar(stringResource(id = title))
            }
        },
    ) { paddingValues ->

        Column(
            modifier = modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                AsyncImage(
                    model = ImageRequest
                        .Builder(LocalContext.current)
                        .data(state.profilePicture).build(),
                    placeholder = painterResource(R.drawable.default_profile_picture),
                    error = painterResource(R.drawable.default_profile_picture),
                    contentScale = ContentScale.Crop,
                    contentDescription = stringResource(id = R.string.contact_profile_picture),
                    modifier = Modifier
                        .size(180.dp)
                        .clip(CircleShape)
                        .clickable { state.onShowImageBoxDialog(true) }
                )
                Text(
                    text = stringResource(R.string.add_picture),
                    //style = MaterialTheme.typography.subtitle1 TODO: Add typography
                )
            }
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .weight(2f),
            ) {
                val currentFocus = LocalFocusManager.current
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null
                        )
                    },
                    value = state.name,
                    onValueChange = state.onChangeName,
                    label = { Text(stringResource(id = R.string.name)) },
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = (KeyboardActions(onNext = { currentFocus.moveFocus(FocusDirection.Next) }))
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = state.lastname,
                    onValueChange = state.onChangeLastname,
                    label = { Text(stringResource(id = R.string.last_name)) },
                    keyboardActions = (KeyboardActions(onNext = { currentFocus.moveFocus(FocusDirection.Next) })),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.Words,
                        imeAction = ImeAction.Next
                    ),
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = null
                        )
                    },
                    value = state.phone,
                    onValueChange = state.onChangePhone,
                    label = { Text(stringResource(id = R.string.phone)) },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Phone,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = (KeyboardActions(onNext = { currentFocus.clearFocus() }))
                )

                OutlinedButton(
                    onClick = { state.onShowBoxDialogDate(true) },
                    modifier = Modifier.fillMaxWidth()

                ) {
                    Icon(
                        imageVector = Icons.Default.DateRange,
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(text = state.textBirthday)
                }


                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onClickSave,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(56.dp),
                ) {
                    Text(text = stringResource(R.string.save))
                }
            }

            if (state.showImageBoxDialog) {
                ImageBoxDialog(
                    state.profilePicture,
                    onChangeProfilePicture = state.onChangeProfilePicture,
                    onClickDismiss = { state.onShowImageBoxDialog(false) },
                    onClickSave = { onLoadImage(it) }
                )
            }

            if (state.showBoxDialogDate) {
                boxDialogDate(
                    LocalContext.current,
                    currentDate = state.birthday,
                    onClickDismiss = { state.onShowBoxDialogDate(false) },
                    onClickSelectedDate = state.onChangeBirthday
                )
            }
        }
    }
}

@Preview
@Composable
@RequiresApi(Build.VERSION_CODES.O)
fun FormularioContatoTelaPreview() {
    ContactAppTheme {
        FormContactScreen(
            state = FormContactUiState()
        )
    }
}