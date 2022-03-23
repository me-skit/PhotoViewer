package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.PhotoDao
import com.example.data.database.model.PhotoEntity

@Database(entities = [PhotoEntity::class], version = 1, exportSchema = false)
abstract class PhotoDatabase: RoomDatabase() {
    abstract fun PhotoDao(): PhotoDao
}