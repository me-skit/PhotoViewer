package com.example.photoviewer.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

@Composable
fun PhotoThumbnail(url: String) {
    Image(
        painter = rememberImagePainter(url),
        contentDescription = "Photo thumbnail",
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
    )
}