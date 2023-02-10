package br.com.rodrigo.contactapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.com.rodrigo.contactapp.models.Contact

@Dao
interface ContactDAO {
    @Insert(onConflict = REPLACE)
    fun insert(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getAll(): List<Contact>

    @Query("SELECT * FROM Contact WHERE id = :id")
    fun getById(id: Long): Contact?

    @Query("DELETE FROM Contact WHERE id = :id")
    fun delete(id: Long)
}