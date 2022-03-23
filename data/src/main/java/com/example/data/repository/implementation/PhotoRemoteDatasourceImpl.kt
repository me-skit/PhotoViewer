package com.example.data.repository.implementation

import com.example.data.networking.model.PhotoResponse
import com.example.data.networking.service.RetrofitPhotoService
import com.example.data.repository.datasourceinterface.PhotoRemoteDatasource
import io.reactivex.Flowable

class PhotoRemoteDatasourceImpl(
    private val retrofitPhotoService: RetrofitPhotoService
) : PhotoRemoteDatasource {
    override fun getPhotos(): Flowable<List<PhotoResponse>> {
        return retrofitPhotoService.getPhotos()
    }
}