package br.com.rodrigo.contactapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import br.com.rodrigo.contactapp.models.Contact
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDAO {
    @Insert(onConflict = REPLACE)
    suspend fun insert(contact: Contact)

    @Query("SELECT * FROM Contact")
    fun getAll(): Flow<List<Contact>>

    @Query("SELECT * FROM Contact WHERE id = :id")
    fun getById(id: Long): Flow<Contact?>

    @Query("DELETE FROM Contact WHERE id = :id")
    suspend fun delete(id: Long)
}