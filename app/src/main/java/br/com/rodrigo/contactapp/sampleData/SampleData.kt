package br.com.rodrigo.contactapp.sampleData

import br.com.rodrigo.contactapp.models.Contact
import java.util.*

var contactsSample: List<Contact> = listOf(
    Contact(
        name = "Ana",
        lastname = "Clara",
        phone = "123",
        profilePicture = "https://images.pexels.com/photos/3922294/pexels-photo-3922294.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        ),
    Contact(
        name = "Bill",
        lastname = "Lima",
        phone = "321",
        profilePicture = "https://images.pexels.com/photos/1415882/pexels-photo-1415882.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        birthday = Calendar.getInstance().time
    ),
    Contact(
        name = "Odes",
        lastname = "Conhecido",
        phone = "321",
        profilePicture = "urlTesteParaDarErro"
    )
)