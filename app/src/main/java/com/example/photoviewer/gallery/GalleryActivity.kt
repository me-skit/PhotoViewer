package com.example.photoviewer.gallery

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.example.photoviewer.compose.ComposePhotoGallery
import com.example.photoviewer.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel

class GalleryActivity : AppCompatActivity() {

    private val galleryViewModel: GalleryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePhotoGallery(galleryViewModel) {
                startActivity(Utils.intent(this, it))
            }
        }
    }
}

