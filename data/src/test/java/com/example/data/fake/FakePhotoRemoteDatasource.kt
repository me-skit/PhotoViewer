package com.example.data.fake

import com.example.data.networking.model.PhotoResponse
import com.example.data.repository.datasourceinterface.PhotoRemoteDatasource
import retrofit2.Response

class FakePhotoRemoteDatasource(private val photoList: ArrayList<PhotoResponse>) : PhotoRemoteDatasource {
//    private var photoList = listOf<PhotoResponse>(
//        PhotoResponse(1, 1, "thumbnailUrl1", "The title 1", "Url1")
//    )

    override suspend fun getPhotos(): Response<List<PhotoResponse>> {
        return Response.success(photoList.toList())
    }
}