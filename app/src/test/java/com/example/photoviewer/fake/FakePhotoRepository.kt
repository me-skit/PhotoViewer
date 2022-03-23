package com.example.photoviewer.fake

import com.example.domain.model.PhotoInfo
import com.example.domain.repository.PhotoRepository

class FakePhotoRepository : PhotoRepository {
    private val photos = listOf<PhotoInfo>(
        PhotoInfo(1, 1, "thumbnailUrl1", "The title 1", "Url1"),
        PhotoInfo(2, 1, "thumbnailUrl2", "The title 2", "Url2")
    )

    override suspend fun getPhotos(): List<PhotoInfo> {
        return photos
    }
}