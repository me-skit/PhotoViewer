package com.example.domain.repository

import com.example.domain.model.PhotoDto
import io.reactivex.Flowable

interface PhotoRepository {
    fun getPhotos(): Flowable<List<PhotoDto>>
}