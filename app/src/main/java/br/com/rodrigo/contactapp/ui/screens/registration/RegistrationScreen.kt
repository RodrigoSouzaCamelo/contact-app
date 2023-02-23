package br.com.rodrigo.contactapp.ui.screens.registration

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import br.com.rodrigo.contactapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import br.com.rodrigo.contactapp.ui.theme.ContactAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistrationScreen(
    state: RegistrationUiState,
    modifier: Modifier = Modifier,
    onSave: () -> Unit = {}
) {
    Column(Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)

        ) {
            Image(
                painter = painterResource(id = R.drawable.helloapp_logo_blue),
                modifier = modifier
                    .size(180.dp),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.app_logo),
            )
            Text(
                text = stringResource(id = R.string.create_new_account),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.primary
            )
        }
        Column(
            modifier
                .padding(16.dp)
                .weight(2f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            val currentFocus = LocalFocusManager.current
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Face, contentDescription = null
                    )
                },
                value = state.name,
                onValueChange = state.onChangeName,
                label = { Text(stringResource(id = R.string.name)) },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        currentFocus.moveFocus(FocusDirection.Next)
                    }
                )
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person, contentDescription = null
                    )
                },
                value = state.user,
                onValueChange = state.onChangeUser,
                label = { Text(stringResource(id = R.string.user)) },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = {
                        currentFocus.moveFocus(FocusDirection.Next)
                    }
                )
            )

            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock, contentDescription = null
                    )
                },
                value = state.password,
                onValueChange = state.onChangePassword,
                label = { Text(stringResource(id = R.string.password)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password, imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { currentFocus.moveFocus(FocusDirection.Next) }
                )
            )

            Spacer(Modifier.height(16.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(56.dp),
                onClick = onSave
            ) {
                Text(text = stringResource(R.string.create))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CadastroLoginScreenPreview() {
    ContactAppTheme {
        RegistrationScreen(RegistrationUiState())
    }
}