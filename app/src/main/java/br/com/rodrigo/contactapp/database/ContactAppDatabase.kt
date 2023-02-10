package br.com.rodrigo.contactapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.rodrigo.contactapp.database.converters.Converters
import br.com.rodrigo.contactapp.models.Contact

@TypeConverters(Converters::class)
@Database(entities = [Contact::class], version = 1)
abstract class ContactAppDatabase : RoomDatabase() {
    abstract fun contactDAO(): ContactDAO

    fun getDatabase(context: Context): ContactAppDatabase {
        return Room.databaseBuilder(
            context,
            ContactAppDatabase::class.java,
            "ContactApp.db"
        ).build()
    }
}