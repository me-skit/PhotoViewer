package com.example.domain.interaction

import com.example.domain.model.PhotoDto
import com.example.domain.repository.PhotoRepository
import io.reactivex.Flowable

class GetPhotoListUseCase(private val photoRepository: PhotoRepository) {
    fun execute(): Flowable<List<PhotoDto>> = photoRepository.getPhotos()
}