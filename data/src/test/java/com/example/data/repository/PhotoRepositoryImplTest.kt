package com.example.data.repository

import com.example.data.database.model.PhotoEntity
import com.example.data.fake.FakePhotoLocalDatasource
import com.example.data.fake.FakePhotoRemoteDatasource
import com.example.data.networking.model.PhotoResponse
import com.example.domain.model.PhotoInfo
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsEqual
import org.hamcrest.core.IsNot.not
import org.hamcrest.core.IsNull
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class PhotoRepositoryImplTest {
    private val photoResponse1 = PhotoResponse(1, 1, "http://thumbnail-url.example1", "Remote Title 1", "http://url.example1")
    private val photoResponse2 = PhotoResponse(2, 1, "http://thumbnail-url.example2", "Remote Title 2", "http://url.example2")
    private val photoEntity = PhotoEntity(3, 1, "http://thumbnail-url.example1", "Local Title 1", "http://url.example3")
    private val remoteList = ArrayList<PhotoResponse>()
    private val localList = ArrayList<PhotoEntity>()

    private lateinit var fakeRemoteDatasource: FakePhotoRemoteDatasource
    private lateinit var fakeLocalDatasource: FakePhotoLocalDatasource
    private lateinit var photoRepositoryImpl: PhotoRepositoryImpl

    @Before
    fun createFakeDataSources() {
        remoteList.add(photoResponse1)
        remoteList.add(photoResponse2)

        localList.add(photoEntity)

        fakeRemoteDatasource = FakePhotoRemoteDatasource(remoteList)
        fakeLocalDatasource = FakePhotoLocalDatasource(localList)

        photoRepositoryImpl = PhotoRepositoryImpl(fakeRemoteDatasource, fakeLocalDatasource)
    }

    @Test
    fun getPhotos_requestAllTasksFromRemoteDatasource() = runBlockingTest() {
        val photoList = photoRepositoryImpl.getPhotos()
        val photosFromRemote = remoteList.map {
            PhotoInfo(it.id, it.albumId, it.thumbnailUrl, it.title, it.url)
        }

        assertThat(photoList, IsEqual(photosFromRemote))
    }

    @Test
    fun getPhotos_returnsANotNullList() = runBlockingTest() {

        val photoList = photoRepositoryImpl.getPhotos()
        assertThat(photoList, not(IsNull.nullValue()))
    }

    @Test
    fun getPhotos_returnsPhotoInfoItems() = runBlockingTest() {


        val photoItem = photoRepositoryImpl.getPhotos()[0]
        assertThat(photoItem, instanceOf(PhotoInfo::class.java))
    }
}