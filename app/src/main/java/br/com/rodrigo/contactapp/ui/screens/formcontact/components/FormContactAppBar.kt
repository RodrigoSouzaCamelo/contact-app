package br.com.rodrigo.contactapp.ui.screens.formcontact.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormContactAppBar(titleAppBar: String) {
    TopAppBar(
        title = { Text(text = titleAppBar) },
    )
}

@Preview
@Composable
fun FormContactAppBarPreview() {
    FormContactAppBar("")
}