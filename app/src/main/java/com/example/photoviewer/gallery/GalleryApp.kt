package com.example.photoviewer.gallery

import android.app.Application
import com.example.data.dinjection.databaseModule
import com.example.data.dinjection.networkingModule
import com.example.data.dinjection.repositoryModule
import com.example.domain.dinjection.interactionModule
import com.example.photoviewer.dinjection.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class GalleryApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@GalleryApp)
            modules(appModules + dataModules + domainModules)
        }
    }
}

val appModules = listOf(appModule)
val dataModules = listOf(databaseModule, networkingModule, repositoryModule)
val domainModules = listOf(interactionModule)