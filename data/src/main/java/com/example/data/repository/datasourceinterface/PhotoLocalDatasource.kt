package com.example.data.repository.datasourceinterface

import com.example.data.database.model.PhotoEntity
import io.reactivex.Flowable

interface PhotoLocalDatasource {
    fun getPhotosFromDB(): Flowable<List<PhotoEntity>>
    fun savePhotosToDB(photos: List<PhotoEntity>)
    fun clearPhotos()
}