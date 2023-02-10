package br.com.rodrigo.contactapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val name: String = "",
    val lastname: String = "",
    val phone: String = "",
    val profilePicture: String = "",
    val birthday: Date? = null
)
