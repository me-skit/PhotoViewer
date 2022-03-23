package com.example.data.repository

import android.content.Context
import android.os.Looper
import android.widget.Toast
import com.example.domain.model.PhotoDto
import com.example.domain.repository.PhotoRepository
import com.example.data.database.model.PhotoEntity
import com.example.data.repository.datasourceinterface.PhotoLocalDatasource
import com.example.data.repository.datasourceinterface.PhotoRemoteDatasource
import io.reactivex.Flowable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PhotoRepositoryImpl(
    private val photoRemoteDatasource: PhotoRemoteDatasource,
    private val photoLocalDatasource: PhotoLocalDatasource,
    private val context: Context
) : PhotoRepository {
    private lateinit var disposable: Disposable

    private fun getPhotosFromAPI(): Flowable<List<PhotoEntity>> {
        return photoRemoteDatasource.getPhotos().map {
            it.subList(0, 25).map { photo ->
                PhotoEntity(photo.id, photo.albumId, photo.thumbnailUrl, photo.title, photo.url)
            }
        }
    }

    private fun getPhotosFromDB(): Flowable<List<PhotoDto>> {
        return photoLocalDatasource.getPhotosFromDB().map {
            it.map { entity ->
                PhotoDto(entity.id, entity.albumId, entity.thumbnailUrl, entity.title, entity.url)
            }
        }
    }

    private fun savePhotosToDB(photoList: List<PhotoEntity>) {
        photoLocalDatasource.savePhotosToDB(photoList)
    }

    private fun clearPhotosFromDB() {
        photoLocalDatasource.clearPhotos()
    }

    override fun getPhotos(): Flowable<List<PhotoDto>> {
        disposable = getPhotosFromAPI()
            .subscribeOn(Schedulers.io())
            .subscribe(
                { list ->
                    clearPhotosFromDB()
                    savePhotosToDB(list)
                },
                {
                    Looper.prepare()
                    Toast.makeText(context, "Unable to reach remote data", Toast.LENGTH_LONG).show()
                    Looper.loop()
               }
            )

        return getPhotosFromDB()
    }
}