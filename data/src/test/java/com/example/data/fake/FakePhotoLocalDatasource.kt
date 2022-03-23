package com.example.data.fake

import com.example.data.database.model.PhotoEntity
import com.example.data.repository.datasourceinterface.PhotoLocalDatasource

class FakePhotoLocalDatasource(private var photoList: ArrayList<PhotoEntity>) : PhotoLocalDatasource {
    //private var photoList = ArrayList<PhotoEntity>()

    override suspend fun getPhotosFromDB(): List<PhotoEntity> {
        return photoList
    }

    override suspend fun savePhotosToDB(photos: List<PhotoEntity>) {
        photoList.clear()
        photoList.addAll(photos)
    }

    override suspend fun clearPhotos() {
        photoList.clear()
    }
}