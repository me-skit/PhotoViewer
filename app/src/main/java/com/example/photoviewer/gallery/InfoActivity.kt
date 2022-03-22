package com.example.photoviewer.gallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.domain.model.PhotoDto
import com.example.photoviewer.compose.PhotoInfo
import com.example.photoviewer.utils.Utils

class InfoActivity : ComponentActivity() {

    private val photoDto: PhotoDto by lazy {
        intent?.getSerializableExtra(Utils.EXTRA_IMAGE_ID) as PhotoDto
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PhotoInfo(photoDto)
        }
    }
}