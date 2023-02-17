package br.com.rodrigo.contactapp.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.contactapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    state: LoginUiState,
    modifier: Modifier = Modifier,
    onClickLogin: () -> Unit = {},
    onClickRegistration: () -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.helloapp_logo_blue),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.app_logo),
                modifier = modifier
                    .size(180.dp),
            )

            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(2f),
        ) {
            if (state.showError) {
                Text(
                    text = stringResource(R.string.incorrect_user_or_password),
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    style = MaterialTheme.typography.labelMedium,
                    modifier = Modifier
                        .fillMaxWidth(),
                )
            }

            val currentFocus = LocalFocusManager.current
            OutlinedTextField(
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                },
                value = state.user,
                onValueChange = state.onChangeUser,
                label = { Text(stringResource(id = R.string.user)) },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    currentFocus.moveFocus(FocusDirection.Next)
                }),
                modifier = Modifier.fillMaxWidth(),
            )

            OutlinedTextField(
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },
                value = state.password,
                onValueChange = state.onChangePassword,
                label = { Text(stringResource(id = R.string.password)) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Next
                ),
                keyboardActions = KeyboardActions(onNext = {
                    currentFocus.moveFocus(FocusDirection.Next)
                }),
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(56.dp), onClick = onClickLogin
            ) {
                Text(text = stringResource(R.string.login))
            }

            TextButton(
                onClick = onClickRegistration,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = stringResource(R.string.create_new_account))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(state = LoginUiState())
}