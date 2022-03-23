package com.example.photoviewer.utils

import android.content.Context
import android.content.Intent
import com.example.domain.model.PhotoDto
import com.example.photoviewer.gallery.InfoActivity

object Utils {
    const val EXTRA_IMAGE_ID = "com.example.photoviewer.IMAGE_ID"

    fun capitalize(str: String): String {
        return str.replaceFirstChar { first -> first.uppercase() }
    }

    fun intent(context: Context, photoDto: PhotoDto) =
        Intent(context, InfoActivity::class.java).apply {
            putExtra(EXTRA_IMAGE_ID, photoDto)
        }
}