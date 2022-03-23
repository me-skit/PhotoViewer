package com.example.data.repository.datasourceinterface

import com.example.data.networking.model.PhotoResponse
import io.reactivex.Flowable

interface PhotoRemoteDatasource {
    fun getPhotos(): Flowable<List<PhotoResponse>>
}