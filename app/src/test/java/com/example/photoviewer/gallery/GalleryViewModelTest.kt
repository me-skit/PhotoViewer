package com.example.photoviewer.gallery

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.interaction.GetPhotoListUseCase
import com.example.photoviewer.fake.FakePhotoRepository
import com.example.photoviewer.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.CoreMatchers.not
import org.hamcrest.CoreMatchers.nullValue
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class GalleryViewModelTest {
    val dispatcher = TestCoroutineDispatcher()

    private lateinit var galleryViewModel: GalleryViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setupViewModel() {
        Dispatchers.setMain(dispatcher)
        galleryViewModel = GalleryViewModel(GetPhotoListUseCase(FakePhotoRepository()))
    }

    @Test
    fun getPhotos_getAListOfPhotoItems() {
        assertThat(galleryViewModel.getPhotos().getOrAwaitValue(), not(nullValue()))
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }
}