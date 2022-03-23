package com.example.data.networking.service

import com.example.data.networking.model.PhotoResponse
import io.reactivex.Flowable
import retrofit2.http.GET

interface RetrofitPhotoService {
    @GET("photos")
    fun getPhotos(): Flowable<List<PhotoResponse>>
}