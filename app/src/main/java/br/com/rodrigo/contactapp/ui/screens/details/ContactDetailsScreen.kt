package br.com.rodrigo.contactapp.ui.screens.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.contactapp.R
import br.com.rodrigo.contactapp.extensions.convertToString
import br.com.rodrigo.contactapp.ui.components.AsyncImageProfile
import br.com.rodrigo.contactapp.ui.screens.details.components.ContactDetailsAppBar
import br.com.rodrigo.contactapp.ui.theme.ContactAppTheme

@Composable
fun ContactDetailsScreen(
    state: ContactDetailsUiState,
    modifier: Modifier = Modifier,
    onClickBack: () -> Unit = {},
    onClickEdit: () -> Unit = {},
    onDeleteContact: () -> Unit = {},
    onClickCallPhone: () -> Unit = {},
    onClickSendSMS: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            ContactDetailsAppBar(
                onClickBack = onClickBack,
                onClickDelete = onDeleteContact,
                onClickEdit = onClickEdit
            )
        },
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = modifier
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .fillMaxSize(),
        ) {
            AsyncImageProfile(
                urlPicture = state.profilePicture,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Text(
                modifier = Modifier.padding(vertical = 16.dp),
                text = state.name,
                style = MaterialTheme.typography.titleMedium
            )

            Divider(thickness = 1.dp)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable { onClickCallPhone() }
                ) {
                    Icon(
                        imageVector = Icons.Default.Phone,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = stringResource(R.string.on),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .clickable { onClickSendSMS() },
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        text = stringResource(R.string.message),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            Divider(thickness = 1.dp)

            Column(
                Modifier.padding(16.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {

                Text(
                    modifier = Modifier.padding(bottom = 22.dp),
                    text = stringResource(R.string.info),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )

                Text(
                    text = stringResource(R.string.full_name),
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = "${state.name} ${state.lastname}",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 5.dp),
                )

                Text(
                    text = stringResource(id = R.string.phone),
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.fillMaxWidth(),
                )
                Text(
                    text = state.phone,
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp),
                )

                state.birthday?.let {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = stringResource(id = R.string.birthday),
                        color = Color.Gray,
                        style = MaterialTheme.typography.bodyMedium
                    )
                    Text(
                        text = it.convertToString(),
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ContactDetailsScreenPreview() {
    ContactAppTheme {
        ContactDetailsScreen(state = ContactDetailsUiState())
    }
}