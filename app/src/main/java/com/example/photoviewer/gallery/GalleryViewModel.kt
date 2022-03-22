package com.example.photoviewer.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.ViewModel
import com.example.domain.interaction.GetPhotoListUseCase
import com.example.domain.model.PhotoDto
import io.reactivex.schedulers.Schedulers

class GalleryViewModel(
    private val getPhotoListUseCase: GetPhotoListUseCase
) : ViewModel() {
    fun getPhotos(): LiveData<List<PhotoDto>> {
        return LiveDataReactiveStreams.fromPublisher(getPhotoListUseCase.execute()
            .subscribeOn(Schedulers.io())
        )
    }
}