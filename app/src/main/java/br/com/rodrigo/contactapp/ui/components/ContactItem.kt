package br.com.rodrigo.contactapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.rodrigo.contactapp.models.Contact
import br.com.rodrigo.contactapp.sampleData.contactsSample
import br.com.rodrigo.contactapp.ui.theme.ContactAppTheme

@Composable
fun ContactItem(
    contact: Contact,
    onClick: (Long) -> Unit = {}
) {
    Card(
        Modifier.clickable { onClick(contact.id) },
        backgroundColor = MaterialTheme.colors.background
    ) {
        Row(
            Modifier.padding(16.dp),
        ) {
            AsyncImageProfile(
                urlPicture = contact.profilePicture,
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
            )
            Column(
                Modifier
                    .padding(start = 8.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = contact.name,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = contact.lastname
                )
            }
        }
    }
}

@Preview
@Composable
fun ContatoItemPreview() {
    ContactAppTheme {
        ContactItem(contactsSample.first()) {}
    }
}