package com.example.domain.interaction

import com.example.domain.fake.FakePhotoRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.core.IsNot.not
import org.hamcrest.core.IsNull.nullValue
import org.junit.Test

@ExperimentalCoroutinesApi
class GetPhotoListUseCaseTest {

    @Test
    fun executeGetPhotoListUseCase_returnsAListOfPhotoItems() = runBlockingTest() {
        val getPhotoListUseCase = GetPhotoListUseCase(FakePhotoRepository())

        val photos = getPhotoListUseCase.execute()
        assertThat(photos, not(nullValue()))
    }
}