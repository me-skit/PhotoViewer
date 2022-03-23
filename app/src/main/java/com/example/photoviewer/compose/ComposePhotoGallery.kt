package com.example.photoviewer.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.unit.dp
import com.example.domain.model.PhotoDto
import com.example.photoviewer.gallery.GalleryViewModel

@Composable
fun ComposePhotoGallery(galleryViewModel: GalleryViewModel, selectedItem: (PhotoDto) -> Unit) {
    val photoList: List<PhotoDto> by galleryViewModel.getPhotos().observeAsState(listOf())

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            items = photoList,
            itemContent = {
                PhotoItem(photoItem = it, selectedItem)
            }
        )
    }
}