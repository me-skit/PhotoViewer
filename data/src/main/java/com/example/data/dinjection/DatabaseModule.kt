package com.example.data.dinjection

import androidx.room.Room
import com.example.data.database.PhotoDatabase
import com.example.data.repository.datasourceinterface.PhotoLocalDatasource
import com.example.data.repository.implementation.PhotoLocalDatasourceImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(androidContext(), PhotoDatabase::class.java, "photo_database").build()
    }

    single { get<PhotoDatabase>().PhotoDao() }

    single<PhotoLocalDatasource> { PhotoLocalDatasourceImpl(get()) }
}