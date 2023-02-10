package br.com.rodrigo.contactapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.rodrigo.contactapp.models.Contact

@Dao
interface ContactDAO {
    @Insert
    fun insert(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getAll(): List<Contact>
}