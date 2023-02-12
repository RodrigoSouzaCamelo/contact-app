package br.com.rodrigo.contactapp.ui.screens.home.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.contactapp.R

@Composable
fun HomeFloatActionButton(onClickRegistration: () -> Unit = {}) {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(16.dp),
        onClick = { onClickRegistration() },
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(R.string.add_new_contact)
        )
    }
}

@Preview
@Composable
fun HomeFloatActionButton() {
    HomeFloatActionButton(onClickRegistration = {})
}