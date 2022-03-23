package com.example.photoviewer.dinjection

import com.example.photoviewer.gallery.GalleryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { GalleryViewModel(get()) }
}