package com.example.data.networking.model

import com.google.gson.annotations.SerializedName

data class PhotoResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("albumId")
    val albumId: Int?,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?
)