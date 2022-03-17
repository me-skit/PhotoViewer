package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.model.PhotoEntity
import io.reactivex.Flowable

@Dao
interface PhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun savePhotoEntities(photosEntities: List<PhotoEntity>)

    @Query("DELETE FROM tbl_photos")
    fun deleteAllPhotoEntities()

    @Query("SELECT * FROM tbl_photos")
    fun getPhotoEntities(): Flowable<List<PhotoEntity>>
}