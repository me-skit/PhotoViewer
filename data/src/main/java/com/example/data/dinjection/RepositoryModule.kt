package com.example.data.dinjection

import com.example.data.repository.PhotoRepositoryImpl
import com.example.domain.repository.PhotoRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {
    single<PhotoRepository> { PhotoRepositoryImpl(get(), get(), androidContext()) }
}