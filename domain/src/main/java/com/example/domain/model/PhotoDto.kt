package com.example.domain.model

import java.io.Serializable

data class PhotoDto(
    val id: Int,
    val albumId: Int?,
    val thumbnailUrl: String?,
    val title: String?,
    val url: String?
) : Serializable
