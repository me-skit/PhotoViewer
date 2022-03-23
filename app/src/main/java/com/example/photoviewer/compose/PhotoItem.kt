package com.example.photoviewer.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.domain.model.PhotoDto
import com.example.photoviewer.utils.Utils

@Composable
fun PhotoItem(photoItem: PhotoDto, selectedItem: (PhotoDto) -> Unit) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(corner = CornerSize(10.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth()
                .clickable { selectedItem(photoItem) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            photoItem.thumbnailUrl?.let { PhotoThumbnail(url = it) }

            Column(
                modifier = Modifier
                    .padding(start = 10.dp)
            ) {
                photoItem.title?.let {
                    Text(
                        text = Utils.capitalize(it),
                        style = MaterialTheme.typography.h6,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))

                CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                    Text(
                        text = "Photo id: ${photoItem.albumId}",
                        style = MaterialTheme.typography.body1
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = "Album id: ${photoItem.albumId}",
                        style = MaterialTheme.typography.body1
                    )
                }
            }
        }
    }
}