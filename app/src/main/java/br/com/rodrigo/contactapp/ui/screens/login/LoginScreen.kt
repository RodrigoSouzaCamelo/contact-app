package br.com.rodrigo.contactapp.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.contactapp.R

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
                modifier = modifier
                    .size(180.dp),
                contentScale = ContentScale.Crop,
                contentDescription = stringResource(R.string.app_logo),
            )
            Text(
                text = stringResource(id = R.string.app_name),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(state = LoginUiState())
}