package br.com.rodrigo.contactapp.di

import android.app.Application
import android.content.Context
import br.com.rodrigo.contactapp.database.ContactAppDatabase
import br.com.rodrigo.contactapp.database.ContactDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): ContactAppDatabase {
        return ContactAppDatabase.getInstance(context)
    }


    @Singleton
    @Provides
    fun provideContactDAO(database: ContactAppDatabase): ContactDAO {
        return database.contactDAO()
    }
}