package com.example.data.repository.implementation

import com.example.data.database.dao.PhotoDao
import com.example.data.database.model.PhotoEntity
import com.example.data.repository.datasourceinterface.PhotoLocalDatasource
import io.reactivex.Flowable

class PhotoLocalDatasourceImpl(private val photoDao: PhotoDao) : PhotoLocalDatasource {
    override fun getPhotosFromDB(): Flowable<List<PhotoEntity>> {
        return photoDao.getPhotoEntities()
    }

    override fun savePhotosToDB(photos: List<PhotoEntity>) {
        return photoDao.savePhotoEntities(photos)
    }

    override fun clearPhotos() {
        photoDao.deleteAllPhotoEntities()
    }
}