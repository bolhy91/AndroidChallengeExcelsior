package com.bolhy91.androidchallengeexcelsior.presentation.detail_track.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.bolhy91.androidchallengeexcelsior.domain.models.Track
import com.bolhy91.androidchallengeexcelsior.ui.theme.Purple80

@Composable
fun BodySection(track: Track) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Image and Category
        Row {
            Box(
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(
                        track.banner
                    ),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .shadow(
                            5.dp,
                            shape = RoundedCornerShape(24.dp),
                            true
                        )
                        .fillMaxSize(),
                    alignment = Alignment.Center
                )
            }

            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.spacedBy(15.dp),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val styleText =
                    MaterialTheme.typography.caption.copy(fontWeight = FontWeight.SemiBold)
                Text(
                    text = "Artist Name: ${track.artistName}",
                    color = Color.Black,
                    style = styleText
                )
                Text(
                    text = "Price: ${track.price}",
                    color = Color.Black,
                    style = styleText
                )
                Text(
                    text = "Country: ${track.country}",
                    color = Color.Black,
                    style = styleText
                )
            }
        }

        Text(
            text = track.name.uppercase(),
            color = Color.Black,
            style = MaterialTheme.typography.h3,
            modifier = Modifier
                .padding(top = 25.dp, bottom = 10.dp)
        )
        // border bottom
        Spacer(
            modifier = Modifier
                .height(1.dp)
                .fillMaxWidth()
                .background(Purple80)
        )
        Text(
            text = "Publish: ${track.publish}",
            color = Color.Black,
            style = MaterialTheme.typography.caption.copy(fontStyle = FontStyle.Italic)
        )
        if (track.description?.isNotBlank() == true) {
            Text(
                text = "DESCRIPTION",
                color = Color.Black,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(top = 20.dp, bottom = 5.dp)
            )
            //Description
            Text(
                text = track.description,
                color = Color.Black,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 5.dp)
            )
        }
    }
}