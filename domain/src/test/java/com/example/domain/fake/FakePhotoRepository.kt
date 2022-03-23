package com.example.domain.fake

import com.example.domain.model.PhotoInfo
import com.example.domain.repository.PhotoRepository

class FakePhotoRepository : PhotoRepository {
    private val photos = ArrayList<PhotoInfo>()

    override suspend fun getPhotos(): List<PhotoInfo> {
        return photos
    }
}