package br.com.rodrigo.contactapp.ui.screens.home

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.rodrigo.contactapp.sampleData.contactsSample
import br.com.rodrigo.contactapp.ui.components.ContactItem
import br.com.rodrigo.contactapp.ui.screens.home.components.HomeAppBar
import br.com.rodrigo.contactapp.ui.screens.home.components.HomeFloatActionButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    state: HomeUiState,
    modifier: Modifier = Modifier,
    onClickSignOut: () -> Unit = {},
    onClickRegistration: () -> Unit = {},
) {
    Scaffold(
        topBar = { HomeAppBar(onClickSignOut) },
        floatingActionButton = { HomeFloatActionButton(onClickRegistration) }
    ) { paddingValues ->

        LazyColumn(modifier.padding(paddingValues)) {
            items(state.contacts) { contact ->
                ContactItem(contact)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(state =  HomeUiState(contactsSample))
}