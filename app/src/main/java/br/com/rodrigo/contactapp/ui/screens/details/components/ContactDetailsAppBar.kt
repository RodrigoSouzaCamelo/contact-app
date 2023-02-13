package br.com.rodrigo.contactapp.ui.screens.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import br.com.rodrigo.contactapp.R
import br.com.rodrigo.contactapp.ui.theme.Blue700

@Composable
fun ContactDetailsAppBar(
    onClickBack: () -> Unit,
    onClickDelete: () -> Unit,
    onClickEdit: () -> Unit
) {
    TopAppBar(
        backgroundColor = Blue700
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(),
        ) {
            IconButton(onClick = onClickBack) {
                Icon(
                    Icons.Default.ArrowBack,
                    tint = Color.White,
                    contentDescription = stringResource(R.string.back)
                )
            }

            Row {
                IconButton(onClick = onClickEdit) {
                    Icon(
                        Icons.Default.Edit,
                        tint = Color.White,
                        contentDescription = stringResource(R.string.edit)
                    )
                }

                IconButton(onClick = { onClickDelete() }) {
                    Icon(
                        Icons.Default.Delete,
                        tint = Color.White,
                        contentDescription = stringResource(R.string.delete)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ContactDetailsAppBarPreview() {
    ContactDetailsAppBar(
        onClickBack = {},
        onClickDelete = {},
        onClickEdit = {}
    )
}