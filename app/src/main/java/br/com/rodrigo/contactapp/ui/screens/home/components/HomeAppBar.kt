package br.com.rodrigo.contactapp.ui.screens.home.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.rodrigo.contactapp.R

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun HomeAppBar(onClickSignOut: () -> Unit) {
    TopAppBar(
        title = { Text(text = stringResource(id = R.string.app_name)) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = Color.White
        ),
        actions = {
            IconButton(
                onClick = onClickSignOut
            ) {
                Icon(
                    imageVector = Icons.Default.ExitToApp,
                    tint = Color.White,
                    contentDescription = stringResource(R.string.sign_out)
                )
            }
        }
    )
}

@Preview
@Composable
fun HomeAppBarPreview() {
    HomeAppBar(onClickSignOut = {})
}
