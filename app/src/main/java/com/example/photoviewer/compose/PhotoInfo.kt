package com.example.photoviewer.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.domain.model.PhotoDto
import com.example.photoviewer.utils.Utils

@Composable
fun PhotoInfo(photoDto: PhotoDto) {
    Card(
        modifier = Modifier.padding(10.dp),
        elevation = 10.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = rememberImagePainter(photoDto.url),
                contentDescription = "Photo image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Spacer(modifier = Modifier.height(16.dp))
            photoDto.title?.let {
                Text(
                    text = Utils.capitalize(it),
                    style = MaterialTheme.typography.h4,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}